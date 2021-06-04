package com.aldi.movienjam.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity

@Database(entities = [MovieEntity::class, TvShowEntity::class], version = 1, exportSchema = false)
abstract class MovienjamDatabase : RoomDatabase() {
    abstract fun movienjamDao(): MovienjamDao

    companion object {

        @Volatile
        private var INSTANCE: MovienjamDatabase? = null

        fun getInstance(context: Context): MovienjamDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MovienjamDatabase::class.java,
                    "movienjam.db"
                ).build()
            }


    }

}