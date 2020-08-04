package com.sibi.loginapp.source.network

import com.sibi.loginapp.model.AkunResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface AkunService {

    @GET("api/users")
    fun getAkun(@Header("Authorization") header : String) : Observable<AkunResponse>
}