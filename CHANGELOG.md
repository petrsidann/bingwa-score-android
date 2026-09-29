# Changelog

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
