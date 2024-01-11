package com.myproject.kotlinapp.network

import com.myproject.kotlinapp.service.ApiRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConstant {
    const val BASE_URL = "https://api.publicapis.org/"
}

object RetrofitBuilder {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(NetworkConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

     val apiInterface: ApiRequest by lazy{
        retrofit.create(ApiRequest::class.java)
    }
}