package com.bingwascore.app.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.Radar
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalLayoutDirection
import com.bingwascore.app.ui.components.SecondaryButton
import com.bingwascore.app.ui.components.StatusDot
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.FailRed
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.TickGreen
import com.bingwascore.app.util.rememberHaptics
import kotlinx.coroutines.delay

/**
 * POLISH P2 — the Home top bar, as three small pieces of chrome.
 *
 * Greeting on the left (the only serif italic sentence in the app, because a
 * greeting set in the same sans as everything else reads as a label), credits
 * bubble on the right. Both are quiet; neither competes with the numbers.
 */
object HomeChrome {
    const val MAX_CREDIT_ROWS = 12
}

/** One credit line in the Credits sheet. */
data class CreditRow(val title: String, val subtitle: String, val amount: Double)

/**
 * The greeting, in serif italic with generous tracking — the one piece of
 * typography on Home that is allowed to be beautiful rather than efficient.
 *
 * Arabic renders right-to-left, so the whole line flips: an LTR layout with an
 * RTL sentence inside is the difference between "thought about it" and "not
 * thought about it".
 */
@Composable
fun GreetingLine(
    bucket: Greetings.Bucket,
    language: Greetings.Language,
    modifier: Modifier = Modifier
) {
    val text = Greetings.text(bucket, language)
    CompositionLocalProvider(
        LocalLayoutDirection provides if (language.rtl) LayoutDirection.Rtl else LayoutDirection.Ltr
    ) {
        Text(
            text = text,
            color = TextWhite,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            fontSize = 19.sp,
            letterSpacing = 1.4.sp,
            maxLines = 1,
            modifier = modifier
        )
    }
}

/**
 * The credits bubble: +1 per successful transaction, so it is a running tally of
 * sales rather than a vanity counter. A star glyph plus the number, tinted by
 * how much the week has earned.
 */
@Composable
fun CreditsBubble(credits: Int, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val haptics = rememberHaptics()
    val shape = RoundedCornerShape(50)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(shape)
            .background(BubbleRaised())
            .border(1.dp, Hairline, shape)
            .clickable {
                haptics.tick()
                onClick()
            }
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Stars,
            contentDescription = null,
            tint = AccentBlue,
            modifier = Modifier.size(13.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "$credits",
            color = TextWhite,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/** The bubble's own surface, one step above the canvas so it floats a little. */
@Composable
private fun BubbleRaised(): Color = Raised

/**
 * The Home top bar: greeting on the left, credits bubble on the right.
 *
 * The greeting is the only sentence on the screen set in a serif, which is
 * exactly why it reads as a greeting and not as another label; the credits
 * bubble is the only piece of chrome on Home that is not text, which is exactly
 * why it reads as something you can tap.
 */
@Composable
fun HomeTopBar(
    bucket: Greetings.Bucket,
    language: Greetings.Language,
    credits: Int,
    onCreditsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GreetingLine(bucket = bucket, language = language, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(12.dp))
        CreditsBubble(credits = credits, onClick = onCreditsClick)
    }
}

/**
 * The Credits sheet — where a credit goes.
 *
 * Each credit is a real transaction: the customer's number, the offer, and the
 * commission Safaricom paid. A bare "+1" would be a game; this is a ledger.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditsSheet(
    credits: Int,
    rows: List<CreditRow>,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = Raised,
        dragHandle = null
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp, bottom = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.Stars,
                    contentDescription = null,
                    tint = AccentBlue,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Credits",
                    color = TextWhite,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$credits earned",
                    color = AccentBlue,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "One credit for every bundle that completed.",
                color = TextGrey,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(14.dp))

            if (rows.isEmpty()) {
                Text(
                    text = "No credits yet. Your first completed bundle will land here.",
                    color = TextDim,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(vertical = 18.dp)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.heightIn(max = 320.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(rows, key = { it.title + it.subtitle }) { row ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .background(AccentBlue.copy(alpha = 0.10f))
                                .padding(horizontal = 12.dp, vertical = 10.dp)
                        ) {
                            StatusDot(color = TickGreen, lit = true, size = 8.dp)
                            Spacer(modifier = Modifier.width(10.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = row.title,
                                    color = TextWhite,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 1
                                )
                                Text(
                                    text = row.subtitle,
                                    color = TextGrey,
                                    fontSize = 11.sp,
                                    maxLines = 1
                                )
                            }
                            Text(
                                text = "+1",
                                color = AccentBlue,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            SecondaryButton(text = "Close", onClick = onDismiss)
            Spacer(modifier = Modifier.navigationBarsPadding().height(8.dp))
        }
    }
}

/**
 * The Autopilot pill.
 *
 * Autopilot used to be a full-width card with a switch, which made "is the
 * engine on?" look like the app's most important decision. It is not — it is a
 * heartbeat, and it reads as one in a 36dp pill.
 *
 * The asymmetry is deliberate: **tap** is free (it opens the Autopilot sheet),
 * but **stopping** takes a 600ms hold, after which a confirmation asks once more.
 * The engine silently stops dialling when an agent brushes past a switch, and a
 * stalled engine is a lost sale every minute it stays off — so the destructive
 * act gets two deliberate steps, and the safe one gets none.
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AutopilotPill(
    engineState: com.bingwascore.app.domain.EngineState,
    onOpenSheet: () -> Unit,
    onPause: () -> Unit,
    modifier: Modifier = Modifier
) {
    val haptics = rememberHaptics()
    var armed by remember { mutableStateOf(false) }
    val shape = RoundedCornerShape(50)
    val isRunning = engineState == com.bingwascore.app.domain.EngineState.RUNNING
    val isPaused = engineState == com.bingwascore.app.domain.EngineState.PAUSED
    val isStopped = engineState == com.bingwascore.app.domain.EngineState.STOPPED

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(shape)
            .background(
                when {
                    isRunning -> AccentBlue.copy(alpha = 0.14f)
                    isPaused -> TextDim.copy(alpha = 0.20f)
                    else -> Raised
                }
            )
            .border(
                1.dp,
                when {
                    isRunning -> AccentBlue.copy(alpha = 0.45f)
                    isPaused -> TextDim.copy(alpha = 0.5f)
                    else -> Hairline
                },
                shape
            )
            .combinedClickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onLongClick = {
                    if (isRunning) {
                        haptics.press()
                        armed = true
                    }
                },
                onClick = {
                    armed = false
                    haptics.tick()
                    onOpenSheet()
                }
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Radar,
            contentDescription = null,
            tint = when {
                isRunning -> AccentBlue
                isPaused -> TextGrey
                else -> TextDim
            },
            modifier = Modifier.size(15.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = when (engineState) {
                com.bingwascore.app.domain.EngineState.RUNNING -> "Autopilot · Running"
                com.bingwascore.app.domain.EngineState.PAUSED -> "Autopilot · Paused"
                com.bingwascore.app.domain.EngineState.STOPPED -> "Autopilot · Stopped"
            },
            color = if (isStopped) TextGrey else TextWhite,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

    // Hold for 600ms pauses the engine
    LaunchedEffect(armed) {
        if (armed) {
            delay(Motion.ARM_HOLD_MILLIS)
            armed = false
            onPause()
        }
    }
}

/**
 * The Autopilot sheet — shows current 3-state engine status with Resume, Pause, Stop, Start actions.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutopilotSheet(
    engineState: com.bingwascore.app.domain.EngineState,
    onDismiss: () -> Unit,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onResume: () -> Unit,
    onStop: () -> Unit
) {
    val haptics = rememberHaptics()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = Raised,
        dragHandle = null
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp, bottom = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.Radar,
                    contentDescription = null,
                    tint = if (engineState == com.bingwascore.app.domain.EngineState.RUNNING) AccentBlue else TextDim,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Autopilot",
                    color = TextWhite,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = when (engineState) {
                        com.bingwascore.app.domain.EngineState.RUNNING -> "Running"
                        com.bingwascore.app.domain.EngineState.PAUSED -> "Paused"
                        com.bingwascore.app.domain.EngineState.STOPPED -> "Stopped"
                    },
                    color = when (engineState) {
                        com.bingwascore.app.domain.EngineState.RUNNING -> AccentBlue
                        com.bingwascore.app.domain.EngineState.PAUSED -> TextGrey
                        com.bingwascore.app.domain.EngineState.STOPPED -> FailRed
                    },
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Autopilot watches every incoming M-Pesa payment, matches it to an " +
                    "offer and dials the bundle without you touching the phone.",
                color = TextGrey,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            when (engineState) {
                com.bingwascore.app.domain.EngineState.RUNNING -> {
                    SecondaryButton(
                        text = "Pause Autopilot (Hold pill to pause)",
                        onClick = {
                            haptics.tick()
                            onPause()
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    HoldToStopButton(
                        onArm = {
                            haptics.press()
                            onStop()
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Hold for 600ms to stop Autopilot completely.",
                        color = TextDim,
                        fontSize = 11.sp
                    )
                }
                com.bingwascore.app.domain.EngineState.PAUSED -> {
                    Surface(
                        onClick = {
                            haptics.press()
                            onResume()
                        },
                        shape = RoundedCornerShape(14.dp),
                        color = AccentBlue,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Resume Autopilot",
                                color = Color.White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    HoldToStopButton(
                        onArm = {
                            haptics.press()
                            onStop()
                        }
                    )
                }
                com.bingwascore.app.domain.EngineState.STOPPED -> {
                    Surface(
                        onClick = {
                            haptics.press()
                            onStart()
                        },
                        shape = RoundedCornerShape(14.dp),
                        color = AccentBlue,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Start Autopilot",
                                color = Color.White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            SecondaryButton(text = "Close", onClick = onDismiss)
            Spacer(modifier = Modifier.navigationBarsPadding().height(8.dp))
        }
    }
}

/** The hold-to-stop control. Press-and-hold for [Motion.ARM_HOLD_MILLIS]. */
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HoldToStopButton(onArm: () -> Unit) {
    val haptics = rememberHaptics()
    val shape = RoundedCornerShape(14.dp)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(FailRed.copy(alpha = 0.14f))
            .border(1.dp, FailRed.copy(alpha = 0.5f), shape)
            .combinedClickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { haptics.tick() },
                onLongClick = {
                    haptics.press()
                    onArm()
                }
            )
            .height(52.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Bolt,
            contentDescription = null,
            tint = FailRed,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Hold to stop Autopilot",
            color = TextWhite,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
