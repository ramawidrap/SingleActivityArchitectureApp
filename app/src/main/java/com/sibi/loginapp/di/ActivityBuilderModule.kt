package com.sibi.loginapp.di

import com.sibi.loginapp.ListProductActivity
import com.sibi.loginapp.MainActivity
import com.sibi.loginapp.fragment.ListProductFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMainActivity() : MainActivity

//    @ActivityScope
//    @ContributesAndroidInjector(modules = [ListProductFragment.ListProductModule::class])
//    abstract fun contributeListFragment() : ListProductFragment
}