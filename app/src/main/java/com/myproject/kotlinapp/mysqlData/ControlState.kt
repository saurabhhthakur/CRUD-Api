package com.myproject.kotlinapp.mysqlData

sealed class ControlState {
    data class Success(val detail:SqlModel) : ControlState()
    data class Error(val exception: Exception) : ControlState()
    data object Loading : ControlState()
}

sealed class GetDataUi {
    data class Success(val allDataModel: AllDataModel) : GetDataUi()
    data class Error(val exception: Exception) : GetDataUi()
    data object Loading : GetDataUi()
}