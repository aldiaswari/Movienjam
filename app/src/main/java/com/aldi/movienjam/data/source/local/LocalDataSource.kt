package com.aldi.movienjam.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import com.aldi.movienjam.data.source.local.room.MovienjamDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val movienjamDao: MovienjamDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movienjamDaoo: MovienjamDao): LocalDataSource {
            return INSTANCE ?: LocalDataSource(movienjamDaoo)
        }
    }


    fun getListMovies(): DataSource.Factory<Int, MovieEntity> = movienjamDao.getListMovies()

    fun getListFavoriteMovies(): DataSource.Factory<Int, MovieEntity> =
        movienjamDao.getListFavoriteMovies()

    fun getListTvShows(): DataSource.Factory<Int, TvShowEntity> = movienjamDao.getListTvShows()

    fun getListFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> =
        movienjamDao.getListFavoriteTvShows()

    fun getDetailMovie(movieId: Int): LiveData<MovieEntity> =
        movienjamDao.getDetailMovieById(movieId)

    fun getDetailTvShow(tvShowId: Int): LiveData<TvShowEntity> =
        movienjamDao.getDetailTvShowById(tvShowId)

    fun insertMovies(movies: List<MovieEntity>) = movienjamDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = movienjamDao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie: MovieEntity) {
        movie.isFavorite = !movie.isFavorite
        movienjamDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity) {
        tvShow.isFavorite = !tvShow.isFavorite
        movienjamDao.updateTvShow(tvShow)
    }
}