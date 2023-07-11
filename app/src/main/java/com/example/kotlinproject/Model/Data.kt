package com.example.kotlinproject.Model

data class Data(
    val categoryId: Int,
    val description: String,
    val downloadStatus: Boolean,
    val likeStatus: Boolean,
    val subCategoryId: Int,
    val subscribeStatus: Boolean,
    val tag: String,
    val thumbNailUrl: String,
    val totalLikes: Int,
    val totalViews: Int,
    val uploadDate: String,
    val userId: Int,
    val userName: String,
    val userProfileUrl: String,
    val videoId: Int,
    val videoTitle: String,
    val videoType: String,
    val videoUrl: String
)