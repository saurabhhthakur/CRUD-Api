package com.myproject.kotlinapp.mysqlData.sqlRepository

import com.myproject.kotlinapp.mysqlData.AllDataModel
import com.myproject.kotlinapp.mysqlData.SqlModel
import com.myproject.kotlinapp.mysqlData.interfaceSql.ApiInterfaceSql

class SqlRepository(private val apiInterfaceSql: ApiInterfaceSql) {

    suspend fun userLogin(username:String?,password:String?): SqlModel {
        return apiInterfaceSql.login(username, password).body() ?: throw Exception("SomeThing error login")
    }

    suspend fun userRegister(username:String?,password:String?): SqlModel{
        return apiInterfaceSql.register(username, password).body() ?: throw Exception("SomeThing error register")
    }

    suspend fun getAllUserData(): AllDataModel{
        return apiInterfaceSql.getAllData().body() ?: throw Exception("Data Not Found")
    }

    suspend fun getLogin(): SqlModel{
        return apiInterfaceSql.getLogin().body() ?: throw Exception("some error")
    }
}