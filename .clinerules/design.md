# Bingwa Score — Cline Design Rules

## Themes (exactly two)
- Obsidian (ThemeMode.DARK) and Porcelain Dim (ThemeMode.PORCELAIN_DIM, default).
- No third mode: no Grayscale, no Silica, no light/white mode beyond Porcelain Dim.

## Tokens only
- Canonical source: ui/theme/DesignTokens.kt (Role / Launch / Motion / Glass / Spacing / Typography). Consume semantic roles via DesignTokens.LocalBingwaRoles. Type ramp: BingwaType in ui/theme/Type.kt.
- Color.kt and StatusColors.kt are legacy shims: read them, never add new literals there.
- Never hardcode colour or typography literals. No raw literals, placeholder rectangles, ambient blobs, clear glass without shadow, dull greys, unstyled bands, white-on-light text.
- Launch palette (DesignTokens.Launch: lime #A4F510, violet #5B21D6, ink #101014) is ONLY for the Launch reveal + Onboarding slides; never leak into app chrome.

## Frosted glass
- Sanctioned exclusively via GlassSpec tokens within ui/glass/ (nav bars, sheets, dialogs). Never on cards. Max one glass layer per region; never glass-on-glass.

## Circles
- A circle is drawn with Canvas.drawCircle (animated radius), never a box clipped with CircleShape (that yields an oval on non-square bounds).

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
10. In-app wordmark is ALWAYS BrandWordmark.TEXT. Launch/Onboarding use the code-dictated "Bingwa Score" wordmark (Stage 58/59 spec) — the single sanctioned exception.

# STANDING DESIGN LAW (Stage 55)

## Shadows
- Layered stacks only: 1px border-shadow + ambient shadow + 1dp top specular highlight for glass. Never single elevation values.

## Motion
- Spring-first, all values from DesignTokens.Motion. Enter: stiffness 380 / damping 0.86 (slight overshoot). Exit: stiffness 500 / damping 1.0 (no overshoot, 90-120ms). Never LinearEasing for surfaces.
- If system "remove animations" is on, all springs/reveals collapse to instant (<=1ms crossfades).

## Glass Optics
- Blur 24dp + tint 70% + saturation +10% + 1dp top specular (Ink 12% alpha). Max ONE glass layer per screen region; never glass-on-glass.

## Haptic Grammar
- Light (TextHandleMove) = select / navigate / toggle.
- LongPress / Heavy = commit / destructive.

## Type
- 4-step scale only: Display / Headline / Body / Caption. Display gets -0.5sp tracking.

## States
- Every list/screen ships 4 states: loading (skeleton), empty, error(retry), success. No screen may show a bare spinner or bare blank.
