# Bingwa Score

Bingwa Score helps Safaricom airtime agents sell bundles faster: one-tap dialing,
auto-renewals, automated replies, multi-hop USSD session automation, and real-time commission tracking — all on
your phone.

**Current release: 1.9.1 (versionCode 11)** — Pre-v2.0 release line: resilient foreground engine, remote backend wiring, frosted-glass navigation, and dual Obsidian + Porcelain Dim themes.

> **Bingwa** — lightning, in Swahili. Because every bundle sale should strike at
> the speed of light.

## Features

- **One-tap bundle dialing** — pick a customer, pick an offer, dial instantly.
- **Auto-renewals & self-renewal engine** — re-dial offers for customers or self-renew on schedule.
- **USSD multi-hop session chain** — multi-step USSD session automation and parsing with accessibility auto-tapper.
- **Commission tracking & ledger** — every transaction logs amount, commission, and status with interactive performance charts.
- **Customer management** — per-customer history, blacklists, authorized sender gating, and VCard import.
- **Engage bot** — timed outbound interactive message sessions with auto-expiry.
- **Scheduled & retry queue** — queued transactions process automatically with exponential backoff on retries.
- **Frosted-glass UI & navigation** — fluid bottom-nav morphing into vertical rail, blurred sheets, and high-clarity cards.
- **Dual display themes** — Obsidian (dark) and Porcelain Dim (light/dim default).
- **Nightly archive & backup** — transactions export locally to CSV; JSON export/import for full database backup.
- **In-app update checker** — checks latest release manifests and downloads updates directly.
- **Crash reporter & ANR watchdog** — captures stack traces to file and surfaces crash dialogs.
- **Foreground engine watchdog** — robust foreground service lifecycle keeping autopilot running in the background.

## UI & Themes

Bingwa Score features a modern frosted-glass design system (detailed in `docs/DESIGN.md`) powered by Compose and `GlassSpec` tokens.

**Display modes** (Settings → Appearance):
- **Porcelain Dim** (*Default*) — soft light porcelain canvas (`#F1F5F9`), pure white cards (`#FFFFFF`), near-black ink (`#0F172A`), and vibrant brand-blue accents (`#2563EB`).
- **Obsidian** — deep slate/dark canvas (`#0F172A`), rich card surfaces (`#1E293B`), hairline slate borders (`#475569`), and crisp white ink.

**Frosted Glass UI**:
- Sanctioned frosted glass styling across navigation rails, floating bottom navigation pills, and focus sheets (`ui/glass/`).
- Elevation shadows and subtle translucent blurs give depth without cluttered gradients or opaque rectangles.

## Showcase Mode (demo reel)

Showcase Mode runs the whole app against a **separate database**
(`bingwa_score_demo.db`) so a demo can never touch real agent data. Real installs
keep using `bingwa_score.db`.

Turn it on in **Settings → Showcase Mode** (or accept the offer on first launch)
and restart. While it is on:

- **Seeded demo data** — realistic sample customers, offers, transactions, and auto-reply templates.
- **Live simulator** — periodic synthetic M-Pesa notifications move through the real intake pipeline so counters climb live.
- **Fake dialling** — simulated USSD responses (no actual calls or SMS placed).
- **Simulated balance** — balance display updates via simulated readings.

A blue-outlined **DEMO** chip appears in the top bars while active.

## Engine logging

Every USSD decision is tagged: `adb logcat -s USSD` traces dials, balance reads,
subscription resolution and accessibility auto-taps.

## Install on a device

The signed release APK is built on every push to `main`. To install:

1. Open the latest **Build APK** run on the
   [Actions tab](https://github.com/petrsidann/bingwa-score-android/actions).
2. Download the **`bingwa-score-release-apk`** artifact at the bottom of the run page.
3. Unzip the download to get `app-release.apk`.
4. Transfer the APK to your Android phone (USB, Bluetooth, email, etc.).
5. On the phone, open the APK file. If prompted, allow the file manager / browser
   to **install unknown apps**.
6. Tap **Install**. Open **Bingwa Score** when it finishes.

> The release APK is signed with the project keystore and is safe to install and
> share directly — no Play Store required.

## Agent device setup

For the engine to run reliably in the background on a real agent device, grant
these after installing:

- [ ] **SMS permissions** — RECEIVE_SMS, READ_SMS, SEND_SMS (needed for operator
      confirmation parsing and the auto-reply engine).
- [ ] **Phone & Call** — READ_PHONE_STATE, CALL_PHONE (dialing offers).
- [ ] **Contacts** — READ_CONTACTS, WRITE_CONTACTS (customer lookup).
- [ ] **Notifications** — POST_NOTIFICATIONS (foreground engine notification).
- [ ] **Display over other apps** — required for the USSD overlay in Advanced Mode.
- [ ] **Accessibility service** — enable **Bingwa Score** under Accessibility settings
      to turn on Advanced Mode USSD automation.
- [ ] **Battery optimization** — exclude Bingwa Score so the engine isn't killed.
- [ ] **Autostart** — if your OEM has an autostart manager, allow Bingwa Score to
      start on boot (the `BootReceiver` revives the engine automatically).

## Development

### Build requirements

- Android Studio Hedgehog (or newer) with JDK 17
- Android SDK 34 (compileSdk / targetSdk)
- Gradle 8.7 (via the wrapper)

### Run a debug build

```bash
./gradlew assembleDebug
```

To configure a custom relay backend URL at build time, pass `-PrelayBaseUrl`:

```bash
./gradlew assembleDebug -PrelayBaseUrl=https://your.url
```

The debug APK lands at `app/build/outputs/apk/debug/app-debug.apk`.

### Build a signed release APK

Generate the release keystore (first time only):

```bash
keytool -genkeypair -v \
  -keystore keystore/release.keystore \
  -alias bingwa -keyalg RSA -keysize 2048 -validity 10000 \
  -storepass bingwa123 -keypass bingwa123 \
  -dname "CN=Bingwa, OU=Dev, O=BingwaScore, L=Nairobi, C=KE"
```

Then build:

```bash
./gradlew assembleRelease
```

The signed APK lands at `app/build/outputs/apk/release/app-release.apk`.

### Tech stack

- Kotlin + Jetpack Compose + Material 3
- Hilt (DI), Room (local DB), DataStore (preferences)
- WorkManager (periodic workers + retry queue)
- Ktor + OkHttp (networking)
- Coil, Accompanist
