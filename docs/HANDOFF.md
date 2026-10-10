# ULTRA session end — handoff

## Where the tree is
- Last commit: `46be194 Ultra U1: USSD session truth` (green, pushed).
- Current working change: U2 recovery — `HomeScreen.kt`, `HomeChrome.kt`, `HomeViewModel.kt`, `UserPreferences.kt`, `TransactionPipeline.kt`, `EngineStateTest.kt`, `EngineStateTraceTest.kt`, `settings.gradle.kts`, `app/build.gradle.kts`, `docs/HANDOFF.md`, `gradle.properties`.
- `docs/HANDOFF.md` is the live handoff; refresh it at every session end.
- No `freebuff_jdk.json` in the repo — it is ignored.

## Build environment (sandbox only)
- AGP 8.5.2 requires JDK 17. This sandbox only has a good JDK 17 at:
  `/c/Users/User/jdk17/jdk-17.0.20.1+1`
- **Repo stays clean**: `gradle.properties` does NOT pin `org.gradle.java.home`.
- **Toolchain preference**: `settings.gradle.kts` registers
  `org.gradle.toolchains.foojay-resolver-convention` 0.8.0 and
  `app/build.gradle.kts` has `kotlin { jvmToolchain(17) }`.
- **FALLBACK build command when the toolchain cannot be provisioned in budget:**
  ```bash
  ./gradlew --stop 2>/dev/null
  rm -rf .gradle/daemon 2>/dev/null
  export JAVA_HOME="/c/Users/User/jdk17/jdk-17.0.20.1+1"
  ./gradlew :app:compileDebugKotlin :app:assembleDebug --no-daemon -q
  ```
- The same JDK 17 path is the only machine path used in this sandbox. It is never
  written into `gradle.properties`.

## Current group
- U2: Autopilot 3-state. EngineState persisted; pill + sheet show state; 600ms
  hold → PAUSE; incoming SMS while paused → QUEUED tx with "Paused" badge,
  unprocessed; RESUME processes backlog in arrival order then live; STOP →
  Home tx section empty-state "Autopilot stopped — history lives in Transactions";
  START processes backlog; tiles count in all states; unit test paused→2
  incoming→resume order.

## Acceptance criteria we are working toward
- EngineState round-trips through DataStore and renders on Home pill/sheet.
- Pause is a 600ms hold on the pill; sheet offers Resume/Pause/Stop/Start.
- Paused engine records incoming payments as queued/pending rows, not dialed.
- Resume replays backlog in arrival order then processes live traffic.
- Stopped engine shows the Home transactions empty-state with the prescribed copy.
- Tiles count in all engine states.
- JVM comprehension test covers paused→2 incoming→resume order.

## Rules of engagement
- Surgical edits only. Read only the first error when red.
- Max 3 fix cycles per item; if still red, stop and report the blocker.
- Prefer editing existing files over creating new ones.
- If a build needs a machine path, keep it out of `gradle.properties`; rely on
  the environment or the toolchain, and record the exact fallback command in
  `docs/HANDOFF.md` only.
- Never commit `freebuff_jdk.json`.
- Commit+push each green group; refresh `docs/HANDOFF.md` at every session end.
- Terse output; first-error-only loop.
