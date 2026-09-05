package com.bingwascore.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bingwascore.app.ui.navigation.AppNavHost
import com.bingwascore.app.ui.theme.BingwaScoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BingwaScoreTheme {
                AppNavHost()
            }
        }
    }
}
