package com.dicoding.projecttest.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.projecttest.data.LoginResponse
import com.dicoding.projecttest.data.Repository
import com.dicoding.projecttest.session.DataModel
import com.dicoding.projecttest.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class LoginViewModel(private var repository: Repository): ViewModel() {
    var loginResponse: SingleLiveEvent<LoginResponse?>? = repository.loginResponse

    fun login(email: String, password: String) {
        return repository.login(email, password)
    }

    fun saveSession(user: DataModel){
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }
}