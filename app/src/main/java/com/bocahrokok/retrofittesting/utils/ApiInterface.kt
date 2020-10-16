package com.bocahrokok.retrofittesting.utils


import com.bocahrokok.retrofittesting.model.PostModel
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Query

interface ApiInterface {

    @GET("/posts")
    suspend fun getPost(): Response<List<PostModel>>

//    @GET("posts")
//    suspend fun getQuery(@Query("dog")): Response<>


}