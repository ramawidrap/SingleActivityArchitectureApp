package com.sibi.loginapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sibi.loginapp.model.Product
import com.sibi.loginapp.source.ListProductSellerDataSource
import com.sibi.loginapp.source.ListProductSellerDataSourceFactory
import javax.inject.Inject

class ListProductSellerViewModel @Inject constructor(private val listProductSellerDataSourceFactory: ListProductSellerDataSourceFactory) : ViewModel() {
    private val  pagedList = PagedList.Config.Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(10).setPageSize(10).build()

    fun getList() : LiveData<PagedList<Product>> {
        return LivePagedListBuilder(listProductSellerDataSourceFactory,pagedList).build()
    }
}