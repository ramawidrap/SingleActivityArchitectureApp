package com.sibi.loginapp.di.list_product

import androidx.paging.PageKeyedDataSource
import com.sibi.loginapp.fragment.ListProductFragment
import com.sibi.loginapp.model.Kategori
import com.sibi.loginapp.model.Product
import com.sibi.loginapp.source.ListProductDataSource
import com.sibi.loginapp.source.network.ProductService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ListProductDataSourceModule{

    @Provides
    fun provideKategori(listProductFragment: ListProductFragment) : Kategori {
        println(listProductFragment.getCategoryID().nama)
        return listProductFragment.getCategoryID()
    }


    @Provides
    fun provideListProductDatasource(productService: ProductService, id : Kategori) : ListProductDataSource {
        return ListProductDataSource(productService,id)
    }


}