# Bingwa Score — Cline Design Rules

## Themes (exactly two)
- Obsidian (ThemeMode.DARK) and Porcelain Dim (ThemeMode.PORCELAIN_DIM, default).
- No third mode: no Grayscale, no Silica, no light/white mode beyond Porcelain Dim.

## Tokens only
- Read every colour from ui/theme/Color.kt and every type from ui/theme/Type.kt (BingwaType).
- Never hardcode colour or typography literals. No raw literals, placeholder rectangles, ambient blobs, clear glass without shadow, dull greys, unstyled bands, white-on-light text.

## Frosted glass
- Sanctioned exclusively via GlassSpec tokens within ui/glass/ (nav bars and sheets). Never on cards.

## FORBIDDEN
1. No orange/amber literals anywhere.
2. No ThemeMode.PORCELAIN / third light mode.
3. No blur outside ui/glass/.
4. No PIN other than exactly 4 digits.
5. No system keyboard on phone/PIN fields.
6. No "Verified!" without relay verification.
7. No local credential verification as a substitute for the relay.
8. Showcase Mode is the ONLY local-data path, explicitly labelled "Demo data".
9. No machine paths in gradle.properties; no secrets/tokens in repo.
10. The wordmark is ALWAYS BrandWordmark.TEXT.