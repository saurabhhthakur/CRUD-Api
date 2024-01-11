package com.myproject.kotlinapp.mysqlData.interfaceSql

import com.myproject.kotlinapp.mysqlData.AllDataModel
import com.myproject.kotlinapp.mysqlData.SqlModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterfaceSql {

    @POST("login")
    @FormUrlEncoded
    suspend fun login(
        @Field("username") username: String?,
        @Field("password") password: String?
    ): Response<SqlModel>

    @POST("register")
    @FormUrlEncoded
    suspend fun register(
        @Field("username") username: String?,
        @Field("password") password: String?
    ): Response<SqlModel>


    @POST("getLogin")
    suspend fun getLogin(): Response<SqlModel>

    @POST("allData")
    suspend fun getAllData(): Response<AllDataModel>

}