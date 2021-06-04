package com.aldi.movienjam.di

import android.app.Application
import com.aldi.movienjam.data.MovienjamRepository
import com.aldi.movienjam.data.source.local.LocalDataSource
import com.aldi.movienjam.data.source.local.room.MovienjamDao
import com.aldi.movienjam.data.source.local.room.MovienjamDatabase
import com.aldi.movienjam.data.source.remote.RemoteDataSource
import com.aldi.movienjam.data.source.remote.api.ApiService

import com.aldi.movienjam.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideCatalogDatabase(application: Application): MovienjamDatabase =
            MovienjamDatabase.getInstance(application)

        @Singleton
        @Provides
        fun provideCatalogDao(movienjamDatabase: MovienjamDatabase): MovienjamDao =
            movienjamDatabase.movienjamDao()

        @Singleton
        @Provides
        fun provideLocalDataSource(movienjamDao: MovienjamDao): LocalDataSource =
            LocalDataSource(movienjamDao)

        @Singleton
        @Provides
        fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
            RemoteDataSource(apiService)

        @Singleton
        @Provides
        fun provideCatalogRepository(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource
        ): MovienjamRepository = MovienjamRepository(remoteDataSource, localDataSource)

        @Singleton
        @Provides
        fun provideViewModelFactory(movienjamRepository: MovienjamRepository): ViewModelFactory =
            ViewModelFactory(movienjamRepository)

    }
}