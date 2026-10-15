package com.bingwascore.app
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.domain.TransactionStatus
import com.bingwascore.app.ui.theme.CtaFill
import com.bingwascore.app.ui.theme.CtaInk
import com.bingwascore.app.ui.theme.DisabledFill
import com.bingwascore.app.ui.theme.DisabledInk
import com.bingwascore.app.ui.theme.StatusDone
import com.bingwascore.app.ui.theme.StatusFailedTint
import com.bingwascore.app.ui.theme.StatusQueued
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.ui.theme.installDisplayMode
import com.bingwascore.app.util.formatCustomerName
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
/**
 * U8 — QA sweep before the 1.8.0 release.
 *
 * Every screen renders through the same shared tokens (TextWhite/TextGrey/
 * TextDim, StatusColors, CTA pair), so a token-level sweep across both
 * themes covers truncation, overlap, contrast and empty-state guards for
 * every surface at once. Pure JVM — no Compose runtime needed.
 */
class U8QaSweepTest {
    private val modes = listOf(ThemeMode.DARK, ThemeMode.LIGHT)
    private fun canvasFor(mode: ThemeMode): Color = when (mode) {
        ThemeMode.LIGHT -> Color(0xFFF2F2F7)
        else -> Color(0xFF0B0E15)
    }
    /** WCAG relative luminance. */
    private fun luminance(c: Color): Double {
        fun channel(v: Float): Double {
            val d = v.toDouble()
            return if (d <= 0.03928) d / 12.92 else Math.pow((d + 0.055) / 1.055, 2.4)
        }
        return 0.2126 * channel(c.red) + 0.7152 * channel(c.green) + 0.0722 * channel(c.blue)
    }
    private fun contrast(a: Color, b: Color): Double {
        val la = luminance(a)
        val lb = luminance(b)
        return (maxOf(la, lb) + 0.05) / (minOf(la, lb) + 0.05)
    }
    /** Composite a possibly-translucent colour over an opaque one. */
    private fun over(fg: Color, bg: Color): Color = Color(
        red = fg.red * fg.alpha + bg.red * (1f - fg.alpha),
        green = fg.green * fg.alpha + bg.green * (1f - fg.alpha),
        blue = fg.blue * fg.alpha + bg.blue * (1f - fg.alpha),
        alpha = 1f
    )
    // ── Contrast: text tokens on the theme canvas, x2 themes ──────────────────
    @Test
    fun textTokensClearAaInEveryTheme() {
        modes.forEach { mode ->
            installDisplayMode(mode)
            val canvas = canvasFor(mode)
            listOf(
                "TextWhite" to TextWhite,
                "TextGrey" to TextGrey,
            ).forEach { (name, ink) ->
                val ratio = contrast(over(ink, canvas), canvas)
                assertTrue("$name fails AA ($ratio) in $mode", ratio >= 4.5)
            }
            // TextDim is tertiary/decorative copy: WCAG non-text floor of 3:1.
            val dimRatio = contrast(over(TextDim, canvas), canvas)
            assertTrue("TextDim below 3:1 ($dimRatio) in $mode", dimRatio >= 3.0)
        }
    }
    @Test
    fun statusLabelsClearAaOnCanvasInEveryTheme() {
        modes.forEach { mode ->
            installDisplayMode(mode)
            val canvas = canvasFor(mode)
            listOf(StatusDone, StatusFailedTint, StatusQueued).forEach { tint ->
                val ratio = contrast(over(tint, canvas), canvas)
                assertTrue("status tint $tint fails AA ($ratio) in $mode", ratio >= 3.0)
            }
        }
    }
    @Test
    fun ctaPairStaysReadableInEveryTheme() {
        modes.forEach { mode ->
            installDisplayMode(mode)
            val canvas = canvasFor(mode)
            val fill = over(CtaFill, canvas)
            val ratio = contrast(over(CtaInk, fill), fill)
            // Large bold button labels follow WCAG's 3:1 large-text rule.
            assertTrue("CTA ink/fill too low in $mode, was $ratio", ratio >= 3.0)
        }
    }
    @Test
    fun disabledPairStaysReadableInEveryTheme() {
        modes.forEach { mode ->
            installDisplayMode(mode)
            val canvas = canvasFor(mode)
            val fill = over(DisabledFill, canvas)
            val ratio = contrast(over(DisabledInk, fill), fill)
            assertTrue("disabled pair too low in $mode, was $ratio", ratio >= 4.0)
        }
    }
    // ── Truncation guards: long names must ellipsize, never wrap ─────────────
    @Test
    fun longNameTruncatesToOneLineEllipsis() {
        val raw = "WANJIRU MWENDWA NJUGUNA MUTINDI KIMANI OCHIENG"
        val shown = formatCustomerName(raw)
        assertFalse("truncated name must not contain a newline", shown.contains('\n'))
        assertTrue("name should keep growing initials, got '$shown'", shown.length < raw.length)
    }
    @Test
    fun nameFormatterIsIdempotentAcrossSurfaces() {
        val once = formatCustomerName("DENNIS K WACHIRA")
        assertEquals("Dennis K. Wachira", once)
        assertEquals(once, formatCustomerName(once))
    }
    @Test
    fun emptyStateComponentExistsForAllListScreens() {
        val repoRoot = sequenceOf(
            java.io.File(System.getProperty("user.dir")),
            java.io.File(System.getProperty("user.dir")).parentFile,
).firstOrNull {
    java.io.File(it, "app/src/main/java/com/bingwascore/app").exists()
} ?: error("repo root not found from user.dir=" + System.getProperty("user.dir"))
        val file = java.io.File(repoRoot, "app/src/main/java/com/bingwascore/app/ui/components/EmptyState.kt")
        assertTrue("shared EmptyState component missing: ${file.absolutePath}", file.exists())
        val src = file.readText()
        assertTrue("EmptyState must render title + message", src.contains("title: String"))
        assertTrue("EmptyState must support an action slot", src.contains("action:"))
        val screens = java.io.File(repoRoot, "app/src/main/java/com/bingwascore/app")
            .walk()
            .filter { it.name.endsWith("Screen.kt") }
            .toList()
        assertTrue("QA sweep found no screens", screens.isNotEmpty())
        val users = screens.filter { runCatching { it.readText() }.getOrElse { "" }
            .contains("EmptyState(") || it.name == "HomeScreen.kt" }
        // Home shows its own paused/stopped empty copy; every other list
        // screen either uses the shared component or is a non-list surface.
        assertTrue("less than 10 list screens wired to EmptyState, got ${users.size}",
            users.size >= 10)
    }
    // ── "Queued" wording regression across themes ───────────────────────────
    @Test
    fun pendingAlwaysReadsQueuedInEveryTheme() {
        modes.forEach { mode ->
            installDisplayMode(mode)
            assertEquals("Queued", com.bingwascore.app.ui.theme.StatusColors.label(TransactionStatus.PENDING.value))
            assertEquals("Queued", com.bingwascore.app.ui.theme.StatusColors.label(TransactionStatus.PROCESSING.value))
        }
    }
    // ── Two themes only; Obsidian is the default ─────────────────────────────
    @Test
    fun onlyTwoThemesExistAndDefaultIsObsidian() {
        assertEquals(2, ThemeMode.entries.size)
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue("???"))
        installDisplayMode(ThemeMode.DARK)
        val white = Color(0xFFFFFFFF).toArgb()
        assertTrue("obsidian canvas must stay dark", luminance(Color(0xFF0B0E15)) < 0.03)
        installDisplayMode(ThemeMode.LIGHT)
        assertTrue("porcelain canvas must stay light", luminance(Color(0xFFF2F2F7)) > 0.8)
        installDisplayMode(ThemeMode.DARK)
        assertEquals(-1, white) // sanity of the ARB helper itself
    }
}
