package com.aulia.idn.newsapp.ui.home

import android.view.View
import com.aulia.idn.newsapp.R
import com.aulia.idn.newsapp.data.model.ArticleItem
import com.aulia.idn.newsapp.databinding.NewsItemViewBinding
import com.aulia.idn.newsapp.utils.loadImage
import com.xwray.groupie.viewbinding.BindableItem

class MainItem (
    private val article: ArticleItem,
    private val onClick: (ArticleItem) -> Unit
): BindableItem<NewsItemViewBinding>() {
    override fun bind(viewBinding: NewsItemViewBinding, position: Int) {
        //ambil data dri news
        viewBinding.apply {
            itemName.text = article.title
            itemImage.loadImage(article.urlToImage)
            itemDesc.text = article.description

            itemCard.setOnClickListener {
                onClick(article)
            }
        }
    }

    override fun getLayout(): Int = R.layout.news_item_view

    override fun initializeViewBinding(view: View): NewsItemViewBinding {
        return NewsItemViewBinding.bind(view)
    }

}