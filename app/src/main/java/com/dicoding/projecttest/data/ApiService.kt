package com.dicoding.projecttest.data

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @FormUrlEncoded
    @POST("api/sales/account/login")
    fun login(
        @Field("username") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @POST("api/sales/account/detail_profile")
    fun detailUser(
        @Query("user_id") id: Int
    ): Call<LoginResponse>

    @POST("api/sales/master/get_customers")
    fun getAllCustomer(
        @Body requestBody: RequestBody
    ) : Call<CustomerResponse>

    @POST("api/sales/transaction/invoice/list_invoices")
    fun getAllInvoice(
        @Body requestBody: RequestBody
    ) : Call<InvoiceResponse>

}
