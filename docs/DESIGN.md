# Bingwa Score — Design Constitution

Anti-slop reference for every stage that touches the UI. When this doc and the
code disagree, the code wins only after a deliberate update to this doc.

## 1. Themes (exactly two)

- **Obsidian** (`ThemeMode.DARK`): canvas `#0B0E15`, cards `#131824`, near-white ink.
- **Porcelain Dim** (`ThemeMode.PORCELAIN_DIM`, default): canvas `#C9CED6`, cards `#DBDFE5`, near-black ink, soft blue accent `#2F6AE0`.
- There is NO light/white mode, NO porcelain, NO grayscale, NO glass-as-surface. Blur lives ONLY in Silica (`ui/glass/`): nav bars + sheets. Never on cards.

## 2. Type scale (sp)

| Role | Size | Weight | Use |
|------|------|--------|-----|
| Display | 28 | Bold | Splash wordmark, Login "Welcome back" |
| H1 | 22 | Bold | Page titles |
| H2 | 20 | Bold | Section headers |
| Body | 14 | Regular | Body copy |
| BodySecondary | 13 | Regular | Subtitles / helper text |
| Caption | 12 | Regular | Metadata, section labels (uppercase) |
| Overline | 11 | SemiBold | Section labels, field labels |
| Micro | 10–11 | Regular | Chips, footnotes |
| Button | 14–16 | SemiBold | CTA labels |

Never random literals: read from `BingwaType` (`ui/theme/Type.kt`).

## 3. 8pt grid

All spacing, padding, gaps, corner radii and icon sizes are multiples of 8dp:
- Screen padding: 20dp horizontal
- Card radius: 12dp (iOS grouped card) / 14dp (glass input) / 16dp (field)
- Spacer steps: 4dp, 6dp, 8dp, 10dp, 12dp, 14dp, 16dp, 20dp, 24dp
- Icon: 20dp (rows), 22dp (nav/drawer), 26dp (fingerprint), 32dp (status)
- CTA height: 48dp / 52dp

## 4. Color roles (per theme, read from `ui/theme/Color.kt`)

- `BgBlack` — canvas (`isPorcelain ? PorcelainDimBg : #0B0E15`)
- `Bubble` — card (`isPorcelain ? PorcelainDimCard : #131824`)
- `TextWhite` / `TextGrey` / `TextDim` / `TextFaint` — ink hierarchy
- `AccentBlue` — brand (`#2563EB` obsidian / `#2F6AE0` dim)
- `StatusDone` / `StatusFailedTint` / `StatusQueued` — statuses
- `FailRed` — error ink (`#C41B1B` dim / `#FC1E1E` obsidian)
- `CtaFill` / `CtaInk` — brand-blue CTA, white ink

**Forbidden colors:** orange, amber, warm gradients, translucent glass on cards. `U4ThemesTest` guards the palette against orange/amber.

## 5. Motion durations & curves (`ui/theme/Motion.kt`)

- Springs: response 0.35 / damping 0.86 (`Motion.DAMPING = 0.86`)
- Press scale: `0.98` (`Motion.PRESS_SCALE`)
- Fade: 320ms; Slide: 360ms
- Splash total: `<=1900ms` (`Motion.SPLASH_TOTAL`), skippable after 1000ms
- Nav crossfade: 200ms (`Motion.NAV_CROSSFADE`)
- Morph: 220ms (`Motion.MORPH_SPRING_MILLIS`)
- Drawer spring: `StiffnessHigh` + 0.86 damping (<300ms)

Nothing loops forever. Nothing bounces. One breath per surface max.

## 6. Component specs

### Card (`BubbleCard`)
- `Bubble` fill, 1dp `Hairline` border, 12dp radius, fillMaxWidth.
- No shadows on flat cards; elevation only via `Raised` surface shift.

### Chip (`StatusChip`)
- 8dp radius, text 10sp SemiBold, status-tinted fill at 14% alpha.
- States: DONE (green), ACTION (grey).

### Keypad
- 3×4 grid of 64dp round glass keys, 20sp SemiBold digits.
- PIN readout: exactly 4 dots, 12dp, filled = `AccentBlue`, empty = `Bubble` + hairline.
- On-screen keypad drives phone + PIN; system keyboard must NOT rise (`LocalSoftwareKeyboardController.hide()` on focus).

### Dialog
- `Bubble` container, white/near-black ink, 16sp max body, monospace for crash reports.
- Actions: blue confirm + grey dismiss. "Verified!" renders ONLY after the relay verifies credentials.

### CTA
- Brand-blue fill (`CtaFill`), white ink (`CtaInk`), 48–52dp height, SemiBold.

## 7. FORBIDDEN (lint/test-guarded where possible)

1. No orange/amber literals anywhere.
2. No `ThemeMode.PORCELAIN` / light mode.
3. No blur outside `ui/glass/`.
4. No PIN other than exactly 4 digits (sign-up enforces 4 + confirm match).
5. No system keyboard on phone/PIN fields (keypad drives both).
6. No "Verified!" without relay verification.
7. No local credential verification as a substitute for the relay.
8. Showcase Mode is the ONLY local-data path, explicitly labelled "Demo data".
9. No machine paths in `gradle.properties`; no secrets/tokens in repo.
10. No half-drawn wordmarks: the wordmark is ALWAYS the full string (`BrandWordmark.TEXT`).

## 8. Compliance

AGENTS.md references this doc. Every future stage must:
- Add/modify tokens in `ui/theme/` only (no literals).
- Add goldens for new screens × both themes.
- Update this doc before introducing a new component or motion value.
