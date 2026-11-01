# HANDOFF — Live Session State

## STEP 0 resume state (Stage 42 shipped; next = Stage 43 aurora snap splash)

- **Current state**: Stage 42 shipped (login focus routing).
  - Fixed sign-in keypad routing bug where phone field accepted nothing.
  - Fields maintain readOnly=true and focusable=true, with FocusRequesters and onClick handlers.
  - Focused field shows 2dp brand-blue border (Obsidian #2563EB, Dim #2F6AE0).
  - Keypad digits/backspace route to the currently focused field via shared state (`focusedField: MutableState<LoginField>`).
  - Default focus = Phone; after 10th phone digit, focus auto-jumps to PIN via LaunchedEffect(snapshotFlow(phone.length)).
  - Soft keyboard remains hidden via windowSoftInputMode="stateAlwaysHidden|adjustNothing".
  - Test coverage: `Stage42LoginFocusRoutingTest`, `Stage36TraceFixTest`, `Stage27AuthGateTest` passing; assembleDebug green.
- **Roadmap / Next stages**:
  - **Stage 43**: Aurora snap splash.
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
