package com.myproject.kotlinapp.mysqlData.sqlViewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.myproject.kotlinapp.mysqlData.ControlState
import com.myproject.kotlinapp.mysqlData.GetDataUi
import com.myproject.kotlinapp.mysqlData.sqlRepository.SqlRepository
import kotlinx.coroutines.Dispatchers

class SqlViewModel(private val repository: SqlRepository): ViewModel() {

    fun login(username: String, password: String) = liveData(Dispatchers.IO) {
        emit(ControlState.Loading)
        try {
            val result = repository.userLogin(username, password)
            emit(ControlState.Success(result))
        } catch (e: Exception) {
            emit(ControlState.Error(e))
        }
    }

    fun register(username: String?, password: String?) = liveData(Dispatchers.IO) {
        emit(ControlState.Loading)
        try {
            val result = repository.userRegister(username, password)
            emit(ControlState.Success(result))
        } catch (e: Exception) {
            emit(ControlState.Error(e))
        }
    }

    fun getAllUserData() = liveData(Dispatchers.IO) {
        emit(GetDataUi.Loading)
        try {
            val result = repository.getAllUserData()
            emit(GetDataUi.Success(result))
        } catch (e: Exception) {
            emit(GetDataUi.Error(e))
        }
    }

    fun getLogin() = liveData(Dispatchers.IO){
        emit(ControlState.Loading)
        try {
            val result = repository.getLogin()
            emit(ControlState.Success(result!!))
        }catch (e: Exception){
            emit(ControlState.Error(e))
        }
    }


}