package com.bingwascore.app.domain

/**
 * Core domain enums shared across the app.
 * Room stores these as plain Strings (see data/local entities) and screens map
 * back using the [fromValue] helpers.
 */
enum class TransactionStatus(val value: String) {
    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    SCHEDULED("SCHEDULED"),
    SUCCESSFUL("SUCCESSFUL"),
    FAILED("FAILED"),
    FAILED_ALREADY_RECOMMENDED("FAILED_ALREADY_RECOMMENDED"),
    UNMATCHED("UNMATCHED"),
    CANCELLED("CANCELLED"),
    PAUSED("PAUSED"),
    /** Parity F â€” SMS from a sender outside the authorized list: audit only, never replied to. */
    IGNORED("IGNORED");

    companion object {
        fun fromValue(value: String?): TransactionStatus =
            entries.firstOrNull { it.value == value } ?: PENDING
    }
}

/**
 * Stage 10 — iOS design system: two themes. Stage 22 adds the third.
 *
 * - [DARK]           "Obsidian"      — dark, #0B0E15 family.
 * - [LIGHT]          "Porcelain"     — light, iMessage-grade (#E2E4E8 bg, #F7F8FA cards).
 * - [PORCELAIN_DIM]  "Porcelain Dim" — the LIGHTS DIMMED: a dim porcelain canvas
 *   with soft blue accents. It is NOT a dark theme — the surfaces stay light
 *   enough to read as porcelain, and it never takes over as Obsidian black.
 *
 * Silica + Grayscale are deleted. [fromValue] maps every retired stored value
 * (GRAYSCALE, SILICA, BLUE_LIGHT_FILTER) to Obsidian so no install resets oddly.
 */
enum class ThemeMode(val value: String, val label: String) {
    DARK("DARK", "Obsidian"),
    LIGHT("LIGHT", "Porcelain"),
    PORCELAIN_DIM("PORCELAIN_DIM", "Porcelain Dim");

    companion object {
        /** Everything unknown — incl. retired modes — reads as Obsidian. */
        fun fromValue(value: String?): ThemeMode =
            entries.firstOrNull { it.value == value } ?: DARK
    }
}

enum class AppProcessingMode(val value: String) {
    EXPRESS("EXPRESS"),
    ADVANCED("ADVANCED");

    companion object {
        fun fromValue(value: String?): AppProcessingMode =
            entries.firstOrNull { it.value == value } ?: EXPRESS
    }
}
enum class EngineState(val value: String) {
    RUNNING("RUNNING"),
    PAUSED("PAUSED"),
    STOPPED("STOPPED");

    companion object {
        fun fromValue(value: String?): EngineState =
            entries.firstOrNull { it.value == value } ?: RUNNING
    }
}

/**
 * MEGA A â€” cold-start gate. Mirrors their APP_STATE key so the startup decision
 * is a single persisted value rather than a pile of unrelated flags.
 *
 * [STATE_SETUP] means "permissions/engine incomplete" â†’ route to the Setup
 * Checklist BEFORE Home. [STATE_RUNNING] means everything is satisfied.
 */
enum class AppState(val value: String) {
    /** Fresh install, nothing granted yet. */
    STATE_SETUP("STATE_SETUP"),

    /** Partially configured â€” at least one checklist row is still ACTION. */
    STATE_INCOMPLETE("STATE_INCOMPLETE"),

    /** Permissions granted and the engine service is alive. */
    STATE_RUNNING("STATE_RUNNING");

    companion object {
        fun fromValue(value: String?): AppState =
            entries.firstOrNull { it.value == value } ?: STATE_SETUP
    }
}

/**
 * MEGA A â€” what the engine is doing right now, mirrored onto the persistent
 * notification so the agent can see the app is alive even mid-dial.
 */
enum class ProcessingActivity(val value: String, val notificationText: String) {
    IDLE("IDLE", "Watching for M-Pesa payments"),
    DIALING("DIALING", "Processing"),
    SENDING_REPLY("SENDING_REPLY", "Processing transaction"),
    COMPLETED("COMPLETED", "Processing complete");

    companion object {
        fun fromValue(value: String?): ProcessingActivity =
            entries.firstOrNull { it.value == value } ?: IDLE
    }
}
