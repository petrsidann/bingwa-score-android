# Bingwa Score — Cline Protocol Rules

## Anti-Skip (one outcome per stage)
- Exactly one stage per session. Never skip stages, batch multiple stages, or self-descope requirements.
- Address every item specified for the stage.
- Each stage produces exactly one verifiable outcome.

## Push at every green
- Push at every green. A stage is not complete until its commit hash is visible on origin/main.

## Naming law (mandatory)
- Commit format: "Stage NN: <human name>"
- Branch format: stage-NN-<human-name>
- PR title format: "Stage NN: <human name>"
- Never use UUIDs, task IDs, or machine-generated gibberish in commits, branches, or PR titles.

## Merge gate
- All changes land via a Pull Request and human merge.
- MERGE GATE = owner smokes PR artifact first.
- DONE definition: commit hash visible on origin/main.