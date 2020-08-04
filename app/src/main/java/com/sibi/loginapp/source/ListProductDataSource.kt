package com.sibi.loginapp.source

import android.annotation.SuppressLint
import androidx.paging.PageKeyedDataSource
import com.sibi.loginapp.model.Kategori
import com.sibi.loginapp.model.Product
import com.sibi.loginapp.source.network.ProductService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListProductDataSource (private  val productService: ProductService,val category: Kategori) : PageKeyedDataSource<Int, Product>(){

    @SuppressLint("CheckResult")
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Product>
    ) {
        println(category.categoryId)
        productService.getListProduct(10,1,category.categoryId).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe {
            callback.onResult(it.result,null,2)
            Consumer<Throwable> {
                println("FAILED")
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Product>) {
        productService.getListProduct(10,params.key,category.categoryId).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe {
            callback.onResult(it.result,params.key+1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Product>) {
    }
}