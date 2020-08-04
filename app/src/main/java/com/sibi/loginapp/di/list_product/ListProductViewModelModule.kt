package com.sibi.loginapp.di.list_product

import androidx.lifecycle.ViewModel
import androidx.paging.PageKeyedDataSource
import com.sibi.loginapp.di.ViewModelKey
import com.sibi.loginapp.model.Product
import com.sibi.loginapp.source.ListProductDataSource
import com.sibi.loginapp.viewmodel.ListProductViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListProductViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListProductViewModel::class)
    abstract fun bindListProductViewModel(listProductViewModel: ListProductViewModel) : ViewModel

}