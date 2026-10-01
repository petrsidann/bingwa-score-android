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
import androidx.compose.material.icons.rounded.Block
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Storefront
import androidx.compose.material.icons.rounded.VerifiedUser
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
import com.bingwascore.app.ui.components.AmbientBackground
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.HapticSwitch
import com.bingwascore.app.ui.theme.Amber
import com.bingwascore.app.ui.theme.Bronze
import com.bingwascore.app.ui.theme.BingwaOrange
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.brandBrush
import com.bingwascore.app.ui.theme.Gold
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.Platinum
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.GlassFill
import com.bingwascore.app.ui.theme.Silver
import com.bingwascore.app.ui.theme.White
import com.bingwascore.app.util.screenEnter

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    onMyStore: () -> Unit = {},
    onReferEarn: () -> Unit = {},
    onSettings: () -> Unit = {},
    onAuthorizedSenders: () -> Unit = {},
    onBlacklist: () -> Unit = {},
    onAbout: () -> Unit = {}
) {
    val userName by viewModel.userName.collectAsStateWithLifecycle()
    val phone by viewModel.phone.collectAsStateWithLifecycle()
    val levelName by viewModel.levelName.collectAsStateWithLifecycle()
    val score by viewModel.score.collectAsStateWithLifecycle()
    val engineEnabled by viewModel.engineEnabled.collectAsStateWithLifecycle()
    val editState by viewModel.editState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize().screenEnter().background(NightBlack)
    ) {
        // PREMIUM LOCK — ambient blobs behind the glass cards on Profile.
        AmbientBackground()

        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp)) {
            Text("Profile", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Your agent account", color = White.copy(alpha = 0.5f), fontSize = 12.sp)
        }

        // MEGA A — the profile is EDITABLE and persisted, not a static card.
        // Level and score stay read-only because they are earned, not typed.
        GlassCard(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(54.dp).clip(CircleShape)
                        .background(brandBrush()),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        (if (editState.isEditing) editState.name else userName)
                            .ifBlank { "B" }.take(1).uppercase(),
                        color = NightBlack, fontSize = 22.sp, fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
                Column(modifier = Modifier.weight(1f)) {
                    if (editState.isEditing) {
                        ProfileField("Name", editState.name, viewModel::updateName)
                        Spacer(modifier = Modifier.height(8.dp))
                        ProfileField("Phone", editState.phone, viewModel::updatePhone)
                    } else {
                        Text(userName, color = White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                        Text(
                            phone.ifEmpty { "No phone set" },
                            color = White.copy(alpha = 0.5f),
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    LevelBadge(levelName)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Score: $score pts", color = White.copy(alpha = 0.7f), fontSize = 13.sp)
            }

            // Inline validation + save state, exactly like the offer settings form.
            editState.errorMessage?.let {
                Spacer(modifier = Modifier.height(10.dp))
                Text(it, color = ErrorRed, fontSize = 12.sp)
            }
            editState.savedMessage?.let {
                Spacer(modifier = Modifier.height(10.dp))
                Text(it, color = EmeraldGreen, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))
            if (editState.isEditing) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    GradientButton(
                        text = if (editState.isSaving) "Saving…" else "Save",
                        enabled = !editState.isSaving,
                        onClick = viewModel::saveProfile,
                        modifier = Modifier.weight(1f)
                    )
                    GradientButton(
                        text = "Cancel",
                        onClick = viewModel::cancelEditing,
                        modifier = Modifier.weight(1f)
                    )
                }
            } else {
                GradientButton(text = "Edit Profile", onClick = viewModel::startEditing)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        GlassCard(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Bingwa Autopilot", color = White, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                    Text(if (engineEnabled) "Running" else "Stopped",
                        color = if (engineEnabled) EmeraldGreen else White.copy(alpha = 0.5f), fontSize = 12.sp)
                }
                HapticSwitch(checked = engineEnabled, onCheckedChange = { viewModel.toggleEngine() })
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ProfileMenuRow("Agent Portal", Icons.Rounded.Storefront, onMyStore)
        ProfileMenuRow("Refer & Earn", Icons.Rounded.Share, onReferEarn)
        ProfileMenuRow("Settings", Icons.Rounded.Settings, onSettings)
        ProfileMenuRow("Trusted Partners", Icons.Rounded.VerifiedUser, onAuthorizedSenders)
        ProfileMenuRow("Blocked Contacts", Icons.Rounded.Block, onBlacklist)
        ProfileMenuRow("About", Icons.Rounded.Info, onAbout)
        Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun ProfileField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column {
        Text(label, color = White.copy(alpha = 0.45f), fontSize = 10.sp)
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(color = White, fontSize = 14.sp),
            cursorBrush = SolidColor(BingwaOrange),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(GlassFill)
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
        else -> Amber
    }
    Box(
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
            .background(Brush.horizontalGradient(listOf(color, color.copy(alpha = 0.7f))))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(levelName, color = NightBlack, fontSize = 11.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun ProfileMenuRow(label: String, icon: ImageVector, onClick: () -> Unit) {
    GlassCard(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 4.dp),
        onClick = onClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = BingwaOrange, modifier = Modifier.size(22.dp))
            Spacer(modifier = Modifier.width(14.dp))
            Text(label, color = White, fontSize = 15.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
            Icon(Icons.Rounded.ChevronRight, contentDescription = null, tint = White.copy(alpha = 0.4f), modifier = Modifier.size(20.dp))
        }
    }
}
