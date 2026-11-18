# Phase 1 Source Notes — Stage 62 harvest

## HomeScreen.kt: HomeTopBar composable

```kotlin
@Composable
fun HomeTopBar(
    bucket: Greetings.Bucket,
    language: Greetings.Language,
    creditsLabel: String,
    onCreditsClick: () -> Unit,
    onThemeToggle: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GreetingLine(bucket = bucket, language = language, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(8.dp))
        ThemeToggle(onToggle = onThemeToggle)
        Spacer(modifier = Modifier.width(8.dp))
        CreditsBubble(label = creditsLabel, onClick = onCreditsClick)
    }
}
```

## HomeScreen.kt: HeroBar composable

```kotlin
@Composable
private fun HeroBar(
    airtimeToday: Double,
    balance: Double?,
    loading: Boolean,
    valuesVisible: Boolean,
    onToggleVisibility: () -> Unit,
    onRefresh: () -> Unit,
    onOpenDiagnostics: () -> Unit
) {
    val density = LocalDensity.current
    val gradient = Brush.verticalGradient(
        colors = listOf(
            DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.14f),
            DesignTokens.LocalBingwaRoles.current.brand.copy(alpha = 0.02f)
        ),
        startY = 0f,
        endY = with(density) { 120.dp.toPx() }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(gradient)
    ) {
        GlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(112.dp)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    MoneyLine(
                        label = "Airtime used today",
                        value = if (valuesVisible) "Ksh ${money(airtimeToday)}" else MASK,
                        valueColor = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    // E1 — NEVER a fake number: null balance shows unavailable + link.
                    val balanceScale by animateFloatAsState(
                        targetValue = if (valuesVisible) 1f else 0.92f,
                        animationSpec = spring(
                            stiffness = DesignTokens.Motion.SpringStiffness,
                            dampingRatio = DesignTokens.Motion.SpringDamping
                        ),
                        label = "HeroBalanceScale"
                    )
                    Box(
                        modifier = Modifier
                            .graphicsLayer {
                                scaleX = balanceScale
                                scaleY = balanceScale
                                alpha = if (valuesVisible) 1f else 0.5f
                            }
                    ) {
                        if (balance == null && valuesVisible) {
                            MoneyLine(label = "Current balance", value = "Unavailable")
                            Text(
                                "run Diagnostics",
                                color = DesignTokens.LocalBingwaRoles.current.brand,
                                fontSize = DesignTokens.Typography.Caption,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.clickable(onClick = onOpenDiagnostics)
                            )
                        } else {
                            MoneyLine(
                                label = "Current balance",
                                value = if (valuesVisible) "Ksh ${money(balance ?: 0.0)}" else MASK,
                                valueColor = DesignTokens.LocalBingwaRoles.current.textPrimary,
                                valueSize = DesignTokens.Typography.Display.fontSize ?: 32.sp,
                                valueWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .clickable(onClick = onToggleVisibility),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (valuesVisible) Icons.Rounded.VisibilityOff
                        else Icons.Rounded.Visibility,
                        contentDescription = if (valuesVisible) "Hide amounts" else "Show amounts",
                        tint = DesignTokens.LocalBingwaRoles.current.textPrimary.copy(alpha = 0.6f),
                        modifier = Modifier.size(19.dp)
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                RefreshButton(loading = loading, onClick = onRefresh)
            }
        }
    }
}
```

## HomeScreenContent LazyColumn item{} blocks (in order)

1. Crash circuit banner (`if (showCrashBanner)`)
2. `HomeTopBar(...)`
3. `AutopilotPill(...)`
4. Language label row (state.greetingLanguage.endonym → Diplomatics)
5. Permission card (`if (state.permissionsMissing)`)
6. `HeroBar(...)`
7. `StatsRow(...)`
8. `CommissionGraphCard` wrapped in `GlassCard`
9. SectionHeader("Transactions", ...)
10. Shimmer skeleton rows OR empty-state message
11. Transaction list items

## Agent display name source

HomeTopBar displays `Greetings.text(bucket, language)` via `GreetingLine`. No separate agent name field; the greeting string (e.g. "Habari", "Good morning") is the top-bar display.

## TransactionFilter enum and chips

```kotlin
enum class TransactionFilter(val label: String) {
    ALL("All"),
    TODAY("Today"),
    YESTERDAY("Yesterday"),
    LAST_7_DAYS("7d"),
    LAST_30_DAYS("30d"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    PENDING("Queued"),
    SCHEDULED("Scheduled"),
    UNMATCHED("Unmatched");
}

internal val transactionFilterChips: List<TransactionFilter>
    get() = TransactionFilter.entries.toList()
```

## UserPreferences keys/flows (theme, credits, plan, expiry)

```kotlin
val themeMode: Flow<ThemeMode> =
    context.dataStore.data.map { ThemeMode.fromValue(it[Keys.THEME_MODE]) }

// Plan-backed credits keys:
val PLAN_ID = stringPreferencesKey("plan_id")
val PLAN_DISPLAY_NAME = stringPreferencesKey("plan_display_name")
val PLAN_PULLS_LEFT = intPreferencesKey("plan_pulls_left")
val PLAN_UNLIMITED = booleanPreferencesKey("plan_unlimited")
val PLAN_EXPIRES_AT = longPreferencesKey("plan_expires_at")

suspend fun setThemeMode(value: ThemeMode) = edit { it[Keys.THEME_MODE] = value.value }
```

## Greetings.Bucket enum constants

```kotlin
enum class Bucket { EARLY_MORNING, MORNING, MID_MORNING, AFTERNOON, LATE_AFTERNOON, EVENING, NIGHT }
```

## DesignTokens.Launch field names

```kotlin
object Launch {
    val lime = ComposeColor(0xFFA4F510)
    val violet = ComposeColor(0xFF5B21D6)
    val ink = ComposeColor(0xFF101014)
}
```
