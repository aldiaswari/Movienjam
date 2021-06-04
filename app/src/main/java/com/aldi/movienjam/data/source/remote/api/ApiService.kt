package com.aldi.movienjam.data.source.remote.api



import com.aldi.movienjam.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("discover/movie")
    fun getMovies(
        @Query("api_key") apiKey: String
    ) : Call<Movie>


    @GET("discover/tv")
    fun getTvShows(
        @Query("api_key") apiKey: String
    ) : Call<TvShow>

}