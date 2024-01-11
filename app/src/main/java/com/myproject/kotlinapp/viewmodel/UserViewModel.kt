package com.myproject.kotlinapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myproject.kotlinapp.states.UserDataState
import com.myproject.kotlinapp.repository.UserDataRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserDataRepository) : ViewModel() {
    private val _userDataState = MutableLiveData<UserDataState>()
    val userDataState: LiveData<UserDataState> get() = _userDataState

    fun getPosts() {
        viewModelScope.launch {
            _userDataState.value = UserDataState.Loading
            try {
                val result = repository.getPost()
                _userDataState.value = UserDataState.Success(result)
            } catch (e: Exception) {
                _userDataState.value = UserDataState.Error(e)
            }
        }
    }
}
