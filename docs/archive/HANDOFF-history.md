# Historical Handoff Archive

This file archives older handoff blocks from `HANDOFF.md` and `docs/HANDOFF.md` verbatim for historical reference. The current live handoff is maintained at `/HANDOFF.md`.

---

## STEP 0 resume state (2026-10-30, Stage 37 shipped)

- Branch: stage-37-perf (from origin/main), commit pending, pushed to origin/stage-37-perf.
- `:app:compileDebugKotlin` + `:app:compileDebugUnitTestKotlin` + `:app:assembleDebug` green.
- Stage 37 — performance-first startup + cheap splash + ANR watchdog:
  - BingwaScoreApp.onCreate: StrictMode debug thread policy (disk reads/writes/network, penaltyDeath + CrashHandler record); DbNameHolder.loadFrom on Dispatchers.IO via runBlocking; Schedulers/seed/engine start deferred to applicationScope (IO); AnrWatchdog started.
  - RemoteHttpClient: Ktor client built lazily on first use.
  - CrashHandler.latestCrashReport runs on Dispatchers.IO; record/writeAnr helpers added.
  - AnrWatchdog pings main every 1s, dumps main stack to crash file after 3s.
  - Motion.SPLASH_TOTAL 1500ms (cheap splash within 1.5s).
- Tests: SplashChoreographyTest, Stage11LaunchCinematicTest, Stage36TraceFixTest green.

## STEP 0 resume state (2026-10-30, Stage 36 shipped)

- Branch: stage-36-trace-fix (from origin/main), commit a7f4345 "Stage 36: trace-driven ANR/crash fix + three surgical fixes", pushed to origin/stage-36-trace-fix (PR not yet opened — `gh` unavailable in this shell; PR URL: https://github.com/petrsidann/bingwa-score-android/pull/new/stage-36-trace-fix).
- `:app:compileDebugKotlin` + `:app:compileDebugUnitTestKotlin` + `:app:assembleDebug` green.
- Stage 36 — trace-driven ANR/crash fix + three surgical fixes:
  - Root cause fixed: ANR at SignIn on first keystroke / process death while typing phone — per-keystroke handlers ran `filter { it.isDigit() }` loops and cleared errors by writing state during composition/event dispatch. Now O(1) pure `updatePhone`/`updatePin` (no regex, no loops), error clear moved to `LaunchedEffect(snapshotFlow)` off the composition thread, fields `readOnly = true`, `windowSoftInputMode="stateAlwaysHidden|adjustNothing"`, every `LocalSoftwareKeyboardController.hide()` deleted.
  - Splash: grey dot particles + both rectangle curtain boxes deleted; wordmark renders directly on canvas color; monogram stroke + traveling tip + bloom ring + tagline remain; only one `background(BgBlack)` (the surface canvas).
  - Debug reachability: long-press the "Bingwa Score" wordmark on SignIn opens a Crash Report dialog (AlertDialog) showing `CrashHandler.readLatestCrashReport(context)` — reachable pre-auth, crash files persist forever.
  - Tests: new Stage36TraceFixTest (12 tests, all green) — keyboard off, readOnly fields, no hide() calls, O(1) validation, snapshotFlow error clear, sign-in <16ms/frame harness, splash curtain/dots absent, wordmark on canvas, monogram/bloom/tagline remain, regression walk sign-in→type→home→relaunch.
- Regression walk green: Stage31WalkTest, Stage11LaunchCinematicTest, SplashChoreographyTest, Stage21FirstRunTruthTest, U4ThemesTest, ThemeModeTest, Stage22PorcelainDimTest all pass. Stage34GoldensTest (paparazzi) cannot render in this sandbox (documented RegisterNatives/SystemProperties abort) — pre-existing env flakiness, not a regression.

## Rules of engagement (unchanged)
- Surgical edits only. Read only the first error when red.
- Max 3 fix cycles per item; if still red, stop and report the blocker.
- Commit + push each green group; refresh this file at every session end.
- Terse output; first-error-only loop.

## STEP 0 resume state (2026-10-24, Stage 25 shipped)

- Shipped+green: Stages 1–24 + **Stage 25 (nav morph + real back navigation)**. U1 USSD engine + E1 balance/dial protected.
- **Stage 25 — NAV MORPH + REAL BACK NAVIGATION**:
  - **Bottom-Nav Morph**: Shared `SharedNavTab` navigation composable and `VerticalNavRail` docked to `SideDrawerSheet` right edge with staggered ~20ms spring damping animation. Morphing navigation between bottom bar and rail on drawer toggle.
  - **Back Navigation**: `android:enableOnBackInvokedCallback="true"` enabled in `AndroidManifest.xml`. Non-dead-end `BackHandler` in `AppNavHost.kt` closing drawer, dialer sheet, referral view, secondary routes, or non-Home tabs on system back.
  - **Tests**: `Stage25NavTest` added.
- **Stage 24 — FIRST-IMPRESSION OVERHAUL**:
  - **Themes**: deleted ThemeMode.PORCELAIN (LIGHT); exactly two themes remain — OBSIDIAN (DARK) + PORCELAIN_DIM (default PORCELAIN_DIM). Migrated all references, removed porcelain goldens, updated tests.
  - **Home toggle**: sun/moon pill toggle (spring thumb) on Home top bar immediately LEFT of the credits/"days" chip; persists via UserPreferences.themeMode; 200ms surface cross-fade. Dark=moon, Dim=sun.
  - **Splash cinematics** (both themes): monogram stroke-draw with glowing tip + spark particles -> completion bloom ring -> wordmark mask-sweep reveal (not typewriter) -> tagline fade-up -> shared-element handoff (monogram shrinks to toolbar, one clean dissolve); <=1.9s total (Motion.SPLASH_TOTAL=1900); skippable after 1s. Obsidian = dark canvas + blue glow; Dim = dim porcelain + dark-ink monogram + soft blue halo.
  - **Dim vibrancy**: Done/Failed/Queued counter tiles get tinted gradient surfaces (blue/rose/slate) + soft elevation shadows; commission chart gradient fill; no flat dull grey.
  - **Eyes**: goldens for splash (dark + dim porcelain), home (dark + dim porcelain), onboarding pages (dim porcelain); recorded via loop.ps1; agent eyes copied to docs/gate/ (39 PNGs).
- `:app:assembleDebug` + `:app:testDebugUnitTest` green.
- Next group: **U6 snake carousel** -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0 release.

## STEP 0 resume state (2026-10-22, Stage 22 shipped)

- Shipped+green: Stages 1–22 + **Stage 23 (remote wiring + ussd session chain)**. U1 USSD engine + E1 balance/dial protected.
- **Stage 23 — REMOTE WIRING + USSD SESSION CHAIN**:
  - **Network**: Ktor client singleton reading `BASE_URL` from `BuildConfig` (default `http://10.0.2.2:8080`), TLS-ready, 12s timeouts, `Authorization: Bearer <token>` injector backed by `TokenStore` (`EncryptedSharedPreferences`).
  - **Auth**: Sign-up/sign-in handling via `/api/auth/*` routes, token persistence, and offline fallback with `"Offline - local mode"` banner.
  - **USSD Session Chain**: Replaced single-shot dial with multi-hop chain parser (`UssdSessionChain.parse`) splitting codes into root dial + ordered segments. Auto-submits next segment upon response until chain completes/errors. Session logs record every hop (`sent`/`received`/`next`). 12s timeout per hop with 1 retry. Thread-safe `abort()` support. Pure Kotlin intents/accessibility retained.
  - **Tests**: `Stage23WiringUssdTest` added.
- **Stage 22 — PORCELAIN DIM + LAG SWEEP + CHECK-FOR-UPDATES + 1.9.1**:
  - **ThemeMode.PORCELAIN_DIM** ("Porcelain Dim"): a dim porcelain canvas (#C9CED6) with lifted cards (#DBDFE5), near-black ink, and a SOFT brand-blue accent (#2F6AE0) — dimmed lights, never Obsidian-black. Status tints deepened for the dim canvas (Done = brand blue #2563EB, Failed = deep red #C41B1B, Queued neutral #6B7280); CTA paints white ink on the blue chip. Contrast-pinned by Stage22PorcelainDimTest (AA on every dim surface); theme switcher entry added.
  - **Lag sweep**: stable keys on every lazy list (Home/Offers/Transactions), remembered per-row actions via new `ui/components/ScrollPerf.kt rememberAction()`, hoisted + bucketed clock in Home rows (`CLOCK_BUCKET_MILLIS`), remembered derived lists (selected offers, selected statuses). `Stage22LagSweepTest` pins composition-count invariants (stable actions skip, inline actions recompose every row, only the changed row recomposes) + source invariants.
  - **Check for updates**: reads the release manifest at `/updates/latest.json` (bundled mock in `app/src/main/assets`) via `UpdateChecker.check(context)`; Settings row "Check for updates" runs the check and surfaces the result in a dialog (up-to-date / update-available with download).
  - **Version bump**: versionCode 11, versionName "1.9.1".
- **Eyes green**: 3 new Porcelain Dim goldens (Home, Offers, Profile) in Stage19ScreensPreviewTest; recorded via loop.ps1, verifyPaparazziDebug green; agent eyes copied to docs/gate/.
- `:app:assembleDebug` + `:app:testDebugUnitTest` green; Paparazzi verify green.
- Next group: **U6 snake carousel** -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0 release.

---

### Archive from docs/HANDOFF.md

## Where the tree is
- Green groups shipped: `Ultra U2: autopilot 3-state`, `Ultra U3: home/graph/splash right-size`,
  `Ultra U4: themes alive`, `Ultra U5: transactions surgical` (see `git log`).
- Stage 17 (this session) complete: contrast remediation (every light-theme text/micro/secondary token `#9E9E9E` → `#4B5563`, propagated through `Color.kt`, `StatusColors.kt`, `README.md`), stale CI workflow `build.yml` ("Build Android APK") deleted — only `build-apk.yml` ("Build APK") remains, and release candidate `v1.9.0` landed (`versionName 1.9.0`, `versionCode 9`, `APP_VERSION 1.9.0`).
- Next group: U6 (see "Groups still open" below).
- `docs/HANDOFF.md` is the live handoff; refresh it at every session end.
- `freebuff_jdk.json` is gitignored; never commit it.

## Build environment (sandbox only)
- AGP 8.5.2 requires JDK 17. The only good JDK 17 here is:
  `/c/Users/User/jdk17/jdk-17.0.20.1+1`
- **Repo stays clean**: `gradle.properties` does NOT pin `org.gradle.java.home`.
- **Toolchain preference**: `settings.gradle.kts` registers
  `org.gradle.toolchains.foojay-resolver-convention` 0.8.0 and
  `app/build.gradle.kts` has `kotlin { jvmToolchain(17) }`.
- **Standing build command in this sandbox** (environment supplies JAVA_HOME; no
  machine path in the repo):
  ```bash
  ./gradlew --stop 2>/dev/null
  rm -rf .gradle/daemon 2>/dev/null
  export JAVA_HOME="/c/Users/User/jdk17/jdk-17.0.20.1+1"
  ./gradlew :app:compileDebugKotlin :app:testDebugUnitTest :app:assembleDebug --no-daemon -q
  ```

## Shipped: U2 — Autopilot 3-state
- `EngineState` (RUNNING / PAUSED / STOPPED) persists in DataStore; `fromValue`
  defaults safely to RUNNING.
- Home pill + sheet render the live state. Pill is a 600ms **hold → PAUSE**; the
  sheet offers Pause / Resume / Stop / Start per state.
- Paused or stopped engine **accepts incoming M-Pesa** (row saved PENDING, no
  dial) so the money is never lost while the engine is off.
- Home transaction rows show a **"Paused" badge** on queued rows while paused.
- RESUME and START both replay the queued backlog in **arrival order**
  (`resumeFromPaused` sorts by `createdAt`), then the engine accepts live
  traffic again.
- STOP → Home transactions empty-state reads
  **"Autopilot stopped — history lives in Transactions."**; incoming is still
  logged (no dial).
- Tiles count in all three states (pending tile counts PENDING/PROCESSING/
  SCHEDULED regardless of engine state).
- JVM tests covering this: `EngineStateTest`, `EngineStateTraceTest`
  (paused → 2 incoming → resume order), and `ui/home/HomeScreenEmptyStateTest`.

## Shipped: U3 — Home/Graph/Splash right-size
- Splash wordmark is always the FULL "Bingwa Score", per-letter alpha, never a
  substring (`wordmarkAlphas` + `U3RightSizeTest` length guard).
- Home activity rows are a fixed 44dp (~30% shorter); Transactions rows are 45dp
  with a 36dp tinted status avatar.
- Balance card is now one medium row: labels + values left, eye + refresh right.
- Commission spline is clamped at/above the zero baseline (points AND control
  points), so a quiet day can never be drawn as negative commission.
- The day-letter tooltip is a **coaster**: it springs up BELOW the tapped letter's
  column instead of covering the curve.
- The today-bubble rolls at 00:00 (`weekdayIndexMonFirst` + `millisUntilNextMidnight`).
- UI says **"Queued"** for PENDING everywhere (`StatusColors.label`,
  `TransactionFilter.PENDING`); the stored enum value is unchanged.
- The Transactions filter row is driven by `transactionFilterChips`, pinned to
  exactly one chip per filter (no stray separator dot).

## Shipped: U4 — themes alive
- **Grayscale** keeps DISTINCT desaturated status tints: Done **silver-blue**
  (`StatusDone`), Failed **charcoal-red** (`StatusFailedTint`), Queued neutral
  (`StatusQueued`). Dots are drawn at **60% saturation** (`GRAYSCALE_DOT_SATURATION`,
  applied once in `StatusDot`).
- **Grayscale CTA** is a solid **#E0E0E0** chip with **black** text (`CtaFill`/`CtaInk`),
  and the secondary action outlines at **#9E9E9E** (`SecondaryOutline`).
- Contrast audit: every switch uses the one shared `statusSwitchColors()` palette
  (Settings switches no longer define their own); `U4ThemesTest` asserts the
  disabled pair clears AA in all three modes and the Grayscale chip clears 10:1.
- **Silica**: blur **32dp** (`Silica.CARD_BLUR`), **18%** white glass tint, gradient
  hairlines, orbs at **8% alpha** with a **140dp** soft edge (`ORB_BLUR`), and a
  **frosted nav rail** that blurs with the rest of the glass.
- **Obsidian**: disabled-state sweep only (no palette churn).
- **Zero orange/amber**: no orange/amber literals remain and `U4ThemesTest` guards
  the token palette against them.

## Shipped: U5 — transactions surgical
- **One action-rule source**: `ui/transactions/TxActionRules.kt` (`rulesFor`,
  `rulesForSelection`).
  - **SUCCESSFUL disables both Retry and Complete** in the focus sheet; the
    greyed chip answers a tap with a **reject haptic** instead of a silent no-op.
  - **Retry** is offered only for **FAILED / FAILED_ALREADY_RECOMMENDED / PENDING
    / PROCESSING / SCHEDULED**; **Complete** for anything not SUCCESSFUL.
  - The batch bar asks `rulesForSelection`: a selection containing a SUCCESSFUL
    sale cannot batch-retry.
- **One name formatter**: `util/CustomerName.kt` → `formatCustomerName()` renders
  "DENNIS K WACHIRA" as **"Dennis K. Wachira"** (middle tokens become initials)
  on every surface — Home row, Home tile, Transactions row, focus-sheet title,
  and the delete snackbar. CSV export deliberately keeps raw values.
- **Search morph**: title fade and bar expansion share
  `Motion.MORPH_SPRING_MILLIS = 220` (inside the 200–260ms band); the bar is an
  overlay in the outer `Box`, so opening/closing search never reflows the list.
- Chip row regression (exactly one chip per filter) confirmed in `U3RightSizeTest`
  and asserted again in `U5TransactionsTest`.
- JVM tests: `U5TransactionsTest` (14).

## Stage 17 — contrast remediation & 1.9.0 release (DONE)
- `SemanticGrey`/`TextGrey` (light) → `Color(0xFF4B5563)` (text/micro/secondary, ≥4.5:1 on `#F2F2F7`).
- `StatusQueued` → light `#4B5563` (Porcelain), light-charcoal `#9CA3AF` (Obsidian) so labels stay 3:1 in both themes.
- `DisabledInk` #9E9E9E literal removed; `TextGrey`/`SemanticGrey` opaque `#4B5563`.
- `U8QaSweepTest` (both themes) green: 0 failures; no `#9E9E9E` family remains.
- Deleted stale CI workflow `build.yml` ("Build Android APK"); only `build-apk.yml` ("Build APK") remains.
- Release candidate `v1.9.0` landed: `versionName 1.9.0`, `versionCode 9`, `APP_VERSION 1.9.0` in `app/build.gradle.kts`.

## Groups still open (ULTRA)
- U6 → U8: the original ULTRA prompt that defines these groups is not in this repo
  and is not in the agent's context. Do not invent acceptance criteria — ask the
  user for the U6–U8 spec, then commit + push each green group and refresh this
  file.

## Track-only (no surface exists yet)
- Audit A6 "Editor / credit accept": the repo has no dedicated Editor/credit
  accept screen. The closest credit surface is the Home credits bubble + sheet
  and `OffersViewModel.saveOfferSettings`. Do not fake a surface that does not
  exist; revisit when one lands.
