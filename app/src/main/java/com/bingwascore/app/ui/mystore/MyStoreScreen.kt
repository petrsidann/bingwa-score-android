package com.bingwascore.app.ui.mystore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DeleteOutline
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.ErrorRed
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White

/** My Store: the agent's public storefront link with a live toggle. */
@Composable
fun MyStoreScreen(viewModel: MyStoreViewModel = hiltViewModel()) {
    val storeLink by viewModel.storeLink.collectAsStateWithLifecycle()
    val isActive by viewModel.isActive.collectAsStateWithLifecycle()
    val userName by viewModel.userName.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NightBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text("My Store", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(
                if (storeLink.isEmpty()) "Create your public storefront link"
                else "Your storefront is ${if (isActive) "live" else "paused"}",
                color = White.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
        }

        if (storeLink.isEmpty()) {
            GlassCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Storefront,
                    contentDescription = null,
                    tint = EmeraldGreen,
                    modifier = Modifier.size(34.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text("No store yet", color = White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    "Generate a shareable link from your name. Customers use it to browse " +
                        "your offers and buy bundles directly.",
                    color = White.copy(alpha = 0.55f),
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "bingwascore.com/store/${MyStoreViewModel.slugify(userName)}",
                    color = TealBlue,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(18.dp))
                GradientButton(text = "Generate Store Link", onClick = viewModel::generateStoreLink)
            }
        } else {
            StoreLinkCard(
                storeLink = storeLink,
                isActive = isActive,
                onToggle = viewModel::setActive,
                onDelete = viewModel::deleteStore
            )
        }
    }
}

@Composable
private fun StoreLinkCard(
    storeLink: String,
    isActive: Boolean,
    onToggle: (Boolean) -> Unit,
    onDelete: () -> Unit
) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Storefront", color = White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    if (isActive) "Visible to customers" else "Hidden from customers",
                    color = if (isActive) EmeraldGreen else White.copy(alpha = 0.45f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Switch(
                checked = isActive,
                onCheckedChange = onToggle,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = NightBlack,
                    checkedTrackColor = EmeraldGreen,
                    checkedBorderColor = EmeraldGreen,
                    uncheckedThumbColor = White.copy(alpha = 0.7f),
                    uncheckedTrackColor = Color(0x22FFFFFF),
                    uncheckedBorderColor = Color(0x33FFFFFF)
                )
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Color(0x14FFFFFF))
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Link,
                contentDescription = null,
                tint = TealBlue,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(storeLink, color = White, fontSize = 13.sp, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .clickable(onClick = onDelete)
                .padding(horizontal = 4.dp, vertical = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.DeleteOutline,
                contentDescription = "Delete store",
                tint = ErrorRed,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                "Delete store",
                color = ErrorRed,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

