package com.dicoding.projecttest.data

import com.google.gson.annotations.SerializedName

data class CustomerResponse(

	@field:SerializedName("data")
	val data: Data2? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)

data class DataItem(

	@field:SerializedName("cust_nib")
	val custNib: String? = null,

	@field:SerializedName("cust_ppoe_suspend_profile")
	val custPpoeSuspendProfile: String? = null,

	@field:SerializedName("mst_server_connection_id")
	val mstServerConnectionId: Int? = null,

	@field:SerializedName("cust_interface")
	val custInterface: Any? = null,

	@field:SerializedName("cust_address")
	val custAddress: String? = null,

	@field:SerializedName("cust_npwp")
	val custNpwp: String? = null,

	@field:SerializedName("customer_category")
	val customerCategory: CustomerCategory? = null,

	@field:SerializedName("cust_ppoe_profile")
	val custPpoeProfile: String? = null,

	@field:SerializedName("cust_phone_number")
	val custPhoneNumber: String? = null,

	@field:SerializedName("cust_ip_address")
	val custIpAddress: Any? = null,

	@field:SerializedName("cust_sales_uname")
	val custSalesUname: String? = null,

	@field:SerializedName("cust_code")
	val custCode: String? = null,

	@field:SerializedName("mst_city")
	val mstCity: MstCity? = null,

	@field:SerializedName("cust_category_id")
	val custCategoryId: Int? = null,

	@field:SerializedName("cust_email")
	val custEmail: String? = null,

	@field:SerializedName("cust_name")
	val custName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("cust_site")
	val custSite: String? = null,

	@field:SerializedName("cust_city")
	val custCity: String? = null
)

data class MstCity(

	@field:SerializedName("city_name")
	val cityName: String? = null,

	@field:SerializedName("city_code")
	val cityCode: String? = null
)

data class LinksItem(

	@field:SerializedName("active")
	val active: Boolean? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("url")
	val url: Any? = null
)

data class CustomerCategory(

	@field:SerializedName("category_name")
	val categoryName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Data2(

	@field:SerializedName("customers")
	val customers: Customers? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class Customers(

	@field:SerializedName("per_page")
	val perPage: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("last_page")
	val lastPage: Int? = null,

	@field:SerializedName("next_page_url")
	val nextPageUrl: String? = null,

	@field:SerializedName("total_customers")
	val totalCustomers: Int? = null,

	@field:SerializedName("prev_page_url")
	val prevPageUrl: Any? = null,

	@field:SerializedName("first_page_url")
	val firstPageUrl: String? = null,

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("last_page_url")
	val lastPageUrl: String? = null,

	@field:SerializedName("from")
	val from: Int? = null,

	@field:SerializedName("links")
	val links: List<LinksItem?>? = null,

	@field:SerializedName("to")
	val to: Int? = null,

	@field:SerializedName("current_page")
	val currentPage: Int? = null
)
