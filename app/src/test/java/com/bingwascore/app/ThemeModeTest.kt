package com.bingwascore.app

import com.bingwascore.app.domain.ThemeMode
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * POLISH P5 — the theme contract.
 *
 * Persisted installs may still carry `"BLUE_LIGHT_FILTER"` from 1.5.0, so the
 * value mapping has to keep resolving to something real, and the three live
 * modes have to stay exactly three with stable stored values (changing a stored
 * value would silently reset everyone's choice).
 */
class ThemeModeTest {

    @Test
    fun `there are exactly three modes and none of them is a light filter`() {
        assertEquals(3, ThemeMode.entries.size)
        assertEquals(
            listOf("DARK", "GRAYSCALE", "SILICA"),
            ThemeMode.entries.map { it.value }
        )
        assertEquals(
            listOf("Obsidian", "Grayscale", "Silica"),
            ThemeMode.entries.map { it.label }
        )
    }

    @Test
    fun `obsidian is the default for an unset or unknown value`() {
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue(null))
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue(""))
    }

    @Test
    fun `the retired blue light filter lands on obsidian`() {
        assertEquals(ThemeMode.DARK, ThemeMode.fromValue("BLUE_LIGHT_FILTER"))
    }

    @Test
    fun `stored values round-trip`() {
        ThemeMode.entries.forEach { mode ->
            assertEquals(mode, ThemeMode.fromValue(mode.value))
        }
    }
}
