# HANDOFF — Live Session State

## STEP 0 resume state (Overnight Phase 1 completion pipeline, S68–S73)

- **Current state**: Autonomous overnight run started from origin/main (6c506b9, Stage 67 merged). Queue lives in `docs/overnight/QUEUE.md`. Log in `docs/overnight/LOG.md`. Report in `docs/overnight/REPORT.md`. Each stage branches from `origin/main`, implements one spec section, gates on build + targeted tests, and opens a PR. Merge authorized tonight if CI passes and diff stays inside allowed files.
- **Stages queued**: S68 Home (spec 4), S69 Transactions/Stats (spec 5), S70 Dial (spec 6), S71 Manage (spec 7), S72 Store/Settings/Community/Profile (spec 8), S73 Polish (Paparazzi/deprecation/version).
- **Global rails**: U1/E1 engine untouched; routes unchanged; glass only via `ui/glass/`; tokens only via `DesignTokens`; no emojis; no hardcoded hex/dp/sp in screens; no version bumps except S73; no new dependencies; no MCPs; no skills beyond caveman + verification-before-completion + systematic-debugging.
- **Reference**: `docs/PHASE1_SPEC.md` is the binding contract. `docs/preview/phase1.html` missing from workspace; rely on spec text. FROZEN screens remain untouched: LensTabBar, OnboardingSlides, PhaseKeypad, Login, PinSetup, SetupChecklist.
- **Verification gate**: `assembleDebug` + `assembleRelease` zero deprecations; targeted tests `StartDestinationTest` and `ContrastGuardTest` green. Full `testDebugUnitTest` NOT run — pre-existing environmental executor crash (Paparazzi bridge / Robolectric SDK 34 / native executor).

## Rules of Engagement
- Anti-skip law: exactly one stage per session; never self-descope.
- Merge gate: work lands via PR + human merge; owner smokes the PR artifact first.
- First-error loop: read ONLY the first error; max 1 fix cycle per error; else STOP and report verbatim.
- Naming law: commits/branches/PRs use "Stage NN: <human name>" / stage-NN-<human-name>. No UUIDs/machine names.
- DONE definition: commit hash visible on origin/main; final report ends with raw `git log origin/main --oneline -1`.
- Design compliance: docs/DESIGN.md is the anti-slop constitution; tokens only; two themes (Obsidian + Porcelain Dim); glass via GlassSpec only.
- Protected invariants: never regress U1 USSD engine or E1 balance/dial logic (extend only). No machine paths in gradle.properties; no credentials committed.
- Handoff maintenance: ONE live STEP 0 block; older blocks → docs/archive/HANDOFF-history.md.
