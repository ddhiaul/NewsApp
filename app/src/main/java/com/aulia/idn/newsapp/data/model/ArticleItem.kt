package com.aulia.idn.newsapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleItem(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceItem,
    val title: String,
    val url: String? = null,
    val urlToImage: String
): Parcelable