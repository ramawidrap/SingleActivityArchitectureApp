package com.sibi.loginapp.di

import com.sibi.loginapp.di.list_product.ListProductDataSourceModule
import com.sibi.loginapp.di.list_product.ListProductViewModelModule
import com.sibi.loginapp.di.list_product_seller.ListProductSellerDataSourceModule
import com.sibi.loginapp.di.list_product_seller.ListProductSellerViewModelModule
import com.sibi.loginapp.fragment.AkunFragment
import com.sibi.loginapp.fragment.ListProductFragment
import com.sibi.loginapp.fragment.LoginFragment
import com.sibi.loginapp.fragment.MyProductFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [LoginViewModelModule::class])
    abstract fun contributeLoginFragment() : LoginFragment

    @ContributesAndroidInjector(modules = [AkunViewModelModule::class])
    abstract fun contributeAkunFragment() : AkunFragment

    @ContributesAndroidInjector(modules = [ListProductViewModelModule::class, ListProductDataSourceModule::class])
    abstract fun contributeListProductFragment() : ListProductFragment

    @ContributesAndroidInjector(modules = [ListProductSellerDataSourceModule::class,ListProductSellerViewModelModule::class])
    abstract fun contributeListProductSellerFragment() : MyProductFragment

}