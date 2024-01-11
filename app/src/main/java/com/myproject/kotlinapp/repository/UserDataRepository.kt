package com.myproject.kotlinapp.repository

import com.myproject.kotlinapp.model.UserDataModel
import com.myproject.kotlinapp.network.NetworkConstant
import com.myproject.kotlinapp.service.ApiRequest

class UserDataRepository(private val apiRequest: ApiRequest) {
    suspend fun getPost(): UserDataModel {
        return apiRequest.getData().body() ?: throw Exception("Data not available")
    }
}