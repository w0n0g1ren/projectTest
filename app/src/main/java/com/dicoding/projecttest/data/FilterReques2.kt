package com.dicoding.projecttest.data

data class FilterM2(
    val filter: FilterRequest2
)
data class FilterRequest2(
    val search: String = "",
    val status: String = "",
    val  month: String = "",
    val  year: String = "")