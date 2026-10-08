package com.bingwascore.app.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.services.EngineDiagnostics
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.Bubble
import com.bingwascore.app.ui.theme.StatusColors
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite

/**
 * E1 — the balance-unavailable escape hatch: the six on-screen engine checks
 * plus an optional silent `*144#` ping, in one dialog. Every result is appended
 * to [com.bingwascore.app.util.EngineLog] so a field report can quote it.
 */
@Composable
fun EngineDiagnosticsDialog(onDismiss: () -> Unit) {
    val context = LocalContext.current
    var checks by remember { mutableStateOf<List<EngineDiagnostics.Check>>(emptyList()) }
    var pingLine by remember { mutableStateOf<String?>(null) }
    var pingStarted by remember { mutableStateOf(false) }

    androidx.compose.runtime.LaunchedEffect(Unit) {
        checks = EngineDiagnostics.runSync(context)
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = Bubble,
        titleContentColor = TextWhite,
        textContentColor = TextGrey,
        title = { Text("Engine diagnostics", fontWeight = FontWeight.Bold, fontSize = 17.sp) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                checks.forEach { check ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Icon(
                            imageVector = if (check.passed) Icons.Rounded.CheckCircle
                            else Icons.Rounded.ErrorOutline,
                            contentDescription = null,
                            tint = if (check.passed) StatusColors.Success else StatusColors.Failed,
                            modifier = Modifier.size(17.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(check.name, color = TextWhite, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                            Text(check.detail, color = TextGrey, fontSize = 11.sp)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    pingLine ?: if (pingStarted) "Silent USSD ping running…" else
                        "Run a silent *144# ping to prove the radio answers.",
                    color = if (pingLine?.contains("PASS") == true) StatusColors.Success else TextGrey,
                    fontSize = 12.sp
                )
                if (!pingStarted) {
                    TextButton(onClick = {
                        pingStarted = true
                        EngineDiagnostics.pingUssd(context) { _, ok, detail ->
                            pingLine = (if (ok) "USSD PASS" else "USSD FAIL") + " — $detail"
                        }
                    }) { Text("Run USSD ping", color = AccentBlue, fontSize = 14.sp) }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Close", color = AccentBlue, fontWeight = FontWeight.Bold) }
        },
        shape = RoundedCornerShape(22.dp)
    )
}