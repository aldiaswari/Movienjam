package com.aldi.movienjam.ui.content

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aldi.movienjam.data.MovienjamRepository
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import com.aldi.movienjam.utils.DataDummy
import com.aldi.movienjam.vo.Resource
import com.denzcoskun.imageslider.models.SlideModel


class ContentViewModel(private val movienjamRepository: MovienjamRepository) : ViewModel() {

    fun getMovie() : LiveData<Resource<PagedList<MovieEntity>>> = movienjamRepository.getMovies()

    fun getTvShow() : LiveData<Resource<PagedList<TvShowEntity>>> = movienjamRepository.getTvShow()

    fun getSlider() : List<SlideModel> = DataDummy.generateImageSliderDummy()


}