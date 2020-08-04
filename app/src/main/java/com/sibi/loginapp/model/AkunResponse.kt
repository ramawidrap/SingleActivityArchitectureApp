package com.sibi.loginapp.model


import com.google.gson.annotations.SerializedName

data class AkunResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: Akun
)