package com.sibi.loginapp.source.network

import com.sibi.loginapp.model.ProductResponse
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ProductService {
    @GET("api/products")
    fun getListProduct(@Query("limit") limit : Int = 10,@Query("page") page : Int, @Query("category") category:String = "category-1") : Observable<ProductResponse>

}