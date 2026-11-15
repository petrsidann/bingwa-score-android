# HANDOFF — Live Session State

## STEP 0 resume state (Stage 59.6 — FINAL InstanT launch: appear + bounce + spread, ZERO blink, branch stage-59.6-final-instant-bounce from origin/main)

- **Current state**: Stage 59.6 applied on branch `stage-59.6-final-instant-bounce` from origin/main (Stage 59.5, 837b25f). PHASE 2 read-back verify GREEN: `Animatable`, `addOval`, `1.16f`, `s59.6` all present; `addCircle` + `phase < 1 -> 0f` absent (zero matches). PHASE 3: build pending (`./gradlew assembleDebug assembleRelease --no-daemon`); targeted tests (StartDestinationTest, ContrastGuardTest, Stage11LaunchCinematicTest, Stage43SplashDurationTest) pending. PHASE 4: no adb device detected — owner must install `app/build/outputs/apk/debug/app-debug.apk`, open app, record launch. PHASE 5: commit + push pending.
- **What changed (1 file)**:
  - `app/src/main/java/com/bingwascore/app/ui/screens/LaunchActivity.kt` — FILE A byte-for-byte replacement: dot present from frame 0 (radius = dotPx * dotScale, dotScale Animatable 1 -> 1.16 -> 1, NEVER 0); one bounce settle overshoot then true circle sweep to full-bleed carrying lime inversion letter-by-letter; `BuildConfig.DEBUG` 's59.6' stamp bottom-right. themes.xml, launch_window.xml, SplashScreen.kt, both LaunchScreen.kt, AppNavHost.kt, MainActivity.kt, AndroidManifest.xml, DesignTokens.kt, Motion.kt, all tests untouched.
- **Verification**: PHASE 2 GREEN. PHASE 3/4 pending build + (device or owner manual install).
- **Expected motion**: lime + violet dot present from FIRST frame (no void, no appear/disappear/reappear); dot gives ONE bounce (settle overshoot) while violet wordmark springs in; dot holds; ONE perfect circle sweeps to full-bleed carrying lime inversion letter-by-letter; full violet + lime wordmark; then slides. 's59.6' stamp bottom-right (debug). Any blink/oval/void = wrong APK.
- **Git**: branch stage-59.6-final-instant-bounce; commit "Stage 59.6: final InstanT appear+bounce+spread, zero blink"; push origin stage-59.6-final-instant-bounce; open PR same title; owner merges. DONE only when hash is on origin/main.

## Rules of Engagement
- Anti-skip law: exactly one stage per session; never self-descope.
- Merge gate: work lands via PR + human merge; owner smokes the PR artifact first.
- First-error loop: read ONLY the first error; max 1 fix cycle per error; else STOP and report verbatim.
- Naming law: commits/branches/PRs use "Stage NN: <human name>" / stage-NN-<human-name>. No UUIDs/machine names.
- DONE definition: commit hash visible on origin/main; final report ends with raw `git log origin/main --oneline -1`.
- Design compliance: docs/DESIGN.md is the anti-slop constitution; tokens only; two themes (Obsidian + Porcelain Dim); glass via GlassSpec only.
- Protected invariants: never regress U1 USSD engine or E1 balance/dial logic (extend only). No machine paths in gradle.properties; no credentials committed.
- Handoff maintenance: ONE live STEP 0 block; older blocks → docs/archive/HANDOFF-history.md.
