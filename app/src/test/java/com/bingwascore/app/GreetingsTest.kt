package com.bingwascore.app

import com.bingwascore.app.ui.home.Greetings
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * POLISH P2 — the rotating greeting.
 *
 * Two properties matter and are easy to break:
 * - **Stable per session.** The same (day, session) must always produce the same
 *   language, or the greeting flips on every recomposition.
 * - **Surprising tomorrow.** A new session index must move the line on.
 */
class GreetingsTest {

    @Test
    fun `buckets map to the hours a human would use`() {
        assertEquals(Greetings.Bucket.EARLY_MORNING, Greetings.bucketFor(2))
        assertEquals(Greetings.Bucket.EARLY_MORNING, Greetings.bucketFor(4))
        assertEquals(Greetings.Bucket.MORNING, Greetings.bucketFor(6))
        assertEquals(Greetings.Bucket.MID_MORNING, Greetings.bucketFor(9))
        assertEquals(Greetings.Bucket.AFTERNOON, Greetings.bucketFor(13))
        assertEquals(Greetings.Bucket.LATE_AFTERNOON, Greetings.bucketFor(16))
        assertEquals(Greetings.Bucket.EVENING, Greetings.bucketFor(19))
        assertEquals(Greetings.Bucket.NIGHT, Greetings.bucketFor(22))
        assertEquals(Greetings.Bucket.NIGHT, Greetings.bucketFor(23))
    }

    @Test
    fun `the language is stable for the same day and session`() {
        val first = Greetings.languageFor(120, 3)
        val second = Greetings.languageFor(120, 3)
        assertEquals(first, second)
    }

    @Test
    fun `a new session moves the language on`() {
        val today = Greetings.languageFor(120, 3)
        val tomorrow = Greetings.languageFor(121, 3)
        assertNotEquals(today, tomorrow)
    }

    @Test
    fun `the rotation wraps instead of overflowing`() {
        val size = Greetings.Language.entries.size
        assertEquals(
            Greetings.languageFor(1, 0),
            Greetings.languageFor(1 + size, 0)
        )
        assertEquals(
            Greetings.languageFor(1, 0),
            Greetings.languageFor(1, size)
        )
    }

    @Test
    fun `every bucket has a non-blank greeting in every language`() {
        Greetings.Language.entries.forEach { language ->
            Greetings.Bucket.entries.forEach { bucket ->
                assertTrue(
                    "missing greeting for ${language.key()} in ${bucket.name}",
                    Greetings.text(bucket, language).isNotBlank()
                )
            }
        }
    }

    @Test
    fun `swahili comes first in the rotation`() {
        assertEquals(Greetings.Language.SWAHILI, Greetings.Language.entries.first())
        assertEquals("Habari za asubuhi", Greetings.text(Greetings.Bucket.MORNING, Greetings.Language.SWAHILI))
    }

    @Test
    fun `arabic is the right-to-left language`() {
        assertTrue(Greetings.Language.ARABIC.rtl)
        assertTrue(Greetings.Language.entries.count { it.rtl } == 1)
    }

    private fun Greetings.Language.key(): String = name
    private fun Greetings.Bucket.key(): String = name
}
