package com.sibi.loginapp.source

import androidx.paging.DataSource
import com.sibi.loginapp.model.Product
import javax.inject.Inject

class ListProductDataSourceFactory @Inject constructor(private val listProductDataSource: ListProductDataSource) :
    DataSource.Factory<Int,Product>() {
    override fun create(): DataSource<Int, Product> {
        return listProductDataSource
    }

}