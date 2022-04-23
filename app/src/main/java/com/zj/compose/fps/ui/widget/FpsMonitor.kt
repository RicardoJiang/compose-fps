package com.zj.compose.fps.ui.widget

import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FpsMonitor(modifier: Modifier) {
    var fpsCount by remember { mutableStateOf(0) }
    var fps by remember { mutableStateOf(0) }
    var lastUpdate by remember { mutableStateOf(0L) }
    Text(
        text = "Fps: $fps", modifier = modifier
            .size(60.dp), color = Color.Red, style = MaterialTheme.typography.body1
    )

    LaunchedEffect(Unit) {
        while (true) {
            withFrameMillis { ms ->
                fpsCount++
                if (fpsCount == 5) {
                    fps = (5000 / (ms - lastUpdate)).toInt()
                    lastUpdate = ms
                    fpsCount = 0
                }
            }
        }
    }
}