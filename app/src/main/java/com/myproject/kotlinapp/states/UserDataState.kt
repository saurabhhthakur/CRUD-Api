package com.myproject.kotlinapp.states

import com.myproject.kotlinapp.model.UserDataModel

sealed class UserDataState {
    data class Success(val userData: UserDataModel) : UserDataState()
    data class Error(val exception: Exception) : UserDataState()
    data object Loading : UserDataState()
}

