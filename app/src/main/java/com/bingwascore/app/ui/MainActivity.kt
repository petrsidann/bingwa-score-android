package com.bingwascore.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import com.bingwascore.app.ui.theme.BingwaScoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BingwaScoreTheme {
                Surface(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
                    val viewModel: MainViewModel = hiltViewModel()
                    MainScreen(viewModel)
                }
            }
        }
    }
}
