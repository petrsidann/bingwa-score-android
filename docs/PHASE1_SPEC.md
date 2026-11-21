# PHASE 1 SPEC — Bingwa Score visual identity (binding contract)

Reference implementation: `docs/preview/phase1.html`. This document is the authority.
Match structure, spacing, palette, and motion. Compose ≠ HTML pixel-for-pixel; fonts and
blur render differently. Acceptance is structural + token-exact, not pixel-diff.

## 0. Non-negotiables
- Engine untouched: U1 (USSD chain, accessibility tapper), E1 (balance/dial). Never edit.
- Routes never change. Only the tab BAR changes. All existing destinations stay routable.
- Pure-content pattern preserved: every screen stays `XScreenContent(state, callbacks)`
  plus a thin wrapper owning hiltViewModel/lifecycle. Paparazzi must still render Content.
- No emojis anywhere in UI. SVG/vector icons only.
- Glass only via `ui/glass/`. Never on plain cards.
- Zero hardcoded hex/dp/sp in screens — `DesignTokens` only.
- Zero deprecation warnings.

## 1. Tokens (Stage 61)
Canvas — Dim: bg #E9EDF2, card #FFFFFF, elevated #F8FAFC, border #CBD5E1, ink #0B0B10, muted #5B6472.
Canvas — Obsidian: bg #0F172A, card #1E293B, elevated #334155, border #475569, ink #F8FAFC, muted #94A3B8.
Hero surface: #0B0B10 on BOTH variants. Hero ink #F8FAFC.
Semantic (Obsidian / Dim):
  complete  #A4F510 / #4D7C0F
  scheduled #8B5CF6 / #6D28D9
  awaiting  #FDE68A / #B45309
  failed    #FDA4AF / #9F1239
  unmatched #64748B / #475569
  info      #0EA5E9 / #0369A1
Accent: #5B21D6. Launch palette unchanged (lime/violet/ink).
Status fill ink = black on complete/awaiting, white on scheduled/failed/unmatched.
Every text-on-surface pair >= 4.5:1 (ContrastGuardTest).
ThemeMode enum is NOT removed. Both variants render this one identity.

## 2. Glass system
blur 22dp, tint 0.55, card radius 20dp, hero radius 26dp.
Glass card: fill = card @ tint, backdrop blur, 1dp border @ 60% border色, inset 1dp top specular white 60%.

## 3. Lens tab bar (Stage 62) — `ui/glass/LensTabBar.kt`
- Black pill: height 64dp, radius 999, margin 14dp horizontal, 14dp bottom, bg #0B0B10.
- 4 tabs, equal weight, in order: **Home, Store, Settings, Community**.
  Home = house. Store = chain-link. Settings = gear. Community = two people.
- Inactive: icon only, #6B7280. Active: icon + label, white, label 9.5sp bold.
- Lens: width 88dp, height 82dp, top offset -9dp, radius 26dp,
  fill white 8%, backdrop blur 6dp, border 1.5dp white 66%,
  inset top/bottom specular arcs (white 92%), drop shadow.
  Two 10dp-tall elliptical highlight arcs at top -2dp and bottom -2dp, 8% inset each side.
- Lens motion: horizontal 450ms cubic-bezier(.34, 1.56, .64, 1); width 300ms.
- Lens centres on the active tab. Secondary screens (Dial/Stats/Manage/Blueprint) keep Home lit.
- Tab targets: Home→home, Store→MyStore, Settings→Settings, Community→Community.
- Dial/Stats/Manage remain routes, reached from Home quick actions and drawer. Drawer unchanged.

## 4. Home (Stage 63–65) — `HomeScreenContent`
Order, top to bottom:
1. **Hero** (black, radius 26): autopilot eye top-LEFT 36dp tile (on = lime fill/stroke, off = maroon + slash);
   greeting 46dp left inset ("Good morning," / name); credits glass box top-RIGHT 118dp wide
   (label "CREDITS EXPIRE", mono countdown d:h:m:s in lime, plan name below; if no plan → "Get credits" link).
   Big number = **completed transactions TODAY** (2.3em, -1.5sp tracking), NOT money.
   Beside it: 30dp maroon bulb — dim when no unseen failure, 1000ms blink when unseen > 0;
   tap → Transactions with Failed filter and clears unseen. Sub-label "completed today".
   Three quick actions: Dial / Stats / Manage (44dp glass tiles).
2. **Offline Mesh banner** (only when offline): info left-rule, queued count, "Flush now".
3. **Float Guard** (only when balance < cheapest enabled offer): awaiting rule, critical = failed rule,
   "Top up" action.
4. **Activation ladder** (glass card): 52dp progress ring n/4, title, four task rows —
   Arm the engine (grant SMS+Phone) · Test drive a payment (sandbox) · Import your book (CSV/3) ·
   Recover a failure (one-tap retry). Each row: 26dp checkbox tile, title, caption, action pill.
   All four complete → lime "Autopilot armed · streak day 1 · retry queue active" strip.
   Persist the four flags in DataStore. Wire to real engine calls; never modify engine internals.
5. **Subtabs**: Offers | Settings (black pill when active).
6. Offers view: Payout card (weekly countdown + commission/goal gradient bar) →
   My Offers (category chips All/Data/Minutes/SMS, add-with-category, price, USSD, toggle) →
   Repeat buyers (top buyer, churn-risk count, follow-up link) → Recent Transactions (4 rows).
   Settings view: grouped settings rows + Feature blueprint entry.

## 5. Transactions / Stats (Stage 67)
Back arrow + "Transactions". Three stat tiles: Completed (lime), Queued (violet), Failed (maroon).
If failures exist: recovery card with "Recover".
Range chips 1W/4M/8M/All. Graph in glass card: violet→lime gradient stroke 3dp, gradient area fill,
black dots with lime 2dp ring. Legend below.
**Two horizontal filter rows**, scrollable, no wrap:
  row 1: All, Completed, Scheduled, Failed, Unmatched, SiteLink, EngageBot, Mesh
  row 2: All time, Today, Yesterday, Last 7 days, Last 30 days
Ledger rows: 40dp status tile, name, offer · source, amount, status chip.
**Amounts have NO + or − sign.** Colour carries meaning.

## 6. Dial
Back arrow + "Quick Dial". Phone field: 2dp lime border, radius 14, 44dp lime call button.
Enabled-offer chips below (selected = accent border + tint). "Selected" card: offer, category,
price, USSD, float-after. Confirm sheet: number, offer, mode (Live dial / Offline queue).

## 7. Manage
Back arrow + "Manage". Subtabs Customers | Credits.
Customers: list rows (40dp initials avatar, name, phone · spend, View) → detail
(phone, total spend, most bought, purchases, churn risk) + that customer's history.
Credits: plan cards (name, price, description, days); current = lime border + "CURRENT · countdown".

## 8. Store / Settings / Community (Stage 68)
Store: back, glass storefront card (link, published count, SiteLink orders, Copy/Share),
published-offer toggles, recent SiteLink orders.
Settings: back, grouped rows (M-Pesa, SiteLink, Auto-save, Test Drive, Processing Mode,
SIM Selection, Server, Backup & Restore) + blueprint entry + activation n/4.
Community: back, glass stats card (online, rank, score, streak), feed cards with like, + Post.

## 9. Entry flow (Stage 69)
Onboarding: keep 4 slides, parallax, spring dot indicator. Slide 4 moves off CSV-blue onto ink/violet.
Login: dark-glass keypad language, lime accents, readOnly fields + TactileKeypad,
system keyboard NEVER rises. "Verified!" only on relay Success — never on Offline.
Create Account (PinSetup): same keypad language; system keyboard must not cover the keypad.
Setup Checklist: 4 grant rows with ACTION/DONE chips, "Start Earning" CTA, new palette.
Onboarding = original full-bleed colour slides (lime/violet/ink/blue) restored from history; chrome (Skip/CTA/dots) fixed outside pager; dots below CTA; CTA clears system nav. slide4 keeps its original deep blue; all four slides full-bleed colour.

## 10. Per-stage acceptance
- `git diff --stat` shows only the named files.
- `assembleDebug` + `assembleRelease` BUILD SUCCESSFUL, zero deprecation warnings.
- Targeted tests green (StartDestinationTest, ContrastGuardTest + that screen's tests).
- Paparazzi goldens re-recorded for changed Content; owner compares against `docs/preview/phase1.html`.
- Owner smokes the APK. UI stages are never auto-merged.

## 9.1 Entry-flow dark liquid glass (Stage 64)
PhaseEntryKit components: PhaseScreen, PhaseDisplay, PhasePinReadout, PhaseKeypad, PhaseChips, PhaseCta, PhaseGrantRow, PhaseMedallion, PhaseSpringDots, PhaseTextField. All glass constants live in `ui/glass/PhaseKeypad.kt`.
- Invariant: numeric fields are never text fields; IME and keypad are mutually exclusive per step. Text fields (name/email) only appear in the identity step of create-account and always use the system keyboard; all phone/PIN entry uses the custom keypad.
- No em dashes in user copy.
- Nothing loops forever: no infinite chevron march, no blinking caret.

## 11. Stage O3 amendments (colour/icon matrix, home glass, plaque)
- Onboarding colour/icon matrix lives in `DesignTokens.Onboarding`. Slide backgrounds, medallion fills and icon tints are token-driven; no per-slide hex literals in `OnboardingSlides.kt`.
- Slide 4 uses the original CSV/cloud-upload icon (not retry arrows). The per-page "Bingwa Score" header block is removed from the pager; chrome is Skip + CTA + dots only.
- Entry route transitions (onboarding ↔ login ↔ pin_setup ↔ setup_checklist) use `slideInHorizontally` / `slideOutHorizontally` only (260 ms). No alpha crossfade between these screens.
- Home cards (offline mesh, ladder, payout, offers container, repeat buyers, recent transactions) are wrapped in `GlassCard`. Hero stays solid black.
- Home hero quick-action tiles are 44 dp glass tiles with 18 dp vector icons and 9.5 sp labels.
- Home credits box shows a live `d:h:m:s` countdown in lime from `UserPreferences.creditsExpiry`; plan name below.
- Home activation ladder uses 26 dp rounded-9 tiles: check glyph (lime fill, ink glyph) when done, plus glyph (muted) otherwise; progress ring is violet while incomplete and lime at 4/4.
- Home subtabs (Offers / Settings) appear as the LazyColumn item immediately after the hero card.
- Payout card shows real weekly commission, a countdown to Friday 17:00 (mono violet) and a gradient bar whose width is `commission / 1,000`.
- Recent-transaction rows show a 40 dp status tile with the appropriate glyph and a right-aligned status chip; amounts carry no +/− sign.
- Plaque prohibition: no ancestor of `LensTabBar` may carry a background. `MainScreen` lays out content and the black pill directly inside a root `Box`; the pill sits on page content with only its drop shadow.
