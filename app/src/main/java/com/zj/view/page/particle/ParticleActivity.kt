package com.zj.view.page.particle

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.android.flexbox.FlexboxLayout
import com.zj.compose.fps.R
import com.zj.compose.fps.ui.page.particle.particlesCount
import com.zj.view.page.ViewFpsMonitor


class ParticleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_particle)
        initView()
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    private fun initView() {
        val tvFps = findViewById<TextView>(R.id.tv_fps)
        val flexboxLayout = findViewById<FlexboxLayout>(R.id.flex_box_layout)
        val particleView = findViewById<ParticleView>(R.id.particle_view)
        ViewFpsMonitor.startMonitor {
            tvFps.text = "Fps: $it"
        }
        particleView.startAnimation()
        particlesCount.forEach {
            val view = layoutInflater.inflate(R.layout.layout_button_item, null, false)
            val tvCount = view.findViewById<TextView>(R.id.tv_count)
            tvCount.text = it.toString()
            flexboxLayout.addView(view)
            tvCount.setOnClickListener {_->
                particleView.setPartCount(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        findViewById<ParticleView>(R.id.particle_view).stopAnimation()
        ViewFpsMonitor.stopMonitor()
    }
}