package com.aldi.movienjam.ui.content

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData

import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.aldi.movienjam.data.MovienjamRepository
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import com.aldi.movienjam.utils.DataDummy
import com.aldi.movienjam.vo.Resource
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.mockito.Mockito
import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class ContentViewModelTest {
    private lateinit var viewModel: ContentViewModel
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movienjamRepository: MovienjamRepository
    @Mock
    private lateinit var observerMovie: Observer<Resource<PagedList<MovieEntity>>>
    @Mock
    private lateinit var observerTv: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>


    @Before
    fun setUp() {
       viewModel = ContentViewModel(movienjamRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = Resource.success(moviePagedList)
        `when`(dummyMovie.data?.size).thenReturn(5)
        val movie = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movie.value = dummyMovie

        `when`(movienjamRepository.getMovies()).thenReturn(movie)
        val movieEntity = viewModel.getMovie().value?.data
        verify(movienjamRepository).getMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)

        viewModel.getMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }




    @Test
    fun getTvShow() {
        val dummyTvShow = Resource.success(tvShowPagedList)
        `when`(dummyTvShow.data?.size).thenReturn(5)
        val tvShow = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShow.value = dummyTvShow

        `when`(movienjamRepository.getTvShow()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow().value?.data
        verify(movienjamRepository).getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(5, tvShowEntity?.size)

        viewModel.getTvShow().observeForever(observerTv)
        verify(observerTv).onChanged(dummyTvShow)
    }


}