package com.sibi.loginapp.source

import androidx.paging.DataSource
import com.sibi.loginapp.model.Agenda
import javax.inject.Inject

class ListAgendaDataSourceFactory @Inject constructor(private val listAgendaDataSource: ListAgendaDataSource) : DataSource.Factory<Int, Agenda>() {
    override fun create(): DataSource<Int, Agenda> {
        return listAgendaDataSource
    }

}