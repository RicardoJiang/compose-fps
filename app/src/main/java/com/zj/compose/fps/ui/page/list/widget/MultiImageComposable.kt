package com.zj.compose.fps.ui.page.list.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zj.compose.fps.ui.page.list.MultiImage

@Composable
fun MultiImageComposable(item: MultiImage) {
    HomeFeedHeader(item.tag)
    MultiImageSection(item = item)
}

@Composable
fun MultiImageSection(item: MultiImage) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Text(
            text = item.content,
            fontSize = 14.sp,
            maxLines = 5,
            modifier = Modifier.padding(end = 10.dp)
        )
        Row(
            Modifier
                .requiredHeight(140.dp)
                .padding(top = 10.dp)
                .fillMaxWidth()
        ) {
            item.images.split(",").take(3).forEachIndexed { index, item ->
                NetworkImage(
                    url = item,
                    modifier = Modifier.weight(0.3f),
                )
                if (index != 2) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
        //action bar
        HomeFeedActionBar(
            item.interaction.likeNum.toString(),
            item.interaction.replyNum.toString(),
            Modifier
                .padding(top = 10.dp, end = 10.dp)
                .align(Alignment.End)
        )
    }
}
