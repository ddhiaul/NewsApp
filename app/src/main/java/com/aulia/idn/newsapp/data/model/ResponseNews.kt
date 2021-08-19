package com.aulia.idn.newsapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseNews(
    val articles: List<ArticleItem>,
    val status: String,
    val totalResults: Int
): Parcelable