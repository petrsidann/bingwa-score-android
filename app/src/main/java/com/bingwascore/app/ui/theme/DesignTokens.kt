package com.bingwascore.app.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

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
            val keypadDigit: ComposeColor
        )

        val Obsidian = ThemeRoles(
            bg = ComposeColor(0xFF0F172A),
            card = ComposeColor(0xFF1E293B),
            elevated = ComposeColor(0xFF334155),
            border = ComposeColor(0xFF475569),
            textPrimary = ComposeColor(0xFFF8FAFC),
            textSecondary = ComposeColor(0xFF94A3B8),
            brand = ComposeColor(0xFF2563EB),
            onBrand = ComposeColor(0xFFFFFFFF),
            success = ComposeColor(0xFF34D399),
            onSuccess = ComposeColor(0xFF06281A),
            error = ComposeColor(0xFFF87171),
            onError = ComposeColor(0xFF2A0A0A),
            keypadKey = ComposeColor(0xFF334155),
            keypadDigit = ComposeColor(0xFFF8FAFC)
        )

        val Dim = ThemeRoles(
            bg = ComposeColor(0xFFEAF0F6),
            card = ComposeColor(0xFFFFFFFF),
            elevated = ComposeColor(0xFFF8FAFC),
            border = ComposeColor(0xFFCBD5E1),
            textPrimary = ComposeColor(0xFF1E293B),
            textSecondary = ComposeColor(0xFF475569),
            brand = ComposeColor(0xFF2F6AE0),
            onBrand = ComposeColor(0xFFFFFFFF),
            success = ComposeColor(0xFF047857),
            onSuccess = ComposeColor(0xFFFFFFFF),
            error = ComposeColor(0xFFDC2626),
            onError = ComposeColor(0xFFFFFFFF),
            keypadKey = ComposeColor(0xFFFFFFFF),
            keypadDigit = ComposeColor(0xFF1E293B)
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
        val Display: TextUnit get() = BingwaType.Display
        /** Screen and section headers. */
        val Headline: TextUnit get() = BingwaType.Headline
        /** Section and card titles. */
        val Subhead: TextUnit get() = BingwaType.Subhead
        /** Body copy. */
        val Body: TextUnit get() = BingwaType.Body
        /** Metadata, labels, captions. */
        val Caption: TextUnit get() = BingwaType.Caption
    }

    object Launch {
        val lime = Color(0xFFA4F510)
        val violet = Color(0xFF5B21D6)
        val ink = Color(0xFF101014)
    }
}
