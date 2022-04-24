package com.zj.view.page.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zj.compose.fps.R
import com.zj.compose.fps.ui.page.list.ComposeListViewModel
import com.zj.view.page.ViewFpsMonitor

class RecyclerViewActivity: ComponentActivity() {
    private val mAdapter = RecyclerViewAdapter()
    private val viewModel by viewModels<ComposeListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun initView(){
        val tvFps = findViewById<TextView>(R.id.tv_fps)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        ViewFpsMonitor.startMonitor {
            tvFps.text = "Fps: $it"
        }
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val itemList = viewModel.produceItems()
        mAdapter.setFeedList(itemList)
    }

    override fun onDestroy() {
        super.onDestroy()
        ViewFpsMonitor.stopMonitor()
    }
}