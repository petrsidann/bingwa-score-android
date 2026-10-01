package com.bingwascore.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * PREMIUM LOCK — the strict iOS type scale.
 *
 * Every size in the app must come from here: **no inline `fontSize = 13.sp`
 * literals**. The ramp is the iOS one (Display 34sp down to Caption 12sp) so
 * spacing between steps reads natively on Android too.
 *
 * Weight pairs with size on purpose: the ramp tightens from Bold at the top
 * to Regular at the bottom, which is what makes a hierarchy feel designed
 * rather than merely scaled.
 */
object BingwaType {

    // ── The ramp (iOS) ────────────────────────────────────────────────────────
    /** Large Title — hero numbers, splash wordmark. */
    val Display: TextUnit = 34.sp

    /** Title 1 — screen heroes. */
    val Title: TextUnit = 28.sp

    /** Title 2 — screen headers ("Offers", "Profile"). */
    val Headline: TextUnit = 22.sp

    /** Title 3 — section headers, card titles. */
    val Subhead: TextUnit = 20.sp

    /** Body — long-form copy. */
    val Body: TextUnit = 17.sp

    /** Callout — default reading size, dialog body. */
    val Callout: TextUnit = 16.sp

    /** Subheadline — list row titles, buttons. */
    val Label: TextUnit = 15.sp

    /** Footnote — secondary copy under a row title. */
    val Footnote: TextUnit = 13.sp

    /** Caption 1 — metadata, timestamps, subtitles under headers. */
    val Caption: TextUnit = 12.sp

    /** Caption 2 — the floor: nav labels, weekday initials. */
    val Micro: TextUnit = 11.sp

    // ── Ready-made styles ─────────────────────────────────────────────────────

    /** Large hero numerals (stat tiles, balance). */
    val displayStyle = TextStyle(fontSize = Display, fontWeight = FontWeight.Bold, lineHeight = 40.sp)

    /** Screen hero. */
    val titleStyle = TextStyle(fontSize = Title, fontWeight = FontWeight.Bold, lineHeight = 34.sp)

    /** Screen header. */
    val headlineStyle = TextStyle(fontSize = Headline, fontWeight = FontWeight.Bold, lineHeight = 28.sp)

    /** Section / card header. */
    val subheadStyle = TextStyle(fontSize = Subhead, fontWeight = FontWeight.Bold, lineHeight = 25.sp)

    /** Default reading size. */
    val bodyStyle = TextStyle(fontSize = Callout, fontWeight = FontWeight.Normal, lineHeight = 22.sp)

    /** List row title / button label. */
    val labelStyle = TextStyle(fontSize = Label, fontWeight = FontWeight.SemiBold, lineHeight = 20.sp)

    /** Secondary copy under a row title. */
    val footnoteStyle = TextStyle(fontSize = Footnote, fontWeight = FontWeight.Normal, lineHeight = 18.sp)

    /** Metadata / header subtitle. */
    val captionStyle = TextStyle(fontSize = Caption, fontWeight = FontWeight.Normal, lineHeight = 16.sp)

    /** The floor — nav labels. */
    val microStyle = TextStyle(fontSize = Micro, fontWeight = FontWeight.Normal, lineHeight = 14.sp)
}

/**
 * Material3 [Typography] backed by [BingwaType] so anything that reads the
 * theme (and every explicit `style =` call) lands on the same ramp.
 */
val Typography = Typography(
    displayLarge = BingwaType.displayStyle,
    displayMedium = BingwaType.titleStyle,
    displaySmall = BingwaType.headlineStyle,
    headlineLarge = BingwaType.headlineStyle,
    headlineMedium = BingwaType.headlineStyle,
    headlineSmall = BingwaType.subheadStyle,
    titleLarge = BingwaType.subheadStyle,
    titleMedium = BingwaType.labelStyle,
    titleSmall = BingwaType.labelStyle,
    bodyLarge = BingwaType.bodyStyle,
    bodyMedium = BingwaType.labelStyle,
    bodySmall = BingwaType.footnoteStyle,
    labelLarge = BingwaType.labelStyle,
    labelMedium = BingwaType.captionStyle,
    labelSmall = BingwaType.microStyle
)
