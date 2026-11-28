package com.bingwascore.app.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Stage 48 — Elite Design System Foundation.
 *
 * Strict single source of truth for every visual token. UI components must
 * reference [DesignTokens] only — zero hardcoded hex, dp, duration or spring
 * literals are permitted in components.
 *
 * Palette (exact hex):
 *   Obsidian:      bg #0F172A, card #1E293B, elevated #334155, border #475569, ink #FFFFFF
 *   Porcelain Dim: bg #EAF0F6, card #FFFFFF, elevated #F8FAFC, border #CBD5E1, ink #1E293B
 *   Brand:         Primary #2563EB, DimAccent #2F6AE0, Success #00C853, Error #FF5252
 *
 * Elevation is modelled as layered shadow stacks (Vercel-style), never a single
 * flat shadow. Level 2 pairs a drop shadow with a top highlight for glass.
 */
object DesignTokens {

    // ─── Colours ──────────────────────────────────────────────────────────────

    object Color {
        private object Obsidian {
            val Bg = ComposeColor(0xFF0F172A)
            val Card = ComposeColor(0xFF1E293B)
            val Elevated = ComposeColor(0xFF334155)
            val Border = ComposeColor(0xFF475569)
            val Ink = ComposeColor(0xFFFFFFFF)
        }

        private object PorcelainDim {
            val Bg = ComposeColor(0xFFEAF0F6)
            val Card = ComposeColor(0xFFFFFFFF)
            val Elevated = ComposeColor(0xFFF8FAFC)
            val Border = ComposeColor(0xFFCBD5E1)
            val Ink = ComposeColor(0xFF1E293B)
        }

        private object Brand {
            val Primary = ComposeColor(0xFF2563EB)
            val DimAccent = ComposeColor(0xFF2F6AE0)
            val Success = ComposeColor(0xFF00C853)
            val Error = ComposeColor(0xFFFF5252)
        }

        /** Mode-aware surface helpers so components never branch on theme. */
        val Bg: ComposeColor get() = if (isPorcelain) PorcelainDim.Bg else Obsidian.Bg
        val Card: ComposeColor get() = if (isPorcelain) PorcelainDim.Card else Obsidian.Card
        val Elevated: ComposeColor get() = if (isPorcelain) PorcelainDim.Elevated else Obsidian.Elevated
        val Border: ComposeColor get() = if (isPorcelain) PorcelainDim.Border else Obsidian.Border
        val Ink: ComposeColor get() = if (isPorcelain) PorcelainDim.Ink else Obsidian.Ink
    }

    // ─── Role system (Stage 56 — color & contrast reckoning) ────────────────
    // Semantic role tokens consumed by every screen/component via LocalBingwaRoles.
    // Raw palette objects (Obsidian / PorcelainDim / Brand) above are now private.

    object Role {
        data class ThemeRoles(
            val bg: ComposeColor,
            val card: ComposeColor,
            val elevated: ComposeColor,
            val border: ComposeColor,
            val textPrimary: ComposeColor,
            val textSecondary: ComposeColor,
            val brand: ComposeColor,
            val onBrand: ComposeColor,
            val success: ComposeColor,
            val onSuccess: ComposeColor,
            val error: ComposeColor,
            val onError: ComposeColor,
            val keypadKey: ComposeColor,
            val keypadDigit: ComposeColor,
            // Stage P2A — D4: Obsidian surface ladder for nested card depth
            val surfaceLowest: ComposeColor,
            val surfaceLow: ComposeColor,
            val surfaceHigh: ComposeColor,
            val surfaceHighest: ComposeColor
        )

        val Obsidian = ThemeRoles(
            bg = ComposeColor(0xFF0F172A),
            card = ComposeColor(0xFF1E293B),
            elevated = ComposeColor(0xFF334155),
            border = ComposeColor(0xFF475569),
            textPrimary = ComposeColor(0xFFF8FAFC),
            textSecondary = ComposeColor(0xFF94A3B8),
            brand = ComposeColor(0xFF5B21D6),
            onBrand = ComposeColor(0xFFFFFFFF),
            success = ComposeColor(0xFFA4F510),
            onSuccess = ComposeColor(0xFF000000),
            error = ComposeColor(0xFFBE123C),
            onError = ComposeColor(0xFFFFFFFF),
            keypadKey = ComposeColor(0xFF334155),
            keypadDigit = ComposeColor(0xFFF8FAFC),
            // Stage P2A — D4: Obsidian surface ladder (dark theme)
            surfaceLowest = ComposeColor(0xFF0B0F0B),
            surfaceLow = ComposeColor(0xFF101510),
            surfaceHigh = ComposeColor(0xFF161B16),
            surfaceHighest = ComposeColor(0xFF1C211C)
        )

        val Dim = ThemeRoles(
            bg = ComposeColor(0xFFE9EDF2),
            card = ComposeColor(0xFFFFFFFF),
            elevated = ComposeColor(0xFFF8FAFC),
            border = ComposeColor(0xFFCBD5E1),
            textPrimary = ComposeColor(0xFF0B0B10),
            textSecondary = ComposeColor(0xFF5B6472),
            brand = ComposeColor(0xFF5B21D6),
            onBrand = ComposeColor(0xFFFFFFFF),
            success = ComposeColor(0xFF84CC16),
            onSuccess = ComposeColor(0xFF000000),
            error = ComposeColor(0xFF7F0D2F),
            onError = ComposeColor(0xFFFFFFFF),
            keypadKey = ComposeColor(0xFFFFFFFF),
            keypadDigit = ComposeColor(0xFF0B0B10),
            // Stage P2A — D4: Porcelain surface ladder (light theme)
            surfaceLowest = ComposeColor(0xFFF8FAFC),
            surfaceLow = ComposeColor(0xFFF1F5F9),
            surfaceHigh = ComposeColor(0xFFE2E8F0),
            surfaceHighest = ComposeColor(0xFFCBD5E1)
        )
    }

    /** Mode-aware semantic roles: Obsidian when dark, Dim (Porcelain) when light. */
    val LocalBingwaRoles = staticCompositionLocalOf { Role.Dim }

    // ─── Elevation (layered shadow stacks) ────────────────────────────────────

    object Elevation {
        /** One layer of a shadow stack. */
        data class Layer(
            val offsetY: Dp,
            val blurRadius: Dp,
            val color: ComposeColor
        )

        // 0px 1px 2px rgba(0,0,0,0.05)
        val Level1 = listOf<Layer>(
            Layer(offsetY = 1.dp, blurRadius = 2.dp, color = ComposeColor(0x0D000000))
        )

        // 0px 4px 12px rgba(0,0,0,0.08) + 0px 1px 1px rgba(255,255,255,0.1)
        val Level2 = listOf<Layer>(
            Layer(offsetY = 4.dp, blurRadius = 12.dp, color = ComposeColor(0x14000000)),
            Layer(offsetY = -1.dp, blurRadius = 1.dp, color = ComposeColor.White.copy(alpha = 0.1f))
        )
    }

    // ─── Shape ────────────────────────────────────────────────────────────────

    object Shape {
        val RadiusSm = 8.dp
        val RadiusMd = 12.dp
        val RadiusLg = 16.dp
        val RadiusFull = 999.dp
    }

    // ─── Motion ───────────────────────────────────────────────────────────────

    object Motion {
        const val SpringStiffness: Float = 400f
        const val SpringDamping: Float = 0.75f
        const val DurationFast: Long = 150
        const val DurationNormal: Long = 250

        // ─── Stage 55 — Standing Design Law motion ────────────────────────
        const val DialogEnterStiffness: Float = 380f
        const val DialogEnterDamping: Float = 0.86f
        const val DialogExitStiffness: Float = 500f
        const val DialogExitDamping: Float = 1.0f
        const val DialogEnterDuration: Long = 120
        const val DialogExitDuration: Long = 100
        const val SheetEnterStiffness: Float = 380f
        const val SheetEnterDamping: Float = 0.86f
        const val ToastEnterStiffness: Float = 380f
        const val ToastEnterDamping: Float = 0.86f
        const val ToastAutoDismiss: Long = 3000
        const val SpinnerRotationDuration: Long = 900
        const val SpinnerGlowMinAlpha: Float = 0.4f
        const val SpinnerGlowMaxAlpha: Float = 0.8f
        const val PressScale: Float = 0.98f
    }

    // ─── Launch (Stage 58.1) ────────────────────────────────────────────────

    object Launch {
        val lime = ComposeColor(0xFFA4F510)
        val violet = ComposeColor(0xFF5B21D6)
        val ink = ComposeColor(0xFF101014)
    }

    // ─── Onboarding (Stage O3) ─────────────────────────────────────────────

    object Onboarding {
        val slideBg = listOf(
            ComposeColor(0xFFA4F510),
            ComposeColor(0xFF5B21D6),
            ComposeColor(0xFF101014),
            ComposeColor(0xFF1E3A8A)
        )
        val medallionFill = listOf(
            ComposeColor(0xFF5B21D6),
            ComposeColor(0xFFA4F510),
            ComposeColor(0xFFA4F510),
            ComposeColor(0xFFA4F510)
        )
        val iconTint = listOf(
            ComposeColor(0xFFA4F510),
            ComposeColor(0xFF5B21D6),
            ComposeColor(0xFF101014),
            ComposeColor(0xFF1E3A8A)
        )
    }

    // ─── Hero surface (Phase 1 spec 4) ───────────────────────────────────────

    object Hero {
        val surface = ComposeColor(0xFF0B0B10)
        val ink = ComposeColor(0xFFF8FAFC)
    }

    // ─── Semantic status colours (Phase 1 spec 1) ───────────────────────────

    object Semantic {
        val complete = ComposeColor(0xFFA4F510)
        val scheduled = ComposeColor(0xFF8B5CF6)
        val awaiting = ComposeColor(0xFFFDE68A)
        val failed = ComposeColor(0xFFFDA4AF)
        val unmatched = ComposeColor(0xFF64748B)
        val info = ComposeColor(0xFF0EA5E9)
    }

    // ─── Glass ────────────────────────────────────────────────────────────────

    object Glass {
        val BlurRadius: Dp = 24.dp
        const val TintAlpha: Float = 0.7f
        // ─── Stage 55 — Standing Design Law glass optics ──────────────────
        const val ScrimInkAlpha: Float = 0.4f
        const val SpecularAlpha: Float = 0.12f
        const val SaturationBoost: Float = 1.1f
    }

    // ─── Spacing (8pt grid, docs/DESIGN.md) ──────────────────────────────────

    object Spacing {
        val Xs = 4.dp
        val Sm = 8.dp
        val Md = 16.dp
        val Lg = 24.dp
        val Xl = 32.dp
        // ─── Stage 55 — Standing Design Law spacing ───────────────────────
        val ToastBottomOffset = 96.dp
        val ToastHorizontalMargin = 16.dp
        val EmptyIconSize = 64.dp
        val EmptyIconAlpha = 0.25f
        val DragHandleWidth = 32.dp
        val DragHandleHeight = 4.dp
        val DragHandleBorderAlpha = 0.4f
    }

    // ─── Typography (delegates to the BingwaType ramp; no literal sizes) ──────

    object Typography {
        /** Hero balance / display numerals. */
        val Display: TextStyle get() = TextStyle(fontSize = 32.sp, lineHeight = 40.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = (-0.5).sp)
        /** Screen and section headers. */
        val Headline: TextStyle get() = TextStyle(fontSize = 20.sp, lineHeight = 28.sp, fontWeight = FontWeight.Bold)
        /** Section and card titles. */
        val Subhead: TextUnit get() = BingwaType.Subhead
        /** Body copy. */
        val Body: TextUnit get() = BingwaType.Body
        /** Metadata, labels, captions. */
        val Caption: TextUnit get() = BingwaType.Caption
    }

    // ─── Home transcription (Stage H3 — phase3-home.html) ───────────────────

    object HomeTokens {
        val HeroBackground = ComposeColor(0xFF0B0B10)
        val HeroRadius = 26.dp
        val HeroPadding = 16.dp
        val HRowGap = 10.dp
        val EyeSize = 36.dp
        val EyeRadius = 12.dp
        val EyeOnFill = ComposeColor(0x29A4F510)
        val EyeOnBorder = ComposeColor(0xFFA4F510)
        val EyeOffFill = ComposeColor(0x2EFDA4AF)
        val EyeOffBorder = ComposeColor(0xFFFDA4AF)
        val GreetingOpacity = 0.85f
        val GreetingNLetterSpacing = (-0.3).sp
        val CredboxWidth = 128.dp
        val CredboxPaddingHorizontal = 10.dp
        val CredboxPaddingVertical = 9.dp
        val CredboxRadius = 14.dp
        val CredboxBorder = ComposeColor(0x4DFFFFFF)
        val CredboxLabelOpacity = 0.72f
        val CredboxCountdownColor = ComposeColor(0xFFA4F510)
        val CredboxPlanOpacity = 0.7f
        val BalrowGap = 12.dp
        val BignumSize = 40.sp
        val BignumLetterSpacing = (-1.5).sp
        val BulbSize = 30.dp
        val BulbHotBorder = ComposeColor(0xFFFDA4AF)
        val BulbHotFill = ComposeColor(0x59FDA4AF)
        val BulbColdOpacity = 0.45f
        val SublblOpacity = 0.62f
        val SublblMarginBottom = 14.dp
        val TilesGap = 10.dp
        val TileRadius = 14.dp
        val TilePaddingVertical = 10.dp
        val TilePaddingHorizontal = 6.dp
        val TileFill = ComposeColor(0x12FFFFFF)
        val TileBorder = ComposeColor(0x24FFFFFF)
        val TileInk = ComposeColor(0xFFF8FAFC)
        val TileIconSize = 18.dp
        val TileLabelSize = 9.5.sp
        val TilePressScale = 0.93f
        val TilePressDuration = 140
        val TilePressEasingStiffness = 0.5f
        val TilePressEasingDamping = 0.4f
        val BannerPadding = 12.dp
        val BannerGap = 10.dp
        val BannerLeftRule = 4.dp
        val BannerInfoColor = ComposeColor(0xFF0EA5E9)
        val BannerFailColor = ComposeColor(0xFF9F1239)
        val LadderRingSize = 52.dp
        val LadderRingStroke = 5.dp
        val LadderRingTrack = ComposeColor(0x407C3AED)
        val LadderRingProgress = ComposeColor(0xFF7C3AED)
        val LadderRingAllDone = ComposeColor(0xFFA4F510)
        val LadderTaskTileSize = 26.dp
        val LadderTaskTileRadius = 9.dp
        val LadderTaskDoneFill = ComposeColor(0xFFA4F510)
        val ApillPaddingHorizontal = 12.dp
        val ApillPaddingVertical = 7.dp
        val ApillActionFill = ComposeColor(0xFF5B21D6)
        val ApillDoneFill = ComposeColor(0x4DA4F510)
        val ArmedPaddingHorizontal = 13.dp
        val ArmedPaddingVertical = 11.dp
        val ArmedRadius = 14.dp
        val ArmedFill = ComposeColor(0xFFA4F510)
        val ArmedInk = ComposeColor(0xFF0B0B10)
        val SubtabsGap = 8.dp
        val SubtabsButtonPaddingVertical = 9.dp
        val SubtabsButtonRadius = 999.dp
        val SubtabsActiveFill = ComposeColor(0xFF0B0B10)
        val SubtabsActiveInk = ComposeColor(0xFFFFFFFF)
        val SubtabsInactiveFill = ComposeColor(0xFFFFFFFF)
        val SubtabsInactiveInk = ComposeColor(0xFF5B6472)
        val PayoutBarHeight = 8.dp
        val PayoutBarRadius = 999.dp
        val PayoutBarMinWidth = 6.dp
        val PayoutBarGradientStart = ComposeColor(0xFF7C3AED)
        val PayoutBarGradientEnd = ComposeColor(0xFFA4F510)
        val PayoutBarGoalTickWidth = 2.dp
        val CatsGap = 6.dp
        val CatsButtonPaddingHorizontal = 13.dp
        val CatsButtonPaddingVertical = 6.dp
        val CatsButtonRadius = 999.dp
        val CatsActiveFill = ComposeColor(0xFF5B21D6)
        val CatsActiveInk = ComposeColor(0xFFFFFFFF)
        val CatsInactiveFill = ComposeColor(0xFFFFFFFF)
        val CatsInactiveInk = ComposeColor(0xFF5B6472)
        val TglWidth = 44.dp
        val TglHeight = 26.dp
        val TglRadius = 999.dp
        val TglOnFill = ComposeColor(0xFFA4F510)
        val TglOffFill = ComposeColor(0xB3CBD5E1)
        val TglKnobSize = 20.dp
        val CustAvatarSize = 36.dp
        val CustAvatarFill = ComposeColor(0xFF5B21D6)
        val RiskFill = ComposeColor(0xFFFDA4AF)
        val RiskInk = ComposeColor(0xFF3F0D1D)
        val SecheadMarginBottom = 8.dp
        val SecheadMarginHorizontal = 2.dp
        val SecheadMarginTop = 14.dp
        val LinkColor = ComposeColor(0xFF5B21D6)
        val TxGlyphSize = 40.dp
        val TxGlyphRadius = 12.dp
        val ChipPaddingHorizontal = 8.dp
        val ChipPaddingVertical = 3.dp
        val ChipRadius = 999.dp
        val GrouphMarginTop = 10.dp
        val GrouphMarginBottom = 4.dp
        val GrouphMarginHorizontal = 2.dp
        val GrouphLetterSpacing = 1.4.sp
        val GrouphColor = ComposeColor(0xFF5B6472)
        val ToastAnchorBottom = 104.dp
        val ToastPaddingHorizontal = 14.dp
        val ToastPaddingVertical = 12.dp
        val ToastRadius = 16.dp
        val ToastFill = ComposeColor(0xEB0A0A0D)
        val ToastBorder = ComposeColor(0x66A4F510)
        val ToastBorderBad = ComposeColor(0x8CFDA4AF)
        val ToastInk = ComposeColor(0xFFFFFFFF)
        val ToastRiseDuration = 260
        val ToastLife = 2500L
        val RingDashAnimateDuration = 400
        val ArmedRiseDuration = 300
        val ArmedCollapseDuration = 220
        val BarWidthDuration = 600
    }
}
