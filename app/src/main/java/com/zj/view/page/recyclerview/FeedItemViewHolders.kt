package com.zj.view.page.recyclerview

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.zj.compose.fps.R
import com.zj.compose.fps.ui.page.list.*


class CoverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val avatar = itemView.findViewById<ImageView>(R.id.iv_avatar)
    private val userName = itemView.findViewById<TextView>(R.id.tv_name)
    private val time = itemView.findViewById<TextView>(R.id.tv_time)
    private val tag = itemView.findViewById<TextView>(R.id.tv_tag)
    private val coverView = itemView.findViewById<ImageView>(R.id.iv_cover)
    private val titleView = itemView.findViewById<TextView>(R.id.tv_title)

    @SuppressLint("SetTextI18n")
    fun setCover(item: Cover) {
        Glide.with(itemView.context).load(item.tag.userAvatar).into(avatar)
        Glide.with(itemView.context).load(item.cover).into(coverView)
        titleView.text = item.title
        userName.text = item.tag.userName
        time.text = "3天前"
        tag.text = item.tag.tagName + "┃"
    }
}

class BannerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val banner =
        itemView.findViewById<Banner<BannerItem, BannerImageAdapter<BannerItem>>>(R.id.banner)

    fun setBanner(item: BannerList) {
        banner.setAdapter(object : BannerImageAdapter<BannerItem>(item.list) {
            override fun onBindView(
                holder: BannerImageHolder,
                data: BannerItem,
                position: Int,
                size: Int
            ) {
                //图片加载自己实现
                Glide.with(holder.itemView)
                    .load(data.cover)
                    .into(holder.imageView)
            }
        })
    }
}

class MultiImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val avatar = itemView.findViewById<ImageView>(R.id.iv_avatar)
    private val userName = itemView.findViewById<TextView>(R.id.tv_name)
    private val time = itemView.findViewById<TextView>(R.id.tv_time)
    private val tag = itemView.findViewById<TextView>(R.id.tv_tag)
    private val ivOne = itemView.findViewById<ImageView>(R.id.iv_one)
    private val ivTwo = itemView.findViewById<ImageView>(R.id.iv_two)
    private val ivThree = itemView.findViewById<ImageView>(R.id.iv_three)

    @SuppressLint("SetTextI18n")
    fun setMultiImage(item: MultiImage) {
        Glide.with(itemView.context).load(item.tag.userAvatar).into(avatar)
        userName.text = item.tag.userName
        time.text = "3天前"
        tag.text = item.tag.tagName + "┃"
        val urlList = item.images.split(",")
        Glide.with(itemView.context).load(urlList[0]).into(ivOne)
        Glide.with(itemView.context).load(urlList[1]).into(ivTwo)
        Glide.with(itemView.context).load(urlList[2]).into(ivThree)
    }
}

class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleView = itemView.findViewById<TextView>(R.id.tv_title)
    private val coverView = itemView.findViewById<ImageView>(R.id.iv_cover)

    fun setVideo(item: Video) {
        titleView.text = item.title
        Glide.with(itemView.context).load(item.cover).into(coverView)
    }
}