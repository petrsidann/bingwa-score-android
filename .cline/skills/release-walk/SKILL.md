---
name: release-walk
description: Walks the release checklist: debug build, smoke test both themes, verify merge gate artifacts (owner-smoked PR), confirm commit hash on origin/main, then tag and push.
when_to_activate: Before opening a release PR or once a stage is green and ready to merge.
---

# release-walk

Run this skill to walk a stage to DONE.

Steps:
1. Build: `./gradlew :app:assembleDebug --no-daemon -q`.
2. Smoke test the changed screens in both Obsidian and Porcelain Dim themes.
3. Verify the merge gate: owner has smoked the PR artifact; PR title/branch/commit follow "Stage NN: <human name>" naming.
4. Run unit tests: `./gradlew testDebugUnitTest --no-daemon -q`.
5. Push at every green; confirm the commit hash is visible on `origin/main`.
6. DONE only when the commit hash is visible on origin/main.