package com.bocahrokok.retrofittesting.utils

import android.util.Log
import com.bocahrokok.retrofittesting.model.PostModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class RetrofitInstance {

    companion object RetroInstance {
            val BASE_URL = "https://jsonplaceholder.typicode.com"

            val Api = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)

    }
}