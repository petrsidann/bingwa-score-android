package com.bingwascore.app

import com.bingwascore.app.domain.ThemeMode
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Stage 10 — the iOS theme contract: Obsidian + Porcelain.
 * Stage 22 — Porcelain Dim joins them: the lights dimmed, not the sun off.
 *
 * Retired stored values (GRAYSCALE, SILICA, BLUE_LIGHT_FILTER) resolve to
 * Obsidian so no install resets oddly; stored values round-trip.
 */
class ThemeModeTest {

    @Test
    fun `there are exactly three modes`() {
        assertEquals(3, ThemeMode.entries.size)
        assertEquals(
            listOf("DARK", "LIGHT", "PORCELAIN_DIM"),
            ThemeMode.entries.map { it.value }
        )
        assertEquals(
            listOf("Obsidian", "Porcelain", "Porcelain Dim"),
            ThemeMode.entries.map { it.label }
        )
    }

    @Test
    fun `obsidian is the default for an unset or unknown value`() {
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue(null))
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue(""))
    }

    @Test
    fun `retired modes land on obsidian`() {
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue("BLUE_LIGHT_FILTER"))
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue("GRAYSCALE"))
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue("SILICA"))
    }

    @Test
    fun `stored values round-trip`() {
        ThemeMode.entries.forEach { mode ->
            assertEquals(mode, ThemeMode.fromValue(mode.value))
        }
    }
}
