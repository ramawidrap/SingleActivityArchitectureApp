package com.sibi.loginapp.di

import androidx.lifecycle.ViewModel
import com.sibi.loginapp.viewmodel.ListProductViewModel
import com.sibi.loginapp.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract  class LoginViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel) : ViewModel


}

