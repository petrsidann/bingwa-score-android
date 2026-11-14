# AGENT PROTOCOL (all AI agents MUST follow)

## 1. RESUME & ANTI-SKIP LAW
- **STEP 0**: Always begin by inspecting git log and handoff: `git log --oneline -5` + `git status --short` + read `HANDOFF.md` top.
- **Anti-skip (mandatory)**: Exactly one stage per session. Never skip stages, batch multiple stages, or self-descope requirements. Address every item specified for the stage.
- **Code-applier discipline**: When the owner supplies exact file contents, apply them byte-for-byte. Do not improvise, rename, reformat, add dependencies, refactor, or explore unrelated files. Full-file replacements only.

## 2. BUILD COMMAND
- Build (mirrors CI build-apk.yml):
  ```bash
  ./gradlew assembleDebug assembleRelease --no-daemon
  ```
- Targeted unit tests (preferred gate):
  ```bash
  ./gradlew testDebugUnitTest --no-daemon --tests "com.bingwascore.app.<TestClass>"
  ```
- Repo stays clean: never add machine paths or `org.gradle.java.home` to `gradle.properties`.

## 3. RED LOOP-BREAKER & SURGICAL EDITS
- Read ONLY the first error when tests or builds are red.
- **One fix-cycle limit**: Maximum 1 fix attempt per error. If still failing/red after 1 attempt, STOP and report the blocker immediately with verbatim error output. No endless retry loops, no refactors, no blind exploration.

## 4. DESIGN SYSTEM
- **Design constitution**: `docs/DESIGN.md` (v4) is the anti-slop reference for all UI work. Run the `design-pass` skill before any UI change.
- **Two themes only**: Obsidian (ThemeMode.DARK) and Porcelain Dim (ThemeMode.PORCELAIN_DIM, default). No third mode.
- **Tokens only**: canonical source is `ui/theme/DesignTokens.kt` (Role/Launch/Motion/Glass/Spacing/Typography); type via `BingwaType` (Type.kt). Color.kt/StatusColors.kt are legacy shims. Never hardcode colour/typography literals.
- **Frosted glass**: sanctioned exclusively via GlassSpec tokens within ui/glass/ (nav bars, sheets, dialogs). Never on cards.
- **Circles**: Canvas.drawCircle with animated radius; never a CircleShape-clipped box.

## 5. INVARIANTS & GUARDRAILS
- Never regress or replace the U1 USSD engine or E1 balance/dial logic (extend only).
- Notification budget: 1 persistent state notification (EngineService foreground) + 3 transient event types.
- PENDING transactions must always display as "Queued".
- Never expose private keys, credentials, or machine paths in repo or commits.

## 6. NAMING LAW (mandatory)
- Commit: "Stage NN: <human name>". Branch: stage-NN-<human-name>. PR title: "Stage NN: <human name>".
- NEVER use UUIDs, task IDs, or machine-generated gibberish.

## 7. MERGE GATE & DONE DEFINITION (law)
- All changes land via a Pull Request and human merge; owner smokes the PR artifact first.
- DONE ONLY when the commit hash is visible on origin/main.
- Every final report MUST end with the raw output of `git log origin/main --oneline -1`.
- If push or merge failed, report `UNPUSHED` + reason.

## 8. KNOWN ENVIRONMENTAL ISSUES (do not chase)
- The FULL `testDebugUnitTest` suite can crash the Gradle test executor on this machine (Paparazzi bridge / Robolectric SDK 34 / native executor). This is PRE-EXISTING and environmental. Gate on TARGETED tests + assembleDebug/assembleRelease instead. Do not "fix" the executor.
- Paparazzi golden recording may stall (daemon CPU flatline). Do not block a stage on re-recording goldens unless the stage explicitly adds a new golden.

## 9. LAUNCH ARCHITECTURE (Stage 59)
- Launcher = ui/screens/LaunchActivity (lime -> violet true-circle reveal, ~1.94s) -> MainActivity (violet window) -> LAUNCH bridge (350ms) -> decideStartDestination -> Onboarding/Login/SetupChecklist/Main.
- The Aurora ui/screens/SplashScreen.kt is UNROUTED, retained only for Stage11/43 source-guard tests. Do not restore or delete it. Do not change Motion.SPLASH_TOTAL or Motion.NAV_CROSSFADE.

## 10. SKILLS
- Load ONLY the named skill file (see .cline/skills/SKILLS-INDEX.md). design-pass before UI; crash-triage on crashes/ANRs; release-walk before a release PR.
