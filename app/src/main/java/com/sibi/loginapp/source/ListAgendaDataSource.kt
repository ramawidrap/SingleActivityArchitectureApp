package com.sibi.loginapp.source

import androidx.paging.PageKeyedDataSource
import com.sibi.loginapp.model.Agenda
import com.sibi.loginapp.source.network.AgendaService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListAgendaDataSource @Inject constructor(private val agendaService: AgendaService) : PageKeyedDataSource<Int, Agenda>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Agenda>
    ) {
        agendaService.getAgenda(1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            callback.onResult(it.result,null,2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Agenda>) {
        agendaService.getAgenda(params.key).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            callback.onResult(it.result,params.key+1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Agenda>) {
    }

}