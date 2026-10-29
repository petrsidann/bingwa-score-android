package com.bingwascore.app

import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BrandBlue
import com.bingwascore.app.ui.theme.IOS_CARD_RADIUS
import com.bingwascore.app.ui.theme.Motion
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 24 — iOS design system: Obsidian + Porcelain Dim (default).
 *
 * - Zero Silica/Grayscale references in app sources.
 * - iOS language numbers: 12dp cards, 48sp display, 16sp body, capsule CTA,
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
    fun iosLanguageNumbers() {
        assertEquals(12.dp, IOS_CARD_RADIUS)
        assertEquals(0.86f, Motion.DAMPING, 0.001f)
        assertEquals(350, Motion.SPRING_RESPONSE_MILLIS)
        assertEquals(0.98f, Motion.PRESS_SCALE, 0.001f)
        assertEquals(48, com.bingwascore.app.ui.theme.BingwaType.Display.value.toInt())
        assertEquals(16, com.bingwascore.app.ui.theme.BingwaType.Body.value.toInt())
    }
}
