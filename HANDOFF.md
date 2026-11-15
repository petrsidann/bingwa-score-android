# HANDOFF — Live Session State

## STEP 0 resume state (Stage 59.3 — definitive InstanT launch reveal)

- **Current state**: Stage 59.3 applied on branch `stage-59.3-definitive-instant-reveal` from origin/main. PHASE 2 CORRECT applied (LaunchActivity.kt rewritten to FILE A contract; themes.xml `Theme.BingwaScore.Launch` windowBackground → `@drawable/launch_window`; new `res/drawable/launch_window.xml`). PHASE 3/4 (build, targeted tests, adb proof) pending.
- **What changed (3 files)**:
  - `app/src/main/java/com/bingwascore/app/ui/screens/LaunchActivity.kt` — FILE A contract: `onSizeChanged` captures box size; `Canvas.drawCircle` true circle (14dp seed dot → screen half-diagonal, CubicBezier(0.3,0,0.2,1)); wordmark inverts violet→lime exactly as the circle's edge crosses it (WM_OFFSET 0.12 / WM_HALF 0.045); `BuildConfig.DEBUG` 's59.3' stamp bottom-right; bar icons flip light once sweep covers 49% of height; reduced-motion/inspection land immediately. ~1.94s choreography in `private object LaunchChoreography` (WORDMARK_IN 420 → DOT_HOLD 300 → REVEAL 620 → END_HOLD 420).
  - `app/src/main/res/values/themes.xml` — `Theme.BingwaScore.Launch` windowBackground now `@drawable/launch_window` (lime field + centred 28dp violet seed dot, so a cold start never shows a blank lime void); `Theme.BingwaScore` / `Theme.BingwaScore.Splash` unchanged.
  - `app/src/main/res/drawable/launch_window.xml` — NEW: layer-list lime field + centred 28dp violet oval (starting window only; the animated reveal itself is a true circle, never a clipped box).
- **Untouched (guard-test safe)**: SplashScreen.kt (Aurora, unrouted, retained for Stage11/43 source guards), both LaunchScreen.kt files, AppNavHost.kt, MainActivity.kt, OnboardingSlides.kt, AndroidManifest.xml, DesignTokens.kt, Motion.kt (SPLASH_TOTAL=1600, NAV_CROSSFADE=200), all tests.
- **Launch flow**: launcher LaunchActivity (lime→violet true-circle reveal) → MainActivity (violet window) → LAUNCH bridge (violet, 350ms) → decideStartDestination → Onboarding / Login / SetupChecklist / Main.
- **Verification**: compileDebugKotlin zero `e:`; assembleDebug + assembleRelease green (mirrors CI build-apk.yml); targeted tests green (StartDestinationTest, ContrastGuardTest, Stage11LaunchCinematicTest, Stage43SplashDurationTest). Full testDebugUnitTest NOT run — pre-existing environmental executor crash; Paparazzi not re-recorded (no golden renders LaunchAnimation).
- **Known follow-up (not this stage)**: AppNavHost LAUNCH route maps `startDestination == null → Routes.MAIN`; a slow cold DataStore read could skip onboarding for a first-launch user. Candidate hardening stage.
- **Git**: branch stage-59.3-definitive-instant-reveal; commit "Stage 59.3: definitive InstanT launch reveal"; PR same title; owner merges. DONE only when hash is on origin/main.

## Rules of Engagement
- Anti-skip law: exactly one stage per session; never self-descope.
- Merge gate: work lands via PR + human merge; owner smokes the PR artifact first.
- First-error loop: read ONLY the first error; max 1 fix cycle per error; else STOP and report verbatim.
- Naming law: commits/branches/PRs use "Stage NN: <human name>" / stage-NN-<human-name>. No UUIDs/machine names.
- DONE definition: commit hash visible on origin/main; final report ends with raw `git log origin/main --oneline -1`.
- Design compliance: docs/DESIGN.md is the anti-slop constitution; tokens only; two themes (Obsidian + Porcelain Dim); glass via GlassSpec only.
- Protected invariants: never regress U1 USSD engine or E1 balance/dial logic (extend only). No machine paths in gradle.properties; no credentials committed.
- Handoff maintenance: ONE live STEP 0 block; older blocks → docs/archive/HANDOFF-history.md.
