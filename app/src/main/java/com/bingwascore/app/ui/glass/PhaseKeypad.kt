package com.bingwascore.app.ui.glass

import androidx.compose.animation.animateColorAsState
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
import androidx.compose.foundation.layout.navigationBarsPadding
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
import androidx.compose.material.icons.automirrored.rounded.Backspace
import androidx.compose.material.icons.rounded.Check
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bingwascore.app.ui.theme.DesignTokens

/** Glass-system constants (spec 0: glass surfaces live only in ui/glass/). */
private val PhaseUtility = Color(0xFFF5F0D8)
private val PhaseUtilityInk = Color(0xFF0B0B10)
private val PadLime = Color(0xFFA4F510)
private val PadInk = Color(0xFFF8FAFC)

/** Shared dark surface colours consumed by entry-flow screens. */
object PhaseSurface {
    val Bg = Color(0xFF0B0B10)
    val Ink = Color(0xFFF8FAFC)
    val Mut = Color(0xFF9CA3AF)
    val Lime = Color(0xFFA4F510)
}

private fun Modifier.phaseGlass(radius: androidx.compose.ui.unit.Dp = 24.dp): Modifier =
    this
        .clip(RoundedCornerShape(radius))
        .background(Color.White.copy(alpha = 0.06f))
        .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(radius))
        .drawBehind {
            val stroke = 1.dp.toPx()
            drawLine(
                brush = Brush.horizontalGradient(
                    0f to Color.Transparent,
                    0.5f to Color.White.copy(alpha = 0.14f),
                    1f to Color.Transparent
                ),
                start = Offset(0f, stroke / 2f),
                end = Offset(size.width, stroke / 2f),
                strokeWidth = stroke
            )
        }

/** Dark screen scaffold for the entry flow. */
@Composable
fun PhaseScreen(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PhaseSurface.Bg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            content = content
        )
    }
}

/** Read-only glass display used for phone / PIN entry. */
@Composable
fun PhaseDisplay(
    label: String,
    value: String,
    placeholder: String = "",
    hint: String? = null,
    hintBad: Boolean = false,
    showCaret: Boolean = false,
    pinCount: Int? = null,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label.uppercase(),
            color = PhaseSurface.Mut,
            fontSize = 10.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 1.6.sp
        )
        Spacer(Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .phaseGlass()
                .padding(horizontal = 20.dp, vertical = 18.dp)
        ) {
            if (pinCount != null) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(4) { i ->
                        val filled = i < pinCount
                        Box(
                            Modifier
                                .size(12.dp)
                                .shadow(
                                    if (filled) 8.dp else 0.dp,
                                    CircleShape,
                                    spotColor = PadLime,
                                    clip = false
                                )
                                .clip(CircleShape)
                                .background(if (filled) PadLime else Color.White.copy(alpha = 0.22f))
                        )
                    }
                }
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                color = PadInk.copy(alpha = 0.35f),
                                fontSize = 34.sp,
                                fontWeight = FontWeight.Bold
                            )
                        } else {
                            Text(
                                text = value,
                                color = PadInk,
                                fontSize = 34.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    if (showCaret) {
                        Spacer(Modifier.width(8.dp))
                        Box(Modifier.width(2.dp).height(24.dp).background(PadLime))
                    }
                }
            }
        }
        if (hint != null) {
            Spacer(Modifier.height(6.dp))
            Text(
                text = hint,
                color = if (hintBad) PadLime else PhaseSurface.Mut,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

/** 4-dot PIN readout variant. */
@Composable
fun PhasePinDots(
    count: Int,
    active: Boolean,
    onTap: () -> Unit,
    modifier: Modifier = Modifier,
    total: Int = 4
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .phaseGlass()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onTap
            )
            .padding(horizontal = 18.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(total) { i ->
            val filled = i < count
            Box(
                Modifier
                    .size(12.dp)
                    .shadow(
                        if (filled) 8.dp else 0.dp,
                        CircleShape,
                        spotColor = PadLime,
                        clip = false
                    )
                    .clip(CircleShape)
                    .background(if (filled) PadLime else Color.White.copy(alpha = 0.22f))
            )
        }
    }
}

/** Shared dark-glass keypad. Consumed by Login and Create Account so they match exactly. */
@Composable
fun PhaseKeypad(
    onDigit: (Char) -> Unit,
    onBackspace: () -> Unit,
    onClear: () -> Unit = {},
    onSubmit: () -> Unit = {},
    onNext: () -> Unit = {},
    onUtilityClick: () -> Unit = {},
    utilityIcon: ImageVector? = null,
    utilityText: String? = null,
    submitEnabled: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .phaseGlass()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(
                modifier = Modifier.weight(3f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    PhaseDigitKey(Modifier.weight(1f), '1', onDigit)
                    PhaseDigitKey(Modifier.weight(1f), '2', onDigit)
                    PhaseDigitKey(Modifier.weight(1f), '3', onDigit)
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    PhaseDigitKey(Modifier.weight(1f), '4', onDigit)
                    PhaseDigitKey(Modifier.weight(1f), '5', onDigit)
                    PhaseDigitKey(Modifier.weight(1f), '6', onDigit)
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    PhaseDigitKey(Modifier.weight(1f), '7', onDigit)
                    PhaseDigitKey(Modifier.weight(1f), '8', onDigit)
                    PhaseDigitKey(Modifier.weight(1f), '9', onDigit)
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    PhaseUtilityKey(
                        modifier = Modifier.weight(1f),
                        icon = utilityIcon,
                        text = utilityText,
                        onClick = onUtilityClick
                    )
                    PhaseDigitKey(Modifier.weight(1f), '0', onDigit)
                    PhaseDarkKey(modifier = Modifier.weight(1f), onClick = onNext) {
                        Text(
                            text = "NEXT",
                            color = PadInk,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                PhaseCreamKey(modifier = Modifier.weight(1f), onClick = onBackspace) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.Backspace,
                        contentDescription = "Backspace",
                        tint = PhaseUtilityInk,
                        modifier = Modifier.size(22.dp)
                    )
                }
                PhaseCreamKey(modifier = Modifier.weight(1f), onClick = onClear) {
                    Text(
                        text = "C",
                        color = PhaseUtilityInk,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                PhaseSubmitKey(
                    modifier = Modifier.weight(2f),
                    enabled = submitEnabled,
                    onClick = onSubmit
                )
            }
        }
    }
}

@Composable
private fun PhaseDigitKey(
    modifier: Modifier,
    digit: Char,
    onDigit: (Char) -> Unit
) {
    PhaseDarkKey(modifier = modifier, onClick = { onDigit(digit) }) {
        Text(
            text = digit.toString(),
            color = PadInk,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun PhaseDarkKey(
    modifier: Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    PhaseKeyCell(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        fill = Color.White.copy(alpha = 0.05f),
        pressedFill = Color.White.copy(alpha = 0.10f),
        border = Color.White.copy(alpha = 0.08f),
        pressedBorder = Color.White.copy(alpha = 0.12f),
        content = content
    )
}

@Composable
private fun PhaseCreamKey(
    modifier: Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    PhaseKeyCell(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        fill = PhaseUtility,
        pressedFill = PhaseUtility.copy(alpha = 0.85f),
        border = PhaseUtility.copy(alpha = 0.40f),
        pressedBorder = PhaseUtility,
        content = content
    )
}

@Composable
private fun PhaseUtilityKey(
    modifier: Modifier,
    icon: ImageVector?,
    text: String?,
    onClick: () -> Unit
) {
    PhaseCreamKey(modifier = modifier, onClick = onClick) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = text ?: "Utility",
                tint = PhaseUtilityInk,
                modifier = Modifier.size(22.dp)
            )
        } else {
            Text(
                text = text ?: "",
                color = PhaseUtilityInk,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun PhaseSubmitKey(
    modifier: Modifier,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.92f else 1f,
        animationSpec = spring(dampingRatio = 0.6f, stiffness = 600f),
        label = "submitScale"
    )
    Box(
        modifier = modifier
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .fillMaxSize()
            .clip(RoundedCornerShape(24.dp))
            .then(
                if (enabled) {
                    Modifier
                        .background(PadLime)
                        .shadow(26.dp, RoundedCornerShape(24.dp), spotColor = PadLime, clip = false)
                } else {
                    Modifier
                        .background(Color.Transparent)
                        .border(1.dp, PadLime.copy(alpha = 0.35f), RoundedCornerShape(24.dp))
                }
            )
            .clickable(interactionSource = source, indication = null, enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.Check,
            contentDescription = "Submit",
            tint = if (enabled) PhaseUtilityInk else PadLime.copy(alpha = 0.45f),
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
private fun PhaseKeyCell(
    modifier: Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    fill: Color,
    pressedFill: Color,
    border: Color,
    pressedBorder: Color,
    content: @Composable () -> Unit
) {
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.92f else 1f,
        animationSpec = spring(dampingRatio = 0.6f, stiffness = 600f),
        label = "phaseKeyScale"
    )
    Box(
        modifier = modifier
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .fillMaxSize()
            .clip(CircleShape)
            .background(if (pressed) pressedFill else fill)
            .border(1.dp, if (pressed) pressedBorder else border, CircleShape)
            .clickable(interactionSource = source, indication = null, enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) { content() }
}

/** Primary CTA button used on entry-flow screens. */
@Composable
fun PhaseCta(
    label: String,
    ready: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bg = if (ready) PadLime else Color.White.copy(alpha = 0.08f)
    val ink = if (ready) PhaseUtilityInk else PadInk
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(RoundedCornerShape(999.dp))
            .background(bg)
            .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(999.dp))
            .then(if (ready) Modifier.clickable(onClick = onClick) else Modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = ink,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/** Permission / checklist row used on the setup screen. */
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
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.08f))
                .border(1.dp, Color.White.copy(alpha = 0.10f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, tint = if (done) PadLime else PadInk, modifier = Modifier.size(22.dp))
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, color = PadInk, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(2.dp))
            Text(text = caption, color = PhaseSurface.Mut, fontSize = 12.sp)
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(999.dp))
                .background(if (done) PadLime else Color.White.copy(alpha = 0.08f))
                .border(1.dp, if (done) Color.Transparent else Color.White.copy(alpha = 0.10f), RoundedCornerShape(999.dp))
                .clickable(onClick = onAction)
                .padding(horizontal = 14.dp, vertical = 8.dp)
        ) {
            Text(
                text = if (done) "DONE" else "ACTION",
                color = if (done) PhaseUtilityInk else PadInk,
                fontSize = 11.sp,
                fontWeight = FontWeight.Black,
                letterSpacing = 1.2.sp
            )
        }
    }
}

/** Circular icon medallion used on onboarding slides. */
@Composable
fun PhaseMedallion(
    icon: ImageVector,
    accent: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(160.dp)
            .shadow(26.dp, CircleShape, spotColor = accent.copy(alpha = 0.25f), clip = false)
            .clip(CircleShape)
            .background(accent.copy(alpha = 0.14f))
            .border(1.dp, accent.copy(alpha = 0.5f), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = accent,
            modifier = Modifier.size(72.dp)
        )
    }
}

/** Dark glass text field used only for identity text (name / email). */
@Composable
fun PhaseTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isError: Boolean = false,
    errorMsg: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier
) {
    var focused by remember { mutableStateOf(false) }
    val borderColor = if (isError) PadLime else if (focused) PadLime else Color.White.copy(alpha = 0.10f)
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = PhaseSurface.Mut,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(Modifier.height(6.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(
                color = PadInk,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            ),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = Modifier
                .fillMaxWidth()
                .phaseGlass()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            decorationBox = { innerTextField ->
                Box {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = PadInk.copy(alpha = 0.35f),
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            }
        )
        if (errorMsg.isNotBlank()) {
            Spacer(Modifier.height(4.dp))
            Text(text = errorMsg, color = PadLime, fontSize = 11.sp)
        }
    }
}
