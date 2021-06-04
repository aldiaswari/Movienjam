package com.aldi.movienjam.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aldi.movienjam.data.MovienjamRepository
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val movienjamRepository: MovienjamRepository) : ViewModel() {

    fun getListFavoriteMovie(): LiveData<PagedList<MovieEntity>> = movienjamRepository.getListFavoriteMovies()

    fun getListFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> = movienjamRepository.getListFavoriteTvShows()
}