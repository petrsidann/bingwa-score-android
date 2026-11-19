@file:Suppress("DEPRECATION")
package com.bingwascore.app.ui.glass

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Fingerprint
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DesignTokens

/** Entry-flow glass constants. Owned here per spec 0: glass lives only in ui/glass/. */
object PhaseSurface {
    val Bg = Color(0xFF060608)
    val Card = Color(0xFF0C0C0F)
    val Key = Color(0xFF17171D)
    val Cream = Color(0xFFF5F0D8)
    val Ink = Color(0xFFF4F5F7)
    val Mut = Color(0xFF8B8C96)
    val Bad = Color(0xFFFF8FA3)
    val KeyInk = Color(0xFF0B0B10)
    val Lime = DesignTokens.Launch.lime
    val Violet = DesignTokens.Launch.violet
    val Tint = 0.72f
    val Radius = 24.dp
    val KeySize = 62.dp
    val KeyGap = 11.dp
}

private fun Modifier.phaseCard(radius: Dp = PhaseSurface.Radius): Modifier = this
    .clip(RoundedCornerShape(radius))
    .background(PhaseSurface.Card.copy(alpha = PhaseSurface.Tint))
    .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(radius))

@Composable
fun PhaseScreen(content: @Composable ColumnScope.() -> Unit) {
    Box(Modifier.fillMaxSize().background(PhaseSurface.Bg)) {
        Column(
            Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState())
                .statusBarsPadding()
                .imePadding()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            content = content
        )
    }
}

@Composable
private fun PhaseKeyCell(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    cream: Boolean = false,
    content: @Composable () -> Unit
) {
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.92f else 1f,
        animationSpec = spring(dampingRatio = 0.6f, stiffness = 600f),
        label = "phaseKeyScale"
    )
    Box(modifier.height(PhaseSurface.KeySize), contentAlignment = Alignment.Center) {
        Box(
            Modifier.size(PhaseSurface.KeySize)
                .graphicsLayer { scaleX = scale; scaleY = scale }
                .clip(CircleShape)
                .background(if (cream) PhaseSurface.Cream else PhaseSurface.Key)
                .border(
                    width = 1.dp,
                    color = if (cream) Color.Transparent else Color.White.copy(alpha = 0.09f),
                    shape = CircleShape
                )
                .then(if (enabled) Modifier.clickable(source, null, onClick = onClick) else Modifier),
            contentAlignment = Alignment.Center
        ) { content() }
    }
}

@Composable
fun PhaseKeypad(
    onDigit: (Char) -> Unit,
    onBackspace: () -> Unit,
    onClear: () -> Unit,
    onSubmit: () -> Unit,
    onNext: () -> Unit,
    submitEnabled: Boolean,
    modifier: Modifier = Modifier,
    onUtil: (() -> Unit)? = null,
    utilIcon: ImageVector? = Icons.Rounded.Fingerprint
) {
    val keyText = TextStyle(fontSize = 21.sp, fontWeight = FontWeight.SemiBold, color = PhaseSurface.Ink)
    Column(
        modifier.phaseCard().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(PhaseSurface.KeyGap)
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(PhaseSurface.KeyGap)) {
            listOf('1', '2', '3').forEach { d ->
                PhaseKeyCell({ onDigit(d) }, Modifier.weight(1f)) { Text(d.toString(), style = keyText) }
            }
            PhaseKeyCell(onBackspace, Modifier.weight(1f), cream = true) {
                Icon(Icons.Rounded.Backspace, "Backspace", tint = PhaseSurface.KeyInk, modifier = Modifier.size(21.dp))
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(PhaseSurface.KeyGap)) {
            listOf('4', '5', '6').forEach { d ->
                PhaseKeyCell({ onDigit(d) }, Modifier.weight(1f)) { Text(d.toString(), style = keyText) }
            }
            PhaseKeyCell(onClear, Modifier.weight(1f), cream = true) {
                Text("C", style = keyText.copy(color = PhaseSurface.KeyInk, fontWeight = FontWeight.Bold))
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(PhaseSurface.KeyGap)) {
            listOf('7', '8', '9').forEach { d ->
                PhaseKeyCell({ onDigit(d) }, Modifier.weight(1f)) { Text(d.toString(), style = keyText) }
            }
            Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Box(
                    Modifier.width(PhaseSurface.KeySize)
                        .height(PhaseSurface.KeySize * 2 + PhaseSurface.KeyGap)
                        .clip(RoundedCornerShape(PhaseSurface.KeySize / 2))
                        .background(if (submitEnabled) PhaseSurface.Lime else PhaseSurface.Lime.copy(alpha = 0.32f))
                        .then(if (submitEnabled) Modifier.clickable(onClick = onSubmit) else Modifier),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Rounded.Check, "Submit", tint = PhaseSurface.KeyInk, modifier = Modifier.size(24.dp))
                }
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(PhaseSurface.KeyGap)) {
            if (onUtil != null && utilIcon != null) {
                PhaseKeyCell(onUtil, Modifier.weight(1f), cream = true) {
                    Icon(utilIcon, "Utility", tint = PhaseSurface.KeyInk, modifier = Modifier.size(20.dp))
                }
            } else {
                Spacer(Modifier.weight(1f).height(PhaseSurface.KeySize))
            }
            PhaseKeyCell({ onDigit('0') }, Modifier.weight(1f)) { Text("0", style = keyText) }
            PhaseKeyCell(onNext, Modifier.weight(1f)) {
                Icon(Icons.Rounded.ArrowForward, "Next field", tint = PhaseSurface.Ink, modifier = Modifier.size(20.dp))
            }
            Spacer(Modifier.weight(1f).height(PhaseSurface.KeySize))
        }
    }
}

@Composable
fun PhasePinReadout(count: Int, modifier: Modifier = Modifier) {
    Row(modifier, horizontalArrangement = Arrangement.spacedBy(11.dp)) {
        repeat(4) { i ->
            Box(
                Modifier.size(15.dp).clip(CircleShape)
                    .background(if (i < count) PhaseSurface.Lime else Color.White.copy(alpha = 0.16f))
            )
        }
    }
}

@Composable
fun PhaseDisplay(
    label: String,
    value: String,
    placeholder: String,
    hint: String,
    hintBad: Boolean,
    showCaret: Boolean,
    modifier: Modifier = Modifier,
    pinCount: Int? = null
) {
    Column(modifier.phaseCard().padding(18.dp)) {
        Text(
            label.uppercase(), color = PhaseSurface.Mut, fontSize = 10.sp,
            fontWeight = FontWeight.Black, letterSpacing = 1.6.sp
        )
        Spacer(Modifier.height(8.dp))
        if (pinCount != null) {
            Box(Modifier.height(38.dp), contentAlignment = Alignment.CenterStart) { PhasePinReadout(pinCount) }
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = if (value.isEmpty()) placeholder else value,
                    color = if (value.isEmpty()) Color(0xFF4A4B55) else Color.White,
                    fontSize = 33.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = (-1.2).sp
                )
                if (showCaret && value.isNotEmpty()) {
                    Box(Modifier.padding(start = 3.dp).width(2.dp).height(30.dp).background(PhaseSurface.Lime))
                }
            }
        }
        Spacer(Modifier.height(9.dp))
        Text(hint, color = if (hintBad) PhaseSurface.Bad else PhaseSurface.Mut, fontSize = 11.sp)
    }
}

@Composable
fun PhaseChips(
    labels: List<String>,
    selected: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
        labels.forEachIndexed { i, l ->
            val on = i == selected
            Box(
                Modifier.clip(CircleShape)
                    .background(if (on) PhaseSurface.Lime else Color.White.copy(alpha = 0.05f))
                    .border(1.dp, if (on) PhaseSurface.Lime else Color.White.copy(alpha = 0.09f), CircleShape)
                    .clickable { onSelect(i) }
                    .padding(horizontal = 14.dp, vertical = 7.dp)
            ) {
                Text(l, color = if (on) PhaseSurface.KeyInk else PhaseSurface.Mut, fontSize = 11.5.sp, fontWeight = FontWeight.ExtraBold)
            }
        }
    }
}

@Composable
fun PhaseCta(label: String, ready: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth().clip(CircleShape)
            .background(PhaseSurface.Card.copy(alpha = PhaseSurface.Tint))
            .border(1.dp, if (ready) PhaseSurface.Lime.copy(alpha = 0.5f) else Color.White.copy(alpha = 0.12f), CircleShape)
            .clickable(onClick = onClick)
            .padding(11.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier.size(44.dp).clip(CircleShape)
                .background(if (ready) PhaseSurface.Lime else Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Rounded.Check, null, tint = PhaseSurface.KeyInk, modifier = Modifier.size(20.dp))
        }
        Spacer(Modifier.width(14.dp))
        Text(label, color = Color.White, fontSize = 14.5.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.weight(1f))
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            repeat(3) {
                Icon(
                    Icons.Rounded.ArrowForward, null,
                    tint = if (ready) PhaseSurface.Lime else PhaseSurface.Mut,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}

@Composable
fun PhaseGrantRow(
    icon: ImageVector,
    title: String,
    caption: String,
    done: Boolean,
    onAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.fillMaxWidth().padding(vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            Modifier.size(42.dp).clip(RoundedCornerShape(14.dp))
                .background(if (done) PhaseSurface.Lime.copy(alpha = 0.14f) else Color.White.copy(alpha = 0.06f))
                .border(
                    1.dp,
                    if (done) PhaseSurface.Lime.copy(alpha = 0.5f) else Color.White.copy(alpha = 0.09f),
                    RoundedCornerShape(14.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, null, tint = if (done) PhaseSurface.Lime else Color(0xFFD8D9E0), modifier = Modifier.size(19.dp))
        }
        Column(Modifier.weight(1f)) {
            Text(title, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(3.dp))
            Text(caption, color = PhaseSurface.Mut, fontSize = 10.5.sp)
        }
        if (done) {
            Box(
                Modifier.clip(CircleShape).background(PhaseSurface.Lime).padding(horizontal = 13.dp, vertical = 8.dp)
            ) { Text("DONE", color = PhaseSurface.KeyInk, fontSize = 10.sp, fontWeight = FontWeight.Black) }
        } else {
            Box(
                Modifier.clip(CircleShape).background(PhaseSurface.Cream).clickable(onClick = onAction)
                    .padding(horizontal = 13.dp, vertical = 8.dp)
            ) { Text("ACTION", color = PhaseSurface.KeyInk, fontSize = 10.sp, fontWeight = FontWeight.Black) }
        }
    }
}

@Composable
fun PhaseMedallion(icon: ImageVector, violet: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier.size(172.dp).clip(CircleShape)
            .background(Color.White.copy(alpha = 0.05f))
            .border(1.dp, Color.White.copy(alpha = 0.12f), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, null, tint = if (violet) PhaseSurface.Violet else PhaseSurface.Lime, modifier = Modifier.size(74.dp))
    }
}

@Composable
fun PhaseSpringDots(count: Int, selected: Int, modifier: Modifier = Modifier) {
    Row(modifier, horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
        repeat(count) { i ->
            Box(
                Modifier.height(7.dp)
                    .width(if (i == selected) 26.dp else 7.dp)
                    .clip(CircleShape)
                    .background(if (i == selected) PhaseSurface.Lime else Color.White.copy(alpha = 0.2f))
            )
        }
    }
}

@Composable
fun PhaseTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isError: Boolean,
    errorMsg: String,
    keyboardType: KeyboardType,
    modifier: Modifier = Modifier
) {
    var focused by remember { mutableStateOf(false) }
    Column(modifier) {
        Text(label.uppercase(), color = PhaseSurface.Mut, fontSize = 10.sp, fontWeight = FontWeight.Black, letterSpacing = 1.6.sp)
        Spacer(Modifier.height(7.dp))
        Box(
            Modifier.fillMaxWidth().clip(RoundedCornerShape(14.dp))
                .background(Color.White.copy(alpha = 0.045f))
                .border(
                    width = if (focused || isError) 1.5.dp else 1.dp,
                    color = if (isError) PhaseSurface.Bad else if (focused) PhaseSurface.Lime else Color.White.copy(alpha = 0.11f),
                    shape = RoundedCornerShape(14.dp)
                )
                .padding(14.dp)
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = TextStyle(color = Color.White, fontSize = 15.sp),
                cursorBrush = SolidColor(PhaseSurface.Lime),
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                modifier = Modifier.fillMaxWidth().onFocusChanged { focused = it.isFocused }
            )
            if (value.isEmpty()) Text(placeholder, color = Color(0xFF5A5B65), fontSize = 15.sp)
        }
        if (isError) {
            Spacer(Modifier.height(6.dp))
            Text(errorMsg, color = PhaseSurface.Bad, fontSize = 10.5.sp)
        }
    }
}
