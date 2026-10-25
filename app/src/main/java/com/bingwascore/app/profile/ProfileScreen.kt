package com.bingwascore.app.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.domain.EngineState
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.HapticSwitch
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.Bronze
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.accentBrush
import com.bingwascore.app.ui.theme.Gold
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Platinum
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.Silver
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.util.screenEnter

/**
 * Stage 19.7 — the PURE Profile surface.
 *
 * The identity card, the Autopilot switch and the menu rows all read from here;
 * the ViewModel lives in the wrapper.
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
    // STAGE 19.7 — the wrapper owns the ViewModel; the content below is pure.
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
 * Stage 19.7 — the pure Profile body: the editable identity card, the Autopilot
 * switch and the four menu doors.
 */
@Composable
fun ProfileScreenContent(
    state: ProfileScreenState,
    callbacks: ProfileScreenCallbacks = ProfileScreenCallbacks()
) {
    Box(
        modifier = Modifier.fillMaxSize().screenEnter().background(BgBlack)
    ) {
        // PREMIUM LOCK — ambient blobs behind the glass cards on Profile.

        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp)) {
            Text("Profile", color = TextWhite, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Your agent account", color = TextWhite.copy(alpha = 0.5f), fontSize = 12.sp)
        }

        // MEGA A — the profile is EDITABLE and persisted, not a static card.
        // Level and score stay read-only because they are earned, not typed.
        BubbleCard(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(54.dp).clip(CircleShape)
                        .background(accentBrush()),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        (if (state.editState.isEditing) state.editState.name else state.userName)
                            .ifBlank { "B" }.take(1).uppercase(),
                        color = BgBlack, fontSize = 22.sp, fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
                Column(modifier = Modifier.weight(1f)) {
                    if (state.editState.isEditing) {
                        ProfileField("Account Type", state.editState.accountType, callbacks.onUpdateAccountType)
                        Spacer(modifier = Modifier.height(8.dp))
                        ProfileField("Name / Business", state.editState.name, callbacks.onUpdateName)
                        Spacer(modifier = Modifier.height(8.dp))
                        ProfileField("Phone", state.editState.phone, callbacks.onUpdatePhone)
                        Spacer(modifier = Modifier.height(8.dp))
                        ProfileField("Email", state.editState.email, callbacks.onUpdateEmail)
                    } else {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(state.userName, color = TextWhite, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Bubble)
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    state.accountType,
                                    color = AccentBlue,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            state.phone.ifEmpty { "No phone set" },
                            color = TextWhite.copy(alpha = 0.6f),
                            fontSize = 12.sp
                        )
                        Text(
                            state.email.ifEmpty { "No email set" },
                            color = TextWhite.copy(alpha = 0.6f),
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    LevelBadge(state.levelName)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Score: ${state.score} pts", color = TextWhite.copy(alpha = 0.7f), fontSize = 13.sp)
            }

            // Inline validation + save state
            state.editState.errorMessage?.let {
                Spacer(modifier = Modifier.height(10.dp))
                Text(it, color = FailRed, fontSize = 12.sp, fontWeight = FontWeight.Medium)
            }
            state.editState.savedMessage?.let {
                Spacer(modifier = Modifier.height(10.dp))
                Text(it, color = TickGreen, fontSize = 12.sp, fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(12.dp))

            if (state.editState.isEditing) {
                if (state.editState.isReauthenticating) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Bubble)
                            .padding(12.dp)
                    ) {
                        Text("Re-authenticate to save changes", color = TextWhite, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.height(8.dp))
                        ProfileField(
                            label = "Enter your PIN",
                            value = state.editState.pinToConfirm,
                            onValueChange = callbacks.onUpdatePinToConfirm,
                            isPassword = true
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            PrimaryButton(
                                text = if (state.editState.isSaving) "Verifying…" else "Confirm & Save",
                                enabled = state.editState.pinToConfirm.length >= 4 && !state.editState.isSaving,
                                onClick = callbacks.onSave,
                                modifier = Modifier.weight(1f).height(44.dp)
                            )
                            PrimaryButton(
                                text = "Cancel",
                                onClick = callbacks.onCancelReauth,
                                modifier = Modifier.weight(1f).height(44.dp)
                            )
                        }
                    }
                } else {
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        PrimaryButton(
                            text = "Save Changes",
                            onClick = callbacks.onPromptReauth,
                            modifier = Modifier.weight(1f).height(44.dp)
                        )
                        PrimaryButton(
                            text = "Cancel",
                            onClick = callbacks.onCancelEditing,
                            modifier = Modifier.weight(1f).height(44.dp)
                        )
                    }
                }
            } else {
                PrimaryButton(text = "Edit Profile", onClick = callbacks.onStartEditing, modifier = Modifier.height(44.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        BubbleCard(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Bingwa Autopilot", color = TextWhite, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                    Text(
                        text = when (state.engineState) {
                            EngineState.RUNNING -> "Running"
                            EngineState.PAUSED -> "Paused"
                            EngineState.STOPPED -> "Stopped"
                        },
                        color = when (state.engineState) {
                            EngineState.RUNNING -> TickGreen
                            EngineState.PAUSED -> TextWhite.copy(alpha = 0.7f)
                            EngineState.STOPPED -> TextWhite.copy(alpha = 0.5f)
                        },
                        fontSize = 12.sp
                    )
                }
                HapticSwitch(
                    checked = state.engineEnabled,
                    onCheckedChange = { callbacks.onToggleEngine() }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ProfileMenuRow("Agent Portal", Icons.Rounded.Storefront, callbacks.onMyStore)
        ProfileMenuRow("Refer & Earn", Icons.Rounded.Share, callbacks.onReferEarn)
        ProfileMenuRow("Settings", Icons.Rounded.Settings, callbacks.onSettings)
        ProfileMenuRow("About", Icons.Rounded.Info, callbacks.onAbout)
        Spacer(modifier = Modifier.height(24.dp))
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
    Column {
        Text(label, color = TextFaint, fontSize = 10.sp)
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(color = TextWhite, fontSize = 14.sp),
            visualTransformation = if (isPassword) androidx.compose.ui.text.input.PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            cursorBrush = SolidColor(AccentBlue),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Bubble)
                .padding(horizontal = 10.dp, vertical = 9.dp)
        )
    }
}

@Composable
private fun LevelBadge(levelName: String) {
    val color = when (levelName) {
        "Bronze" -> Bronze
        "Silver" -> Silver
        "Gold" -> Gold
        "Platinum" -> Platinum
        else -> PendGrey
    }
    Box(
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
            .background(Brush.horizontalGradient(listOf(color, color.copy(alpha = 0.7f))))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(levelName, color = BgBlack, fontSize = 11.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun ProfileMenuRow(label: String, icon: ImageVector, onClick: () -> Unit) {
    BubbleCard(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 4.dp),
        onClick = onClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = AccentBlue, modifier = Modifier.size(22.dp))
            Spacer(modifier = Modifier.width(14.dp))
            Text(label, color = TextWhite, fontSize = 15.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
            Icon(Icons.Rounded.ChevronRight, contentDescription = null, tint = TextFaint, modifier = Modifier.size(20.dp))
        }
    }
}
