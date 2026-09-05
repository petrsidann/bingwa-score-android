package com.bingwascore.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bingwascore.app.ui.theme.EmeraldGreen

@Composable
fun MainScreen(viewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = viewModel.appName, style = MaterialTheme.typography.bodyLarge, color = EmeraldGreen)
        Text(text = "Build Successful! Clean slate achieved.", style = MaterialTheme.typography.bodyLarge)
    }
}
