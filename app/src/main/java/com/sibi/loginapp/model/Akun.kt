package com.sibi.loginapp.model


import com.google.gson.annotations.SerializedName

data class Akun(
    @SerializedName("email")
    val email: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("user_id")
    val userId: String
)