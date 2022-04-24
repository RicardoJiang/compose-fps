package com.zj.view.page.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zj.compose.fps.R
import com.zj.compose.fps.ui.page.list.*


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var list: List<IFeedItem> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setFeedList(list: List<IFeedItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FeedItemType.Cover.type -> {
                CoverViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_feed_cover, parent, false)
                )
            }
            FeedItemType.BannerList.type -> {
                BannerListViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_feed_banner_list, parent, false)
                )
            }
            FeedItemType.MultiImage.type -> {
                MultiImageViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_feed_multi_image, parent, false)
                )
            }
            else -> {
                VideoViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_feed_video, parent, false)
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (holder) {
            is CoverViewHolder -> holder.setCover(item as Cover)
            is BannerListViewHolder -> holder.setBanner(item as BannerList)
            is MultiImageViewHolder -> holder.setMultiImage(item as MultiImage)
            is VideoViewHolder -> holder.setVideo(item as Video)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Cover -> FeedItemType.Cover.type
            is BannerList -> FeedItemType.BannerList.type
            is MultiImage -> FeedItemType.MultiImage.type
            else -> FeedItemType.Video.type
        }
    }
}