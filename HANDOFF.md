# ULTRA session end — handoff

## STEP 0 resume state (2026-10-24, Stage 25 shipped)

- Shipped+green: Stages 1–24 + **Stage 25 (nav morph + real back navigation)**. U1 USSD engine + E1 balance/dial protected.
- **Stage 25 — NAV MORPH + REAL BACK NAVIGATION**:
  - **Bottom-Nav Morph**: Shared `SharedNavTab` navigation composable and `VerticalNavRail` docked to `SideDrawerSheet` right edge with staggered ~20ms spring damping animation. Morphing navigation between bottom bar and rail on drawer toggle.
  - **Back Navigation**: `android:enableOnBackInvokedCallback="true"` enabled in `AndroidManifest.xml`. Non-dead-end `BackHandler` in `AppNavHost.kt` closing drawer, dialer sheet, referral view, secondary routes, or non-Home tabs on system back.
  - **Tests**: `Stage25NavTest` added.
- **Stage 24 — FIRST-IMPRESSION OVERHAUL**:
  - **Themes**: deleted ThemeMode.PORCELAIN (LIGHT); exactly two themes remain — OBSIDIAN (DARK) + PORCELAIN_DIM (default PORCELAIN_DIM). Migrated all references, removed porcelain goldens, updated tests.
  - **Home toggle**: sun/moon pill toggle (spring thumb) on Home top bar immediately LEFT of the credits/"days" chip; persists via UserPreferences.themeMode; 200ms surface cross-fade. Dark=moon, Dim=sun.
  - **Splash cinematics** (both themes): monogram stroke-draw with glowing tip + spark particles -> completion bloom ring -> wordmark mask-sweep reveal (not typewriter) -> tagline fade-up -> shared-element handoff (monogram shrinks to toolbar, one clean dissolve); <=1.9s total (Motion.SPLASH_TOTAL=1900); skippable after 1s. Obsidian = dark canvas + blue glow; Dim = dim porcelain + dark-ink monogram + soft blue halo.
  - **Dim vibrancy**: Done/Failed/Queued counter tiles get tinted gradient surfaces (blue/rose/slate) + soft elevation shadows; commission chart gradient fill; no flat dull grey.
  - **Eyes**: goldens for splash (dark + dim porcelain), home (dark + dim porcelain), onboarding pages (dim porcelain); recorded via loop.ps1; agent eyes copied to docs/gate/ (39 PNGs).
- `:app:assembleDebug` + `:app:testDebugUnitTest` green.
- Next group: **U6 snake carousel** -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0 release.

## STEP 0 resume state (2026-10-22, Stage 22 shipped)

- Shipped+green: Stages 1–22 + **Stage 23 (remote wiring + ussd session chain)**. U1 USSD engine + E1 balance/dial protected.
- **Stage 23 — REMOTE WIRING + USSD SESSION CHAIN**:
  - **Network**: Ktor client singleton reading `BASE_URL` from `BuildConfig` (default `http://10.0.2.2:8080`), TLS-ready, 12s timeouts, `Authorization: Bearer <token>` injector backed by `TokenStore` (`EncryptedSharedPreferences`).
  - **Auth**: Sign-up/sign-in handling via `/api/auth/*` routes, token persistence, and offline fallback with `"Offline - local mode"` banner.
  - **USSD Session Chain**: Replaced single-shot dial with multi-hop chain parser (`UssdSessionChain.parse`) splitting codes into root dial + ordered segments. Auto-submits next segment upon response until chain completes/errors. Session logs record every hop (`sent`/`received`/`next`). 12s timeout per hop with 1 retry. Thread-safe `abort()` support. Pure Kotlin intents/accessibility retained.
  - **Tests**: `Stage23WiringUssdTest` added.
- **Stage 22 — PORCELAIN DIM + LAG SWEEP + CHECK-FOR-UPDATES + 1.9.1**:
  - **ThemeMode.PORCELAIN_DIM** ("Porcelain Dim"): a dim porcelain canvas (#C9CED6) with lifted cards (#DBDFE5), near-black ink, and a SOFT brand-blue accent (#2F6AE0) — dimmed lights, never Obsidian-black. Status tints deepened for the dim canvas (Done = brand blue #2563EB, Failed = deep red #C41B1B, Queued neutral #6B7280); CTA paints white ink on the blue chip. Contrast-pinned by Stage22PorcelainDimTest (AA on every dim surface); theme switcher entry added.
  - **Lag sweep**: stable keys on every lazy list (Home/Offers/Transactions), remembered per-row actions via new `ui/components/ScrollPerf.kt rememberAction()`, hoisted + bucketed clock in Home rows (`CLOCK_BUCKET_MILLIS`), remembered derived lists (selected offers, selected statuses). `Stage22LagSweepTest` pins composition-count invariants (stable actions skip, inline actions recompose every row, only the changed row recomposes) + source invariants.
  - **Check for updates**: reads the release manifest at `/updates/latest.json` (bundled mock in `app/src/main/assets`) via `UpdateChecker.check(context)`; Settings row "Check for updates" runs the check and surfaces the result in a dialog (up-to-date / update-available with download).
  - **Version bump**: versionCode 11, versionName "1.9.1".
- **Eyes green**: 3 new Porcelain Dim goldens (Home, Offers, Profile) in Stage19ScreensPreviewTest; recorded via loop.ps1, verifyPaparazziDebug green; agent eyes copied to docs/gate/.
- `:app:assembleDebug` + `:app:testDebugUnitTest` green; Paparazzi verify green.
- Next group: **U6 snake carousel** -> U7.1 credits+pass -> U7.2 real updates -> U8 QA + 1.8.0 release.

## Rules of engagement
- Surgical edits only. Read only the first error when red.
- Max 3 fix cycles per item; if still red, stop and report the blocker.
- Prefer editing existing files over creating new ones.
- If a build needs a machine path, keep it out of `gradle.properties`; rely on the environment or the toolchain and record the exact command here only.
- Commit + push each green group; refresh this file at every session end.
- Terse output; first-error-only loop.
