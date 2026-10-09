package com.bingwascore.app

import com.bingwascore.app.domain.EngineState
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * U2 — EngineState round-trip and default-value correctness.
 *
 * Laws:
 *  1. fromValue on any known string returns the matching enum entry.
 *  2. fromValue on an unknown / null string defaults to RUNNING (safe fallback
 *     so a missing DataStore key never silently stops the engine).
 *  3. The value strings stored in DataStore are stable across refactors.
 */
class EngineStateTest {

    // ── Law 1: known-string round-trip ────────────────────────────────────────

    @Test
    fun fromValue_running_returnsRunning() {
        assertEquals(EngineState.RUNNING, EngineState.fromValue("RUNNING"))
    }

    @Test
    fun fromValue_paused_returnsPaused() {
        assertEquals(EngineState.PAUSED, EngineState.fromValue("PAUSED"))
    }

    @Test
    fun fromValue_stopped_returnsStopped() {
        assertEquals(EngineState.STOPPED, EngineState.fromValue("STOPPED"))
    }

    // ── Law 2: unknown / null defaults to RUNNING ─────────────────────────────

    @Test
    fun fromValue_null_defaultsToRunning() {
        assertEquals(EngineState.RUNNING, EngineState.fromValue(null))
    }

    @Test
    fun fromValue_empty_defaultsToRunning() {
        assertEquals(EngineState.RUNNING, EngineState.fromValue(""))
    }

    @Test
    fun fromValue_garbage_defaultsToRunning() {
        assertEquals(EngineState.RUNNING, EngineState.fromValue("UNKNOWN_STATE"))
    }

    // ── Law 3: stored value strings are stable ────────────────────────────────

    @Test
    fun storedValues_areUppercaseLiterals() {
        assertEquals("RUNNING", EngineState.RUNNING.value)
        assertEquals("PAUSED", EngineState.PAUSED.value)
        assertEquals("STOPPED", EngineState.STOPPED.value)
    }
}
