package com.aldi.movienjam.di.main

import com.aldi.movienjam.di.main.favorite.FavoriteFragmentBuildersModule
import com.aldi.movienjam.ui.content.movie.MovieFragment
import com.aldi.movienjam.ui.content.tv.TvShowFragment
import com.aldi.movienjam.ui.favorite.FavoriteFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMovieFragment() : MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowFragment() : TvShowFragment

    @ContributesAndroidInjector(modules = [FavoriteFragmentBuildersModule::class])
    abstract fun contributeFavoriteFragment() : FavoriteFragment
}
