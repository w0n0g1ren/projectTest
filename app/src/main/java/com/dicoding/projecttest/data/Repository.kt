package com.dicoding.projecttest.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.projecttest.session.DataModel
import com.dicoding.projecttest.session.SessionPreference
import com.dicoding.projecttest.utils.SingleLiveEvent
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Filter

class Repository(
    private val apiService: ApiService,
    private val sessionPreference: SessionPreference)

{
    private var _loginResponse = SingleLiveEvent<LoginResponse?>()
    var loginResponse: SingleLiveEvent<LoginResponse?>? = _loginResponse

    private var _dataUser = SingleLiveEvent<LoginResponse?>()
    var dataUser: SingleLiveEvent<LoginResponse?>? = _dataUser

    private var _customerResponse = MutableLiveData<CustomerResponse?>()
    var customerResponse: LiveData<CustomerResponse?>? = _customerResponse

    private var _invoiceResponse = MutableLiveData<InvoiceResponse?>()
    var invoiceResponse: LiveData<InvoiceResponse?>? = _invoiceResponse

    private var filterM = FilterM(FilterRequest("","",""))
    private var filterM2 = FilterM2(FilterRequest2("","","",""))
    fun login(email: String, password: String) {

        val client = apiService.login(email, password)
        client.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) { if (response.isSuccessful) {
                val responseBody = response.body()
                if(responseBody != null){
                    _loginResponse.value = response.body()
                }
            }
            else{
                val errorResponse = Gson().fromJson(response.errorBody()?.string(),
                    LoginResponse::class.java)
                _loginResponse.value = errorResponse
            }

            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun detailUser(id: Int){
        val client = apiService.detailUser(id)
        client.enqueue(object : Callback<LoginResponse?>{
            override fun onResponse(call: Call<LoginResponse?>, response: Response<LoginResponse?>) {
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null){
                        _dataUser.value = response.body()
                    }
                    else{
                        val errorResponse = Gson().fromJson(response.errorBody()?.string(),
                            LoginResponse::class.java)
                        _dataUser.value = errorResponse
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }

    fun getAllCustomer(username: String){
        val gson = Gson()
        val requestBody2 = RequestBody.create(
            "application/json".toMediaTypeOrNull(), gson.toJson(
            mapOf(
                "sort_by" to "",
                "order_by" to "",
                "limit" to 10,
                "sales_uname" to "$username",
                "filter" to filterM.filter
            )
        ))

        val client = apiService.getAllCustomer(requestBody2)
        client.enqueue(object : Callback<CustomerResponse>{
            override fun onResponse(
                call: Call<CustomerResponse>,
                response: Response<CustomerResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null){
                        _customerResponse.value = response.body()
                    }
                    else{
                        val errorResponse = Gson().fromJson(response.errorBody()?.string(),
                            CustomerResponse::class.java)
                        _customerResponse.value = errorResponse
                    }
                }
            }

            override fun onFailure(call: Call<CustomerResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun getAllInvoice(username: String){
        val gson = Gson()
        val requestBody3 = RequestBody.create(
            "application/json".toMediaTypeOrNull(), gson.toJson(
                mapOf(
                    "sales_uname" to "$username",
                    "sort_by" to "",
                    "order_by" to "",
                    "limit" to 10,
                    "filter" to filterM2.filter
                )
            ))
        val client = apiService.getAllInvoice(requestBody3)
        client.enqueue(object : Callback<InvoiceResponse>{
            override fun onResponse(
                call: Call<InvoiceResponse>,
                response: Response<InvoiceResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null){
                        _invoiceResponse.value = response.body()
                        Log.e("cekkesekian",responseBody.meta?.message.toString())
                    }
                    else{
                        val errorResponse = Gson().fromJson(response.errorBody()?.string(),
                            InvoiceResponse::class.java)
                        _invoiceResponse.value = errorResponse
                    }
                }
            }

            override fun onFailure(call: Call<InvoiceResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }

    suspend fun saveSession(user: DataModel) {
        sessionPreference.saveSessionSetting(user)
    }
    fun getSession() {
        sessionPreference.getToken()
    }


    companion object {
        @Volatile
        private var instance: Repository? = null
        private const val TAG = "AppRepository"
        fun getInstance(
            apiService: ApiService,
            sessionPreference: SessionPreference
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(apiService, sessionPreference)
            }.also { instance = it }

        fun clearInstance() {
            instance = null
        }
    }
}