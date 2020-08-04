package com.sibi.loginapp.model


import com.google.gson.annotations.SerializedName

data class Agenda(
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("location")
    val location: String,
    @SerializedName("title")
    val title: String
)