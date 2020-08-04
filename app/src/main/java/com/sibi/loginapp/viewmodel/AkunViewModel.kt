package com.sibi.loginapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sibi.loginapp.model.Akun
import com.sibi.loginapp.source.repository.AkunRepository
import javax.inject.Inject

class AkunViewModel @Inject constructor(val akunRepository: AkunRepository) : ViewModel() {

    fun getUser(token : String) : LiveData<Akun> {
        akunRepository.getAkun(token)
        return akunRepository.akunMutableLivaData
    }
}