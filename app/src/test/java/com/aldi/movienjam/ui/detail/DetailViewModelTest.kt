package com.aldi.movienjam.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aldi.movienjam.data.MovienjamRepository
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import com.aldi.movienjam.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {


    private val dummyMovie = DataDummy.generateDataMovieDummy()[0]
    private val movieId = dummyMovie.movieId
    private val dummyTvShow = DataDummy.generateDataTvShowDummy()[0]
    private val tvShowId = dummyTvShow.tvShowId
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movienjamRepository: MovienjamRepository

    @Mock
    private lateinit var movie: MovieEntity

    @Mock
    private lateinit var tvShow: TvShowEntity

    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>

    @Mock
    private lateinit var observerTv: Observer<TvShowEntity>
    @Before
    fun setUp() {
        viewModel = DetailViewModel(movienjamRepository)

    }

    @Test
    fun getMovieDetail() {
        val movieDummy = MutableLiveData<MovieEntity>()
        movieDummy.value = dummyMovie

        `when`(movienjamRepository.getMovieDetail(movieId)).thenReturn(movieDummy)

        val movieData = viewModel.getMovieDetail(movieId).value as MovieEntity
        verify(movienjamRepository).getMovieDetail(movieId)
        assertNotNull(movieData)
        assertEquals(dummyMovie.backdropPath, movieData.backdropPath)
        assertEquals(dummyMovie.movieId, movieData.movieId)
        assertEquals(dummyMovie.overview, movieData.overview)
        assertEquals(dummyMovie.posterPath, movieData.posterPath)
        assertEquals(dummyMovie.releaseDate, movieData.releaseDate)
        assertEquals(dummyMovie.title, movieData.title)
        viewModel.getMovieDetail(movieId).observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)

    }

    @Test
    fun getTvShowDetail() {
        val tvShowDummy = MutableLiveData<TvShowEntity>()
        tvShowDummy.value = dummyTvShow

        `when`(movienjamRepository.getTvShowDetail(tvShowId)).thenReturn(tvShowDummy)

        val tvShowData = viewModel.getTvShowDetail(tvShowId).value as TvShowEntity
        verify(movienjamRepository).getTvShowDetail(tvShowId)
        assertNotNull(tvShowData)
        assertEquals(dummyTvShow.backdropPath, tvShowData.backdropPath)
        assertEquals(dummyTvShow.tvShowId, tvShowData.tvShowId)
        assertEquals(dummyTvShow.overview, tvShowData.overview)
        assertEquals(dummyTvShow.posterPath, tvShowData.posterPath)
        assertEquals(dummyTvShow.firstAirDate, tvShowData.firstAirDate)
        assertEquals(dummyTvShow.name, tvShowData.name)
        viewModel.getTvShowDetail(tvShowId).observeForever(observerTv)
        verify(observerTv).onChanged(dummyTvShow)
    }

    @Test
    fun setFavoriteMovie(){

        val movieData =viewModel.setFavoriteMovie(movie)
        verify(movienjamRepository).setFavoriteMovie(movie)
        assertNotNull(movieData)
    }

    @Test
    fun setFavoriteTvShow(){
        val tvShowData = viewModel.setFavoriteTvShow(tvShow)
        verify(movienjamRepository).setFavoriteTvShow(tvShow)
        assertNotNull(tvShowData)
    }

}