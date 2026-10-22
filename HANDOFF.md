# ULTRA session end — handoff

## STEP 0 resume state (2026-10-22, Stage 22 shipped)

- Shipped+green: Stages 1–21 + **Stage 22 (porcelain dim + lag sweep + check-for-updates + 1.9.1)**. U1 USSD engine + E1 balance/dial protected.
- **Stage 22 — PORCELAIN DIM + LAG SWEEP + CHECK-FOR-UPDATES + 1.9.1**:
  - **ThemeMode.PORCELAIN_DIM** ("Porcelain Dim"): a dim porcelain canvas (#C9CED6) with lifted cards (#DBDFE5), near-black ink, and a SOFT brand-blue accent (#2F6AE0) — dimmed lights, never Obsidian-black. Status tints deepened for the dim canvas (Done = brand blue #2563EB, Failed = deep red #C41B1B, Queued neutral #6B7280); CTA paints white ink on the blue chip. Contrast-pinned by Stage22PorcelainDimTest (AA on every dim surface); theme switcher entry added.
  - **Lag sweep**: stable keys on every lazy list (Home/Offers/Transactions), remembered per-row actions via new `ui/components/ScrollPerf.kt rememberAction()`, hoisted + bucketed clock in Home rows (`CLOCK_BUCKET_MILLIS`), remembered derived lists (selected offers, selected statuses). `Stage22LagSweepTest` pins composition-count invariants (stable actions skip, inline actions recompose every row, only the changed row recomposes) + source invariants.
  - **Check for updates**: reads the release manifest at `/updates/latest.json` (bundled mock in `app/src/main/assets`) via `UpdateChecker.check(context)`; Settings row "Check for updates" runs the check and surfaces the result in a dialog (up-to-date / update-available with download).
  - **Version bump**: versionCode 11, versionName "1.9.1".
- **Eyes green**: 3 new Porcelain Dim goldens (Home, Offers, Profile) in Stage19ScreensPreviewTest; recorded via loop.ps1, verifyPaparazziDebug green; agent eyes copied to docs/gate/.
- `:app:assembleDebug` + `:app:testDebugUnitTest` (396 tests) green; Paparazzi verify green.
- Next group: **U6 snake carousel** -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0 release.


## STEP 0 resume state (2026-10-22, Stage 21 shipped)

- Shipped+green: Stages 1–20 + **Stage 21 (first-run + splash truth)**. U1 USSD engine + E1 balance/dial protected.
- **Stage 21 — the first run tells the truth**: the onboarding is a REAL `HorizontalPager` (`PageSize.Fill`, a 24dp
  page gap, a fixed-height card, a per-page icon/title/body column, inactive pages fading with the page offset and a
  dot pill that slides with the pager). The card copy is measured at its natural size and **scaled to fit**, so a
  short screen shows the same page, smaller — never a cut-off title, never smashed slides. Skip / Back / Next all
  clear 44dp. Landscape is a first-class citizen and has its own golden suite.
- **The wordmark was BROKEN, now fixed**: `wordmarkAlphas` capped the stagger at `length - 1`, so the last letter
  never rose — the splash shipped **"Bingwa Scor"**. The cap is `length` now, and the string lives in ONE place
  (`BrandWordmark.TEXT` = "Bingwa Score"), rendered by the splash and the onboarding alike.
  `Stage21FirstRunTruthTest` asserts the STRING (never pixels) in BOTH themes.
- **The splash has theme parity**: stroke-ignite monogram, a traveling blue tip, an ignition band that rides the
  STROKE (the old rectangle sweep left a visible box edge on the canvas) and a soft blue radial halo on dim
  porcelain, with a dark-ink monogram. The halo is always on (a resting light); the pulse rides on top of it. The
  ink is a decision, not a lookup: `splashInk(dark)` = white / #16181D.
- **The palette landed one frame late** (a `SideEffect` in the theme): the first frame of a light screen was painted
  with the PREVIOUS theme — the light splash came up dark for one frame, the light onboarding wore a dark canvas
  under a white card. `BingwaScoreTheme` now installs the palette BEFORE the content composes.
- **Eyes green**: 14 new goldens (onboarding pages 1–3 + splash, both themes, portrait AND landscape) in
  `Stage21FirstRunPreviewTest` + `Stage21FirstRunLandscapePreviewTest`; every PNG was viewed and accepted. The old
  Stage 19 onboarding/splash goldens moved to the new suite (one owner per surface). `:app:assembleDebug` +
  `:app:testDebugUnitTest` (371 tests) green; Paparazzi verify green.
- Known drift (pre-existing, not Stage 21): the 4 Home goldens re-record differently at another hour of the day —
  `Greeting` reads `System.currentTimeMillis()`. The My Plan + first-run goldens are clock-anchored and
  byte-stable. Known pre-existing: `CtaInk` is mode-aware, so the blue CTA label in Porcelain is dark ink (4.3:1
  on #007AFF — clears large-text AA). It is a global design-system token, so Stage 21 left it alone.
- Next group: **U6 snake carousel** -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0 release.


## STEP 0 resume state (2026-10-22, Stage 20 shipped)

- Shipped+green: Stages 1–19.7 + **Stage 20 (my plan meta-grade)**. U1 USSD engine + E1 balance/dial protected.
- **Landed on `origin/main`** (branch `stage-20-my-plan-meta-grade`): this commit carries Stage 20 **and** the
  Stage 19.7 preview suite, which `origin/main` had only half of (the Paparazzi plugin was wired, but the
  preview test + goldens never reached main — they are here now).
- **Stage 20 — My Plan paywall in the Meta One grammar** (structure, not colours): `MyPlanScreenContent` is now a
  flat paywall — an opaque **aurora band** on top (blue family only: `AuroraDeep/Mid/Edge` + `auroraBrush()`),
  the **STEADY | BULK ENGINE** pill, a swipeable `HorizontalPager` (4 pages per family) and a dot indicator.
  Every page is the same grammar: large title, truth subtitle (pulls/duration), price line, exactly **three**
  benefit rows (icon + bold title + grey desc, derived only from plan facts), the **"Explore all benefits"**
  expander (plan/allowance/window/payment facts), the legal microcopy strip, and the full-width blue CTA
  **"Activate <Plan> - Ksh <price>"**. The ACTIVE page swaps the CTA for the **ACTIVE badge + live countdown**
  (`PlanCountdown`; ticks once a second, frozen under inspection so goldens are stable). The **MY monogram**
  sits in the band. **No blur, no glass, no iOS material on this screen, ever** — the M-Pesa confirm sheet is
  gone: the purchase runs in place (Idle → Paying → receipt on the page).
- **PRICE LAW** (pinned by the new `PlanMatrixTest`): STEADY — Starter unlimited/1 day/Ksh 20 · Basic 1,000/Ksh 25 ·
  Noob 2,500/Ksh 55 · Pro 5,000/Ksh 110. BULK ENGINE — Small unlimited/3 days/Ksh 60 · Medium unlimited/7 days/Ksh 140 ·
  Mega unlimited/1 month/Ksh 600 · Ultimate unlimited/3 months/Ksh 1,800. A plan page may only quote its own
  numbers (the test enforces it). `PlanOffer` keeps the old constructor shape (`bulk` = family), so the
  existing Stage 13 contracts still hold.
- **Eyes green**: 4 MyPlan goldens (STEADY + BULK ENGINE × both themes) in `Stage19ScreensPreviewTest`;
  every PNG was viewed and the page was tightened until nothing clips on the small screen.
  `:app:assembleDebug` + `:app:testDebugUnitTest` (349 tests) green. New: `PlanMatrixTest` (price law),
  `Stage20MyPlanPaywallTest` (grammar + no-glass guards). `MaterialSmokeTest` no longer expects My Plan to
  own a modal backdrop (it has no modal any more).
- **Known drift (pre-existing, not Stage 20)**: the 4 Home goldens re-record differently at another hour of
  the day — `Greeting` reads `System.currentTimeMillis()`, so "Habari za asubuhi/jioni" flips. The My Plan
  goldens are clock-anchored and byte-stable.
- Next group: **U6 snake carousel** -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0 release.


## STEP 0 resume state (2026-10-21, Stage 19.7 shipped)

- Shipped+green: Stages 1–19 + **Stage 19.7 (preview-pure screens + eyes green)**. U1 USSD engine + E1 balance/dial protected.
- **Stage 19.7 — preview-pure screens**: every screen in the screen map is now a PURE `XScreenContent(state, callbacks)`
  composable with a thin `XScreen` wrapper that hoists the platform bits — Home, Offers, Dialer, Transactions,
  Profile, Onboarding, Splash, My Plan. No `hiltViewModel`, no Activity, no `LifecycleOwner`, no
  `rememberLauncherForActivityResult` inside a Content. Callbacks are plain lambdas (empty by default), so a
  snapshot renders the real surface with no ViewModel in sight. `Haptics.Disabled` is the no-op haptics for previews.
- **Eyes green**: Paparazzi **1.3.5** (root plugin + `app.cash.paparazzi` in the app module) renders all 8 screens
  × both themes (18 goldens) from fake state — `Stage19ScreensPreviewTest`. Goldens live in
  `app/src/test/snapshots/images/`, the agent eyes are copied to `docs/gate/` by `loop.ps1`.
  Enter animations settle in inspection mode (`LocalInspectionMode`), so a snapshot shows the landed screen,
  not a half-faded one. `:app:assembleDebug` + `:app:testDebugUnitTest` (328 tests) green.
- Wordmark is exactly "Bingwa Score" (splash + onboarding); the Home Autopilot pill renders in BOTH themes;
  layout is identical row-for-row across themes (verified by pixel audit of the recorded PNGs).
- Next group: **U6 snake carousel** -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0 release.


## STEP 0 resume state (2026-10-20, Stage 19 green)

- Shipped+green: Stages 1–18 (see git log). Three Stage tests + assembleDebug green at rescue commit `0db8469`.
- **Stage 19 — nav + home restructure**: RESOLVED. Replaced `ModalNavigationDrawer` edge-pull with `SideDrawerSheet` spring side-sheet (iosMaterial background, <300ms spring via `Spring.StiffnessHigh` + `Motion.DAMPING`). Hamburger is the LEFT CAP of the floating pill (`RoundedCornerShape(28.dp)` + `iosMaterial`, identical both themes). Drawer gains "My Score" entry at `MY_SCORE_DRAWER_INDEX`. Edge-pull demoted to secondary — hamburger tap is primary open gesture. Home already has zero score UI (no `MyScoreCard` on Home). `MaterialSmokeTest` drawer backdrop-region assertion preserved. `:app:compileDebugKotlin`, `:app:assembleDebug`, `:app:testDebugUnitTest` (310 tests) all green. APK installed and verified on emulator-5554 (docs/gate/home.png, docs/gate/drawer.png).
- Next group: **U6 snake carousel**.


## STEP 0 resume state (2026-10-12, Stage 16 shipped)
- Shipped+green: Stages 1-16. U1 USSD engine + E1 balance/dial protected.
- **Stage 16 — mesh v2 offline P2P**: new pure core `domain/mesh/` — `MeshCore` (roles Main/Receiver, chain ≤4, routing table amount→Receiver, offline queue, PaymentRequest/StatusUpdate, flush) + `MeshTransport` interface with `LoopbackTransport` (channel-buffered in-memory pair), `BleGattTransport` (6-digit pairing), `WifiDirectTransport` (P2P socket stubs) + `MeshNode` runtime (onPayment routes+queues-on-down; Receiver auto-processes + syncs status back; flushQueue on reconnect). `MeshScreen`/`MeshViewModel` rebuilt: role picker, linked devices with 3-dot signal, routing editor, test-pulse that round-trips a real Main→Receiver over the loopback bus.
- Tests: new `Stage16MeshTest` (10 tests, green — full loopback lifecycle + queue-visible-when-down + wiring). `:app:assembleDebug` green.
- Next group: **Stage 17 (Profile club-grade + Redeem + 1.9.0 release)**.




## STEP 0 resume state (2026-10-12, Stage 12 shipped)
- Shipped+green: Stages 1-12 (see git log, "Stage N: ..." commits). U1 USSD engine + E1 balance/dial protected.
- **Stage 12 — home guards + diplomatics**: Autopilot pill tap NEVER pauses (guard `AutopilotGuard`:
  `TAP_PAUSES=false`, `HOLD_MILLIS=600`); hold fills a progress ring (`Animatable` 0..1, LinearEasing)
  driven by a `LaunchedEffect` (the `awaitEachGesture` scope is suspension-restricted, so the gesture
  only toggles `holding`/reads `committedHold`); completion fires `haptics.press()` + `onPause()`
  exactly once; early release is a tap and a tap only opens the sheet. Credits bubble now shows
  plan state via `PlanState.remainingLabel` (pulls count / "N days" / earned-credit fallback).
  New screens: **My Plan** (drawer 15, Stage 13 expands the matrix) and **Diplomatics** (drawer 16,
  pin-one-language + session/day cadence; pinned beats rotation; `Cadence.fromValue` falls back).
- Tests: new `Stage12HomeGuardsTest` (14 tests, green). `:app:assembleDebug` green.
- Known pre-existing failures (also fail at adfe26d WITHOUT Stage 12): `U8QaSweepTest`
  `statusLabelsClearAaOnCanvasInEveryTheme` + `textTokensClearAaInEveryTheme` — LIGHT-mode AA
  contrast (2.86:1, 2.92:1 vs 3:1). Not a Stage 12 regression; fix in Stage 17 QA sweep.
- Next group: **Stage 13 (My Plan: M-Y monogram, Starter/Basic/Noob/Pro + bulk Small/Medium/Mega/Ultimate,
  confirm sheet + simulated M-Pesa, plan matrix test, expiry worker)** -> Stage 14 Customers book
  -> Stage 15 Self-Renewal/My Score -> Stage 16 Mesh v2 -> Stage 17 Profile/Redeem/Release 1.9.0.

## STEP 0 resume state (2026-10-12, Stage 11 shipped)
- Shipped+green: Stages 1-11 (see git log, "Stage N: ..." commits). U1 USSD engine + E1 balance/dial protected.
- **Stage 11 — launch cinematic**: splash PathMeasure stroke now draws with a glowing traveling tip
  (`drawTravelingTip`), fires a shockwave ring + specular sweep at full trim, the FULL "Bingwa Score"
  wordmark rises on spring stagger (`settle` scale/rise), tagline breathes one cycle
  (`taglineBreath`), and the monogram shrinks into the login logo (shared-element exit,
  `exitShrink.animateTo(1f, tween(200))`) before `onFinish`.
- **Transition gap killed**: NavHost declares `enter/exit/popEnter/popExit` transitions =
  200ms crossfade on `Motion.NAV_CROSSFADE` (new token). New `HomePreWarmViewModel` warms
  `liveTransactions.first()` during the splash so Home's first Room snapshot is cached pre-handoff.
- Tests: new `Stage11LaunchCinematicTest` (10 tests: tip, ring+sweep, full-wordmark regression,
  spring letters, tagline breath, exit shrink order, 200ms crossfade, pre-warm-before-MAIN,
  2s budget). Stage11 + SplashChoreography = 13 tests green; `:app:assembleDebug` green.
- Next group: **Stage 12 (Home guards/Diplomatics)** -> Stage 13 My Plan -> Stage 14 Customers book
  -> Stage 15 Self-Renewal/My Score -> Stage 16 Mesh v2 -> Stage 17 Profile/Redeem/Release 1.9.0.

## STEP 0 resume state (2026-10-10)
- Shipped+green: U2, U3, U4, U5 (see git log). U1 USSD engine + E1 balance/dial protected.
- Next group: **U6 snake carousel** -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0.
- This sandbox: JDK 17 at /usr/lib/jvm/java-17-openjdk-amd64 (env JAVA_HOME); no remote configured here — pushes land on the local `main` branch ref (origin-less sandbox).
- Build command used in this sandbox:
  `./gradlew :app:assembleDebug --no-daemon -q` (+ named test via `:app:testDebugUnitTest --tests ...`)

## Where the tree is
- Green groups shipped: `Ultra U2: autopilot 3-state`, `Ultra U3: home/graph/splash right-size`,
  `Ultra U4: themes alive`, `Ultra U5: transactions surgical` (see `git log`).
- Verified on this tree: `:app:compileDebugKotlin` green, full
  `:app:testDebugUnitTest` green (177 tests), `:app:assembleDebug` green with a
  fresh APK at `app/build/outputs/apk/debug/app-debug.apk`.
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

## Groups still open (ULTRA)
- **U6 → U8**: the original ULTRA prompt that defines these groups is **not in the
  repo** (only the U1/U2-era text survives in git) and is not in the agent's
  context. Do not invent acceptance criteria — ask the user for the U6–U8 spec,
  then commit + push each green group and refresh this file.

## Track-only (no surface exists yet)
- Audit A6 "Editor / credit accept": the repo has no dedicated Editor/credit
  accept screen. The closest credit surface is the Home credits bubble + sheet
  and `OffersViewModel.saveOfferSettings`. Do not fake a surface that does not
  exist; revisit when one lands.

## Rules of engagement
- Surgical edits only. Read only the first error when red.
- Max 3 fix cycles per item; if still red, stop and report the blocker.
- Prefer editing existing files over creating new ones.
- If a build needs a machine path, keep it out of `gradle.properties`; rely on
  the environment or the toolchain and record the exact command here only.
- Never commit `freebuff_jdk.json`.
- Commit + push each green group; refresh this file at every session end.
- Terse output; first-error-only loop.
