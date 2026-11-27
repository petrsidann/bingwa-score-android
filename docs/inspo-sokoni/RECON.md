# Sokoni Recon — Bingwa Production App (com.appengineer.bingwa)

**Package:** `com.appengineer.bingwa`  
**Version:** Not extractable from resources alone (requires APK versionName from manifest or Play Store)  
**Toolkit verdict:** **Flutter 2.x/3.x** (not Compose, not XML). Evidence: `flutterEmbedding: 2` meta-data in AndroidManifest, `io.flutter.embedding.android.NormalTheme`, Flutter plugin registrations (firebase_messaging, flutter_foreground_task, android_alarm_manager_plus, sms_receive, telephony, awesome_notifications, url_launcher, open_file, install_plugin), Flutter asset bundle at `assets/flutter_assets/`.

---

## Architecture Summary

- **Single-activity Flutter shell** (`com.example.bingwa.MainActivity`) hosting a Flutter engine.
- **Multiple background services:** USSD accessibility service (`com.phan_tech.ussd_advanced.USSDServiceKT`), foreground services for USSD and notifications, SMS receivers, boot receivers, alarm managers.
- **Firebase integration:** Auth, Firestore, Messaging, Analytics, Installations.
- **Permissions-heavy:** SMS read/write/send/receive, phone state, call phone, contacts, storage, location, notification listener, device admin, battery optimization exemption.
- **Deep linking:** `bingwa://bingwa.com` scheme registered.
- **Device admin receiver** for kiosk/MDM-like control.

**Layer model:** Flutter presentation layer (Dart code compiled to native ARM, not recoverable via jadx) + Android native plugins (Kotlin/Java) for platform features (USSD, SMS, notifications, alarms).

---

## Screen Map (inferred from assets + manifest)

No XML layouts exist (Flutter renders via Skia canvas). Screen structure inferred from:
- Asset names: `app_launcher_icon.png`, `logoBS-removebg-preview.png`, `card-2.jpg`, `drone-removebg.png`, `PLANE-removebg.png`, `rocket-png-22-removebg.png`, `error_image.png`, `download.png`, `pl-removebg.png`
- Lottie/Rive animation directories present (but only `favicon.png` placeholders found — actual `.json`/`.riv` files may be obfuscated or embedded in Dart code)
- SQLite DB: `assets/sqlite_db_files/new.db`
- Manifest activities/services hint at: onboarding (illustration assets), home/dashboard (card image), USSD flows, SMS compose screen (`ComposeSmsActivity`), settings/profile (standard Flutter patterns)

**Estimated screens (16-screen map not feasible without Dart source):**
1. Splash / Launch (blank white background via `launch_background.xml`)
2. Onboarding (drone/plane/rocket illustrations)
3. Login / Phone auth (SMS permissions + Firebase Auth)
4. PIN setup (device admin receiver)
5. Home / Dashboard (card-2.jpg, logoBS branding)
6. USSD dialer flow (phan_tech USSD service)
7. Transaction history (SQLite DB)
8. Balance check (USSD response parsing)
9. SMS inbox / compose (`IncomingSmsReceiver`, `ComposeSmsActivity`)
10. Notifications list (awesome_notifications + NotificationListenerService)
11. Settings / Profile (standard Flutter)
12. Error state (`error_image.png`)
13. Download / Update screen (`download.png`)
14. Loading / Skeleton states (Lottie animations expected)
15. Overlay window / Floating UI (`flutter_overlay_window.OverlayService`)
16. Background task management (foreground service)

---

## Feature Inventory (from manifest + assets + permissions)

| Feature | Evidence | Source |
|---------|----------|--------|
| USSD automation | `USSDServiceKT` (AccessibilityService), `USSDForegroundService` | AndroidManifest.xml lines ~90-96, ~130 |
| SMS send/receive/intercept | `IncomingSmsReceiver`, `MmsReceiver`, `HeadlessSmsSendService`, `ComposeSmsActivity`, permissions | AndroidManifest.xml lines ~115-145 |
| Firebase Auth (phone/email) | Firebase components registered | AndroidManifest.xml lines ~170-185 |
| Firestore offline cache | `flutterfirebasemessaginginitprovider`, SQLite DB | AndroidManifest.xml line ~210, assets |
| Push notifications (FCM) | `FlutterFirebaseMessagingService`, `FlutterFirebaseMessagingReceiver` | AndroidManifest.xml lines ~195-205 |
| Local notifications | `awesome_notifications` package, `StatusBarManager` (NotificationListenerService) | AndroidManifest.xml lines ~150-165, assets |
| Foreground service (persistent) | `ForegroundService` (dataSync + specialUse types) | AndroidManifest.xml lines ~100-110 |
| Alarms / scheduled tasks | `AlarmBroadcastReceiver`, `RebootBroadcastReceiver`, `AlarmService` | AndroidManifest.xml lines ~97-103 |
| Boot persistence | `BootReceiver` (BOOT_COMPLETED + MY_PACKAGE_REPLACED) | AndroidManifest.xml lines ~95-99 |
| Device admin / kiosk mode | `MyDeviceAdminReceiver`, `BIND_DEVICE_ADMIN` permission | AndroidManifest.xml line ~112 |
| Deep linking | `bingwa://bingwa.com` intent filter | AndroidManifest.xml line ~85 |
| File picker / open file | `FileProvider` (com.crazecoder.openfile) | AndroidManifest.xml line ~215 |
| App install / update | `InstallFileProvider` (com.zaihui.installplugin) | AndroidManifest.xml line ~212 |
| URL launching | `WebViewActivity` (io.flutter.plugins.urllauncher) | AndroidManifest.xml line ~218 |
| Background isolation | `WatchdogReceiver`, `BackgroundService` (id.flutter.flutter_background_service) | AndroidManifest.xml lines ~220-230 |
| Contact access | READ_CONTACTS, WRITE_CONTACTS permissions | AndroidManifest.xml line ~22 |
| Location access | ACCESS_COARSE_LOCATION permission | AndroidManifest.xml line ~42 |
| Badge / shortcut integration | Multiple launcher badge permissions (Samsung, HTC, Sony, Huawei, OPPO) | AndroidManifest.xml lines ~55-70 |

---

## Mechanics (no Compose/XML — Flutter canvas rendering)

**Keypad:** Not extractable. Flutter renders custom widgets; no XML layout or Jetpack Compose code exists. USSD dialing likely uses the `telephony` Flutter plugin (package `com.shounakmulay.telephony.sms` visible in manifest).

**Tabs / Navigation:** Flutter's `Navigator` + likely `BottomNavigationBar` or custom tab bar (no Material BottomNavigationView XML found). Package `cupertino_icons` and `font_awesome_flutter` suggest icon-based navigation.

**Cards:** `card-2.jpg` asset implies image-backed card UI. No XML card layouts (Flutter draws via `Container` + `BoxDecoration`).

**Countdowns / Timers:** `android_alarm_manager_plus` and `flutter_foreground_task` plugins indicate background timers (e.g., session expiry, USSD timeout).

**Status glyphs:** Material Icons font (`MaterialIcons-Regular.otf`) used for status indicators (check, error, warning icons). Font Awesome brands/solid for additional iconography.

**Motion:** Lottie animations directory exists (`assets/lottie_animations/`) but only placeholder PNGs found — actual `.json` files may be bundled inside the Dart snapshot or obfuscated. Rive animations directory also present (`assets/rive_animations/`).

**Glass / Blur:** No evidence of backdrop blur or frosted glass effects. Flutter would require `ImageFilter.blur` in Dart code (not visible in Java decompilation).

**Spring physics:** Not extractable from resources. Flutter's `AnimationController` + `CurvedAnimation` would handle this in Dart.

---

## Tokens Delta vs docs/inspo (Hybrid v2.5.11)

| Token category | Hybrid (Compose) | Sokoni (Flutter) | Delta |
|----------------|------------------|-------------------|-------|
| **UI toolkit** | Jetpack Compose + Material3 | Flutter + Material 3 (default theme) | Different framework entirely |
| **Brand colors** | `#001fbf` (blue primary), `#009544` (green secondary) in `Color.kt` | No custom brand colors in `colors.xml` — all Material 3 defaults (`#6750a4` primary, `#03dac6` secondary) | Sokoni uses stock M3 palette; branding likely in Flutter Dart code (images/logos only) |
| **Spacing** | Custom 8-value scale in `Spacing.kt`: 2, 4, 8, 12, 16, 20, 24, 32 dp | No custom dimens — all Material 3 defaults (abc_*, m3_*, design_* prefixes) | Sokoni relies on Flutter's default padding constants |
| **Radii** | `GlassCard` shape tokens (Medium, Large, ExtraLarge) | `m3_card_corner_size = 12dp`, `m3_alert_dialog_corner_size = 28dp` (M3 defaults) | No custom glass/elevation tokens |
| **Typography** | `BingwaType` (Type.kt) with custom font families | Roboto Regular only (`Roboto-Regular.ttf` in assets) + Material Icons + Font Awesome | Sokoni uses system default typography |
| **Motion** | `Motion.SPLASH_TOTAL = 1940ms`, spring configs in `Anim.kt` | Not extractable (Flutter animation logic in Dart snapshot) | Cannot compare |
| **Navigation pattern** | Single-activity Compose with `LensTabBar` bottom nav | Single-activity Flutter shell with likely custom tab bar | Different navigation paradigm |
| **State management** | ViewModel + StateFlow (Kotlin) | Likely Provider/Bloc/Riverpod (Flutter — not visible in Java decompilation) | Cannot compare |

---

## Sokoni vs Hybrid vs Ours (12-line diff)

1. **Toolkit:** Hybrid = Compose Native; Sokoni = Flutter cross-platform; Ours = Compose Native (matches Hybrid)
2. **Branding:** Hybrid has custom blue/green tokens; Sokoni uses stock M3 palette; Ours matches Hybrid tokens
3. **Typography:** Hybrid uses custom `BingwaType`; Sokoni uses Roboto only; Ours matches Hybrid
4. **Navigation:** Hybrid uses bottom `LensTabBar`; Sokoni likely uses Flutter tab bar; Ours matches Hybrid
5. **USSD:** Hybrid has U1 engine (Kotlin); Sokoni has phan_tech USSD plugin (separate package); Ours retains U1
6. **SMS:** Hybrid minimal SMS usage; Sokoni heavily integrated (send/receive/intercept/compose); Ours does not touch SMS
7. **Persistence:** Hybrid uses Room/DataStore; Sokoni uses SQLite + Firestore; Ours matches Hybrid
8. **Notifications:** Hybrid uses transient + persistent budget; Sokoni uses awesome_notifications + FCM; Ours matches Hybrid budget
9. **Motion:** Hybrid has defined spring/timing tokens; Sokoni motion in Dart (unextractable); Ours matches Hybrid
10. **Glass effects:** Hybrid has `GlassSpec` tokens; Sokoni has no blur/glass evidence; Ours matches Hybrid
11. **Architecture:** Hybrid = Clean Architecture (domain/infrastructure/presentation); Sokoni = Flutter plugins + Firebase; Ours matches Hybrid
12. **Permissions:** Hybrid minimal (INTERNET, POST_NOTIFICATIONS); Sokoni extensive (SMS, phone, contacts, location, device admin); Ours matches Hybrid minimal set

---

## DO-NOT-COPY Guardrails

- **Engine logic:** The USSD automation service (`com.phan_tech.ussd_advanced.*`) is third-party proprietary code. Do not copy or replicate its accessibility-service-based USSD parsing logic.
- **Socket protocols:** No WebSocket/socket.io evidence found in manifest or resources, but Flutter Dart code may contain real-time connections. Do not reverse-engineer any socket schemas.
- **Database schemas:** `assets/sqlite_db_files/new.db` contains app data schema. Do not extract or replicate table structures.
- **Secrets:** API keys, Firebase project IDs, server endpoints are embedded in Flutter Dart code (compiled snapshot) and/or `google-services.json` (not extracted here). All such values must be treated as **REDACTED**. Do not hardcode any credentials.
- **SMS interception:** The app intercepts incoming SMS (`RECEIVE_SMS`, `READ_SMS`, `WRITE_SMS` permissions + broadcast receivers). This is a privacy-sensitive feature. Do not replicate SMS interception logic.
- **Device admin:** The app requests device administrator privileges (`BIND_DEVICE_ADMIN`). Do not replicate kiosk/MDM functionality.
- **Notification listener:** The app runs a `NotificationListenerService` to read other apps' notifications. Do not replicate this surveillance capability.
- **Flutter-specific code:** All Dart code is compiled into the Flutter engine snapshot and is not recoverable via jadx. Do not attempt to decompile the Dart snapshot or extract proprietary business logic.

---

## Coverage Note

**Verbs that failed / fallback used:**
- `jadx` decompilation produced 54 errors — Kotlin sources were not extracted (jadx requires JDK 17+ for full Kotlin metadata; environment has JDK 17 but jadx still produced Java-only output due to obfuscation/proguard).
- Flutter Dart code is compiled to native ARM machine code inside the `lib/` directory of the APK — **no Dart source code is recoverable** via static analysis tools. All UI mechanics, state management, navigation logic, and business rules are invisible to this recon.
- Lottie/Rive animation files were not found as `.json`/`.riv` — they may be embedded inside the Dart snapshot or obfuscated with non-standard extensions.
- **Fallback:** Recon relies entirely on AndroidManifest.xml (permissions, services, receivers), resource files (colors, dimens, drawables), Flutter asset manifest, and file names. Actual screen layouts, user flows, and interaction patterns cannot be reconstructed without dynamic analysis (running the app) or access to the original Dart source code.

**What this recon can tell you:** The app is a Flutter-based financial/USSD automation tool with heavy SMS integration, Firebase backend, and extensive Android platform permissions. It uses default Material 3 theming with custom branding only in image assets (logos, illustrations). No custom design tokens (spacing, radii, colors, typography, motion) are defined in Android resources — all customization lives in the Flutter Dart layer.

**What this recon cannot tell you:** Screen layouts, navigation flows, color hex codes used in Flutter widgets, spacing values, typography sizes, animation durations, spring physics parameters, glass/blur effects, or any business logic. For that, you would need to run the app and observe it visually, or obtain the original Dart source code.
