package com.aldi.movienjam.utils

import android.content.Context
import android.widget.ImageView
import com.aldi.movienjam.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object Helper {

    const val TYPE_MOVIE = "TYPE_MOVIE"
    const val TYPE_TVSHOW = "TYPE_TVSHOW"
    const val ENDPOINT_POSTER_SIZE_W185 = "w185/"
    const val ENDPOINT_POSTER_SIZE_W780 = "w780"

    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).into(imageView)
    }

    fun ImageView.loadFromUrl(path: String) {
        Glide.with(this).clear(this)
        Glide.with(this)
            .setDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.drawable.movie1)
                    .error(R.drawable.movie1)
            ).load(path).into(this)
    }
}