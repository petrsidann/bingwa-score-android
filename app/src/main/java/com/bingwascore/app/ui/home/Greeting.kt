package com.bingwascore.app.ui.home

import java.util.Calendar

/**
 * POLISH P2 — the greeting line.
 *
 * Two axes make it feel written rather than assembled:
 *
 * 1. **Time bucket** — seven buckets across the day, because "Good evening" at
 *    18:40 and at 20:10 are different sentences and a static "Hello" is not a
 *    greeting at all.
 * 2. **Language** — eight languages, rotating daily. The agent is Kenyan and
 *    multilingual; the app meeting them in their language (and sometimes in a
 *    language they did not expect) is a courtesy that reads as considered.
 *
 * The rotation key is `dayOfYear + sessionIndex`: the same greeting all session
 * (no flicker on rotation, no flicker on resume), and a new one tomorrow. Pure
 * and deterministic, so it is unit-tested like the rest of this app.
 */
object Greetings {

    /** The day, in seven readable parts. */
    enum class Bucket { EARLY_MORNING, MORNING, MID_MORNING, AFTERNOON, LATE_AFTERNOON, EVENING, NIGHT }

    /** Rotation order — Swahili first: this is a Kenyan product. */
    enum class Language(val endonym: String, val rtl: Boolean = false) {
        SWAHILI("Kiswahili"),
        ENGLISH("English"),
        FRENCH("Francais"),
        ITALIAN("Italiano"),
        GERMAN("Deutsch"),
        SPANISH("Espanol"),
        PORTUGUESE("Portugues"),
        ARABIC("العربية", rtl = true)
    }

    /** Hour-of-day -> bucket. Boundaries are the ones a human would use. */
    fun bucketFor(hourOfDay: Int): Bucket = when (hourOfDay) {
        in 0..4 -> Bucket.EARLY_MORNING
        in 5..7 -> Bucket.MORNING
        in 8..10 -> Bucket.MID_MORNING
        in 11..14 -> Bucket.AFTERNOON
        in 15..16 -> Bucket.LATE_AFTERNOON
        in 17..19 -> Bucket.EVENING
        else -> Bucket.NIGHT
    }

    /** The bucket for right now. */
    fun currentBucket(nowMillis: Long = System.currentTimeMillis()): Bucket =
        bucketFor(Calendar.getInstance().apply { timeInMillis = nowMillis }.get(Calendar.HOUR_OF_DAY))

    /**
     * Stable per session, different tomorrow.
     *
     * [sessionIndex] is persisted and bumped once per cold start, so the greeting
     * holds still while the agent works and still changes day to day.
     */
    fun languageFor(dayOfYear: Int, sessionIndex: Int): Language {
        val entries = Language.entries
        return entries[Math.floorMod(dayOfYear + sessionIndex, entries.size)]
    }

    /** Today's day-of-year, used as the rotation key. */
    fun todayIndex(nowMillis: Long = System.currentTimeMillis()): Int =
        Calendar.getInstance().apply { timeInMillis = nowMillis }.get(Calendar.DAY_OF_YEAR)

    /** The greeting itself, in the chosen language. */
    fun text(bucket: Bucket, language: Language): String = when (language) {
        Language.SWAHILI -> when (bucket) {
            Bucket.EARLY_MORNING -> "Masika tulivu"
            Bucket.MORNING -> "Habari za asubuhi"
            Bucket.MID_MORNING -> "Asubuhi njema"
            Bucket.AFTERNOON -> "Habari za mchana"
            Bucket.LATE_AFTERNOON -> "Jioni karibu"
            Bucket.EVENING -> "Habari za jioni"
            Bucket.NIGHT -> "Habari za usiku"
        }
        Language.ENGLISH -> when (bucket) {
            Bucket.EARLY_MORNING -> "Quiet early hours"
            Bucket.MORNING -> "Good morning"
            Bucket.MID_MORNING -> "Good morning to you"
            Bucket.AFTERNOON -> "Good afternoon"
            Bucket.LATE_AFTERNOON -> "Winding down well"
            Bucket.EVENING -> "Good evening"
            Bucket.NIGHT -> "Good night"
        }
        Language.FRENCH -> when (bucket) {
            Bucket.EARLY_MORNING -> "Petites heures"
            Bucket.MORNING -> "Bonjour"
            Bucket.MID_MORNING -> "Bonjour a vous"
            Bucket.AFTERNOON -> "Bon apres-midi"
            Bucket.LATE_AFTERNOON -> "Belle fin de journee"
            Bucket.EVENING -> "Bonsoir"
            Bucket.NIGHT -> "Bonne nuit"
        }
        Language.ITALIAN -> when (bucket) {
            Bucket.EARLY_MORNING -> "Piccole ore"
            Bucket.MORNING -> "Buongiorno"
            Bucket.MID_MORNING -> "Buongiorno a lei"
            Bucket.AFTERNOON -> "Buon pomeriggio"
            Bucket.LATE_AFTERNOON -> "Bella fine giornata"
            Bucket.EVENING -> "Buonasera"
            Bucket.NIGHT -> "Buonanotte"
        }
        Language.GERMAN -> when (bucket) {
            Bucket.EARLY_MORNING -> "Kleine Stunden"
            Bucket.MORNING -> "Guten Morgen"
            Bucket.MID_MORNING -> "Guten Morgen Ihnen"
            Bucket.AFTERNOON -> "Guten Tag"
            Bucket.LATE_AFTERNOON -> "Schoner Feierabend"
            Bucket.EVENING -> "Guten Abend"
            Bucket.NIGHT -> "Gute Nacht"
        }
        Language.SPANISH -> when (bucket) {
            Bucket.EARLY_MORNING -> "Horas tempranas"
            Bucket.MORNING -> "Buenos dias"
            Bucket.MID_MORNING -> "Buenos dias a usted"
            Bucket.AFTERNOON -> "Buenas tardes"
            Bucket.LATE_AFTERNOON -> "Buen atardecer"
            Bucket.EVENING -> "Buenas noches"
            Bucket.NIGHT -> "Que descanse"
        }
        Language.PORTUGUESE -> when (bucket) {
            Bucket.EARLY_MORNING -> "Madrugada"
            Bucket.MORNING -> "Bom dia"
            Bucket.MID_MORNING -> "Bom dia para si"
            Bucket.AFTERNOON -> "Boa tarde"
            Bucket.LATE_AFTERNOON -> "Bom fim de tarde"
            Bucket.EVENING -> "Boa noite"
            Bucket.NIGHT -> "Boa madrugada"
        }
        Language.ARABIC -> when (bucket) {
            Bucket.EARLY_MORNING -> "ساعات مبكرة هادئة"
            Bucket.MORNING -> "صباح الخير"
            Bucket.MID_MORNING -> "صباح الخير لك"
            Bucket.AFTERNOON -> "طاب يومك"
            Bucket.LATE_AFTERNOON -> "مساء الخير"
            Bucket.EVENING -> "مساء الخير لك"
            Bucket.NIGHT -> "تصبح على خير"
        }
    }
}
