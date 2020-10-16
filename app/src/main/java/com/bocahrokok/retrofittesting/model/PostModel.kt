package com.bocahrokok.retrofittesting.model


import com.google.gson.annotations.SerializedName

data class PostModel(
    @SerializedName("body")
    val body: String,
    val id: Int,
    @SerializedName("title")
    val title: String,
    val userId: Int
)