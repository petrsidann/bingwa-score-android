package com.bingwascore.app.ui.mystore

import android.content.Intent
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
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.PrimaryButton
import com.bingwascore.app.ui.components.HapticSwitch
import com.bingwascore.app.util.screenEnter
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite

/**
 * Agent Portal — the agent's public storefront.
 *
 * Named for what it actually is (a shopfront they can share), and given a REAL
 * empty state: a portal with nothing in it is not a broken screen, it is an
 * instruction to add the first offer.
 */
@Composable
fun MyStoreScreen(viewModel: MyStoreViewModel = hiltViewModel()) {
    val storeLink by viewModel.storeLink.collectAsStateWithLifecycle()
    val isActive by viewModel.isActive.collectAsStateWithLifecycle()
    val userName by viewModel.userName.collectAsStateWithLifecycle()
    val activeOffers by viewModel.activeOffers.collectAsStateWithLifecycle()
    val isEmpty by viewModel.isEmpty.collectAsStateWithLifecycle()

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(BgBlack)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Agent Portal", color = TextWhite, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    if (storeLink.isEmpty()) "Create your public storefront link"
                    else "Your storefront is ${if (isActive) "live" else "paused"}",
                    color = TextWhite.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )
            }
            Icon(
                Icons.Rounded.Share,
                contentDescription = "Share store",
                tint = AccentBlue,
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        val msg = if (storeLink.isNotEmpty()) "Check out my store: $storeLink" else "Join me on Bingwa Score!"
                        val send = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, msg)
                        }
                        context.startActivity(Intent.createChooser(send, "Share via"))
                    }
                    .padding(6.dp)
            )
        }

        // MEGA A — the real empty state. A storefront with nothing to sell is
        // the very first thing a new agent hits, so it must say what to do.
        if (isEmpty) {
            EmptyState(
                icon = Icons.Rounded.Storefront,
                title = "No offers yet — add one to start selling",
                message = "Your Agent Portal shows every active offer. Create your " +
                    "first bundle on the Offers tab and it appears here instantly, " +
                    "ready to share with customers.",
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        if (storeLink.isEmpty()) {
            BubbleCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Storefront,
                    contentDescription = null,
                    tint = AccentBlue,
                    modifier = Modifier.size(34.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text("No store yet", color = TextWhite, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    "Generate a shareable link from your name. Customers use it to browse " +
                        "your offers and buy bundles directly.",
                    color = TextWhite.copy(alpha = 0.55f),
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "bingwascore.com/store/${MyStoreViewModel.slugify(userName)}",
                    color = PendGrey,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(18.dp))
                PrimaryButton(text = "Generate Store Link", onClick = viewModel::generateStoreLink)
            }
        } else {
            StoreLinkCard(
                storeLink = storeLink,
                isActive = isActive,
                onToggle = viewModel::setActive,
                onDelete = viewModel::deleteStore
            )
        }

        // Live catalogue count so the portal is never just a link.
        if (!isEmpty) {
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                "${activeOffers.size} active ${if (activeOffers.size == 1) "offer" else "offers"} on sale",
                color = TextWhite.copy(alpha = 0.55f),
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
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
    BubbleCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Storefront", color = TextWhite, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    if (isActive) "Visible to customers" else "Hidden from customers",
                    color = if (isActive) TickGreen else TextFaint,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            HapticSwitch(
                checked = isActive,
                onCheckedChange = onToggle,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = BgBlack,
                    checkedTrackColor = AccentBlue,
                    checkedBorderColor = AccentBlue,
                    uncheckedThumbColor = TextWhite.copy(alpha = 0.7f),
                    uncheckedTrackColor = Raised,
                    uncheckedBorderColor = Hairline
                )
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Bubble)
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Link,
                contentDescription = null,
                tint = PendGrey,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(storeLink, color = TextWhite, fontSize = 13.sp, fontWeight = FontWeight.Medium)
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
                tint = FailRed,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                "Delete store",
                color = FailRed,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

