package com.dicoding.projecttest.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.projecttest.data.Injection
import com.dicoding.projecttest.data.Repository
import com.dicoding.projecttest.ui.costumer.CustomerViewModel
import com.dicoding.projecttest.ui.invoice.InvoiceViewModel
import com.dicoding.projecttest.ui.login.LoginViewModel
import com.dicoding.projecttest.ui.profile.ProfileViewModel

class ViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(repository) as T
            }
            modelClass.isAssignableFrom(InvoiceViewModel::class.java) ->{
                InvoiceViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CustomerViewModel::class.java) ->{
                CustomerViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }

        fun clearInstance() {
            Repository.clearInstance()
            INSTANCE = null
        }
    }
}