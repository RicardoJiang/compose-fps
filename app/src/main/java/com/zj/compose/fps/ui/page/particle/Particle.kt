package com.zj.compose.fps.ui.page.particle

import ParticlesCanvas
import RandomParticle
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow

val particlesCount = listOf(100, 300, 1000, 3000, 10_000, 20_000, 30_000, 100_000)

val particles = Array(particlesCount.last()) { RandomParticle() }

fun io.data2viz.color.Color.toColor() = Color(this.r, this.g, this.b)

val red = Color(red = 180, green = 0, blue = 0)

@Composable
fun ParticlePage() {
    var particleCount by remember { mutableStateOf(particlesCount.first()) }
    var time by remember { mutableStateOf(0L) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        FlowRow(mainAxisSpacing = 10.dp) {
            particlesCount.forEach {
                Button(
                    onClick = { particleCount = it }
                ) {
                    Text(it.toString())
                }
            }
        }

        ParticlesCanvas(
            time, particleCount,
            Modifier
                .fillMaxWidth()
                .height(500.dp)
        )
    }

    LaunchedEffect(Unit) {
        while (true) {
            withFrameMillis { ms ->
                (0 until particleCount).forEach { id ->
                    particles[id].updatePositionAndSpeed()
                }
                time = ms
            }
        }
    }
}