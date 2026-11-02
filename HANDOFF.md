# HANDOFF — Live Session State

## STEP 0 resume state (Stage 44 shipped; next = Stage 45 design pass)

- **Current state**: Stage 44 shipped (stability + input truth).
  - **COLD-PATH LAW**: Application.onCreate, BootReceiver and WatchdogWorker no longer start the engine directly; they enqueue the EngineStartWorker one-shot, which retries until an Activity is visible (`Result.retry`, not silent success). `EngineService` promotion order unchanged (Stage 38/41).
  - **Login**: PIN cap 4 (5th press = inline "PIN is 4 digits"), phone cap 10 (11th = inline "Phone number is 10 digits"); focus routing + auto-jump kept; no system keyboard.
  - **Signup**: Individual/Business toggle DELETED — one account type AGENT (`AuthConstants.ACCOUNT_TYPE_AGENT`); single "Your name or business name" field; PIN + Confirm PIN keypad-only (4-dot readouts, cap 4, inline mismatch); inline email reason; Create Account disabled with visible reason.
  - **Splash**: retimed to the 1600ms device-law floor (`SPLASH_TOTAL = 1600`); hand-off only after choreography; Dim tagline ink #475569.
  - **Tests**: `Stage44ColdPathBanTest`, `Stage44InputTruthTest`, `Stage44SplashGoldensTest` (0.4/0.9/1.5s × both themes); `Stage43SplashDurationTest` updated to the 1600ms floor / 2.0s budget contract.
- **Next**: Stage 45 design pass — goldens × both themes × viewed; archive older HANDOFF blocks to docs/archive/.

## STEP 0 resume state (Stage 43 shipped; next = FEATURE FREEZE -> full phone walk -> owner tags v2.0.0)

- **Current state**: Stage 43 shipped (aurora snap splash).
  - Aurora snap splash duration <= 1.3s (Motion.SPLASH_TOTAL = 1300ms).
  - 0.0–0.2s: Aurora glow fades in (Obsidian: #0F172A canvas + #2563EB radial glow; Dim: #EAF0F6 canvas + pastel-blue #93C5FD glow).
  - 0.2–0.5s: 'B' monogram snaps in with spring overshoot + micro-ripple ring.
  - 0.5–0.8s: Monogram fills (white ink on Obsidian / #1E293B ink on Dim) + tagline "Your bundle business, automated." fades up.
  - 0.8–1.3s: Whole screen scales 1.0 -> 1.04 + cross-fades to next screen.
  - Goldens recorded and committed in `docs/gate/` for 0.3s, 0.6s, 1.0s x both themes (Obsidian and Porcelain Dim).
  - Test coverage: `Stage43SplashDurationTest`, `Stage43SplashSnapshotTest`, `Stage11LaunchCinematicTest`, `Stage36TraceFixTest`, `SplashChoreographyTest`, `Stage21FirstRunTruthTest` all pass; `:app:assembleDebug` + `:app:testDebugUnitTest` green.
- **Roadmap / Next stages**:
  - **Next**: FEATURE FREEZE -> full phone walk -> owner tags v2.0.0.

## Rules of Engagement

- **Anti-skip law**: Exactly one stage per session. Never skip stages or self-descope acceptance criteria.
- **Merge gate**: Work lands via PR and human merge only.
- **First-error loop & fix-cycle limit**: Read ONLY the first error when red. Max 1 fix cycle per error; if still red, stop and report the blocker immediately. No blind exploration or refactors while red.
- **Naming law**: Every commit, branch, and PR title MUST use standard human stage names: `"Stage NN: <human name>"`. Never UUIDs, task IDs, or machine names.
- **DONE definition**: A task is DONE only when its commit hash is visible on `origin/main`. Final reporting MUST end with the raw output of `git log origin/main --oneline -1`.
- **Design system compliance**: `docs/DESIGN.md` is the anti-slop constitution (exactly two themes: Obsidian and Porcelain Dim; frosted glass sanctioned via GlassSpec tokens; tokens only, no literals).
- **Protected invariants**: Never regress U1 USSD engine or E1 balance/dial logic (extend only). Never put machine paths in `gradle.properties` or commit credentials.
- **Handoff maintenance**: Maintain `HANDOFF.md` as ONE live document containing a single active STEP 0 resume block. Move all older blocks to `docs/archive/HANDOFF-history.md`.
