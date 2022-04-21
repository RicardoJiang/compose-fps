package com.zj.compose.fps.ui.page.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.zj.compose.fps.ui.page.list.widget.CoverComposable
import com.zj.compose.fps.ui.page.list.widget.HomeBannerComposable
import com.zj.compose.fps.ui.page.list.widget.MultiImageComposable
import com.zj.compose.fps.ui.page.list.widget.VideoComposable

@Composable
fun ComposeList(){
    val viewModel = ComposeListViewModel()
    LazyColumn(
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            bottom = 10.dp,
            top = 10.dp
        )
    ) {
        items(viewModel.produceItems()) {
            when(it){
                is Cover -> CoverComposable(item = it)
                is BannerList -> HomeBannerComposable(item = it)
                is MultiImage -> MultiImageComposable(item = it)
                is Video -> VideoComposable(item = it)
            }
        }
    }
}