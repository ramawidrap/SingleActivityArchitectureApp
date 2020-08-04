package com.sibi.loginapp

import com.sibi.loginapp.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    val appComp = DaggerApplicationComponent.builder().getApp(this).build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().getApp(this).build()
    }

}