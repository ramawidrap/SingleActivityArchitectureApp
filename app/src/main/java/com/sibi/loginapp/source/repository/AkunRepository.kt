package com.sibi.loginapp.source.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.sibi.loginapp.model.Akun
import com.sibi.loginapp.source.network.AkunService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AkunRepository @Inject constructor(private val akunService: AkunService) {
    val akunMutableLivaData = MutableLiveData<Akun>()

    @SuppressLint("CheckResult")
    fun getAkun(token : String) {
        akunService.getAkun("Bearer $token").observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe {
            akunMutableLivaData.postValue(it.result)
            Consumer<Throwable>() {
               println(it.message)
            }
        }
    }
}