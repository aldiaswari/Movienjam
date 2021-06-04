package com.aldi.movienjam.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_favorite_tvshow")
@Parcelize
data class TvShowEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    val tvShowId: Int ,

    @ColumnInfo(name = "tvShowName")
    val name: String,

    @ColumnInfo(name = "tvShowOverview")
    val overview: String,

    @ColumnInfo(name = "tvShowfirstAirDate")
    val firstAirDate: String,

    @ColumnInfo(name = "tvShowPosterPath")
    val posterPath: String,

    @ColumnInfo(name = "tvShowBackdropPath")
    val backdropPath: String,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
): Parcelable