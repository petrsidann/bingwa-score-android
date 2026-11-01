# AGENT PROTOCOL (all AI agents MUST follow)

## 1. RESUME & ANTI-SKIP LAW
- **STEP 0**: Always begin by inspecting git log and handoff: `git log --oneline -5` + `git status --short` + read `HANDOFF.md` top.
- **Anti-skip (mandatory)**: Exactly one stage per session. Never skip stages, batch multiple stages, or self-descope requirements. Address every item specified for the stage.

## 2. BUILD COMMAND
- Build command for this environment:
  ```bash
  ./gradlew :app:assembleDebug --no-daemon -q
  ```
  Or for running unit tests:
  ```bash
  ./gradlew testDebugUnitTest --no-daemon -q
  ```
- Repo stays clean: never add machine paths or `org.gradle.java.home` to `gradle.properties`.

## 3. RED LOOP-BREAKER & SURGICAL EDITS
- Read ONLY the first error when tests or builds are red.
- **One fix-cycle limit**: Maximum 1 fix attempt per error. If still failing/red after 1 attempt, STOP and report the blocker immediately with verbatim error output. No endless retry loops, no refactors, no blind exploration.

## 4. DESIGN SYSTEM & REFERENCE REPOS
- **Design constitution**: `docs/DESIGN.md` is the anti-slop reference for all UI work.
- **Two themes only**: Obsidian (`ThemeMode.DARK`) and Porcelain Dim (`ThemeMode.PORCELAIN_DIM`, default). No third mode (Grayscale and Silica are retired).
- **Frosted glass**: Sanctioned exclusively via `GlassSpec` tokens within `ui/glass/` (nav bars and sheets).
- **Tokens only**: Use design tokens from `ui/theme/Color.kt` and `ui/theme/Type.kt` only; never hardcode color or typography literals.
- **Reference / design inspiration**: Clean, modern frosted-glass Android apps; inspect `docs/DESIGN.md` for complete token and motion invariants.

## 5. INVARIANTS & GUARDRAILS
- Never regress or replace the U1 USSD engine or E1 balance/dial logic (extend only).
- Notification budget: 1 persistent state notification (`EngineService` foreground) + 3 transient event types.
- PENDING transactions must always display as "Queued".
- Never expose private keys, credentials, or machine paths in repo or commits.

## 6. NAMING LAW (mandatory)
- Every commit, branch, and pull request title MUST use clean human stage naming so the Git/Actions log reads as a production release log:
  - Commit format: `"Stage NN: <human name>"` (e.g., `"Stage 41: engine foreground crash fix"`, `"Stage 41.5: repo docs hygiene"`).
  - Branch format: `stage-NN-<human-name>` (e.g., `stage-41.5-repo-docs-hygiene`).
  - PR title format: `"Stage NN: <human name>"`.
- NEVER use UUIDs, task IDs, or machine-generated gibberish in commit messages, branches, or PR titles.

## 7. MERGE GATE & DONE DEFINITION (law)
- **Merge gate**: All changes must land via a Pull Request and human merge.
- **DONE definition (mandatory)**: A stage/task is DONE ONLY when its commit hash is visible on `origin/main`.
- Every final turn report MUST end with the raw output of:
  ```bash
  git log origin/main --oneline -1
  ```
- If push or merge failed, the report must say `UNPUSHED` and state the reason. No exceptions: no task is complete without the `origin/main` receipt.
