---
name: design-pass
description: Applies the Bingwa design constitution to a screen/component: tokens only from ui/theme/Color.kt and Type.kt, two themes (Obsidian + Porcelain Dim) with parity, frosted glass only via GlassSpec in ui/glass/, and the FORBIDDEN list (no orange/amber, no third theme, no blur outside ui/glass/, 4-digit PIN, no system keyboard on phone/PIN fields).
when_to_activate: Before any UI change, when implementing a new component, or when auditing a screen for design compliance across both themes.
---

# design-pass

Run this skill to review or implement UI work against `.clinerules/design.md`.

Checks:
1. Colours/text come from `ui/theme/Color.kt`; type from `BingwaType` in `ui/theme/Type.kt` — no hardcoded literals.
2. Exactly two themes: Obsidian (`ThemeMode.DARK`) and Porcelain Dim (`ThemeMode.PORCELAIN_DIM`, default). No Grayscale/Silica/third mode.
3. Frosted glass only via `GlassSpec` tokens in `ui/glass/` (nav bars, sheets) — never on cards.
4. FORBIDDEN list: no orange/amber, no third light mode, no blur outside `ui/glass/`, PIN exactly 4 digits, no system keyboard on phone/PIN fields, no "Verified!" without relay verification, wordmark always `BrandWordmark.TEXT`.
5. Goldens added for new screens × both themes.