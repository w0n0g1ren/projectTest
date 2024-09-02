package com.dicoding.projecttest.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)

data class DataUser(

	@field:SerializedName("is_active")
	val isActive: String? = null,

	@field:SerializedName("udt")
	val udt: String? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("token")
	val token: Any? = null,

	@field:SerializedName("uid")
	val uid: Any? = null,

	@field:SerializedName("cdt")
	val cdt: String? = null,

	@field:SerializedName("group_id")
	val groupId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("dept_id")
	val deptId: Any? = null,

	@field:SerializedName("email")
	val email: Any? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("position_id")
	val positionId: Any? = null,

	@field:SerializedName("cid")
	val cid: Int? = null
)

data class Meta(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Data(

	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@field:SerializedName("data_user")
	val dataUser: DataUser? = null,

	@field:SerializedName("user_device_id")
	val userDeviceId: Any? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("token_type")
	val tokenType: String? = null
)
