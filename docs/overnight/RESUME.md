RESUME OVERNIGHT RUNNER (idempotent). caveman, flash, no thinking; thinking only after 2nd red in a stage. Load ONLY caveman + superpowers:verification-before-completion + superpowers:systematic-debugging.
Read: docs/overnight/QUEUE.md, LOG.md, REPORT.md, HANDOFF.md STEP 0, docs/PHASE1_SPEC.md, docs/PHASE1_SOURCE_NOTES.md, docs/preview/phase1.html.
Verify origin/main green before working (gh run list --limit 3). Merged stages are DONE — never redo.

QUEUE (pending only):
 S71 Manage — spec 7: Customers|Credits subtabs, customer rows -> detail (phone, spend, most bought, purchases, churn) + history, plan cards with CURRENT + d:h:m:s countdown.
 S72 Glass elevation + scaffold: append to PHASE1_SPEC.md section 2 the iOS-27 recipe (dual blur 40+12 RenderEffect API31+ with no-blur fallback, saturation +18%, tint white55/white8, chromatic 1dp gradient edge 70/25/12, specular pair 60/18, shadow ambient+key, refraction arcs interactive-only). Implement in ui/glass/GlassSpec (or new PhaseGlass.kt) as the single source. Add ui/glass/PhaseScaffold.kt: statusBarsPadding, back bar (vector arrow + 20sp bold title + trailing actions), 16dp gutters, bottom padding = lens clearance (82+14+14dp) when tab bar present else navigationBarsPadding+16dp.
 S73 Store/Settings/Community/Profile — spec 8, each wrapped in PhaseScaffold, glass per amended section 2. Adopt scaffold in Home/Transactions/Manage ONLY if it changes insets; never restyle their content.
 S74 Polish — Paparazzi re-record changed Content into docs/gate only; ContrastGuard re-check; zero-deprecation sweep; versionName 1.10.0 versionCode +1; README feature list; HANDOFF archive roll.

PER-STAGE LOOP: branch stage-NN-slug off origin/main -> implement (full-file for named files, surgical elsewhere) -> gates: compileDebugKotlin, assembleDebug+assembleRelease (zero new deprecations), testDebugUnitTest --tests StartDestinationTest --tests ContrastGuardTest (never full suite) -> diff confined to stage files; rail check: no engine U1/E1, no routes, no build files/wrapper/catalog, no secrets, no deleted tests, FROZEN untouched (LensTabBar, OnboardingSlides, PhaseKeypad, Login, PinSetup, SetupChecklist, Dial as merged) -> commit "Stage NN: slug" -> rebase origin/main (conflicts: main wins outside stage files) -> push -u -> gh pr create -> poll CI; red = first error, one fix, max 3 cycles -> merge ONLY if CI success + rail check clean (auto-merge authorized under these rails) -> wait main green; red main = fix branch max 2 cycles else revert PR + STOP.
After each stage: append LOG.md line, rewrite HANDOFF.md STEP 0, mark QUEUE entry done.

STOP (write REPORT.md, idle): queue empty; BLOCKED merge; revert; 3 red cycles; context pressure.
REPORT.md: per-stage table (commit, PR, CI id, status), BLOCKED/REVERTED first-errors verbatim, daytime fix order, raw git log origin/main --oneline -8.
