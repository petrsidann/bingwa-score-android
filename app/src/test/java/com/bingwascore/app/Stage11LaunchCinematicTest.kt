package com.bingwascore.app

import com.bingwascore.app.ui.theme.Motion
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 11 — launch cinematic + no-blank-frame hand-off.
 *
 * The choreography and the transition gap are contracts with the agent: the
 * splash must draw with a tip, ignite (ring + sweep), rise the FULL wordmark,
 * and hand off inside 2.0s; every route change must crossfade 200ms and the
 * Home data must be pre-warmed before navigation, so no frame between two
 * destinations ever renders blank.
 */
class Stage11LaunchCinematicTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private val splashSrc: String = File(
        repoRoot, "app/src/main/java/com/bingwascore/app/ui/screens/SplashScreen.kt"
    ).readText()

    private val navSrc: String = File(
        repoRoot, "app/src/main/java/com/bingwascore/app/ui/navigation/AppNavHost.kt"
    ).readText()

    @Test
    fun `splash draws a glowing traveling tip on the stroke head`() {
        assertTrue(
            "SplashScreen must draw the traveling tip helper",
            splashSrc.contains("drawTravelingTip(trim.value)")
        )
        assertTrue(
            "the tip helper must sample Monogram.path positions",
            splashSrc.contains("fun DrawScope.drawTravelingTip")
        )
    }

    @Test
    fun `stroke completes with a shockwave ring and specular sweep`() {
        assertTrue(
            "the monogram must emit a shockwave ring at full trim",
            splashSrc.contains("Stroke(width = 2f)")
        )
        assertTrue(
            "the monogram must sweep a specular gradient across the stroke",
            splashSrc.contains("Brush.linearGradient(")
        )
    }

    @Test
    fun `the full wordmark rises — every letter, never sliced`() {
        // Regression: a refactor that rendered only part of "Bingwa Score"
        // (the historical drop-letter bug) fails here. The wordmark composable
        // must iterate the whole text through wordmarkAlphas.
        val wordmark = splashSrc.substringAfter(
            "private fun StaggeredWordmark",
            missingDelimiterValue = "StaggeredWordmark not found"
        )
        assertTrue(
            "the wordmark must iterate every char of the full string",
            wordmark.contains("text.forEachIndexed")
        )
        assertTrue(
            "the wordmark must drive letters through wordmarkAlphas",
            wordmark.contains("wordmarkAlphas(text, progress)")
        )
    }

    @Test
    fun `letters spring up rather than hard-cut in`() {
        assertTrue(
            "letters must settle with spring-style scale/rise",
            splashSrc.contains("val settle = (local * 1.06f)")
        )
        assertTrue(
            "letters must rise while fading",
            splashSrc.contains("translationY = (1f - settle) * 10f * density")
        )
    }

    @Test
    fun `the tagline breathes instead of fading once`() {
        assertTrue(
            "tagline alpha must ride a soft breath",
            splashSrc.contains("taglineAlpha * (0.92f + 0.08f * taglineBreath.value)")
        )
    }

    @Test
    fun `the monogram shrinks into the login logo before hand-off`() {
        assertTrue(
            "an exit-shrink animatable must exist",
            splashSrc.contains("val exitShrink = remember { Animatable(0f) }")
        )
        assertTrue(
            "the shrink must complete before onFinish fires",
            splashSrc.contains("exitShrink.animateTo(1f, tween(200))")
        )
        val shrinkAt = splashSrc.indexOf("exitShrink.animateTo")
        val finishAt = splashSrc.indexOf("currentOnFinish(resolved)")
        assertTrue("shrink must run before the route fires", shrinkAt in 0 until finishAt)
        assertTrue(
            "the monogram canvas must apply the shared-element exit transform",
            splashSrc.contains("val t = exitShrink.value")
        )
    }

    @Test
    fun `every route change crossfades 200ms — no blank frame`() {
        assertTrue("NAV_CROSSFADE must be 200ms", Motion.NAV_CROSSFADE == 200)
        listOf("enterTransition", "exitTransition", "popEnterTransition", "popExitTransition")
            .forEach { param ->
                assertTrue(
                    "NavHost must declare $param with the crossfade",
                    navSrc.contains("$param = { fade")
                )
            }
        assertTrue(
            "the crossfade must read the shared Motion token",
            navSrc.contains("Motion.NAV_CROSSFADE")
        )
    }

    @Test
    fun `home data is pre-warmed before navigation to home`() {
        val preWarmFile = File(
            repoRoot, "app/src/main/java/com/bingwascore/app/ui/home/HomePreWarmViewModel.kt"
        )
        assertTrue("HomePreWarmViewModel missing", preWarmFile.exists())
        val preWarmSrc = preWarmFile.readText()
        assertTrue(
            "the pre-warm must perform Home's first Room read",
            preWarmSrc.contains("transactionRepository.liveTransactions.first()")
        )
        assertTrue(
            "AppNavHost must instantiate the pre-warm shell",
            navSrc.contains("HomePreWarmViewModel")
        )
        val warmAt = navSrc.indexOf("homePreWarm:")
        val homeNavAt = navSrc.indexOf("navigate(Routes.MAIN)")
        assertTrue("pre-warm declared in AppNavHost", warmAt >= 0)
        assertTrue(
            "pre-warm must be declared before navigating to MAIN",
            warmAt < homeNavAt
        )
    }

    @Test
    fun `the splash hands off inside its 2s budget with the exit beat`() {
        // The exit shrink (200ms) runs inside SPLASH_TOTAL — pin the budget so
        // the cinematic + shrink never push the agent past two seconds.
        assertTrue(
            "splash total ${Motion.SPLASH_TOTAL}ms exceeds the 2.0s budget",
            Motion.SPLASH_TOTAL <= 2_000
        )
        assertTrue(Motion.SPLASH_DRAW == 900)
    }
}