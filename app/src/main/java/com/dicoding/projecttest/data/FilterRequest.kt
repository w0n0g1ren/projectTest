package com.dicoding.projecttest.data

import retrofit2.http.Field
import retrofit2.http.Query

data class FilterM(
    val filter: FilterRequest
)
data class FilterRequest(
    val search: String = "",
    val city_code: String = "",
    val  category_id: String = "")