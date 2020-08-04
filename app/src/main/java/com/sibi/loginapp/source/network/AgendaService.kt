package com.sibi.loginapp.source.network

import com.sibi.loginapp.model.ListAgendaResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface AgendaService {
    @GET("api/agenda")
    fun getAgenda(@Query("page") page : Int) : Observable<ListAgendaResponse>
}