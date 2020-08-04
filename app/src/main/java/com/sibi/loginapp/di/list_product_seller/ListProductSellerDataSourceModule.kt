package com.sibi.loginapp.di.list_product_seller

import android.content.Context
import com.sibi.loginapp.fragment.MyProductFragment
import com.sibi.loginapp.source.ListProductSellerDataSource
import com.sibi.loginapp.source.network.ProductSellerService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ListProductSellerDataSourceModule {

    @Provides
    fun provideToken(frag : MyProductFragment) : String{
        val sharedPref = frag.requireActivity().getPreferences(Context.MODE_PRIVATE)
        val token = sharedPref.getString("token","")
        return token!!;
    }

    @Provides
    fun provideDataSource(listProductSellerService: ProductSellerService,token : String) : ListProductSellerDataSource {
        return ListProductSellerDataSource(listProductSellerService,token)
    }
}