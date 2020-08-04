package com.sibi.loginapp

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message:String,

    @SerializedName("result")
    val result:Result
)

data class Result(
    @SerializedName("access_token")
    val token:String
)