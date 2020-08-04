package com.sibi.loginapp.di.list_product_seller

import androidx.lifecycle.ViewModel
import com.sibi.loginapp.di.ViewModelKey
import com.sibi.loginapp.viewmodel.ListProductSellerViewModel
import com.sibi.loginapp.viewmodel.ListProductViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListProductSellerViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ListProductSellerViewModel::class)
    abstract fun bindListProductViewModel(listProductViewModel: ListProductSellerViewModel) : ViewModel
}