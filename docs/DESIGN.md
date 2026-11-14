# Bingwa Score — Design Constitution (v4 · Stage 60)

Anti-slop reference for every stage that touches UI. When this doc and the code
disagree, the code wins only after a deliberate update to this doc.

Tokens only. No raw literals, no placeholder rectangles, no ambient blobs, no
clear glass without shadow, no dull greys, no unstyled bands, no white-on-light.

Canonical token source: `ui/theme/DesignTokens.kt` (Role / Launch / Motion /
Glass / Spacing / Typography). Type ramp: `BingwaType` in `ui/theme/Type.kt`.
`Color.kt` and `StatusColors.kt` are legacy shims — read them, never add new
literals there. Semantic roles are consumed via `DesignTokens.LocalBingwaRoles`.

## 1. Themes (exactly two)
- Obsidian (`ThemeMode.DARK`): bg #0F172A, card #1E293B, elevated #334155, border #475569, ink #F8FAFC.
- Porcelain Dim (`ThemeMode.PORCELAIN_DIM`, default): bg #EAF0F6, card #FFFFFF, elevated #F8FAFC, border #CBD5E1, ink #1E293B, secondary #475569.
- No third mode (Grayscale/Silica retired; `ThemeMode.fromValue` maps them to Dim).
- Both-themes parity: every surface/token/motion renders identically in structure.

## 2. Semantic roles (Stage 56 — ContrastGuardTest pins these)
| Role | Obsidian | Porcelain Dim |
|---|---|---|
| brand | #2563EB | #2F6AE0 |
| onBrand | #FFFFFF | #FFFFFF |
| success | #34D399 | #047857 |
| onSuccess | #06281A | #FFFFFF |
| error | #F87171 | #DC2626 |
| onError | #2A0A0A | #FFFFFF |
| textPrimary | #F8FAFC | #1E293B |
| textSecondary | #94A3B8 | #475569 |
| keypadKey | #334155 | #FFFFFF |
| keypadDigit | #F8FAFC | #1E293B |

Contrast law: text/background pairs >= 4.5:1 both directions (ContrastGuardTest).
Forbidden: orange/amber literals, raw blobs, placeholder rectangles, clear glass
without shadow, dull greys, unstyled bands, white-on-light.

## 3. Launch palette (Stage 58/59 — the only place these live)
`DesignTokens.Launch`: lime #A4F510, violet #5B21D6, ink #101014. Used ONLY by
the Launch reveal + Onboarding slides. violet<->lime and lime<->ink must clear
4.5:1 (ContrastGuardTest launch_pairs). Not a theme; never leak into app chrome.

## 4. Type (4-step law)
Display / Headline / Body / Caption only (DesignTokens.Typography -> BingwaType).
Display 32sp ExtraBold -0.5sp; Headline 20sp Bold; Body 16sp; Caption 12sp.
The Launch wordmark is the single code-dictated exception: 40sp ExtraBold -1sp.
No random literals.

## 5. 8pt grid
Spacing/padding/gaps/radii/icons are multiples of 8 (4dp half-step allowed):
4, 8, 16, 24, 32, 40, 48. Card radius 12, chip 8, button 12, CTA height 48-64.
Launch/Onboarding are full-bleed behind system bars (deliberate exception).

## 6. Motion
- Springs from DesignTokens.Motion: enter stiffness 380 / damping 0.86 (slight
  overshoot); exit stiffness 500 / damping 1.0 (90-120ms, no overshoot).
- Durations 150 / 250 / 400ms. Never LinearEasing for surfaces. Nothing loops
  forever; one breath per surface max.
- Nav crossfade 200ms (`Motion.NAV_CROSSFADE`, pinned). Morph 220ms; drawer < 300ms.
- Legacy Aurora token `Motion.SPLASH_TOTAL` stays in the 1600-2000ms window
  (Stage43SplashDurationTest). It is UNROUTED — retained for source-guard tests only.
- Reduced motion: when system "remove animations" is on, springs/reveals collapse
  to instant (<=1ms crossfade); Launch shows its landed frame and hands off early.

## 7. Launch & Onboarding (Stage 59 — InstanT-style reveal)
Route: launcher `ui/screens/LaunchActivity` -> `MainActivity` LAUNCH bridge ->
Onboarding / Login / SetupChecklist / Main (decideStartDestination).
Choreography (~1.94s, all beats in `LaunchChoreography`):
1. 0-420ms lime field; violet wordmark springs in (0.4 -> 1.12 -> 1.0).
2. 420-680ms wordmark yields; 28dp violet seed dot pops at centre (overshoot 1.15).
3. 680-900ms seed holds (the "lil circle" beat).
4. 900-1520ms TRUE-CIRCLE reveal (Canvas.drawCircle, radius 14dp -> screen
   half-diagonal, CubicBezier(0.3,0,0.2,1)). Never a clipped box (oval bug).
5. ~1330-1490ms lime wordmark reborn on violet (fade + 6dp rise).
6. 1520-1940ms hold full violet; bar icons flip light; hand off.
Handoff: MainActivity window is violet (`Theme.BingwaScore.Splash` ->
launch_violet_window) so there is NO lime void; the LAUNCH bridge holds 350ms
then crossfades 200ms to the destination. Onboarding = 4 code-dictated slides
(lime/violet/ink/CSV-blue), full-bleed, parallax + spring dot indicator.
The old Aurora `SplashScreen.kt` is retained ONLY for legacy source-guard tests;
it is not routed and must not be "restored".

## 8. Frosted glass (Stage 55 standing law)
Sanctioned ONLY via GlassSpec in ui/glass/ (nav bars, sheets, dialogs). Never on
cards. Optics: blur 24dp + tint 70% + saturation +10% + 1dp top specular (Ink 12%).
Max ONE glass layer per region; never glass-on-glass. Shadows are layered stacks
(1px border-shadow + ambient + 1dp top specular), never single elevation.

## 9. Haptics & states
- Light/TextHandleMove = select/navigate/toggle; LongPress/Heavy = commit/destructive.
- Every list/screen ships 4 states: loading (skeleton), empty, error(retry),
  success. No bare spinner, no bare blank.

## 10. FORBIDDEN (test-guarded where possible)
1. No orange/amber literals. 2. No third theme. 3. No blur outside ui/glass/.
4. PIN exactly 4 digits. 5. No system keyboard on phone/PIN fields.
6. No "Verified!" without relay verification. 7. No local credential verification
substituting the relay. 8. Showcase Mode is the ONLY local-data path ("Demo data").
9. No machine paths in gradle.properties; no secrets in repo. 10. In-app wordmark
is ALWAYS BrandWordmark.TEXT (Launch/Onboarding use the code-dictated wordmark).
11. No white rectangles, grey blobs, white-on-light. 12. No clipped-box "circles".

## 11. Compliance
Every UI stage: tokens only; goldens for new screens x both themes; update this
doc before introducing a new component/motion value; run the design-pass skill.
