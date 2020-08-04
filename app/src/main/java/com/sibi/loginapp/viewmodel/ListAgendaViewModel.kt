package com.sibi.loginapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sibi.loginapp.model.Agenda
import com.sibi.loginapp.source.ListAgendaDataSourceFactory
import javax.inject.Inject

class ListAgendaViewModel @Inject constructor(private val listAgendaDataSourceFactory: ListAgendaDataSourceFactory) : ViewModel() {
    private val  pagedList = PagedList.Config.Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(10).setPageSize(10).build()

    fun getAgenda() : LiveData<PagedList<Agenda>> {
        return LivePagedListBuilder(listAgendaDataSourceFactory,pagedList).build()
    }
}