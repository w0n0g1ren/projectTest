package com.dicoding.projecttest.data

import android.content.Context
import com.dicoding.projecttest.session.SessionPreference
import com.dicoding.projecttest.session.datastore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): Repository = runBlocking  {
        val pref = SessionPreference.getInstance(context.datastore)
        val token = runBlocking { pref.getToken().first() }
        val apiService = ApiConfig.getApiService(token.token)
        Repository.getInstance(apiService, pref)
    }
}