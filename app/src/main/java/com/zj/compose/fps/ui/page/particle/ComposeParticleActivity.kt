package com.zj.compose.fps.ui.page.particle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zj.compose.fps.ui.widget.FpsMonitor

class ComposeParticleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box {
                ParticlePage()
                FpsMonitor(modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp,42.dp))
            }
        }
    }
}