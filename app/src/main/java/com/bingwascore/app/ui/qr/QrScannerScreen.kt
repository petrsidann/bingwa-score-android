package com.bingwascore.app.ui.qr

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Contacts
import androidx.compose.material.icons.rounded.QrCodeScanner
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.ui.components.AmbientBackground
import com.bingwascore.app.ui.components.EmptyState
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.components.ShimmerBlock
import com.bingwascore.app.ui.theme.Amber
import com.bingwascore.app.ui.theme.BingwaOrange
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.EmeraldGreen
import com.bingwascore.app.ui.theme.NightBlack
import com.bingwascore.app.ui.theme.White
import com.bingwascore.app.util.screenEnter

/**
 * PREMIUM LOCK — "QR Scanner": pull contacts into the agent's book.
 *
 * Two import paths, both fully on-device:
 *  - **Scan a QR code** that encodes a vCard / MECARD payload.
 *  - **Import from the phone's contacts** via the system picker.
 *
 * Both resolve to canonical ten-digit numbers and are written straight into
 * Room, so an imported contact is immediately dialable. No network involved.
 */
@Composable
fun QrScannerScreen(viewModel: QrScannerViewModel = hiltViewModel()) {
    val imported by viewModel.imported.collectAsStateWithLifecycle()
    val message by viewModel.message.collectAsStateWithLifecycle()
    val busy by viewModel.busy.collectAsStateWithLifecycle()
    val context = LocalContext.current

    // Scanning delegates to the system barcode/QR handler: we hand it the
    // vision intent and get the decoded string back. Keeps the app free of a
    // bundled decoder while still being a real end-to-end scan flow.
    val scanLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val raw = result.data?.getStringExtra(QrPayloadContract.EXTRA_PAYLOAD)
        if (!raw.isNullOrBlank()) viewModel.importPayload(raw)
    }

    val pickContactLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickContact()
    ) { uri: Uri? ->
        if (uri == null) return@rememberLauncherForActivityResult
        val number = runCatching {
            context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val index = cursor.getColumnIndex(ContactsContractPhone.NUMBER)
                    if (index >= 0) cursor.getString(index) else null
                } else {
                    null
                }
            }
        }.getOrNull()
        if (!number.isNullOrBlank()) viewModel.importNumber(number)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .screenEnter()
            .background(NightBlack)
    ) {
        AmbientBackground()

        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text("QR Scanner", color = White, style = BingwaType.headlineStyle)
                Text(
                    "Scan a code or pick a contact to add them to your book",
                    color = White.copy(alpha = 0.5f),
                    style = BingwaType.captionStyle
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ImportTile(
                    icon = Icons.Rounded.QrCodeScanner,
                    title = "Scan QR",
                    subtitle = "vCard or MECARD",
                    modifier = Modifier.weight(1f),
                    onClick = { scanLauncher.launch(Intent(QrPayloadContract.ACTION)) }
                )
                ImportTile(
                    icon = Icons.Rounded.Contacts,
                    title = "From Contacts",
                    subtitle = "Phone book",
                    modifier = Modifier.weight(1f),
                    onClick = { pickContactLauncher.launch(null) }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            val statusText = message
            if (!statusText.isNullOrBlank()) {
                Text(
                    statusText,
                    color = if (imported.isNotEmpty()) EmeraldGreen else White.copy(alpha = 0.7f),
                    style = BingwaType.captionStyle,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            if (busy) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    repeat(2) {
                        GlassCard(modifier = Modifier.fillMaxWidth(), cornerRadius = 18.dp) {
                            ShimmerBlock(modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
            } else if (imported.isEmpty()) {
                EmptyState(
                    icon = Icons.Rounded.QrCodeScanner,
                    title = "No contacts imported yet",
                    message = "Scan a QR vCard or pick someone from your phone book — they land " +
                        "in your agent book and become dialable right away.",
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 96.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    itemsIndexed(imported, key = { _, entry -> entry.phone }) { index, entry ->
                        ImportedRow(
                            entry = entry,
                            enterDelayMillis = minOf(index, 6) * 35
                        )
                    }
                }
            }
        }
    }
}

/** One of the two import entry points (Scan QR / From Contacts). */
@Composable
private fun ImportTile(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    GlassCard(modifier = modifier, cornerRadius = 18.dp, onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null, tint = Amber, modifier = Modifier.size(26.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text(title, color = White, style = BingwaType.labelStyle)
        Spacer(modifier = Modifier.height(3.dp))
        Text(subtitle, color = White.copy(alpha = 0.5f), style = BingwaType.microStyle)
    }
}

/** One imported contact. */
@Composable
private fun ImportedRow(entry: ImportedContact, enterDelayMillis: Int) {
    GlassCard(
        modifier = Modifier.fillMaxWidth(),
        cornerRadius = 18.dp,
        enterDelayMillis = enterDelayMillis
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(Brush.horizontalGradient(listOf(BingwaOrange, Amber))),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = null,
                    tint = NightBlack,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(entry.name, color = White, style = BingwaType.labelStyle)
                Spacer(modifier = Modifier.height(3.dp))
                Text(entry.phone, color = White.copy(alpha = 0.5f), style = BingwaType.captionStyle)
            }
            Text(
                "Saved",
                color = EmeraldGreen,
                style = BingwaType.microStyle,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
