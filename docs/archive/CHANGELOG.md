# Changelog

## PRODUCTION LOG — stage numbering (Stages 1–8 predate the rename)

| Stage | Historical commit | Title |
|-------|-------------------|-------|
| 1 | `46be194` | Ultra U1: USSD session truth |
| 2 | `6947a7b` | Ultra U2: autopilot 3-state |
| 3 | `fa201ac` | Ultra U3: home/graph/splash right-size |
| 4 | `576adaa` | Ultra U4: themes alive |
| 5 | `eec8cdd` | Ultra U5: transactions surgical |
| 6 | `662cae0` | Ultra U6.1: snake carousel logic + onboarding UI + tests |
| 7 | `737a919` | Ultra U7.1: credits + pass ladder logic with tests |
| 8 | `6ef1164` | Stage 8: QA + 1.8.0 release |
| 9 | `9af4319` | Stage 9: dial truth round 2 |
| 10 | `ffd09a3` | Stage 10: iOS design system |
| 11 | `adfe26d` | Stage 11: launch cinematic |

## 1.8.0 — ULTRA U6–U8 (2026-10-10)

### U6 — Snake carousel onboarding
- Three-slide onboarding carousel with clamped paging (never wraps) and
  per-slide title/body copy (`SnakeCarousel`, `U6SnakeCarouselTest`).

### U7 — Credits, pass ladder + real updates
- A credit is exactly one SUCCESSFUL transaction; failed/queued/scheduled rows
  never mint credits. Monotonic tier ladder; pass purchase can never drive the
  balance negative (`CreditsPass`, `U7CreditsPassTest`).
- Update checker wired to real release metadata.

### U8 — QA sweep + release
- Token-level contrast audit across all three themes (Obsidian / Grayscale /
  Silica): text tokens, status tints, CTA pair and disabled pair all clear AA
  (`U8QaSweepTest`).
- Truncation guards (single-line ellipsized customer names), shared
  `EmptyState` coverage check for every list screen, and "Queued" wording
  regression locked in every theme.
- versionName 1.8.0 / versionCode 8; tests, `assembleDebug` and
  `assembleRelease` green.

## 1.6.0 — Polish P1–P6 (2026-10-05)

### Engine reality
- Balance is **only** ever read from `*144#` (silent `sendUssdRequest`, main
  looper, default-subscription fallback, one retry). Manual balance entry deleted.
  Failure says one sentence: "Balance unavailable - check SIM/permissions".
- Balance refreshes on every foreground + every 30 min (`BalanceWorker`), behind a
  themed phone-access prompt.
- `UssdAutomationService` falls back to the **phone app** (`ACTION_CALL` with an
  encoded USSD) when the platform refuses a silent dial, and persists the exact
  Safaricom reply so the dialer can show "Dial successful/failed" plus the
  operator's own wording.
- Quick Dial is a real destination: leaving it (tab or back) always dismisses it.
- One snackbar in the app: a dark bubble (Raised, hairline, white text, blue action).

### Home
- Compact single-row status tiles (~40% shorter) with lit status dots and 12%
  status washes; dots fade over 300 ms and tick when a sale completes live.
- Autopilot is a pill with a radar glyph: tap opens the sheet, stopping needs a
  600 ms hold **and** a confirmation.
- Time-bucket × rotating-language greeting (serif italic), credits bubble
  (+1 per completed sale) opening a real ledger.
- Commission chart is a Catmull-Rom spline with a gradient area, a today-bubble on
  the day letter, and a spring tooltip per day.

### Transactions
- One long-press, one check (`beginSelection` is idempotent).
- Fixed 64 dp rows with a 200 ms spring tick morph — no reflow.
- Search: top-centre icon, title fades then the bar springs open, matches name OR
  phone OR transaction id, "No available records" when nothing matches.

### Offers
- Category chips derived from the offer type, with per-category counts and empty
  states; compact two-column grid cards.
- Seeds deduped to exactly four real Safaricom bundles.

### Themes v2
- Dark is now **Obsidian** (accent softened ~12 %); **Blue Light Filter removed**.
- **Grayscale** keeps semantic status colour (blue/red/grey) while chrome goes mono.
- **Silica**: frosted glass cards (blur API 31+, gradient hairline borders),
  translucent nav rail, drifting blue/violet ambient orbs.
- Appearance is three cards with live mini previews, instant recompose, haptics.

### Release
- Cinematic splash: stroke 900 ms → one soft glow pulse → 30 ms letter stagger →
  tagline, hand-off at 1.9 s.
- Login gains the gradient-orb hero behind the card.
- Contrast audit: every faint label now uses `TextFaint` (≈7:1), disabled CTAs use
  `DisabledFill`/`DisabledInk`, switches share one visible palette.
- versionCode 7 / versionName 1.6.0; `testDebugUnitTest`, `assembleDebug` and
  `assembleRelease` green.

## 1.1.0 — Audit G8/G9/G10 (2026-09-29)

- SMS functional truth: `SmsParser.SmsType` + `classify()`; pipeline acts ONLY
  on INCOMING (`received from`); OUTGOING (`sent to`/`you have sent`/`withdrawn`)
  ignored with no transaction and no reply; replies go to the parsed payer phone.
- Authorized-senders gate: non-empty trusted list → other senders IGNORED, no reply.
- Settings → Simulate Payment (DEV chip): phone/name/amount feed a fake INCOMING
  SMS into the real engine for zero-money end-to-end tests.
- UI deep-clean: `DotTrack`/`FaintDivider`/`OnBrandInk`/`LightBackground`/`LightSurface`
  tokens; zero raw `Color(0x…)` outside `Color.kt`; Settings subpages all use
  `PageTitle` + `PageIntro`.
- Tests: `SmsParserTest` + `ScoreEngineTest` (classify, USSD responses, CSV escape,
  ScoreEngine levels, `botLogColor`) — `./gradlew test` green.
- Release: versionCode 2 / versionName 1.1.0; CI runs unit tests and uploads the
  release APK artifact.
