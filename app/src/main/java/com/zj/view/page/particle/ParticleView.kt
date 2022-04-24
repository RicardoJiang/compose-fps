package com.zj.view.page.particle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.Choreographer
import android.view.View
import com.zj.compose.fps.ui.page.particle.particles
import io.data2viz.scale.Scales

class ParticleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr),Choreographer.FrameCallback {
    private val bgPaint by lazy {
        Paint().apply {
            color = Color.RED
            isAntiAlias = true
        }
    }

    private val circlePaint by lazy {
        Paint().apply {
            color = Color.WHITE
            isAntiAlias = true
        }
    }

    private val xScale by lazy {
        Scales.Continuous.linear {
            domain = listOf(.0, 5.0)
            range = listOf(width / 2.0, width.toDouble())
        }
    }

    private val yScale by lazy {
        Scales.Continuous.linear {
            domain = listOf(.0, 5.0)
            range = listOf(height / 2.0, height.toDouble())
        }
    }

    private var partCount = 100
    private var isStart = false
    fun setPartCount(count: Int) {
        this.partCount = count
    }

    fun startAnimation() {
        if (!isStart){
            isStart = true
            Choreographer.getInstance().postFrameCallback(this)
        }
    }

    fun stopAnimation() {
        Choreographer.getInstance().removeFrameCallback(this)
        isStart = false
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), bgPaint)
        (0 until partCount).forEach { id ->
            val particle = particles[id]
            val x = xScale(particle.x).toFloat()
            val y = yScale(particle.y).toFloat()
            canvas.drawCircle(x, y, 5f, circlePaint)
        }
    }

    override fun doFrame(frameTimeNanos: Long) {
        (0 until partCount).forEach { id ->
            particles[id].updatePositionAndSpeed()
        }
        this.invalidate()
        Choreographer.getInstance().postFrameCallback(this)
    }
}