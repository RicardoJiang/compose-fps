package com.zj.compose.fps.ui.page.list

import androidx.lifecycle.ViewModel

class ComposeListViewModel : ViewModel() {
    fun produceItems(): List<IFeedItem> {
        val products = ArrayList<IFeedItem>()
        val url = "https://pic2.zhimg.com/80/v2-b7f8e2a6554bad1f6fba6e2bc8e91230_720w.jpg?source=1940ef5c"
        products.add(
            BannerList(
                list = listOf(
                    BannerItem(
                        title = "PS5国行光驱版 现货 本地直发",
                        cover = url
                    ),
                    BannerItem(
                        title = "PS5国行光驱版 现货 本地直发",
                        cover = url
                    )
                )
            )
        )
        for (i in 1..100) {
            when {
                i % 5 == 0 -> {
                    products.add(
                        Video(
                            title = "PS5国行光驱版 现货 本地直发",
                            cover = url
                        )
                    )
                }
                i % 4 == 0 -> {
                    products.add(
                        MultiImage(
                            content = "PS5国行光驱版 现货 本地直发",
                            images = "${url},${url},${url}",
                            tag = Tag(
                                userAvatar = url,
                                userName = "ITHome",
                                tagName = "新闻"
                            ),
                            interaction = Interaction(3, 4),
                        )
                    )
                }
                else -> {
                    products.add(
                        Cover(
                            title = "PS5国行光驱版 现货 本地直发",
                            cover = url,
                            tag = Tag(
                                userAvatar = url,
                                userName = "ITHome",
                                tagName = "新闻"
                            ),
                            interaction = Interaction(3, 4),
                        )
                    )
                }
            }
        }
        return products
    }


}