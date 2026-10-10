package com.bingwascore.app.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.bingwascore.app.domain.ThemeMode

/**
 * POLISH P5 - the Bingwa Score colour system.
 *
 * One rule: every UI colour comes from a token below, never from a literal.
 * Tokens are *mode aware* - they read [DisplayModeState], which the theme writes
 * on every recomposition, so switching mode repaints the whole app on the next
 * frame without restarting anything or touching a single screen.
 *
 * Modes (Settings > Appearance, there is deliberately NO light mode):
 * - [ThemeMode.DARK]      "Obsidian"  - pure black, softened electric blue.
 * - [ThemeMode.GRAYSCALE] "Grayscale" - monochrome chrome, semantic colour kept.
 * - [ThemeMode.SILICA]    "Silica"     - frosted glass, orbs, gradient hairlines.
 *
 * The old BLUE LIGHT FILTER is gone: a warm cast over a black terminal UI was
 * never a mode, it was a night-light workaround, and it cost real contrast.
 */
internal object DisplayModeState {
    var mode: ThemeMode by mutableStateOf(ThemeMode.DARK)
}

/** Written by the theme after a successful composition; read by every token. */
internal fun installDisplayMode(value: ThemeMode) {
    if (DisplayModeState.mode != value) DisplayModeState.mode = value
}

/** The display mode currently painted by the app. */
val currentDisplayMode: ThemeMode get() = DisplayModeState.mode

/**
 * True in the two alternate modes, where a blue CTA can no longer read as blue:
 * buttons drop to solid near-black chips with a hairline border instead.
 */
val usesSolidChips: Boolean get() = DisplayModeState.mode != ThemeMode.DARK

// ─── Surfaces ─────────────────────────────────────────────────────────────────
val BgBlack: Color get() = when (DisplayModeState.mode) {
    // Silica is never pure black: glass needs something behind it to refract.
    ThemeMode.SILICA -> Color(0xFF07070C)
    else -> Color(0xFF000000)
}

val Bubble: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x14FFFFFF)   // translucent: the orbs show through
    else -> Color(0xFF141414)
}

val Raised: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x1FFFFFFF)
    else -> Color(0xFF1C1C1C)
}

val Hairline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x33FFFFFF)
    else -> Color(0xFF2A2A2A)
}

/** Selected-row wash behind multi-selected transactions. */
val SelectTint: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x263E6BFF)
    else -> Color(0xFF10233F)
}

// ─── Type ─────────────────────────────────────────────────────────────────────
val TextWhite: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0xFFF2F4FF)
    else -> Color(0xFFFFFFFF)
}

val TextGrey: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0xFFB9BDD4)
    else -> Color(0xFF9E9E9E)
}

val TextDim: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0xFF8B90AD)
    else -> Color(0xFF6B6B6B)
}

// ─── Accents + statuses ───────────────────────────────────────────────────────

/**
 * POLISH P5 — the semantic status palette.
 *
 * These three are **not** mode-aware, and that is the whole point: a failed
 * transaction is red in Obsidian, red in Grayscale and red in Silica. Only the
 * *chrome* (buttons, nav, switches, surfaces) changes with the mode, so switching
 * to Grayscale never costs the agent the one signal that matters — which rows
 * failed and which cleared.
 */
val SemanticBlue: Color = Color(0xFF3E6BFF)
val SemanticRed: Color = Color(0xFFFF5252)
val SemanticGrey: Color = Color(0xFF9E9E9E)

// ─── U4 — Grayscale keeps DISTINCT, desaturated status tints ─────────────────
/**
 * U4 — how much saturation a status dot keeps in Grayscale.
 *
 * Grayscale is a monochrome chrome, not a monochrome ledger: a completed row, a
 * failed row and a queued row must still be tellable apart at a glance. The dots
 * keep 60% of their saturation (blended 40% toward their own luminance), which is
 * the band where the hue still reads without the chrome going colourful.
 */
const val GRAYSCALE_DOT_SATURATION = 0.6f

/**
 * U4 — blend [color] toward its own luminance so [saturation] of 0 is grey and 1
 * is the untouched colour. Pure, so the Grayscale palette is unit-testable.
 */
fun saturate(color: Color, saturation: Float): Color {
    val keep = saturation.coerceIn(0f, 1f)
    val lum = 0.299f * color.red + 0.587f * color.green + 0.114f * color.blue
    return Color(
        red = lum + (color.red - lum) * keep,
        green = lum + (color.green - lum) * keep,
        blue = lum + (color.blue - lum) * keep,
        alpha = color.alpha
    )
}

/**
 * U4 — the Done tint. Grayscale uses a **silver-blue** so a cleared sale still
 * separates from a failed one without the palette turning blue.
 */
val StatusDone: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFF8FA6C8)
    else -> SemanticBlue
}

/**
 * U4 — the Failed tint. Grayscale uses a **charcoal-red** so failure keeps its
 * urgency in monochrome chrome.
 */
val StatusFailedTint: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFA87070)
    else -> SemanticRed
}

/** U4 — Queued stays **neutral** in every mode: it carries no verdict yet. */
val StatusQueued: Color get() = SemanticGrey

/**
 * The chrome accent.
 *
 * POLISH P5 — softened about 12% from the old `#2962FF`. Pure electric blue on
 * pure black is harsh at 3am on a shop counter and, at full strength behind a
 * filled label, clips. Twelve percent of headroom keeps it unmistakably blue and
 * comfortably readable.
 */
val AccentBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFBDBDBD)
    else -> Color(0xFF4176FF)
}

val ChartBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFBDBDBD)
    else -> Color(0xFF5482FF)
}

val FailRed: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFF757575)
    else -> SemanticRed
}

/** Pending / scheduled rows carry no signal either way, so they stay grey. */
val PendGrey: Color get() = SemanticGrey

/**
 * POLISH P6 — the floor for secondary text, after the contrast audit.
 *
 * Every "metadata" label used to be `TextFaint`, which lands
 * around 3.7:1 on the bubble surface — below the 4.5:1 AA threshold for small
 * text, and worse on Silica where the surface is translucent. Sixty percent white
 * measures about 7:1 on every surface in all three modes, so this is the one
 * faint ink in the app and the audit's replacement for the whole family.
 */
val TextFaint: Color get() = TextWhite.copy(alpha = 0.6f)

/**
 * POLISH P2 — the card wash.
 *
 * A status tile (or a status row) is the bubble surface with a 12% tint of its
 * own status colour laid over it. Ten to fourteen percent is the band where a
 * blue tile reads as blue on black without turning into a coloured slab; below it
 * nothing happens, above it the surface stops being a surface. The colour is the
 * *semantic* one, so Grayscale keeps the wash even when the chrome goes mono.
 */
fun statusWash(statusColor: Color, alpha: Float = 0.12f): Color = statusColor.copy(alpha = alpha)

/** Reserved for the "mark complete" tick and nothing else. */
val TickGreen: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFBDBDBD)
    else -> Color(0xFF00C853)
}

// ─── POLISH P5 — Silica glass ─────────────────────────────────────────────────

/** True only in the glass mode, so surfaces can branch without a mode check. */
val isSilica: Boolean get() = DisplayModeState.mode == ThemeMode.SILICA

/**
 * The frosted fill of a card: white at **18%** (U4), so the orbs behind it show
 * through while the pane still reads as glass rather than as a hole.
 */
val GlassFill: Color get() = Color(0x2EFFFFFF)

/** A slightly denser glass for sheets and rails that sit above content. */
val GlassFillStrong: Color get() = Color(0x33FFFFFF)

/**
 * The gradient hairline.
 *
 * A flat 1px border around glass looks like a mistake; a hairline that fades
 * from 26% white to 6% across the shape reads as an edge catching light, which
 * is what makes the card look like a pane rather than a rectangle.
 */
fun glassBorderBrush(strong: Boolean = false): Brush = Brush.linearGradient(
    colors = listOf(
        Color(0x66FFFFFF),
        Color(0x14FFFFFF),
        if (strong) Color(0x59FFFFFF) else Color(0x0FFFFFFF)
    )
)

/**
 * The ambient orbs behind the glass: one blue, one violet, each at **8% alpha**
 * (U4) — present enough to refract, quiet enough never to be a colour the agent
 * notices. Their soft edge is set by [ORB_BLUR] in the renderer.
 */
val OrbBlue: Color get() = Color(0x143E6BFF)
val OrbViolet: Color get() = Color(0x148C6BFF)

/** U4 — how far the orbs fade at their edge. */
val ORB_BLUR: androidx.compose.ui.unit.Dp = 140.dp

/** The full ambient wash painted behind a Silica screen. */
fun orbBrush(): Brush = Brush.radialGradient(
    colors = listOf(OrbBlue, Color.Transparent),
    center = androidx.compose.ui.geometry.Offset(180f, 220f),
    radius = 780f
)

/**
 * The disabled pair.
 *
 * POLISH P5 — the old disabled button was `Raised` with 45% white on top, which
 * measured about 2.4:1 and made "Dial Now" look broken rather than unavailable.
 * These are explicit tokens: the fill is a shade above the surface and the ink is
 * a fixed 60% white, which clears 4.5:1 on black in every mode.
 */
val DisabledFill: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x1AFFFFFF)
    else -> Color(0xFF232323)
}

val DisabledInk: Color get() = when (DisplayModeState.mode) {
    ThemeMode.SILICA -> Color(0x99FFFFFF)
    else -> Color(0xFF9E9E9E)
}

// ─── Call-to-action chrome ────────────────────────────────────────────────────
/**
 * U4 — Grayscale CTAs are a **solid #E0E0E0 chip with black text**, which is the
 * only figure/ground pair that stays unambiguous when the accent is no longer a
 * hue. Obsidian and Silica keep the brand blue.
 */
val CtaFill: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFFE0E0E0)
    else -> AccentBlue
}

/** Ink drawn on [CtaFill] — black on the Grayscale chip, white on the blue CTA. */
val CtaInk: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFF000000)
    else -> TextWhite
}

/** The hairline that separates a solid chip from the background. */
val CtaBorder: Color get() = if (usesSolidChips) Hairline else Color.Transparent

/**
 * U4 — the secondary button's outline. Grayscale draws it at **#9E9E9E** so an
 * outlined action is legible against the monochrome canvas instead of vanishing
 * into a hairline that matches the surface.
 */
val SecondaryOutline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.GRAYSCALE -> Color(0xFF9E9E9E)
    else -> Hairline
}

/** Shared chrome for tracks, dividers and inactive dots. */
val DotTrack: Color get() = Raised
val FaintDivider: Color get() = Hairline

/** Solid accent brush — the brand has no gradients any more. */
fun accentBrush(): Brush = SolidColor(AccentBlue)

/** Agent level badges — a neutral ladder, never a warm hue. */
val Bronze: Color get() = Color(0xFF8D8D8D)
val Silver: Color get() = Color(0xFFB0B0B0)
val Gold: Color get() = Color(0xFFD0D0D0)
val Platinum: Color get() = Color(0xFFFFFFFF)

/** Accent that must stay legible on top of [AccentBlue]. */
val OnAccent: Color get() = Color(0xFFFFFFFF)

/** Offer tag buckets (Hybrid OfferTag OFFER_1..OFFER_4). */
object OfferTags {
    const val OFFER_1 = "OFFER_1"
    const val OFFER_2 = "OFFER_2"
    const val OFFER_3 = "OFFER_3"
    const val OFFER_4 = "OFFER_4"
    val ALL = listOf(OFFER_1, OFFER_2, OFFER_3, OFFER_4)
}
