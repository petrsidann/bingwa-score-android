---
name: crash-triage
description: Reproduces an Android crash/ANR, captures logcat and crash reports, and traces to root cause without regressing the U1 USSD engine or E1 balance/dial logic.
when_to_activate: On a crash, ANR, uncaught exception, or repeated crash report from a device/smoke test.
---

# crash-triage

Run this skill to triage a Bingwa Score crash.

Steps:
1. Reproduce on device/emulator; capture logcat around the crash timestamp.
2. Identify the crashing thread and exception type; pull the crash report/stack trace.
3. Trace to root cause; confirm the U1 USSD engine and E1 balance/dial logic are untouched (extend only — never regress).
4. Verify PENDING transactions still display as "Queued".
5. Fix, add a regression test, and run `./gradlew testDebugUnitTest --no-daemon -q`.