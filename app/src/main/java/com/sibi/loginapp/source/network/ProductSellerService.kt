package com.sibi.loginapp.source.network

import com.sibi.loginapp.model.ProductResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.util.*

interface ProductSellerService {
    @GET("api/shop/products")
    fun getProductSeller(@Header("Authorization") header : String,@Query("page") page : Int) : Observable<ProductResponse>

}