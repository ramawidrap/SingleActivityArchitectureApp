package com.sibi.loginapp.source.network

import com.sibi.loginapp.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface LoginService {

    @POST("api/auth/login")
    @FormUrlEncoded
    fun loginUser(@Field("email") email:String,@Field("password") password:String) : Observable<LoginResponse>
}