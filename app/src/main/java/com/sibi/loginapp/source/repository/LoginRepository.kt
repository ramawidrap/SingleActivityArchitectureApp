package com.sibi.loginapp.source.repository

import androidx.lifecycle.MutableLiveData
import com.sibi.loginapp.source.network.LoginService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginRepository @Inject constructor(val loginService: LoginService) {
    val token = MutableLiveData<String>();
    private val compositeDisposable = CompositeDisposable()
    val error = MutableLiveData<Throwable>()

    fun loginUser(email :String,password:String) {
        compositeDisposable.add(loginService.loginUser(email,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            token.postValue(it.result.token)
        })
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}
