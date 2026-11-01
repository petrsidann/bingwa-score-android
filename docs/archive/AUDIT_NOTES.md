# 10-Group Recovery Audit — Progress Ledger

Status after G7 (all groups: build GREEN → commit → push):

- **G1 ✅ 3fe619f** Brand identity — teal/green → BingwaOrange/Amber sweep (~20 files, success-states kept green); splash rework (centered logo + spark + wordmark/tagline); gated nav flow splash→onboarding→login→main via new `SplashViewModel` + `StartDestination`; app icon rework (orange bg + white B + amber spark); `build_log.txt` untracked.
- **G2 ✅ 1882e58** Glass system — tokens `GlassFill`/`GlassBorder`/`GlassFillStrong`/`GlassBorderStrong` in Color.kt; 57 hardcoded literals replaced across ~20 files; GradientButton verified on BrandColors.
- **G3 ✅ 970f87b** Navigation — real `EngageBotScreen`/`EngageBotViewModel` wired to `EngageBotSessionLifecycle`; last `PlaceholderScreen` deleted; `BotLogRow` shared (`ui/engagebot/BotLogRow.kt`); dialog "Save" CTA → brand orange.
- **G4 ✅ 7aa0725** Motion — all animation durations tokenized into `Motion.kt` (FADE/SLIDE/SPLASH_*/COUNT_UP/CHART/SHIMMER/CONFETTI/GLOW/AMBIENT_*); zero raw `tween(<number>)` remain; dead `Motion.ENTER` removed; ScreenTransition indent fixed. Sequencing `delay(...)` pauses stay literal by design.
- **G5 ✅ 135381e** Data — Room v1→v2: indices on transactions (status+createdAt, status+scheduledAt, phoneNumber, createdAt), offers(isActive), customers(isBlacklisted), auto_replies(type); non-destructive `MIGRATION_1_2` in AppDatabase (Room naming convention matched).
- **G6 ✅ 5563ae1** Engine — `UssdAccessibilityService`: 1.5s auto-tap debounce (`TAP_DEBOUNCE_MILLIS`) prevents double-taps on bursty WINDOW_CONTENT_CHANGED events; `serviceScope.cancel()` in onDestroy; indent fix.
- **G7 ✅ a45a290** Workers/receivers — `WatchdogWorker` now resolves `UserPreferences` via Hilt EntryPoint (was `UserPreferences(applicationContext)`); `BootReceiver` uses `goAsync()`+`finish()` so the boot-time DataStore read + EngineService start survive; RetryWorker/EngageBotTimeoutWorker already used EntryPoint pattern.

## Remaining (next session: run STEP 0 — `git log --oneline` for last "Audit G<n>" — then continue)
- **G8 UI polish audit** — HomeScreen (740+ lines) deep-clean: leftover raw `Color(0xFF0A0A0F)`-style literals → `NightBlack` token; EmptyState/GradientButton usage consistency; Settings subpage scaffold consistency (PageTitle/PageIntro).
- **G9 Testing** — add unit tests: `classifyResponse` (UssdAutomationService), `botLogColor`, `csvEscape` (DailyArchiveWorker), `SmsParser`/`SmsMessageParser`, `ScoreEngine`. Run `./gradlew test`.
- **G10 Release** — verify signed release build (`./gradlew assembleRelease`), versionCode/versionName bump, ProGuard rules sanity, README/CHANGELOG touch-up.

## Standing notes
- PowerShell reports exit code 1 on `git push` (stderr progress artifact) — push is fine; confirm via `git log --oneline -1 origin/main`.
- Keep builds green before every commit; never leave the tree dirty.
- `build_log.txt` is gitignored — don't re-add.
