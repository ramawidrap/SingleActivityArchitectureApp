package com.sibi.loginapp.model


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<Product>
)