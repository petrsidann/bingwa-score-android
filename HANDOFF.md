# HANDOFF — Live Session State

## STEP 0 resume state (Stage 41 shipped)

- **Current state**: Stage 41 shipped (engine foreground crash fix).
  - Synchronous `startForeground()` at top of `onCreate()` and idempotently in `onStartCommand()` in `EngineService`.
  - Zero-delay notification (`FOREGROUND_SERVICE_IMMEDIATE`).
  - Background start caller gate: avoids starting foreground service from background on API 31+, deferring work safely to WorkManager.
  - Test coverage: `Stage41ForegroundCrashTest`, `Stage38ForegroundOrderingTest` passing.
- **Roadmap / Next stages**:
  - **Stage 42**: Subscribe wiring (server / billing / plan subscription flows).
  - **Stage 43**: Payments + receipts.
  - **Post-Stage 43**: Feature freeze + v2.0.0 tag.

## Rules of Engagement

- **Anti-skip law**: Exactly one stage per session. Never skip stages or self-descope acceptance criteria.
- **Merge gate**: Work lands via PR and human merge only.
- **First-error loop & fix-cycle limit**: Read ONLY the first error when red. Max 1 fix cycle per error; if still red, stop and report the blocker immediately. No blind exploration or refactors while red.
- **Naming law**: Every commit, branch, and PR title MUST use standard human stage names: `"Stage NN: <human name>"`. Never UUIDs, task IDs, or machine names.
- **DONE definition**: A task is DONE only when its commit hash is visible on `origin/main`. Final reporting MUST end with the raw output of `git log origin/main --oneline -1`.
- **Design system compliance**: `docs/DESIGN.md` is the anti-slop constitution (exactly two themes: Obsidian and Porcelain Dim; frosted glass sanctioned via GlassSpec tokens; tokens only, no literals).
- **Protected invariants**: Never regress U1 USSD engine or E1 balance/dial logic (extend only). Never put machine paths in `gradle.properties` or commit credentials.
- **Handoff maintenance**: Maintain `HANDOFF.md` as ONE live document containing a single active STEP 0 resume block. Move all older blocks to `docs/archive/HANDOFF-history.md`.
