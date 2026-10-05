package com.bingwascore.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BingwaType
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextWhite

/**
 * POLISH P1 — the app's only snackbar.
 *
 * Material's stock `Snackbar` paints a light-grey container with a dark label,
 * which fought the black terminal look and, worse, was the one surface in the
 * product that dropped to a colour no other surface used. Every host in the app
 * now renders [DarkSnackbar]: a **Raised** bubble, a hairline edge, white copy
 * and a blue action — the same vocabulary as the cards behind it.
 */
@Composable
fun DarkSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    SnackbarHost(hostState = hostState, modifier = modifier) { data ->
        DarkSnackbar(data = data)
    }
}

/** One dark bubble: message on the left, optional blue action on the right. */
@Composable
fun DarkSnackbar(data: SnackbarData, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        shape = RoundedCornerShape(18.dp),
        color = Raised,
        border = BorderStroke(1.dp, Hairline),
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = data.visuals.message,
                color = TextWhite,
                style = BingwaType.footnoteStyle,
                modifier = Modifier.weight(1f)
            )
            // SnackbarData exposes the action label on the visuals and the action
            // itself as performAction(). With no label there is nothing to press,
            // so the bubble stays a pure message.
            val visuals = data.visuals
            val actionLabel = visuals.actionLabel
            if (actionLabel != null) {
                Spacer(modifier = Modifier.width(8.dp))
                TextButton(onClick = { data.dismiss(); data.performAction() }) {
                    Text(
                        text = actionLabel,
                        color = AccentBlue,
                        fontWeight = FontWeight.Bold,
                        style = BingwaType.captionStyle
                    )
                }
            }
        }
    }
}
