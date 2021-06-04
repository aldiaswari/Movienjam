package com.aldi.movienjam.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aldi.movienjam.data.MovienjamRepository
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import javax.inject.Inject


class DetailViewModel @Inject constructor (private val movienjamRepository: MovienjamRepository): ViewModel() {


    fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =
        movienjamRepository.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity> =
        movienjamRepository.getTvShowDetail(tvShowId)

    fun setFavoriteMovie(movie: MovieEntity){
        movienjamRepository.setFavoriteMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity){
        movienjamRepository.setFavoriteTvShow(tvShow)
    }




}