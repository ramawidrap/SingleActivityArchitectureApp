package com.sibi.loginapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sibi.loginapp.source.repository.LoginRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(val loginRepository: LoginRepository) : ViewModel() {
    val email =MutableLiveData<String>()
    val password = MutableLiveData<String>()


    fun loginUser(){
        println("CLICK")
        loginRepository.loginUser(email.value!!,password.value!!)

    }

    fun getError() : LiveData<Throwable> {
        return loginRepository.error
    }

    fun clear() {
        loginRepository.dispose()
    }
    fun getToken() : LiveData<String> {
        return loginRepository.token
    }

}