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
 * POLISH P5 — display modes (Settings > Appearance).
 *
 * Three readings of the same dark product, no light mode:
 *
 * - [DARK]   "Obsidian" — black + softened electric blue. The default.
 * - [GRAYSCALE] — monochrome chrome, but **semantic colour survives**: a failed
 *   transaction is still red and a completed one still blue, because a ledger
 *   that cannot be read at a glance is a worse ledger.
 * - [SILICA] — glassmorphism: frosted cards, a translucent nav rail, ambient
 *   purple/blue orbs behind everything.
 *
 * [fromValue] retires the old BLUE LIGHT FILTER: an install that had it stored
 * lands on Obsidian, since a warm filter is no longer a mode anyone can pick.
 */
enum class ThemeMode(val value: String, val label: String) {
    DARK("DARK", "Obsidian"),
    GRAYSCALE("GRAYSCALE", "Grayscale"),
    SILICA("SILICA", "Silica");

    companion object {
        /** Everything that is not one of the three above reads as Obsidian. */
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
