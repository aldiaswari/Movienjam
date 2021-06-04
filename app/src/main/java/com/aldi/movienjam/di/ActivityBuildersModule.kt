package com.aldi.movienjam.di

import com.aldi.movienjam.di.main.MainActivityBuildersModule
import com.aldi.movienjam.ui.detail.DetailActivity
import com.aldi.movienjam.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [MainActivityBuildersModule::class])
    abstract fun contributeHomeActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity

}