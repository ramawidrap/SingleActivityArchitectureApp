package com.sibi.loginapp.di

import android.app.Application
import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.sibi.loginapp.model.Akun
import com.sibi.loginapp.source.network.AkunService
import com.sibi.loginapp.source.network.LoginService
import com.sibi.loginapp.source.network.ProductSellerService
import com.sibi.loginapp.source.network.ProductService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module()
class ApplicationModule {

    companion object {
        const val BASE_URL =
            "http://a25254162fa2c4357a634b58e7ae86d1-e9b67027acef191a.elb.ap-southeast-1.amazonaws.com"
    }

    @Singleton
    @Provides
    fun getRetrofitModule(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun LoginService(retrofit: Retrofit) : LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Singleton
    @Provides
    fun ProductServiceModule(retrofit: Retrofit) : ProductService {
        return retrofit.create(ProductService::class.java)
    }

    @Singleton
    @Provides
    fun akunServiceModule(retrofit: Retrofit) : AkunService {
        return retrofit.create(AkunService::class.java)
    }

    @Singleton
    @Provides
    fun productSellerModule(retrofit: Retrofit) : ProductSellerService {
        return retrofit.create(ProductSellerService::class.java)
    }



}