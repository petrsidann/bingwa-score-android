# PHASE 1 SPEC — Bingwa Score visual identity (binding contract)
Reference: docs/preview/phase1.html. This document is the authority. Match structure, spacing, palette, motion. Acceptance is structural + token-exact, not pixel-diff.

## 0. Non-negotiables
- Engine untouched: U1 (USSD chain, accessibility tapper), E1 (balance/dial).
- Routes never change; only the tab BAR changes. All destinations stay routable.
- Pure-content pattern preserved: XScreenContent(state, callbacks) + thin wrapper. Paparazzi renders Content.
- No emojis in UI. Vector icons only.
- Glass only via ui/glass/. Never on plain cards.
- Zero hardcoded hex/dp/sp in screens — DesignTokens only. Zero deprecation warnings.

## 1. Tokens
Dim: bg #E9EDF2, card #FFFFFF, elevated #F8FAFC, border #CBD5E1, ink #0B0B10, muted #5B6472.
Obsidian: bg #0F172A, card #1E293B, elevated #334155, border #475569, ink #F8FAFC, muted #94A3B8.
Hero surface #0B0B10 on BOTH; hero ink #F8FAFC.
Semantic (Obsidian / Dim): complete #A4F510/#4D7C0F; scheduled #8B5CF6/#6D28D9; awaiting #FDE68A/#B45309; failed #FDA4AF/#9F1239; unmatched #64748B/#475569; info #0EA5E9/#0369A1.
Accent #5B21D6. Launch palette unchanged.
Status fill ink: black on complete/awaiting; white on scheduled/failed/unmatched.
Every text-on-surface pair >= 4.5:1. ThemeMode enum NOT removed; both variants render this one identity.

## 2. Glass
blur 22dp, tint 0.55, card radius 20dp, hero radius 26dp. Glass card: fill card@tint, backdrop blur, 1dp border@60%, inset 1dp top specular white 60%.

## 3. Lens tab bar — ui/glass/LensTabBar.kt
Black pill h64 r999 margin14 bottom14 bg #0B0B10. 4 tabs equal weight: Home(house), Store(chain), Settings(gear), Community(two people).
Inactive icon-only #6B7280; active icon+label white 9.5sp bold.
Lens w88 h82 top-9 r26, fill white8%, blur6, border1.5 white66%, inset top/bottom specular arcs white92%, drop shadow; two 10dp elliptical arcs top-2/bottom-2 inset8%.
Lens motion: horizontal 450ms cubic-bezier(.34,1.56,.64,1); width 300ms. Centres on active tab; secondary screens keep Home lit.
Targets: Home→home, Store→MyStore, Settings→Settings, Community→Community. Dial/Stats/Manage stay routes via Home actions + drawer. Drawer unchanged.

## 4. Home
Order: Hero(black r26): autopilot eye top-LEFT 36dp (on lime / off maroon+slash); greeting 46dp left inset; credits glass box top-RIGHT 118dp (label CREDITS EXPIRE, mono d:h:m:s lime, plan below; no plan→Get credits). Big number = completed transactions TODAY (2.3em -1.5sp), NOT money. Beside: 30dp maroon bulb, dim when no unseen failure, 1000ms blink when unseen>0, tap→Transactions Failed filter + clear. Sub "completed today". Three actions Dial/Stats/Manage 44dp glass tiles.
Offline Mesh banner (offline only): info rule, queued count, Flush now.
Float Guard (balance < cheapest enabled offer): awaiting rule, critical=failed rule, Top up.
Activation ladder glass card: 52dp ring n/4; rows Arm engine(grant SMS+Phone) / Test drive(sandbox) / Import book(CSV/3) / Recover failure(retry); 26dp checkbox tile + title + caption + action pill; all four→lime "Autopilot armed · streak day 1 · retry queue active". Persist flags in DataStore; call real engine, never edit internals.
Subtabs Offers|Settings (black pill active).
Offers view: Payout card(weekly countdown + commission/goal gradient bar) → My Offers(chips All/Data/Minutes/SMS, add-with-category, price, USSD, toggle) → Repeat buyers(top buyer, churn count, follow-up) → Recent Transactions(4).
Settings view: grouped rows + Feature blueprint entry.

## 5. Transactions/Stats
Back + "Transactions". Tiles Completed(lime)/Queued(violet)/Failed(maroon). If failures: recovery card + Recover.
Range 1W/4M/8M/All. Graph in glass: violet→lime stroke3, gradient area, black dots lime2 ring, legend.
Two scrollable filter rows: [All,Completed,Scheduled,Failed,Unmatched,SiteLink,EngageBot,Mesh] and [All time,Today,Yesterday,Last 7 days,Last 30 days].
Rows: 40dp status tile, name, offer·source, amount, chip. NO +/− signs; colour carries meaning.

## 6. Dial
Back + "Quick Dial". Phone field 2dp lime border r14, 44dp lime call. Enabled-offer chips (selected accent). Selected card: offer/category/price/USSD/float-after. Confirm sheet: number/offer/mode(Live dial|Offline queue).

## 7. Manage
Back + "Manage". Subtabs Customers|Credits. Customers rows(40dp initials, name, phone·spend, View)→detail(phone,total spend,most bought,purchases,churn)+history. Credits: plan cards(name,price,desc,days); current lime border + CURRENT·countdown.

## 8. Store/Settings/Community
Store: back, glass storefront(link,published count,SiteLink orders,Copy/Share), published toggles, recent orders.
Settings: back, grouped rows(M-Pesa,SiteLink,Auto-save,Test Drive,Processing Mode,SIM,Server,Backup)+blueprint+activation n/4.
Community: back, glass stats(online,rank,score,streak), feed+like, +Post.

## 9. Entry flow
Onboarding: keep 4 slides/parallax/spring dots; slide4 off CSV-blue onto ink/violet.
Login: dark-glass keypad, lime accents, readOnly+TactileKeypad, system keyboard NEVER rises; "Verified!" only on relay Success.
Create Account: same keypad; keyboard must not cover keypad.
Setup Checklist: 4 grant rows ACTION/DONE + Start Earning, new palette.

## 10. Per-stage acceptance
git diff --stat only named files. assembleDebug+assembleRelease SUCCESS zero deprecations. Targeted tests green. Paparazzi re-record changed Content; owner compares to docs/preview/phase1.html. Owner smokes APK. UI never auto-merged.
