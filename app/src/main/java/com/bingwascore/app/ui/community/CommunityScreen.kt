package com.bingwascore.app.ui.community

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.glass.GlassCard
import com.bingwascore.app.ui.theme.DesignTokens
import com.bingwascore.app.util.screenEnter

@Composable
fun CommunityScreen(viewModel: CommunityViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(DesignTokens.LocalBingwaRoles.current.bg)
    ) {
        // S4.1 Back + "Community"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Back",
                tint = DesignTokens.LocalBingwaRoles.current.textPrimary,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Navigate back */ }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Community",
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(start = 20.dp, end = 20.dp, bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // S4.2 Stats glass card
            item {
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        KVRow(label = "Agents online", value = "${state.agentsOnline}")
                        Spacer(modifier = Modifier.height(8.dp))
                        KVRow(label = "Your rank", value = "#${state.yourRank}")
                        Spacer(modifier = Modifier.height(8.dp))
                        KVRow(label = "Streak", value = "${state.streakDays} day")
                    }
                }
            }

            // S4.3 Feed section header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Feed",
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "+ Post",
                        color = DesignTokens.LocalBingwaRoles.current.brand,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable { /* Open compose sheet */ }
                    )
                }
            }

            // S4.4 Three seeded posts
            itemsIndexed(state.posts) { index, post ->
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    PostRow(post = post, onLike = { viewModel.toggleLike(index) })
                }
            }
        }
    }
}

@Composable
private fun KVRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
            fontSize = 12.sp
        )
        Text(
            text = value,
            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun PostRow(post: CommunityPost, onLike: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        // 36dp violet initials avatar
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF7C3AED).copy(alpha = 0.14f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = post.initials,
                color = Color(0xFF7C3AED),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = post.author,
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = post.body,
                color = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.7f),
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Like row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.clickable(onClick = onLike)
            ) {
                Icon(
                    imageVector = if (post.liked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                    contentDescription = "Like",
                    tint = if (post.liked) Color(0xFF9F1239) else DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "${post.likes}",
                    color = if (post.liked) Color(0xFF9F1239) else DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.5f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
