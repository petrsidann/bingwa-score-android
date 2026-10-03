# Bingwa Score

Bingwa Score helps Safaricom airtime agents sell bundles faster: one-tap dialing,
auto-renewals, botted replies, USSD automation and commission tracking — all on
your phone.

> **Bingwa** — lightning, in Swahili. Because every bundle sale should strike at
> the speed of light.

## Features

- **One-tap bundle dialing** — pick a customer, pick an offer, dial instantly.
- **Auto-renewals** — re-dial offers for customers on a schedule without lifting a finger.
- **Auto-reply engine** — canned SMS replies triggered on authorized senders.
- **USSD automation (Advanced Mode)** — accessibility-service auto-tapper that reads
  and completes Safaricom USSD sessions for you.
- **Commission tracking** — every transaction logs amount, commission and status.
- **Customer management** — per-customer history, blacklist, authorized senders.
- **Engage bot** — timed outbound message sessions with auto-expiry.
- **Scheduled / retry queue** — due transactions fire automatically; failed ones retry.
- **Nightly archive** — older transactions export to CSV and are cleared locally.
- **Backup & Restore** — export and import your full dataset as JSON.
- **Update checker** — compares your install to the latest GitHub release.
- **Crash handler** — writes stack traces to `getExternalFilesDir("crashes")`.
- **Watchdog** — periodic worker that restarts the engine and re-enqueues schedulers.
- **Bingwa Score UI** — dark-first terminal aesthetic: flat black canvas, bubble
  cards, electric-blue actions. No glass, no blur, no gradients.

## Brand

| Token | Hex | Used for |
| --- | --- | --- |
| BgBlack | `#000000` | every screen background |
| Bubble | `#141414` | cards and rows |
| Raised | `#1C1C1C` | sheets and pressed surfaces |
| Hairline | `#2A2A2A` | borders and dividers |
| TextWhite | `#FFFFFF` | titles and values |
| TextGrey | `#9E9E9E` | metadata |
| TextDim | `#6B6B6B` | quiet labels |
| AccentBlue | `#2962FF` | primary actions, selected tabs |
| ChartBlue | `#3D6FFF` | commission chart line |
| FailRed | `#FF5252` | failures and delete |
| PendGrey | `#9E9E9E` | pending / scheduled |
| TickGreen | `#00C853` | the complete-action tick, and nothing else |

**Display modes** (Settings → Appearance, no light mode):
- **Dark** — the product truth.
- **Grayscale** — monochrome: every accent drops to `#BDBDBD`, statuses to greys.
- **Blue Light Filter** — warm dark for night use (bg `#0A0806`, text `#FFE9C9`,
  accent `#FFB74D`). CTAs become solid near-black chips with a hairline border.

**Monogram** — one continuous extra-bold white script stroke: a cursive B flowing
into an S loop that ends on an upward checkmark flick. Used as the launcher icon
and drawn on-screen at the start of every launch.

## Showcase Mode (demo reel)

Showcase Mode runs the whole app against a **separate database**
(`bingwa_score_demo.db`) so a demo can never touch real agent data. Real installs
keep using `bingwa_score.db`.

Turn it on in **Settings → Showcase Mode** (or accept the offer on first launch)
and restart. While it is on:

- **Seeded demo month** — 6 customers, 5 offers, 42 transactions across 30 days,
  4 auto-reply templates, 1 blocked contact and 1 trusted partner.
- **Live simulator** — every 20–45s a real Hybrid-format M-Pesa confirmation
  arrives and is fed through the production `SmsParser` and
  `TransactionPipeline`, so counters climb and rows walk
  PENDING → PROCESSING → SUCCESSFUL for real. 15% of sales also produce a
  commission summary; 10% are duplicate payments that route into the Engage Bot.
- **Fake dialling** — USSD replies arrive on a 2–4s timer (80% success,
  12% "already been recommended", 8% "Connection problem"). **No USSD is dialled
  and no SMS is sent.**
- **Simulated balance** — `*144#` returns a random walk instead of a real read.
- **Notifications** — one per processed payment: "Ksh X from NAME - offer delivered".

A blue-outlined **DEMO** chip appears in the top bars while it is active. Settings
also offers **Reseed demo data** and **Exit showcase**.

When Showcase Mode is off, none of the demo code runs: every entry point is
guarded by the flag (engine start, fake dial, fake balance, seeding, chip).

## Engine logging

Every USSD decision is tagged: `adb logcat -s USSD` traces dials, balance reads,
subscription resolution and accessibility auto-taps.

## Screenshots

<!-- TODO: add screenshots here -->
<!-- ![](docs/screenshot-1.png) -->
<!-- ![](docs/screenshot-2.png) -->

## Install on a device

The signed release APK is built on every push to `main`. To install:

1. Open the latest **Build Android APK** run on the
   [Actions tab](https://github.com/petrsidann/bingwa-score-android/actions).
2. Download the **`app-release-apk`** artifact at the bottom of the run page.
3. Unzip the download — it contains `app-release.apk`.
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
- Moshi + Retrofit + OkHttp (networking)
- Coil, Lottie, Accompanist

## Distribution

Grab the signed `app-release.apk` from the
[Actions artifacts](https://github.com/petrsidann/bingwa-score-android/actions) and
share it with agents via Bluetooth, WhatsApp, or a USB cable. Because it is signed,
agents can install it directly and receive updates by installing newer release
APKs over the existing app.

## Manual test script — Simulate Payment trace (Audit G8/G10)

No real money moves. On a debug or release build:

1. Seed an offer: **Offers** → add an offer priced exactly **Ksh 20.00**.
2. Open **Settings → Simulate Payment** (DEV chip).
3. Enter phone `0712345678`, name `TEST USER`, amount `20` → **Run Simulation**.
4. Expect a *"Simulated Ksh 20.00 …"* confirmation line under the button.
5. Open **Transactions** → a new `SIM…` row appears (PENDING → PROCESSING →
   SUCCESSFUL/FAILED after the USSD step).
6. **Truth checks**: an M-Pesa SMS with *"sent to"* or *"withdrawn"* must create
   **no** transaction and send **no** reply. Only *"received from"* creates work.
7. Authorized-senders gate: **Authorized Senders** → add `MPESA`, then a payment
   SMS from any other sender must be ignored with no reply. Remove all senders
   to return to default-open.

## Parity vs Bingwa Hybrid (assessment, 2026-09-29)

| Area | Bingwa Score (this app) | Hybrid | Gap |
|---|---|---|---|
| M-Pesa intake | `SmsParser.classify` → INCOMING only; OUTGOING ignored; replies to payer phone | same truth model | ✅ parity |
| Offer matching | amount == price | amount == price + fallback rules | minor — fallback rules deferred |
| USSD dial | `UssdAutomationService` + accessibility auto-tap | same | ✅ parity |
| Engage bot | duplicate-INCOMING trigger, session Q&A, timeout worker | same | ✅ parity |
| Silent batch dial | multi-select offers → queued sequential dials (3 s gap, silent first); non-silent offers ask once | silent batch dial + confirmation for advanced | ✅ parity |
| Tests | `SmsParser`/`UssdResponses`/`CsvEscapes`/`ScoreEngine`/`botLogColor` unit tests | device tests | ✅ JVM parity; no device farm |

