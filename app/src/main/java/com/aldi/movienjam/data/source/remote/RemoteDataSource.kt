package com.aldi.movienjam.data.source.remote


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aldi.movienjam.BuildConfig.API_KEY
import com.aldi.movienjam.data.source.remote.api.ApiService
import com.aldi.movienjam.data.source.remote.response.*
import com.aldi.movienjam.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val apiService: ApiService){


    fun getMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovieResponse = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(IO).launch {
            try {
                val response = apiService.getMovies(API_KEY).await()
                resultMovieResponse.postValue(ApiResponse.success(response.results))
            } catch (e: IOException) {
                e.printStackTrace()
                resultMovieResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovieResponse
    }



    fun getTvShow(): LiveData<ApiResponse<List<TVShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShowResponse = MutableLiveData<ApiResponse<List<TVShowResponse>>>()
        CoroutineScope(IO).launch {
            try {
                val response = apiService.getTvShows(API_KEY).await()
                resultTvShowResponse.postValue(ApiResponse.success(response.results))
            } catch (e: IOException) {
                e.printStackTrace()
                resultTvShowResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultTvShowResponse
    }



}