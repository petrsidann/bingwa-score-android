# Changelog

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
