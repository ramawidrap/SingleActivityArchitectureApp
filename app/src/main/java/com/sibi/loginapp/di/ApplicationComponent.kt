package com.sibi.loginapp.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.sibi.loginapp.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,ApplicationModule::class,ActivityBuilderModule::class,ViewModelFactoryModule::class])
interface ApplicationComponent : AndroidInjector<App> {


    @Component.Builder
    interface  Builder {
        @BindsInstance
        fun getApp(context : Context) :Builder

//        @BindsInstance
//        fun listProdModule(listProductViewModelModule: ListProductViewModelModule) : Builder
//
//        @BindsInstance
//        fun dataSourceModule(listProductDataSourceModule: ListProductDataSourceModule) : Builder

        fun build() : ApplicationComponent
    }

}