package com.sibi.loginapp.di

import androidx.lifecycle.ViewModel
import com.sibi.loginapp.viewmodel.AkunViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AkunViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AkunViewModel::class)
    abstract fun bindAkunViewModel(akunViewModel: AkunViewModel) : ViewModel

}