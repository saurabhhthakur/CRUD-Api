package com.myproject.kotlinapp.service

import com.myproject.kotlinapp.model.UserDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiRequest {
    @GET("entries")
    suspend fun getData(): Response<UserDataModel>
}