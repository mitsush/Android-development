package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val id: Int,
    val title: String,
    val content: String,
    val imageUrl: String,
    var isLiked: Boolean = false,
    var likeCount: Int = 0
) : Parcelable