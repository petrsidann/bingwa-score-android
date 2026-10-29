# AGENT PROTOCOL (all AI agents MUST follow)

RESUME: STEP 0 = git log --oneline -5 + git status --short + read HANDOFF.md top. Resume at first missing "Ultra U<n>".
BUILD (only way): $env:JAVA_HOME='C:\Users\User\.jdks\jdk17.0.20_10'; ./gradlew :app:assembleDebug --no-daemon -q
RED LOOP-BREAKER: read ONLY first error; max 2 fix attempts per error; still red => commit "WIP red checkpoint", write error verbatim into HANDOFF.md, STOP + report. No retries, no refactors, no exploration.
GREEN: run only the named test, then commit "Ultra U<n>.<k>: <what>" + push IMMEDIATELY. Max 1 item uncommitted. Refresh HANDOFF.md top after every commit.
GUARDRAILS: no orange/amber; MyPlan glass is now sanctioned, opaque-aurora law retired; frosted glass per GlassSpec tokens; brand blue #2563EB family; never regress U1 USSD engine or E1 balance/dial (extend only); notification budget = 1 state notification + 3 event types; PENDING displays as "Queued"; never machine paths in gradle.properties; never secrets/tokens in repo or prompts.
OUTPUT: terse, max 8 lines per group.
REMAINING ROADMAP: U6 snake carousel -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0 release.
DESIGN: docs/DESIGN.md is the anti-slop constitution; every future stage complies (tokens only, no literals, goldens x both themes).
NAMING (mandatory): every commit, branch and PR title uses human stage names so the Actions list reads like a production log:
"Stage 6: dial snake carousel", "Stage 7: credits + pass + updates", "Stage 8: QA + 1.8.0 release".
NEVER uuid/task-id/machine names in commits, branches or PRs. Rename or delete any that exist.
DONE DEFINITION (law): a task is DONE only when its commit hash is visible on origin/main. Every final report must END with the raw output of: git log origin/main --oneline -1. If the push failed, the report must say UNPUSHED and why. No exceptions, no "committed" without the origin receipt.
