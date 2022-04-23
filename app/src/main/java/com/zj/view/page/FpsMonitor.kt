package com.zj.view.page

import android.util.Log
import android.view.Choreographer

object FpsMonitor {
    private val fpsRunnable by lazy { FpsRunnable() }
    private val listeners = arrayListOf<(Int) -> Unit>()
    private var isFpsOpen = false

    fun startMonitor(listener: (Int) -> Unit) {
        if (!isFpsOpen){
            isFpsOpen = true
            listeners.add(listener)
            Choreographer.getInstance().postFrameCallback(fpsRunnable)
        }
    }

    fun stopMonitor() {
        Choreographer.getInstance().removeFrameCallback(fpsRunnable)
        isFpsOpen = false
        listeners.clear()
    }

    class FpsRunnable : Choreographer.FrameCallback {
        var fpsCount = 0
        var fps = 0
        var lastUpdate = 0L
        override fun doFrame(frameTimeNanos: Long) {
            val ms = frameTimeNanos / 1000 / 1000
            fpsCount++
            if (fpsCount == 5) {
                fps = (5000 / (ms - lastUpdate)).toInt()
                lastUpdate = ms
                fpsCount = 0
                listeners.forEach { it.invoke(fps) }
            }
            Choreographer.getInstance().postFrameCallback(this)
        }
    }
}

