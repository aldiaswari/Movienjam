package com.aldi.movienjam.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_favorite_movie")
@Parcelize
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Int,

    @ColumnInfo(name = "movieTitle")
    var title: String,

    @ColumnInfo(name = "movieOverview")
    var overview: String,

    @ColumnInfo(name = "movieReleaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "moviePosterPath")
    var posterPath: String,

    @ColumnInfo(name = "movieBackDropPath")
    var backdropPath: String,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
): Parcelable