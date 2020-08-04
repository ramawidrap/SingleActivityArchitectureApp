package com.sibi.loginapp.source

import androidx.paging.PageKeyedDataSource
import com.sibi.loginapp.model.Product
import com.sibi.loginapp.source.network.ProductSellerService
import com.sibi.loginapp.source.network.ProductService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListProductSellerDataSource @Inject constructor(private val listProductService: ProductSellerService,private val token:String) : PageKeyedDataSource<Int, Product>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Product>
    ) {
        listProductService.getProductSeller("Bearer $token",1).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe {
            callback.onResult(it.result,null,2);
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Product>) {
        listProductService.getProductSeller("Bearer $token",params.key).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe {
            callback.onResult(it.result,params.key+1);
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Product>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}