package com.bingwascore.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.domain.ThemeMode
import com.bingwascore.app.ui.navigation.AppNavHost
import com.bingwascore.app.ui.theme.BingwaScoreTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeMode: ThemeMode by userPreferences.themeMode
                .collectAsStateWithLifecycle(initialValue = ThemeMode.DARK)
            BingwaScoreTheme(themeMode = themeMode) {
                AppNavHost()
            }
        }
    }
}

