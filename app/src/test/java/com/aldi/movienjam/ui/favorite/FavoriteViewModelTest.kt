package com.aldi.movienjam.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.aldi.movienjam.data.MovienjamRepository
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movienjamRepository: MovienjamRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(movienjamRepository)
    }

    @Test
    fun getListFavoriteMovie() {

        val dummyMovie = moviePagedList
        `when`(dummyMovie.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovie

        `when`(movienjamRepository.getListFavoriteMovies()).thenReturn(movie)
        val movieEntity = viewModel.getListFavoriteMovie().value
        verify(movienjamRepository).getListFavoriteMovies()
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(5, movieEntity?.size)

        viewModel.getListFavoriteMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)

    }

    @Test
    fun getListFavoriteTvShow() {
        val dummyTvShow = tvShowPagedList
        `when`(dummyTvShow.size).thenReturn(5)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow

        `when`(movienjamRepository.getListFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getListFavoriteTvShow().value
        verify(movienjamRepository).getListFavoriteTvShows()
        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(5, tvShowEntity?.size)

        viewModel.getListFavoriteTvShow().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }
}