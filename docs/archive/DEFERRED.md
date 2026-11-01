# DEFERRED — parked items (none blocking release)

- Offer fallback matching (nearest-price when no exact amount match): kept as
  exact-match by design for money safety; revisit with agent feedback.
- Device-farm / on-device SMS tests: covered by JVM unit tests + the
  Settings → Simulate Payment bench instead.
- Appearance light/dark (Parity F3): `themeMode` *does* recompose at runtime
  (MainActivity collects UserPreferences.themeMode → BingwaScoreTheme), but the
  screens paint the dark-first constants (`NightBlack`, `White`, `GlassFill` —
  76 + 276 references) instead of `MaterialTheme.colorScheme`, so Light mode
  still renders the dark glass palette. A real light glass palette needs a
  token refactor (CompositionLocal + per-screen sweep) — deliberately kept out
  of the 1.2.0 build block.
