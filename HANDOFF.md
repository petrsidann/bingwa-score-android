# HANDOFF — Live Session State

## STEP 0 resume state (v2.0.0 ready to tag)

- **Current state**: v2.0.0 ready for release tagging. Full 12-point phone walk completed; release-walk skill activated and merge gate smoked.
  - **COLD-PATH LAW**: Application.onCreate, BootReceiver and WatchdogWorker no longer start the engine directly; they enqueue the EngineStartWorker one-shot, which retries until an Activity is visible (`Result.retry`, not silent success). `EngineService` promotion order unchanged (Stage 38/41).
  - **Login**: PIN cap 4 (5th press = inline "PIN is 4 digits"), phone cap 10 (11th = inline "Phone number is 10 digits"); focus routing + auto-jump kept; no system keyboard.
  - **Signup**: Individual/Business toggle DELETED — one account type AGENT (`AuthConstants.ACCOUNT_TYPE_AGENT`); single "Your name or business name" field; PIN + Confirm PIN keypad-only (4-dot readouts, cap 4, inline mismatch); inline email reason; Create Account disabled with visible reason.
  - **Splash**: retimed to the 1600ms device-law floor (`SPLASH_TOTAL = 1600`); hand-off only after choreography; Dim tagline ink #475569.
  - **Tests**: `Stage44ColdPathBanTest`, `Stage44InputTruthTest`, `Stage44SplashGoldensTest` (0.4/0.9/1.5s × both themes); all phone walk goldens passed for both Obsidian and Porcelain Dim themes.
- **Next**: v2.0.0 tagging and release preparation.

## Rules of Engagement

- **Anti-skip law**: Exactly one stage per session. Never skip stages or self-descope acceptance criteria.
- **Merge gate**: Work lands via PR and human merge only.
- **First-error loop & fix-cycle limit**: Read ONLY the first error when red. Max 1 fix cycle per error; if still red, stop and report the blocker immediately. No blind exploration or refactors while red.
- **Naming law**: Every commit, branch, and PR title MUST use standard human stage names: `"Stage NN: <human name>"`. Never UUIDs, task IDs, or machine names.
- **DONE definition**: A task is DONE only when its commit hash is visible on `origin/main`. Final reporting MUST end with the raw output of `git log origin/main --oneline -1`.
- **Design system compliance**: `docs/DESIGN.md` is the anti-slop constitution (exactly two themes: Obsidian and Porcelain Dim; frosted glass sanctioned via GlassSpec tokens; tokens only, no literals).
- **Protected invariants**: Never regress U1 USSD engine or E1 balance/dial logic (extend only). Never put machine paths in `gradle.properties` or commit credentials.
- **Handoff maintenance**: Maintain `HANDOFF.md` as ONE live document containing a single active STEP 0 resume block. Move all older blocks to `docs/archive/HANDOFF-history.md`.
