package com.bingwascore.app.ui.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.components.GlassCard
import com.bingwascore.app.ui.theme.DesignTokens

/**
 * S68 — Activation ladder.
 *
 * Four task rows inside a glass card. Progress ring shows n/4. When all four
 * tasks are complete a lime summary strip is shown.
 */
@Composable
fun ActivationLadder(
    engineArmed: Boolean,
    testDriveDone: Boolean,
    importBookDone: Boolean,
    recoverFailureDone: Boolean,
    onEngineArmedClick: () -> Unit,
    onTestDriveClick: () -> Unit,
    onImportBookClick: () -> Unit,
    onRecoverFailureClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tasks = listOf(
        LadderTask("Arm the engine", "Grant SMS + Phone so the autopilot can dial.", engineArmed, onEngineArmedClick),
        LadderTask("Test drive a payment", "Run one sandbox payment end-to-end.", testDriveDone, onTestDriveClick),
        LadderTask("Import your book", "Upload CSV or link to existing customers.", importBookDone, onImportBookClick),
        LadderTask("Recover a failure", "Retry one failed transaction with one tap.", recoverFailureDone, onRecoverFailureClick)
    )
    val completed = tasks.count { it.done }
    val allDone = completed == tasks.size

    GlassCard(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ProgressRing(completed = completed, total = tasks.size)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Activation ladder",
                        color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                        fontSize = DesignTokens.Typography.Subhead,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "$completed/${tasks.size} complete",
                        color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                        fontSize = DesignTokens.Typography.Caption
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            tasks.forEach { task ->
                TaskRow(task = task)
                Spacer(modifier = Modifier.height(10.dp))
            }

            if (allDone) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(DesignTokens.Shape.RadiusMd))
                        .background(DesignTokens.Semantic.complete)
                        .padding(horizontal = 12.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Autopilot armed · streak day 1 · retry queue active",
                        color = DesignTokens.LocalBingwaRoles.current.onSuccess,
                        fontSize = DesignTokens.Typography.Body,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

private data class LadderTask(
    val title: String,
    val caption: String,
    val done: Boolean,
    val onClick: () -> Unit
)

@Composable
private fun TaskRow(task: LadderTask) {
    val alpha by animateFloatAsState(targetValue = if (task.done) 0.6f else 1f, label = "TaskAlpha")
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = task.onClick)
            .padding(vertical = 4.dp)
            .alphaIf(alpha)
    ) {
        CheckboxTile(checked = task.done)
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = task.title,
                color = DesignTokens.LocalBingwaRoles.current.textPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = task.caption,
                color = DesignTokens.LocalBingwaRoles.current.textSecondary,
                fontSize = 12.sp
            )
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(
                    if (task.done) DesignTokens.Semantic.complete
                    else DesignTokens.LocalBingwaRoles.current.brand
                )
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Text(
                text = if (task.done) "DONE" else "ACTION",
                color = if (task.done) DesignTokens.LocalBingwaRoles.current.onSuccess
                    else DesignTokens.LocalBingwaRoles.current.onBrand,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun CheckboxTile(checked: Boolean) {
    val color by animateColorAsState(
        targetValue = if (checked) DesignTokens.Semantic.complete
            else DesignTokens.LocalBingwaRoles.current.border,
        label = "CheckboxColor"
    )
    Box(
        modifier = Modifier
            .size(26.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Rounded.Check,
                contentDescription = "Done",
                tint = DesignTokens.LocalBingwaRoles.current.onSuccess,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
private fun ProgressRing(completed: Int, total: Int) {
    val progress = completed.toFloat() / total.toFloat().coerceAtLeast(1f)
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = { progress },
            modifier = Modifier.size(52.dp),
            color = DesignTokens.Semantic.complete,
            trackColor = DesignTokens.LocalBingwaRoles.current.border,
            strokeWidth = 6.dp
        )
        Text(
            text = "$completed",
            color = DesignTokens.LocalBingwaRoles.current.textPrimary,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

private fun Modifier.alphaIf(alpha: Float): Modifier = this.then(Modifier.alpha(alpha))
