package com.bingwascore.app.profile

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import kotlinx.coroutines.launch
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.domain.EngineState
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.NeoButton
import com.bingwascore.app.ui.theme.Bronze
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.ui.theme.Gold
import com.bingwascore.app.ui.theme.Platinum
import com.bingwascore.app.ui.theme.Silver
import com.bingwascore.app.util.screenEnter
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.geometry.Offset

/**
 * Stage 51 — premium Profile surface.
 *
 * Fintech-dashboard feel: gradient-ring avatar, tier badge, animated headline
 * score, NeoButton CTAs and glass list rows. The ViewModel is untouched — only
 * UI composition changed.
 */

data class ProfileScreenState(
    val userName: String = "Bingwa User",
    val accountType: String = "Individual",
    val phone: String = "",
    val email: String = "",
    val levelName: String = "Bronze",
    val score: Int = 0,
    val engineEnabled: Boolean = true,
    val engineState: EngineState = EngineState.RUNNING,
    val editState: ProfileEditState = ProfileEditState()
)

data class ProfileScreenCallbacks(
    val onMyStore: () -> Unit = {},
    val onReferEarn: () -> Unit = {},
    val onSettings: () -> Unit = {},
    val onAbout: () -> Unit = {},
    val onUpdateAccountType: (String) -> Unit = {},
    val onUpdateName: (String) -> Unit = {},
    val onUpdatePhone: (String) -> Unit = {},
    val onUpdateEmail: (String) -> Unit = {},
    val onUpdatePinToConfirm: (String) -> Unit = {},
    val onPromptReauth: () -> Unit = {},
    val onCancelReauth: () -> Unit = {},
    val onSave: () -> Unit = {},
    val onCancelEditing: () -> Unit = {},
    val onStartEditing: () -> Unit = {},
    val onToggleEngine: () -> Unit = {}
)

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    onMyStore: () -> Unit = {},
    onReferEarn: () -> Unit = {},
    onSettings: () -> Unit = {},
    onAbout: () -> Unit = {}
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val userName by viewModel.userName.collectAsStateWithLifecycle()
    val accountType by viewModel.accountType.collectAsStateWithLifecycle()
    val phone by viewModel.phone.collectAsStateWithLifecycle()
    val email by viewModel.email.collectAsStateWithLifecycle()
    val levelName by viewModel.levelName.collectAsStateWithLifecycle()
    val score by viewModel.score.collectAsStateWithLifecycle()
    val engineEnabled by viewModel.engineEnabled.collectAsStateWithLifecycle()
    val engineState by viewModel.engineState.collectAsStateWithLifecycle()
    val editState by viewModel.editState.collectAsStateWithLifecycle()

    val state = ProfileScreenState(
        userName = userName,
        accountType = accountType,
        phone = phone,
        email = email,
        levelName = levelName,
        score = score,
        engineEnabled = engineEnabled,
        engineState = engineState,
        editState = editState
    )

    val callbacks = ProfileScreenCallbacks(
        onMyStore = onMyStore,
        onReferEarn = onReferEarn,
        onSettings = onSettings,
        onAbout = onAbout,
        onUpdateAccountType = viewModel::updateAccountType,
        onUpdateName = viewModel::updateName,
        onUpdatePhone = viewModel::updatePhone,
        onUpdateEmail = viewModel::updateEmail,
        onUpdatePinToConfirm = viewModel::updatePinToConfirm,
        onPromptReauth = viewModel::promptReauth,
        onCancelReauth = viewModel::cancelReauth,
        onSave = viewModel::saveProfile,
        onCancelEditing = viewModel::cancelEditing,
        onStartEditing = viewModel::startEditing,
        onToggleEngine = viewModel::toggleEngine
    )

    ProfileScreenContent(state = state, callbacks = callbacks)
}

/**
 * Stage 51 — the pure Profile body: gradient-ring header card, editable
 * identity, Autopilot toggle and glass menu rows.
 */
@Composable
fun ProfileScreenContent(
    state: ProfileScreenState,
    callbacks: ProfileScreenCallbacks = ProfileScreenCallbacks()
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val scoreAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "ProfileScoreAlpha"
    )
    val slideAnim = remember { Animatable(8f) }
    LaunchedEffect(Unit) {
        launch {
            slideAnim.animateTo(
                targetValue = 0f,
                animationSpec = spring(
                    stiffness = DesignTokens.Motion.SpringStiffness,
                    dampingRatio = DesignTokens.Motion.SpringDamping
                )
            )
        }
    }
    val scoreSlide = slideAnim.value

    Box(
        modifier = Modifier.fillMaxSize().screenEnter().background(DesignTokens.Color.Bg)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp)) {
                Text(
                    text = "Profile",
                    color = DesignTokens.Color.Ink,
                    fontSize = DesignTokens.Typography.Headline,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Your agent account",
                    color = DesignTokens.Color.Ink.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Header card: gradient-ring avatar, tier badge below it, animated score.
            GlassCard(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 4.dp)
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(
                                        Brush.linearGradient(
                                            colors = listOf(
                                                roles.brand,
                                                roles.brand
                                            )
                                        )
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(CircleShape)
                                        .background(DesignTokens.Color.Bg)
                                ) {
                                    Text(
                                        text = (if (state.editState.isEditing) state.editState.name else state.userName)
                                            .ifBlank { "B" }.take(1).uppercase(),
                                        color = DesignTokens.Color.Ink,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            TierBadge(levelName = state.levelName)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = if (state.editState.isEditing) state.editState.name else state.userName,
                                color = DesignTokens.Color.Ink,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(roles.brand)
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = state.accountType,
                                    color = DesignTokens.Color.Ink,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Score: ${state.score} pts",
                            style = TextStyle(
                                fontSize = DesignTokens.Typography.Headline,
                                fontWeight = FontWeight.Bold
                            ),
                            color = DesignTokens.Color.Ink,
                            modifier = Modifier.graphicsLayer {
                                alpha = scoreAlpha
                                translationY = scoreSlide
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Identity card: read-only info or the edit form.
            IdentityCard(state = state, callbacks = callbacks)

            Spacer(modifier = Modifier.height(16.dp))

            // Bingwa Autopilot row with the custom premium toggle.
            GlassCard(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 4.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Bingwa Autopilot",
                            color = DesignTokens.Color.Ink,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = when (state.engineState) {
                                EngineState.RUNNING -> "Running"
                                EngineState.PAUSED -> "Paused"
                                EngineState.STOPPED -> "Stopped"
                            },
                            color = when (state.engineState) {
                                EngineState.RUNNING -> DesignTokens.LocalBingwaRoles.current.success
                                EngineState.PAUSED -> DesignTokens.Color.Ink.copy(alpha = 0.7f)
                                EngineState.STOPPED -> DesignTokens.Color.Ink.copy(alpha = 0.5f)
                            },
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    PremiumToggle(
                        checked = state.engineEnabled,
                        onCheckedChange = { callbacks.onToggleEngine() }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Glass menu rows: each wrapped in GlassCard, 1dp separator except last.
            GlassMenuRow(
                icon = Icons.Rounded.Storefront,
                label = "Agent Portal",
                onClick = callbacks.onMyStore,
                last = false
            )
            GlassMenuRow(
                icon = Icons.Rounded.Share,
                label = "Refer & Earn",
                onClick = callbacks.onReferEarn,
                last = false
            )
            GlassMenuRow(
                icon = Icons.Rounded.Settings,
                label = "Settings",
                onClick = callbacks.onSettings,
                last = false
            )
            GlassMenuRow(
                icon = Icons.Rounded.Info,
                label = "About",
                onClick = callbacks.onAbout,
                last = true
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun TierBadge(levelName: String) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val color = when (levelName) {
        "Bronze" -> Bronze
        "Silver" -> Silver
        "Gold" -> Gold
        "Platinum" -> Platinum
        else -> roles.brand
    }
    val density = LocalDensity.current
    val radiusPx = with(density) { DesignTokens.Shape.RadiusMd.toPx() }
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(DesignTokens.Shape.RadiusFull))
            .background(color)
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .drawBehind {
                val textPrimaryGlow = roles.textPrimary.copy(alpha = 0.10f)
                drawRoundRect(
                    brush = SolidColor(textPrimaryGlow),
                    cornerRadius = CornerRadius(radiusPx, radiusPx)
                )
            }
    ) {
        Text(
            text = levelName,
            color = DesignTokens.Color.Ink,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun IdentityCard(
    state: ProfileScreenState,
    callbacks: ProfileScreenCallbacks
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    GlassCard(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 4.dp)
    ) {
        Column {
            if (state.editState.isEditing) {
                EditForm(state = state, callbacks = callbacks)
            } else {
                ReadOnlyIdentity(state = state, callbacks = callbacks)
            }
        }
    }
}

@Composable
private fun ReadOnlyIdentity(
    state: ProfileScreenState,
    callbacks: ProfileScreenCallbacks
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = state.userName,
            color = DesignTokens.Color.Ink,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(roles.brand)
                .padding(horizontal = 6.dp, vertical = 2.dp)
        ) {
            Text(
                text = state.accountType,
                color = DesignTokens.Color.Ink,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = state.phone.ifEmpty { "No phone set" },
        color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
        fontSize = 12.sp
    )
    Text(
        text = state.email.ifEmpty { "No email set" },
        color = DesignTokens.Color.Ink.copy(alpha = 0.6f),
        fontSize = 12.sp
    )
    Spacer(modifier = Modifier.height(12.dp))
    NeoButton(
        onClick = callbacks.onStartEditing,
        text = "Edit Profile"
    )
}

@Composable
private fun EditForm(
    state: ProfileScreenState,
    callbacks: ProfileScreenCallbacks = ProfileScreenCallbacks()
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    Column {
        ProfileField(
            label = "Account Type",
            value = state.editState.accountType,
            onValueChange = callbacks.onUpdateAccountType
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProfileField(
            label = "Name / Business",
            value = state.editState.name,
            onValueChange = callbacks.onUpdateName
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProfileField(
            label = "Phone",
            value = state.editState.phone,
            onValueChange = callbacks.onUpdatePhone
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProfileField(
            label = "Email",
            value = state.editState.email,
            onValueChange = callbacks.onUpdateEmail
        )
        Spacer(modifier = Modifier.height(6.dp))

        state.editState.errorMessage?.let {
            Text(
                text = it,
                color = DesignTokens.LocalBingwaRoles.current.error,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        state.editState.savedMessage?.let {
            Text(
                text = it,
                color = DesignTokens.LocalBingwaRoles.current.success,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (state.editState.isReauthenticating) {
            Text(
                text = "Re-authenticate to save changes",
                color = DesignTokens.Color.Ink,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            ProfileField(
                label = "Enter your PIN",
                value = state.editState.pinToConfirm,
                onValueChange = callbacks.onUpdatePinToConfirm,
                isPassword = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                NeoButton(
                    enabled = state.editState.pinToConfirm.length >= 4 && !state.editState.isSaving,
                    onClick = callbacks.onSave,
                    text = if (state.editState.isSaving) "Verifying…" else "Confirm & Save"
                )
                NeoButton(
                    onClick = callbacks.onCancelReauth,
                    text = "Cancel"
                )
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                NeoButton(
                    onClick = callbacks.onPromptReauth,
                    text = "Save Changes"
                )
                NeoButton(
                    onClick = callbacks.onCancelEditing,
                    text = "Cancel"
                )
            }
        }
    }
}

@Composable
private fun ProfileField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    Column {
        Text(
            text = label,
            color = DesignTokens.Color.Ink.copy(alpha = 0.45f),
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(color = DesignTokens.Color.Ink, fontSize = 14.sp),
            visualTransformation = if (isPassword) androidx.compose.ui.text.input.PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            cursorBrush = SolidColor(roles.brand),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(DesignTokens.Color.Card)
                .padding(horizontal = 10.dp, vertical = 9.dp)
        )
    }
}

@Composable
private fun GlassMenuRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit,
    last: Boolean
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "GlassMenuRowPress"
    )
    val separator = roles.border.copy(alpha = 0.1f)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
            .graphicsLayer { scaleX = scale; scaleY = scale }
    ) {
        GlassCard(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 6.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = roles.brand,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(14.dp))
                Text(
                    text = label,
                    color = DesignTokens.Color.Ink,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Rounded.ChevronRight,
                    contentDescription = null,
                    tint = roles.textPrimary.copy(alpha = 0.4f),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        if (!last) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(1.dp)
                    .background(separator)
            )
        }
    }
}

/**
 * Stage 51 — the Autopilot premium toggle: transparent track with a 1dp
 * Obsidian border, sliding thumb, Brand.Primary active fill and a Level1
 * shadow on the thumb when on. Haptic TextHandleMove on toggle.
 */
@Composable
private fun PremiumToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val roles = DesignTokens.LocalBingwaRoles.current
    val density = LocalDensity.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val haptic = LocalHapticFeedback.current

    val trackWidth = 44.dp
    val trackHeight = 24.dp
    val thumbSize = 18.dp
    val pad = 3.dp

    val thumbX by animateDpAsState(
        targetValue = if (checked) trackWidth - thumbSize - pad else pad,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "PremiumToggleThumb"
    )
    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.97f else 1f,
        animationSpec = spring(
            stiffness = DesignTokens.Motion.SpringStiffness,
            dampingRatio = DesignTokens.Motion.SpringDamping
        ),
        label = "PremiumTogglePress"
    )

    val radiusPx = with(density) { DesignTokens.Shape.RadiusFull.toPx() }
    val thumbPx = with(density) { thumbSize.toPx() }
    val trackHeightPx = with(density) { trackHeight.toPx() }
    val shadowY = with(density) { DesignTokens.Elevation.Level1.first().offsetY.toPx() }
    val shadowColor = DesignTokens.Elevation.Level1.first().color
    val borderColor = roles.border.copy(alpha = 0.5f)
    val trackShape = RoundedCornerShape(DesignTokens.Shape.RadiusFull)

    Box(
        modifier = Modifier
            .size(trackWidth, trackHeight)
            .graphicsLayer { scaleX = pressScale; scaleY = pressScale }
            .border(1.dp, borderColor, trackShape)
            .clickable(interactionSource = interactionSource, indication = null, onClick = {
                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                onCheckedChange(!checked)
            })
            .drawBehind {
                val brand = roles.brand
                val fill = if (checked) brand else Color.Transparent
                drawRoundRect(
                    brush = SolidColor(fill),
                    cornerRadius = CornerRadius(radiusPx, radiusPx)
                )
            }
    ) {
        Box(
            modifier = Modifier
                .size(thumbSize, thumbSize)
                .clip(CircleShape)
                .background(DesignTokens.Color.Ink)
                .graphicsLayer {
                    translationX = with(density) { thumbX.toPx() }
                    translationY = with(density) { ((trackHeight - thumbSize) / 2).toPx() }
                }
                .drawBehind {
                    if (checked) {
                        val cx = with(density) { thumbPx / 2f }
                        val cy = with(density) { thumbPx / 2f + shadowY }
                        drawCircle(
                            color = shadowColor.copy(alpha = 0.5f),
                            center = Offset(cx, cy),
                            radius = with(density) { thumbPx / 2f }
                        )
                    }
                }
        )
    }
}
