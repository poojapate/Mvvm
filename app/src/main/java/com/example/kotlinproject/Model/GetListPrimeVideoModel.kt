package com.example.kotlinproject.Model

data class GetListPrimeVideoModel(
    val `data`: List<DataXX>,
    val message: String,
    val result: Boolean,
    val totalVideos: Int
)