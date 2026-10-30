# ULTRA session end — handoff

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

## Rules of engagement
- Surgical edits only. Read only the first error when red.
- Max 3 fix cycles per item; if still red, stop and report the blocker.
- Prefer editing existing files over creating new ones.
- If a build needs a machine path, keep it out of `gradle.properties`; rely on the environment or the toolchain and record the exact command here only.
- Commit + push each green group; refresh this file at every session end.
- Terse output; first-error-only loop.
