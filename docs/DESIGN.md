# Bingwa Score — Design Constitution (v3)

Anti-slop reference for every stage that touches the UI. When this doc and the
code disagree, the code wins only after a deliberate update to this doc.

Tokens only. No raw literals, no placeholder rectangles, no ambient blobs,
no clear glass without shadow, no dull greys, no unstyled bands.

## 1. Themes (exactly two)

- **Obsidian** (`ThemeMode.DARK`): bg `#0F172A`, card `#1E293B`, elevated
  `#334155`, borders `#475569`, white/light ink.
- **Porcelain Dim** (`ThemeMode.PORCELAIN_DIM`, **default**): bg `#F1F5F9`,
  card `#FFFFFF`, elevated `#F8FAFC`, borders `#CBD5E1`, near-black ink
  `#0F172A`, secondary `#475569`.
- There is NO third mode: no Grayscale, no Silica, no light/white mode beyond
  Porcelain Dim. Blur lives ONLY in `ui/glass/` (nav bars + sheets). Never on
  cards.
- `ThemeMode.fromValue` maps every retired stored value to Porcelain Dim.

## 2. Colours

| Role | Hex | Use |
|------|-----|-----|
| Primary / BrandBlue | `#2563EB` | brand, CTAs, links, active states |
| Success | `#10B981` | done states, ticks, confirm CTAs |
| Error | `#EF4444` | failures, destructive actions, validation errors |
| Warning | `#F59E0B` | cautions, attention states |
| Obsidian bg/card/elevated/border | `#0F172A` / `#1E293B` / `#334155` / `#475569` | dark surfaces |
| Porcelain Dim bg/card/elevated/border | `#F1F5F9` / `#FFFFFF` / `#F8FAFC` / `#CBD5E1` | light surfaces |
| Text primary (dark) | `#0F172A` | all text on Porcelain Dim |
| Text secondary (dark) | `#475569` | helper text on Porcelain Dim |
| Text primary (dark theme) | `#FFFFFF` | all text on Obsidian |
| Status done | `#2563EB` | both themes |
| Status failed | `#DC2626` (dim) / `#EF4444` (obsidian) | both themes |
| Status queued | `#6B7280` | neutral, both themes |

Read every colour from `ui/theme/Color.kt`. `TextWhite` / `TextGrey` / `TextDim`
resolve to dark ink in Porcelain Dim and light ink in Obsidian — zero
white-on-light anywhere.

**Forbidden:** orange/amber (`U4ThemesTest` guards the palette), raw blobs,
placeholder rectangles, clear glass without shadow, dull greys, unstyled bands,
system keyboard over phone/PIN fields (custom keypad only).

## 3. Type scale (sp)

| Role | Size | Weight | Use |
|------|------|--------|-----|
| Display | 48 | Bold | Splash wordmark |
| Title | 32 | Bold | Screen heroes |
| Headline | 24 | Bold | Screen headers |
| Subhead | 20 | Bold | Section headers, card titles |
| Body | 16 | Regular | Body copy |
| Callout | 16 | Regular | Dialog body, reading size |
| Label | 14 | SemiBold | Row titles, buttons |
| Footnote | 14 | Regular | Secondary copy |
| Caption | 12 | Regular | Metadata, subtitles |
| Micro | 12 | Regular | Nav labels |

Never random literals: read from `BingwaType` (`ui/theme/Type.kt`).

## 4. 8pt grid

All spacing, padding, gaps, corner radii and icon sizes are multiples of 8dp:
- Screen padding: 20dp horizontal
- Card radius: 12dp
- Chip radius: 8dp
- Button radius: 12dp
- Spacer steps: 4, 8, 12, 16, 20, 24, 32, 40, 48dp
- Icon: 20dp rows, 22dp nav, 26dp fingerprint, 32dp status
- Keypad keys: 64dp, 3×4 grid, 20sp SemiBold digits
- CTA height: 48–56dp
- PIN readout: exactly 4 dots, 12dp

## 5. Motion (`ui/theme/Motion.kt`)

- Spring: response 0.35 / damping 0.86; press scale 0.98
- Durations: 150ms / 250ms / 400ms (fade, slide, step)
- Splash total: <= 2000ms (`Motion.SPLASH_TOTAL`), skippable after 1000ms
- Nav crossfade: 200ms; morph: 220ms; drawer spring < 300ms

Nothing loops forever. Nothing bounces. One breath per surface max.

## 6. Components

### Card (`BubbleCard`)
- Surface fill, 12dp radius, fillMaxWidth, 1dp hairline border where specified.
- Soft shadow: 0 4px 12px rgba(0,0,0,0.08) on elevated surfaces.

### Chip
- 8dp radius, text 10sp SemiBold, status-tinted fill at 14% alpha.

### Buttons
- Primary: brand-blue fill, white ink, 12dp radius, 48–56dp height, press
  scale 0.98, disabled pair clears AA in both themes.
- Secondary: transparent fill, hairline border.

### Keypad
- 3×4 grid of 64dp round keys, 20sp SemiBold digits, PIN readout of exactly
  4 dots. Drives phone + PIN fields; system keyboard MUST NOT rise
  (`LocalSoftwareKeyboardController.hide()` on focus). Backspace works.

### Dialog
- Card surface, dark/light ink per theme, 16sp max body, monospace for crash
  reports. Blue confirm + grey dismiss. Frosted glass header + shadow depth
  where specified (MyPlan header, nav pill).

## 7. Splash (<= 1.3s, skippable after 900ms) — Stage 43 Aurora Snap

1. **0.0–0.2s**: Aurora glow fades in (Obsidian: `#0F172A` canvas + `#2563EB` radial glow; Dim: `#EAF0F6` canvas + pastel-blue `#93C5FD` glow).
2. **0.2–0.5s**: 'B' monogram snaps in with spring overshoot + micro-ripple ring.
3. **0.5–0.8s**: Monogram fills (white ink on Obsidian / `#1E293B` ink on Dim) + tagline "Your bundle business, automated." fades up.
4. **0.8–1.3s**: Whole screen scales 1.0 -> 1.04 + cross-fades to next screen.

Obsidian: #0F172A canvas + #2563EB glow. Porcelain Dim: #EAF0F6 canvas + pastel-blue glow + #1E293B ink.

## 8. FORBIDDEN (lint/test-guarded where possible)

1. No orange/amber literals anywhere.
2. No `ThemeMode.PORCELAIN` / third light mode.
3. No blur outside `ui/glass/`.
4. No PIN other than exactly 4 digits (sign-up enforces 4 + confirm match).
5. No system keyboard on phone/PIN fields.
6. No "Verified!" without relay verification.
7. No local credential verification as a substitute for the relay.
8. Showcase Mode is the ONLY local-data path, explicitly labelled "Demo data".
9. No machine paths in `gradle.properties`; no secrets/tokens in repo.
10. No half-drawn wordmarks: the wordmark is ALWAYS `BrandWordmark.TEXT`.
11. No white rectangles, grey placeholder blobs, or white-on-light text.

## 9. Compliance

AGENTS.md references this doc. Every future stage must:
- Add/modify tokens in `ui/theme/` only (no literals).
- Add goldens for new screens × both themes.
- Update this doc before introducing a new component or motion value.
