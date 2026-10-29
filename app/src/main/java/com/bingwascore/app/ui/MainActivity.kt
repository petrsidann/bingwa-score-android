package com.bingwascore.app.ui

import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.data.remote.RemoteHttpClient
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.navigation.AppNavHost
import com.bingwascore.app.ui.settings.FirstLaunchShowcaseOffer
import com.bingwascore.app.ui.theme.BingwaScoreTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @Inject
    lateinit var userPreferences: UserPreferences

    @Inject
    lateinit var remoteHttpClient: RemoteHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Edge-to-edge: transparent system bars, content draws behind them and
        // each screen respects the insets via the scaffold padding below.
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
        )
        setContent {
            val themeMode: ThemeMode by userPreferences.themeMode
                .collectAsStateWithLifecycle(initialValue = ThemeMode.PORCELAIN_DIM)
            BingwaScoreTheme(themeMode = themeMode) {
                AppNavHost(remoteHttpClient)
                // SHOWCASE S1 — first ever launch offers the demo reel.
                FirstLaunchShowcaseOffer(onDecided = {})
            }
        }
    }
}

