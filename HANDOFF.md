# HANDOFF — Live Session State

## STEP 0 resume state (Stage 59.7 — TRUE InstanT launch: dot born from NOTHING, fast-pop + resist-bounce + spread, branch stage-59.7-born-from-nothing from origin/main)

- **Current state**: Stage 59.7 applied on branch `stage-59.7-born-from-nothing` from origin/main (Stage 59.6, aecbee9 merge). PHASE 1 FILE A + FILE B byte-for-byte replaced; PHASE 2 read-back verify GREEN (`Animatable(0f)`, `1.28f`, `0.92f`, `addOval`, `s59.7` all present in LaunchActivity.kt; `addCircle` + `Animatable(1f)` absent; `launch_window.xml` has no `oval`). PHASE 3 BUILD SUCCESSFUL (`./gradlew assembleDebug assembleRelease --no-daemon`); targeted tests green (StartDestinationTest, ContrastGuardTest, Stage11LaunchCinematicTest, Stage43SplashDurationTest). PHASE 4: no adb device attached — owner must install `app/build/outputs/apk/debug/app-debug.apk`, open app, record launch. PHASE 5: commit + push pending.
- **What changed (2 files)**:
  - `app/src/main/java/com/bingwascore/app/ui/screens/LaunchActivity.kt` — FILE A: dot BORN FROM NOTHING (`Animatable(0f)`; keyframes 0 -> 1.28 -> 0.92 -> 1 over POP 360ms = fast expand, resist/contract, settle); `DOT_RADIUS_DP = 16f`; `s59.7` debug stamp bottom-right; starting window PLAIN LIME via FILE B so no pre-shown dot, no blink, no oval, no void-with-dot; lime wordmark clipped to the same `CircleRevealShape` (`addOval`) so the inversion rides the edge letter-by-letter; TRUE circle spreads to full-bleed.
  - `app/src/main/res/drawable/launch_window.xml` — FILE B: layer-list single lime item `@color/launch_lime`; the 28dp violet oval dot removed (dot born in Compose only).
- **Untouched (guard-test safe)**: themes.xml, SplashScreen.kt, both LaunchScreen.kt, AppNavHost.kt, MainActivity.kt, AndroidManifest.xml, DesignTokens.kt, Motion.kt, all tests.
- **Verification**: PHASE 1/2 GREEN. PHASE 3 GREEN (build + targeted tests). Full `testDebugUnitTest` NOT run — pre-existing environmental executor crash (Paparazzi bridge / Robolectric SDK 34 / native executor). PHASE 4 pending (device or owner manual install).
- **Expected motion**: lime + violet wordmark with NO dot at first; dot POPS from nothing (fast expand), RESISTS (contracts) and settles (the bounce), holds a beat, then ONE perfect circle spreads to full-bleed carrying the lime inversion letter-by-letter; full violet + lime wordmark; slides. 's59.7' stamp bottom-right (debug). No pre-shown dot, no blink, no oval, no void-with-dot.
- **Git**: branch stage-59.7-born-from-nothing; commit "Stage 59.7: InstanT dot born-from-nothing, pop+resist-bounce+spread"; push origin stage-59.7-born-from-nothing; open PR same title; owner merges. DONE only when hash is on origin/main.

## Rules of Engagement
- Anti-skip law: exactly one stage per session; never self-descope.
- Merge gate: work lands via PR + human merge; owner smokes the PR artifact first.
- First-error loop: read ONLY the first error; max 1 fix cycle per error; else STOP and report verbatim.
- Naming law: commits/branches/PRs use "Stage NN: <human name>" / stage-NN-<human-name>. No UUIDs/machine names.
- DONE definition: commit hash visible on origin/main; final report ends with raw `git log origin/main --oneline -1`.
- Design compliance: docs/DESIGN.md is the anti-slop constitution; tokens only; two themes (Obsidian + Porcelain Dim); glass via GlassSpec only.
- Protected invariants: never regress U1 USSD engine or E1 balance/dial logic (extend only). No machine paths in gradle.properties; no credentials committed.
- Handoff maintenance: ONE live STEP 0 block; older blocks → docs/archive/HANDOFF-history.md.
