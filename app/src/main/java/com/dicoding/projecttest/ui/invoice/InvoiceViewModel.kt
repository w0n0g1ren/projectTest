package com.dicoding.projecttest.ui.invoice

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.projecttest.data.CustomerResponse
import com.dicoding.projecttest.data.InvoiceResponse
import com.dicoding.projecttest.data.Repository

class InvoiceViewModel(private var repository: Repository) : ViewModel() {
    var invoiceResponse: LiveData<InvoiceResponse?>? = repository.invoiceResponse
    var customerResponse: LiveData<CustomerResponse?>? = repository.customerResponse

    fun getAllInvoice(username: String){
        return repository.getAllInvoice(username)
    }
}