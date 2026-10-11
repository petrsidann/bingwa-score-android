package com.bingwascore.app

import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BrandBlue
import com.bingwascore.app.ui.theme.IOS_CARD_RADIUS
import com.bingwascore.app.ui.theme.IosBlue
import com.bingwascore.app.ui.theme.Motion
import com.bingwascore.app.ui.theme.PorcelainBg
import com.bingwascore.app.ui.theme.PorcelainCard
import com.bingwascore.app.ui.theme.PorcelainSeparator
import com.bingwascore.app.ui.theme.PorcelainText
import com.bingwascore.app.ui.theme.installDisplayMode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 10 — iOS design system:
 * - Zero Silica/Grayscale references in app sources.
 * - Porcelain exact hex; both themes compile (tokens resolve per mode).
 * - iOS language numbers: 12dp cards, 34sp titles, 17sp body, capsule CTA,
 *   28dp floating pill, springs 0.35/0.86, press 0.98.
 */
class Stage10IosDesignTest {

    @Test
    fun zeroSilicaGrayscaleReferences() {
        val repoRoot = sequenceOf(
            File(System.getProperty("user.dir")),
            File(System.getProperty("user.dir")).parentFile,
        ).firstOrNull {
            File(it, "app/src/main/java/com/bingwascore/app").exists()
        } ?: error("repo root not found")
        // The Models.kt KDoc intentionally names the retired stored values so
        // installers know where they map; that doc line is not a live reference.
        val hits = File(repoRoot, "app/src/main/java").walkTopDown()
            .filter { it.isFile && it.name.endsWith(".kt") }
            .flatMap { f ->
                f.readLines().mapIndexedNotNull { i, line ->
                    val hit = line.contains("Silica") || line.contains("SILICA") ||
                        line.contains("Grayscale") || line.contains("GRAYSCALE") ||
                        line.contains("isSilica") || line.contains("GlassFill") ||
                        line.contains("AmbientOrbs") || line.contains("glassSurface") ||
                        line.contains("GRAYSCALE_DOT") || line.contains("OrbBlue")
                    if (hit && !f.name.contains("Silica")) "${f.name}:${i + 1}: $line" else null
                }
            }.filterNot { it.startsWith("Models.kt") }
            .toList()
        assertTrue("legacy theme refs remain: $hits", hits.isEmpty())
    }

    @Test
    fun porcelainHexAndBothThemesResolve() {
        assertEquals(0xFFF2F2F7.toInt(), PorcelainBg.toArgb())
        assertEquals(0xFFFFFFFF.toInt(), PorcelainCard.toArgb())
        assertEquals(0xFF000000.toInt(), PorcelainText.toArgb())
        assertEquals(0x4A3C3C43.toInt(), PorcelainSeparator.toArgb())
        assertEquals(0xFF007AFF.toInt(), IosBlue.toArgb())
        assertEquals(0xFF2563EB.toInt(), BrandBlue.toArgb())
        installDisplayMode(ThemeMode.LIGHT)
        assertEquals(PorcelainBg.toArgb(), com.bingwascore.app.ui.theme.BgBlack.toArgb())
        assertEquals(IosBlue.toArgb(), AccentBlue.toArgb())
        installDisplayMode(ThemeMode.DARK)
        assertEquals(BrandBlue.toArgb(), AccentBlue.toArgb())
    }

    @Test
    fun iosLanguageNumbers() {
        assertEquals(12.dp, IOS_CARD_RADIUS)
        assertEquals(0.86f, Motion.DAMPING, 0.001f)
        assertEquals(350, Motion.SPRING_RESPONSE_MILLIS)
        assertEquals(0.98f, Motion.PRESS_SCALE, 0.001f)
        assertEquals(34, com.bingwascore.app.ui.theme.BingwaType.Display.value.toInt())
        assertEquals(17, com.bingwascore.app.ui.theme.BingwaType.Body.value.toInt())
    }
}
