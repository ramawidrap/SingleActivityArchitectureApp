package com.sibi.loginapp.source

import androidx.paging.DataSource
import com.sibi.loginapp.model.Product
import javax.inject.Inject


class ListProductSellerDataSourceFactory @Inject constructor(private val listProductSellerDataSource: ListProductSellerDataSource) : DataSource.Factory<Int, Product>() {
    override fun create(): DataSource<Int, Product> {
        return listProductSellerDataSource
    }

}