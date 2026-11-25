# Bingwa Hybrid UI Reconnaissance Report

**APK:** com.example.bingwahybrid v2.5.11  
**Package:** `com.example.bingwahybrid`  
**Architecture:** Clean Architecture (domain/infrastructure/presentation layers)  
**UI Framework:** Jetpack Compose (single-activity)  
**Date:** 2026-11-26  

---

## Architecture Summary

Bingwa Hybrid is a single-activity Android application built with Jetpack Compose following Clean Architecture patterns. The codebase is organized into four main layers:

- **presentation**: UI screens, viewmodels, theme, and composables
- **domain**: Business logic use cases
- **data**: Data sources and repositories  
- **infrastructure**: Platform implementations, DI (Hilt), networking

The app uses Hilt for dependency injection, Kotlin Coroutines for async operations, and follows MVVM pattern in the presentation layer.

## Screen Map

Discovered screens from decompiled artifacts:

| Screen | Package Path | Purpose |
|--------|-------------|---------|
| DrawerScaffoldScreen | `presentation.ui.screens` | Main navigation scaffold with drawer |
| BlackListScreen | `presentation.blacklist` | Customer blacklist management |
| CommunityOffersScreen | `presentation.community.screens` | Community offers display |
| OffersScreen | `presentation.offers.screens` | General offers listing |
| QuickDialScreen | `presentation.quickdial.screens` | Quick dial functionality |
| SiteLinkScreen | `presentation.sitelink.screens` | Site link management |
| AddSiteLinkOfferScreen | `presentation.sitelink.screens` | Add site link offer flow |
| MySubscriptionScreen | `presentation.subscriptions` | User subscription management |
| TransactionDetailsScreen | `presentation.transactions.screens` | Transaction detail view |
| HomeViewModel | `presentation.viewmodel` | Home screen state management |
| PinLoginViewModel | `presentation.viewmodel` | PIN login authentication |
| PinSetupViewModel | `presentation.viewmodel` | PIN setup flow |
| OtpVerificationViewModel | `presentation.viewmodel` | OTP verification |
| ForgotPasswordViewModel | `presentation.viewmodel` | Password recovery |
| RegisterViewModel | `presentation.viewmodel` | User registration |
| RedeemCouponViewModel | `presentation.viewmodel` | Coupon redemption |

## Per-Screen Mechanics

### Launch Animation
**Evidence:** Not directly observable from static analysis. No explicit launch animation tokens found in resources. Likely uses standard Compose transitions.

### Onboarding + Dots
**Evidence:** ViewModels for PinSetup and OtpVerification suggest multi-step onboarding flow. Dot indicators likely implemented as Compose pager with page indicators.

### Keypad States
**Evidence:** PinLoginViewModel and PinSetupViewModel imply numeric keypad input. State management through ViewModel with password/PIN entry states.

### Tab/Lens Motion
**Evidence:** DrawerScaffoldScreen suggests tab-based navigation. "Lens" terminology appears in our codebase but not confirmed in target APK static analysis.

### Hero Sections
**Evidence:** OffersScreen and CommunityOffersScreen suggest hero/promotional content sections with card-based layouts.

### Countdown Formats
**Evidence:** No countdown timer tokens found in extracted resources. May be implemented dynamically in code.

### Status Glyphs
**Evidence:** Standard Android notification icons present. Custom status glyphs not identified in resource extraction.

## Inspo Mechanics vs Our Current Build

1. **Spacing system**: Target uses 8-value spacing scale (2,4,8,12,16,20,24,32dp); we use DesignTokens with similar granularity
2. **Color palette**: Target has primary (#001fbf) and secondary (#009544) brand colors; our build uses different token names
3. **Corner radius**: Target uses uniform 2dp corners for dialogs/controls; we use variable radii per component
4. **Typography**: Target relies on Android Material text sizes (12-112sp range); we use custom BingwaType scale
5. **Navigation**: Target uses DrawerScaffold pattern; we use LensTabBar bottom navigation
6. **Glass effects**: No blur/glass tokens found in target resources; may be runtime-calculated or absent
7. **Motion**: No spring/tween duration constants extracted; animations likely use Compose defaults
8. **Keypad**: PIN-based auth present but no custom keypad UI tokens identified in resources
9. **Pager**: Dot indicators implied by onboarding ViewModels but no explicit pager tokens found
10. **Elevation**: Standard Material elevation (4dp action bar, 16dp floating window); no custom z-index system

## DO-NOT-COPY

The following must NEVER be copied into our codebase:

- **Engine logic**: USSD dialer implementation, balance checking algorithms, transaction processing
- **Socket protocol**: WebSocket endpoints, real-time communication protocol details
- **API keys**: All API keys, secrets, tokens printed as REDACTED only
- **Backend URLs**: Server endpoints, base URLs, gateway configurations
- **Business rules**: Pricing logic, validation rules, rate limiting parameters
- **Database schemas**: Table structures, query patterns, migration logic
- **Cryptographic material**: Encryption keys, signing certificates, hash salts
- **Proprietary algorithms**: Custom scoring, ranking, or recommendation logic
- **User data handling**: PII processing, consent management, data retention policies
- **Third-party integrations**: Analytics IDs, push notification keys, payment gateway credentials

---

**Recon Methodology:** Static APK analysis via apktool 3.0.3 (resources + smali) and partial jadx-headless decompilation (Java sources only due to Java 11 runtime limitation). Full Kotlin source extraction was not possible. Tokens extracted from R.java resource references, Spacing.kt constructor defaults, and Android framework dimens/colors.

**Coverage Note:** jadx MCP server unavailable (requires Java 17+); used direct apktool decode and partial jadx CLI. Smali code for app package not produced by apktool (only framework smali decoded). Motion/spring/blur tokens not extractable from available artifacts.
