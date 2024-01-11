package com.myproject.kotlinapp.mysqlData

import com.myproject.kotlinapp.mysqlData.interfaceSql.ApiInterfaceSql
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val base_url = "http://192.168.29.93/dashboard/index.php/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiInterfaceSql by lazy {
       retrofit.create(ApiInterfaceSql::class.java)
    }
}