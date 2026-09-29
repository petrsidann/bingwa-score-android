package com.bingwascore.app.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// ─── Brand: orange ────────────────────────────────────────────────────────────
val BingwaOrange = Color(0xFFFF6D00)
val Amber = Color(0xFFFFB300)
val OrangeDark = Color(0xFFE65100)

/** The primary brand gradient used on buttons, FABs, chips, rings and nav. */
val BrandColors = listOf(BingwaOrange, Amber)

/** Convenience brush for the orange→amber brand gradient. */
fun brandBrush(): Brush = Brush.linearGradient(BrandColors)

// ─── Semantic: green is reserved for success states only ─────────────────────
val EmeraldGreen = Color(0xFF00C853)
val SuccessGreen = Color(0xFF00C853)
val TealBlue = Color(0xFF00B8D4)
val Orange500 = Color(0xFFFF9800)
val Purple500 = Color(0xFF6200EE)
val White = Color(0xFFFFFFFF)
val ErrorRed = Color(0xFFFF453A)

/** Agent level badge colors. */
val Bronze = Color(0xFFCD7F32)
val Silver = Color(0xFFC0C0C0)
val Gold = Color(0xFFFFD700)
val Platinum = Color(0xFFE5E4E2)

/** Dark-first anchors used across screens. */
val NightBlack = Color(0xFF0A0A0F)
val SurfaceDark = Color(0xFF12121A)

// ─── Glass system: shared translucent surface tokens ──────────────────────────
/** Frosted card / chip fill (white ≈8%). */
val GlassFill = Color(0x14FFFFFF)

/** Hairline glass border (white ≈12%). */
val GlassBorder = Color(0x1FFFFFFF)

/** Stronger translucent fill — pressed fills, unchecked tracks (white ≈13%). */
val GlassFillStrong = Color(0x22FFFFFF)

/** Strong glass border — emphasized rows, dividers (white ≈20%). */
val GlassBorderStrong = Color(0x33FFFFFF)

/** Active-dot track (white 25%) — replaces raw Color(0x40FFFFFF). */
val DotTrack = Color(0x40FFFFFF)

/** Faint divider (white ≈5%) — replaces raw Color(0x0DFFFFFF). */
val FaintDivider = Color(0x0DFFFFFF)

// ─── Light scheme anchors ────────────────────────────────────────────────────
/** Light-mode screen background. */
val LightBackground = Color(0xFFF4F6F5)

/** Light-mode card surface. */
val LightSurface = Color(0xFFFFFFFF)

/** Ink drawn on top of the orange→amber brand gradient. */
val OnBrandInk = Color(0xFF0A0A0F)
