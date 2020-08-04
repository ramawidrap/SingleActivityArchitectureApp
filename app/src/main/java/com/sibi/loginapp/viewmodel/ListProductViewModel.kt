package com.sibi.loginapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sibi.loginapp.model.Product
import com.sibi.loginapp.source.ListProductDataSourceFactory
import javax.inject.Inject

class ListProductViewModel @Inject constructor(private val dataSourceFactory: ListProductDataSourceFactory) : ViewModel() {

    private val  pagedList = PagedList.Config.Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(10).setPageSize(10).build()


    fun getList() : LiveData<PagedList<Product>> {
        println("get list");
        return LivePagedListBuilder(dataSourceFactory,pagedList).build()
    }

}