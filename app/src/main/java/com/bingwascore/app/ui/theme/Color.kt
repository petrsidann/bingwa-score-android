package com.bingwascore.app.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.glass.GlassSpec

/**
 * Stage 34 — production design system: Obsidian (dark) + Porcelain Dim (default light).
 *
 * Surface values mirror docs/DESIGN.md exactly:
 *   Obsidian:      bg #0F172A, card #1E293B, elevated #334155, border #475569
 *   Porcelain Dim: bg #F1F5F9, card #FFFFFF, elevated #F8FAFC, border #CBD5E1
 *
 * Semantic colours: Primary #2563EB, Success #10B981, Error #EF4444, Warning #F59E0B.
 *
 * One rule: every UI colour comes from a token below, never from a literal.
 * Tokens are mode-aware — they read [DisplayModeState], which the theme writes
 * on every composition, so switching mode repaints the whole app instantly.
 *
 * Obsidian (dark): near-black canvas family, white/light ink.
 * Porcelain Dim (#F1F5F9 canvas): dimmed lights, near-black ink #0F172A,
 * secondary #475569, brand kept at #2563EB so light never reads dull.
 */
internal object DisplayModeState {
    var mode: ThemeMode by mutableStateOf(ThemeMode.PORCELAIN_DIM)
}

/** Written by the theme after a successful composition; read by every token. */
internal fun installDisplayMode(value: ThemeMode) {
    if (DisplayModeState.mode != value) DisplayModeState.mode = value
}

/** The display mode currently painted by the app. */
val currentDisplayMode: ThemeMode get() = DisplayModeState.mode

/** True in Porcelain Dim — the light canvas. */
val isPorcelain: Boolean get() = DisplayModeState.mode != ThemeMode.DARK

// ─── Obsidian (dark) surfaces ─────────────────────────────────────────────────

val ObsidianBg: Color = Color(0xFF0F172A)
val ObsidianCard: Color = Color(0xFF1E293B)
val ObsidianElevated: Color = Color(0xFF334155)
val ObsidianBorder: Color = Color(0xFF475569)

// ─── Porcelain Dim (light) surfaces ───────────────────────────────────────────

val PorcelainDimBg: Color = Color(0xFFF1F5F9)
val PorcelainDimCard: Color = Color(0xFFFFFFFF)
val PorcelainDimElevated: Color = Color(0xFFF8FAFC)
val PorcelainDimBorder: Color = Color(0xFFCBD5E1)
val PorcelainDimSurface: Color = Color(0xFFF1F5F9)
val PorcelainDimRaised: Color = Color(0xFFF1F5F9)
val PorcelainDimSeparator: Color = Color(0x593C3C43)
val PorcelainDimText: Color = Color(0xFF0F172A)
val PorcelainDimSecondaryText: Color = Color(0xFF475569)
val PorcelainDimTertiaryText: Color = Color(0xFF64748B)
/** The brand stays at full strength on the dim canvas so light never reads dull. */
val PorcelainDimAccent: Color = Color(0xFF2563EB)
val PorcelainDimChartBlue: Color = Color(0xFF2563EB)
/** Deepened signal red so a failed status still clears 3:1 on the dim canvas. */
val PorcelainDimFailed: Color = Color(0xFFDC2626)
val PorcelainDimDisabledInk: Color = Color(0xFF0F172A)

// ─── Semantic colours (shared by both themes) ─────────────────────────────────

/** Brand primary: #2563EB everywhere. */
val BrandBlue: Color = Color(0xFF2563EB)
/** Success #10B981 — done states, ticks, confirm CTAs. */
val Success: Color = Color(0xFF10B981)
/** Error #EF4444 — failures, destructive actions, validation errors. */
val Error: Color = Color(0xFFEF4444)
/** Warning #F59E0B — cautions and attention states. */
val Warning: Color = Color(0xFFF59E0B)

val SemanticBlue: Color = BrandBlue
val SemanticRed: Color = Error
/** Mid-grey clears 3:1 on BOTH canvases (Obsidian #0F172A and Porcelain #F1F5F9). */
val SemanticGrey: Color = Color(0xFF6B7280)

/** Stage 10 — Done/Failed/Queued are the semantic trio in every theme. */
val StatusDone: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> BrandBlue
    else -> SemanticBlue
}

val StatusFailedTint: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimFailed
    else -> SemanticRed
}

/** Queued stays **neutral** and identical across themes. */
val StatusQueued: Color = SemanticGrey

/** Chrome accent: brand blue family, identical in both themes. */
val AccentBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimAccent
    else -> BrandBlue
}

val ChartBlue: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimChartBlue
    else -> BrandBlue
}

/** The error ink: Error #EF4444 on obsidian, deepened red on the dim canvas. */
val FailRed: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimFailed
    else -> Error
}

/** Pending / scheduled rows carry no signal either way, so they stay grey. */
val PendGrey: Color get() = SemanticGrey

// ─── Surfaces (mode-aware read points) ────────────────────────────────────────

val BgBlack: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimBg
    else -> ObsidianBg
}

val Bubble: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimCard
    else -> ObsidianCard
}

val Raised: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimElevated
    else -> ObsidianElevated
}

val Hairline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimBorder
    else -> ObsidianBorder
}

/** Selected-row wash behind multi-selected transactions. */
val SelectTint: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> Color(0x1A2563EB)
    else -> Color(0xFF10233F)
}

// ─── Type ─────────────────────────────────────────────────────────────────────

val TextWhite: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimText
    else -> Color(0xFFFFFFFF)
}

val TextGrey: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimSecondaryText
    else -> Color(0xFF94A3B8)
}

val TextDim: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimTertiaryText
    else -> Color(0xFF94A3B8)
}

/**
 * Stage 24 — vibrancy gradients for the Done/Failed/Queued counter tiles.
 *
 * Done   = blue gradient,  Failed = rose gradient, Queued = slate gradient.
 * Tinted surfaces replace the flat wash so nothing reads as dull grey.
 */
val StatusDoneGradient: Brush = Brush.linearGradient(
    colors = listOf(StatusDone.copy(alpha = 0.18f), StatusDone.copy(alpha = 0.06f))
)
val StatusFailedGradient: Brush = Brush.linearGradient(
    colors = listOf(StatusFailedTint.copy(alpha = 0.18f), StatusFailedTint.copy(alpha = 0.06f))
)
val StatusQueuedGradient: Brush = Brush.linearGradient(
    colors = listOf(StatusQueued.copy(alpha = 0.14f), StatusQueued.copy(alpha = 0.04f))
)

/**
 * Stage 10 — secondary text floor: 60% ink clears AA on every surface
 * in both themes.
 */
val TextFaint: Color get() = TextWhite.copy(alpha = 0.6f)

/**
 * POLISH P2 — the card wash.
 *
 * A status tile (or a status row) is the bubble surface with a 12% tint of its
 * own status colour laid over it. The colour is the *semantic* one, identical
 * in both themes.
 */
fun statusWash(statusColor: Color, alpha: Float = 0.12f): Color = statusColor.copy(alpha = alpha)

/** Reserved for the "mark complete" tick and nothing else. */
val TickGreen: Color get() = Color(0xFF00C853)

// ─── Stage 10 — iOS materials (blur ONLY here: nav bars + sheets) ────────────

/** Translucent material fill for nav bars + page sheets (Stage 26 — GlassSpec). */
val IosMaterialFill: Color get() = GlassSpec.scrimColor(isPorcelain)

/** iOS hairline border for the floating tab pill. */
fun iosPillBorderBrush(): Brush = Brush.linearGradient(
    colors = listOf(
        Color(0x1A000000),
        Color(0x0D000000)
    )
)

/** Stage 10 — iOS language: inset grouped cards use a 12dp radius. */
val IOS_CARD_RADIUS: androidx.compose.ui.unit.Dp = 12.dp

/**
 * Stage 10 — iOS grouped-list separator: rgba(60,60,67,0.29) in Porcelain,
 * hairline on the dark canvas.
 */
val IosSeparator: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimSeparator
    else -> Hairline
}

/**
 * Stage 10 — the disabled pair: clears AA in BOTH themes. Porcelain inks grey
 * on a light fill; Obsidian keeps light ink on a raised fill.
 */
val DisabledFill: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimElevated
    else -> ObsidianElevated
}

val DisabledInk: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> PorcelainDimText
    else -> Color(0xFFFFFFFF)
}

// ─── Call-to-action chrome ────────────────────────────────────────────────────
/** Stage 10 — capsule CTA: brand blue fill, white ink, both themes. */
val CtaFill: Color get() = AccentBlue

/** Ink drawn on [CtaFill]. */
val CtaInk: Color get() = Color(0xFFFFFFFF)

/** The hairline that separates a solid chip from the background. */
val CtaBorder: Color = Color.Transparent

/** Stage 10 — secondary outline: hairline dark, grey light. */
val SecondaryOutline: Color get() = when (DisplayModeState.mode) {
    ThemeMode.PORCELAIN_DIM -> Color(0xFF7C828C)
    else -> Hairline
}

/** Shared chrome for tracks, dividers and inactive dots. */
val DotTrack: Color get() = Raised
val FaintDivider: Color get() = Hairline

/** Solid accent brush — the brand has no gradients any more. */
fun accentBrush(): Brush = SolidColor(AccentBlue)

// ─── Stage 20 — the My Plan paywall band ────────────────────────────────────

/**
 * The paywall band is the one gradient the brand allows: three **opaque** blue
 * stops, no warm hue, no translucency, no glass. White ink clears AA on every
 * stop, so the band reads the same in both themes.
 */
val AuroraDeep: Color = Color(0xFF0B2A6B)
val AuroraMid: Color = Color(0xFF1D4ED8)
val AuroraEdge: Color = Color(0xFF2563EB)

/** Solid white — the band ink and the solid chip that sits on the band. */
val BandWhite: Color = Color(0xFFFFFFFF)

/** The band brush: an aurora sweep across the blue family. */
fun auroraBrush(): Brush = Brush.linearGradient(listOf(AuroraDeep, AuroraMid, AuroraEdge))

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
