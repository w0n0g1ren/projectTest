package com.dicoding.projecttest.ui.costumer

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.projecttest.data.CustomerResponse
import com.dicoding.projecttest.data.Repository

class CustomerViewModel(private var repository: Repository) : ViewModel() {
    var customerResponse: LiveData<CustomerResponse?>? = repository.customerResponse

    fun getAllCostumer(username:String) {
        return repository.getAllCustomer(username)
    }
}