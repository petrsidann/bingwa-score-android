# ULTRA session end — handoff

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
