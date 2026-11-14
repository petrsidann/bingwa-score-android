# Bingwa Score

Bingwa Score helps Safaricom airtime agents sell bundles faster: one-tap dialing,
auto-renewals, automated replies, multi-hop USSD session automation, and real-time
commission tracking — all on your phone.

**Current release: 1.9.1 (versionCode 11)** — resilient foreground engine, remote
backend wiring, frosted-glass navigation, InstanT-style launch reveal, and dual
Obsidian + Porcelain Dim themes.

> **Bingwa** — lightning, in Swahili. Because every bundle sale should strike at
> the speed of light.

## Repositories
- **bingwa-score-android** (this repo) — the Kotlin + Jetpack Compose app.
- **bingwa-score-relay** — the Kotlin/JVM 17 + Ktor 3 backend: WebSocket/SSE score
  relay, admin portal (/admin), per-agent storefronts (/store/{slug}), and M-Pesa
  Daraja STK push + callbacks. The app connects via a runtime-configurable server
  URL and is fully functional offline.

## Features
- **One-tap bundle dialing** — pick a customer, pick an offer, dial instantly.
- **Auto-renewals & self-renewal engine** — re-dial offers for customers or self-renew on schedule.
- **USSD multi-hop session chain** — multi-step USSD automation and parsing with accessibility auto-tapper.
- **Commission tracking & ledger** — every transaction logs amount, commission, and status with interactive charts.
- **Customer management** — per-customer history, blacklists, authorized sender gating, VCard + CSV import.
- **Engage bot** — timed outbound interactive message sessions with auto-expiry.
- **Scheduled & retry queue** — queued transactions process automatically with exponential backoff.
- **Frosted-glass UI & navigation** — bottom-nav morphing into a vertical rail, blurred sheets, high-clarity cards.
- **InstanT-style launch** — lime field, violet seed dot, true-circle reveal, lime wordmark reborn on violet.
- **Dual display themes** — Obsidian (dark) and Porcelain Dim (light/dim default).
- **Nightly archive & backup** — CSV export; JSON export/import for full database backup.
- **In-app update checker**, **crash reporter & ANR watchdog**, **foreground engine watchdog**.

## UI & Themes
Modern frosted-glass design system (see `docs/DESIGN.md`, the anti-slop constitution)
powered by Compose and `GlassSpec` tokens. Canonical tokens: `ui/theme/DesignTokens.kt`.
- **Porcelain Dim** (default) — soft porcelain canvas, white cards, near-black ink, brand-blue accents.
- **Obsidian** — deep slate canvas, rich card surfaces, hairline borders, crisp white ink.
Glass is sanctioned only in `ui/glass/` (nav bars, sheets, dialogs), never on cards.

## Showcase Mode (demo reel)
Runs the whole app against a separate database (`bingwa_score_demo.db`) so a demo
never touches real agent data. Enable in Settings -> Showcase Mode and restart.
Seeded demo data, a live simulator moving synthetic M-Pesa notifications through
the real pipeline, fake dialling, simulated balance, and a blue-outlined DEMO chip.

## Engine logging
Every USSD decision is tagged: `adb logcat -s USSD` traces dials, balance reads,
subscription resolution and accessibility auto-taps.

## Install on a device
CI (`.github/workflows/build-apk.yml`) builds on every push/PR to main and uploads
two artifacts: `bingwa-score-debug-apk` and `bingwa-score-release-apk`.
1. Open the latest **Build APK** run on the Actions tab (or the PR's check).
2. Download an artifact and unzip to get the APK.
3. Transfer to your phone and open it; allow "install unknown apps" if prompted.
4. Tap Install.
> The debug build has applicationId `com.bingwascore.app.debug`, so it installs
> alongside the release build — handy for testing a PR without removing your main app.

## Agent device setup
Grant after installing: SMS (RECEIVE/READ/SEND), Phone & Call (READ_PHONE_STATE,
CALL_PHONE), Contacts (READ/WRITE), Notifications (POST_NOTIFICATIONS), Display
over other apps (USSD overlay), Accessibility service (Advanced Mode USSD),
Battery-optimization exclusion, and OEM Autostart (BootReceiver revives the engine).

## Development
### Requirements
- Android Studio Hedgehog+ with JDK 17, Android SDK 34 (compileSdk/targetSdk), minSdk 26, Gradle 8.7 (wrapper).

### Build
```bash
./gradlew assembleDebug assembleRelease --no-daemon
```
Custom relay URL at build time: `./gradlew assembleDebug -PrelayBaseUrl=https://your.url`
(default http://10.0.2.2:8080). Debug APK: app/build/outputs/apk/debug/app-debug.apk.

### Tests
Gate on targeted tests (the full suite has a known environmental executor crash):
```bash
./gradlew testDebugUnitTest --no-daemon --tests "com.bingwascore.app.StartDestinationTest"
```
Paparazzi goldens live in docs/gate; record with recordPaparazziDebug when a stage adds a screen.

### Signed release
The release keystore lives at keystore/release.keystore (NOT committed). Generate
once with keytool (alias bingwa, RSA 2048), keep the password private, then
`./gradlew assembleRelease`. CI falls back to the debug keystore when no release
keystore is present. Never commit the keystore or its password.

### Tech stack
Kotlin + Jetpack Compose + Material 3; Hilt, Room, DataStore; WorkManager;
Ktor + OkHttp + Retrofit/Moshi; Coil, Lottie, Accompanist; Paparazzi + Robolectric.

## Working with AI agents
This repo is built stage-by-stage with IDE agents (Kilo/Cline). The law:
- One stage per session; full-file replacements; no improvisation.
- Read AGENTS.md + HANDOFF.md first; obey docs/DESIGN.md and .clinerules/.
- Load only the named skill (.cline/skills/SKILLS-INDEX.md): design-pass before UI.
- Build green (assembleDebug + assembleRelease) + targeted tests, then push a
  branch and open a PR titled "Stage NN: <human name>". The owner smokes the PR
  artifact and merges. DONE = commit hash on origin/main.
