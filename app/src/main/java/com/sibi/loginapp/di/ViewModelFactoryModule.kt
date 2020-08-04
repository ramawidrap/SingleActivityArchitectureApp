package com.sibi.loginapp.di

import androidx.lifecycle.ViewModelProvider
import com.sibi.loginapp.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindsViewModelFactory(factory : ViewModelFactory) : ViewModelProvider.Factory
}