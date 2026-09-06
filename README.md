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
- **Glass UI** — Material 3 dark theme with frosted cards and gradient actions.

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
