package com.bingwascore.app.referral

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
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
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.GradientButton
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.TealBlue
import com.bingwascore.app.ui.theme.White
import com.bingwascore.app.util.screenEnter

@Composable
fun ReferralScreen(viewModel: ReferralViewModel = hiltViewModel()) {
    val code by viewModel.referralCode.collectAsStateWithLifecycle()
    val count by viewModel.referralCount.collectAsStateWithLifecycle()
    val storeLink by viewModel.storeLink.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().screenEnter().background(NightBlack).verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp)) {
            Text("Refer & Earn", color = White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Invite friends and earn rewards", color = White.copy(alpha = 0.5f), fontSize = 12.sp)
        }

        GlassCard(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Text("Your Referral Code", color = White.copy(alpha = 0.55f), fontSize = 12.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(code.ifEmpty { "---" }, color = White, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                Row(
                    modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(Color(0x14FFFFFF)).clickable {
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        clipboard.setPrimaryClip(ClipData.newPlainText("Referral Code", code))
                    }.padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Rounded.ContentCopy, contentDescription = "Copy", tint = TealBlue, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Copy", color = TealBlue, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text("$count friend(s) joined", color = EmeraldGreen, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        GradientButton(
            text = "Invite Friends",
            onClick = {
                viewModel.recordShare()
                val msg = "I'm using Bingwa Score to run my bundle business on autopilot. Join me: $code"
                val send = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, msg)
                }
                context.startActivity(Intent.createChooser(send, "Invite via"))
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        GradientButton(
            text = "Share My Store",
            onClick = {
                viewModel.recordShare()
                val msg = if (storeLink.isNotEmpty()) "Check out my store: $storeLink" else "Join me on Bingwa Score!"
                val send = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, msg)
                }
                context.startActivity(Intent.createChooser(send, "Share via"))
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}
