package com.sibi.loginapp.model


import com.google.gson.annotations.SerializedName

data class ListAgendaResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<Agenda>
)