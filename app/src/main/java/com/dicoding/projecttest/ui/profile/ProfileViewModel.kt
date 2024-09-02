package com.dicoding.projecttest.ui.profile

import androidx.lifecycle.ViewModel
import com.dicoding.projecttest.data.Data
import com.dicoding.projecttest.data.DataUser
import com.dicoding.projecttest.data.LoginResponse
import com.dicoding.projecttest.data.Repository
import com.dicoding.projecttest.utils.SingleLiveEvent

class ProfileViewModel(private var repository: Repository) : ViewModel() {
    var dataUser: SingleLiveEvent<LoginResponse?>? = repository.dataUser

    fun detailUser(id: Int){
        return repository.detailUser(id)
    }

    fun getId(){
        return repository.getSession()
    }
}