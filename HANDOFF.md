# HANDOFF — Live Session State

## STEP 0 resume state (Stage 59 — InstanT-style circular reveal launch)

- **Current state**: Stage 59 applied on branch `stage-59-instant-launch-reveal` from origin/main (Stage 58-ARCH). PR open, awaiting owner merge.
- **What changed (3 files)**:
  - `ui/screens/LaunchActivity.kt` — rewritten. The launch reveal is now a TRUE CIRCLE via `Canvas.drawCircle` (radius animates 14dp → screen half-diagonal), replacing the old clipped-box approach that produced an oval and a 1200ms dead beat. Choreography (~1.94s) lives in `private object LaunchChoreography`: wordmark spring-in (0–420ms) → 28dp violet seed-dot pop + hold (420–900ms) → circular sweep (900–1520ms, CubicBezier(0.3,0,0.2,1)) → lime wordmark reborn on violet (~1330–1490ms) → end hold (1520–1940ms) → handoff. Full-bleed via enableEdgeToEdge; bar icons flip light at 85% sweep. Reduced-motion (ANIMATOR_DURATION_SCALE=0) and LocalInspectionMode render the landed frame and hand off early.
  - `res/values/themes.xml` — `Theme.BingwaScore.Splash` (MainActivity's manifest theme) windowBackground/status/nav now `@color/launch_violet_window` with light bars OFF, so MainActivity's starting window continues the violet instead of flashing lime. `Theme.BingwaScore.Launch` (LaunchActivity) stays lime. `Theme.BingwaScore` unchanged.
  - `HANDOFF.md` — this block; prior STEP 0 archived to docs/archive/HANDOFF-history.md.
- **Untouched (guard-test safe)**: SplashScreen.kt (Aurora, unrouted, retained for Stage11/43 source guards), both LaunchScreen.kt files, AppNavHost.kt, MainActivity.kt, OnboardingSlides.kt, AndroidManifest.xml, DesignTokens.kt, Motion.kt (SPLASH_TOTAL=1600, NAV_CROSSFADE=200), all tests.
- **Launch flow**: launcher LaunchActivity (lime→violet reveal) → MainActivity (violet window) → LAUNCH bridge (violet, 350ms) → decideStartDestination → Onboarding / Login / SetupChecklist / Main.
- **Verification**: compileDebugKotlin zero `e:`; assembleDebug + assembleRelease green (mirrors CI build-apk.yml); targeted tests green (StartDestinationTest, ContrastGuardTest, Stage11LaunchCinematicTest, Stage43SplashDurationTest). Full testDebugUnitTest NOT run — pre-existing environmental executor crash; Paparazzi not re-recorded (no golden renders LaunchAnimation).
- **Known follow-up (not this stage)**: AppNavHost LAUNCH route maps `startDestination == null → Routes.MAIN`; a slow cold DataStore read could skip onboarding for a first-launch user. Candidate hardening stage.
- **Git**: branch stage-59-instant-launch-reveal; commit "Stage 59: InstanT-style circular reveal launch"; PR same title; owner merges. DONE only when hash is on origin/main.

## Rules of Engagement
- Anti-skip law: exactly one stage per session; never self-descope.
- Merge gate: work lands via PR + human merge; owner smokes the PR artifact first.
- First-error loop: read ONLY the first error; max 1 fix cycle per error; else STOP and report verbatim.
- Naming law: commits/branches/PRs use "Stage NN: <human name>" / stage-NN-<human-name>. No UUIDs/machine names.
- DONE definition: commit hash visible on origin/main; final report ends with raw `git log origin/main --oneline -1`.
- Design compliance: docs/DESIGN.md is the anti-slop constitution; tokens only; two themes (Obsidian + Porcelain Dim); glass via GlassSpec only.
- Protected invariants: never regress U1 USSD engine or E1 balance/dial logic (extend only). No machine paths in gradle.properties; no credentials committed.
- Handoff maintenance: ONE live STEP 0 block; older blocks → docs/archive/HANDOFF-history.md.
