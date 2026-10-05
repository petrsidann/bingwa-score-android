package com.bingwascore.app.ui.community

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.Storefront
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.BubbleCard
import com.bingwascore.app.ui.components.ShimmerBlock
import com.bingwascore.app.ui.theme.PendGrey
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.OfferTags
import com.bingwascore.app.ui.theme.TextFaint
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.util.screenEnter

/**
 * PREMIUM LOCK — "Community": the agent marketplace.
 *
 * Bundles other agents have published to the relay, so a new agent can see
 * what sells before dialling their own stock. Backed entirely by the local
 * Room offer table — no network, no backend. Works offline on first launch.
 */
@Composable
fun CommunityScreen(viewModel: CommunityViewModel = hiltViewModel()) {
    val listings by viewModel.listings.collectAsStateWithLifecycle()
    val selectedTag by viewModel.selectedTag.collectAsStateWithLifecycle()
    val loading by viewModel.loading.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(BgBlack)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text("Community", color = TextWhite, style = BingwaType.headlineStyle)
                Text(
                    "${listings.size} listing(s) from agents on the relay",
                    color = TextWhite.copy(alpha = 0.5f),
                    style = BingwaType.captionStyle
                )
            }

            // Tag filters — horizontally scrollable so the row never truncates.
            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(OfferTags.ALL) { tag ->
                    val label = tag.removePrefix("OFFER_").replace('_', ' ')
                    CommunityFilterChip(
                        label = "Offer $label",
                        selected = tag == selectedTag,
                        onClick = { viewModel.selectTag(if (tag == selectedTag) null else tag) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            when {
                loading -> CommunitySkeleton()
                listings.isEmpty() -> EmptyState(
                    icon = Icons.Rounded.Groups,
                    title = "The community is quiet",
                    message = "No shared listings yet. Bundles agents publish to the relay show up " +
                        "here — everything still works offline.",
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                else -> LazyColumn(
                    contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 96.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(listings, key = { _, listing -> listing.id }) { index, listing ->
                        CommunityCard(listing = listing, enterDelayMillis = minOf(index, 6) * 35)
                    }
                }
            }
        }
    }
}
/**
 * One marketplace card. `enterDelayMillis` drives the shared stagger inside
 * [BubbleCard], so the cascade matches every other list in the app.
 */
@Composable
private fun CommunityCard(listing: CommunityListing, enterDelayMillis: Int) {
    BubbleCard(
        modifier = Modifier.fillMaxWidth(),
        cornerRadius = 20.dp,
        enterDelayMillis = enterDelayMillis
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        if (listing.isVerified) {
                            Brush.horizontalGradient(listOf(PendGrey, AccentBlue))
                        } else {
                            Brush.horizontalGradient(
                                listOf(TextWhite.copy(alpha = 0.18f), TextWhite.copy(alpha = 0.08f))
                            )
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (listing.isVerified) Icons.Rounded.Verified else Icons.Rounded.Storefront,
                    contentDescription = null,
                    tint = if (listing.isVerified) BgBlack else TextWhite.copy(alpha = 0.8f),
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(listing.name, color = TextWhite, style = BingwaType.labelStyle)
                Spacer(modifier = Modifier.height(3.dp))
                Text(listing.seller, color = TextWhite.copy(alpha = 0.5f), style = BingwaType.captionStyle)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    "Ksh ${listing.price}",
                    color = if (listing.isVerified) PendGrey else TextWhite,
                    style = BingwaType.labelStyle
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(listing.tagLabel, color = TextFaint, style = BingwaType.microStyle)
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MetaPill(text = "${listing.validityHours}h data", tint = TextWhite.copy(alpha = 0.7f))
            if (listing.autoRenewable) MetaPill(text = "Auto-renew", tint = TickGreen)
            if (listing.silentEligible) MetaPill(text = "Ghost Queue", tint = PendGrey)
        }
    }
}

/** Small translucent pill used for the card metadata strip. */
@Composable
private fun MetaPill(text: String, tint: Color) {
    Text(
        text,
        color = tint,
        style = BingwaType.microStyle,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .clip(CircleShape)
            .background(tint.copy(alpha = 0.12f))
            .padding(horizontal = 10.dp, vertical = 5.dp)
    )
}

/** Filter chip for the tag row. Tapping the active tag clears the filter. */
@Composable
private fun CommunityFilterChip(label: String, selected: Boolean, onClick: () -> Unit) {
    Text(
        label,
        color = if (selected) BgBlack else TextWhite.copy(alpha = 0.7f),
        style = BingwaType.captionStyle,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .clip(CircleShape)
            .background(
                if (selected) {
                    Brush.horizontalGradient(listOf(AccentBlue, PendGrey))
                } else {
                    Brush.horizontalGradient(
                        listOf(TextWhite.copy(alpha = 0.12f), TextWhite.copy(alpha = 0.06f))
                    )
                }
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 8.dp)
    )
}

/** Shimmer placeholders so the marketplace never pops in empty. */
@Composable
private fun CommunitySkeleton() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(3) {
            BubbleCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 20.dp) {
                ShimmerBlock(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                ShimmerBlock(modifier = Modifier.fillMaxWidth(0.6f))
            }
        }
    }
}
