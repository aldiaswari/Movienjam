package com.aldi.movienjam.ui.detail

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle

import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible


import androidx.lifecycle.ViewModelProvider
import androidx.palette.graphics.Palette

import com.aldi.movienjam.BuildConfig.IMAGE_URL
import com.aldi.movienjam.R
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity

import com.aldi.movienjam.databinding.ActivityDetailBinding
import com.aldi.movienjam.utils.Helper.TYPE_MOVIE
import com.aldi.movienjam.utils.Helper.TYPE_TVSHOW
import com.aldi.movienjam.utils.Helper.loadFromUrl

import com.aldi.movienjam.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import java.lang.Math.abs
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity(), AppBarLayout.OnOffsetChangedListener {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var detailBinding: ActivityDetailBinding
    private val percentageToShowImage = 20
    private var mMaxScrollSize = 0
    private var mIsImageHidden = false
    private lateinit var viewModel: DetailViewModel

    @Inject
    lateinit var factory: ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.hide()

        showProgressBar(true)

        detailBinding.toolbar.setNavigationOnClickListener { onBackPressed() }
        detailBinding.appbar.addOnOffsetChangedListener(this)


        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getInt(EXTRA_DATA, 0)
            val type = extras.getString(EXTRA_TYPE)

            if (type.equals(TYPE_MOVIE, ignoreCase = true)) {

                observeDetailMovie(id)


            } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {

                observeDetailTvShow(id)
            }
        }

    }

    private fun observeDetailMovie(movieId: Int) {
        viewModel.getMovieDetail(movieId).observe(this, {
            populateDataDetail(it, null)
        })
    }

    private fun observeDetailTvShow(tvShowId: Int) {
        viewModel.getTvShowDetail(tvShowId).observe(this, {
            it?.let {
                populateDataDetail(null, it)
            }
        })
    }

    private fun showProgressBar(state: Boolean) {
        detailBinding.progressBar.isVisible = state
        detailBinding.appbar.isInvisible = state
        detailBinding.nestedScrollView.isInvisible = state
    }

    private fun populateDataDetail(movie: MovieEntity?, tvShow: TvShowEntity?) {
        val type = intent.getStringExtra(EXTRA_TYPE)
        val statusFavorite = movie?.isFavorite ?: tvShow?.isFavorite

        statusFavorite?.let { status ->
            setFavoriteState(status)
        }

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            Glide.with(this)
                .asBitmap()
                .load(IMAGE_URL + movie?.backdropPath)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        detailBinding.ivDetail.setImageBitmap(resource)
                        setColorByPalette(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {

                    }
                })

            Glide.with(this)
                .load(IMAGE_URL + movie?.backdropPath)
                .into(detailBinding.ivBackdrop)

            detailBinding.imgDetailPoster.loadFromUrl(IMAGE_URL + movie?.posterPath)

        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            Glide.with(this)
                .asBitmap()
                .load(IMAGE_URL + tvShow?.backdropPath)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        detailBinding.ivDetail.setImageBitmap(resource)
                        setColorByPalette(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {

                    }
                })

            Glide.with(this)
                .load(IMAGE_URL + tvShow?.backdropPath)
                .into(detailBinding.ivBackdrop)

            detailBinding.imgDetailPoster.loadFromUrl(IMAGE_URL + tvShow?.posterPath)
        }

        detailBinding.tvDetailReleaseDate.text = movie?.releaseDate ?: tvShow?.firstAirDate
        detailBinding.collapsing.title = movie?.title ?: tvShow?.name
        detailBinding.tvDetailOverview.text = movie?.overview ?: tvShow?.overview
        detailBinding.ivDetail.tag = movie?.posterPath ?: tvShow?.posterPath
        detailBinding.ivBackdrop.tag = movie?.backdropPath ?: tvShow?.backdropPath

        showProgressBar(false)

        setFav(movie, tvShow)
    }

    private fun setFav(movie: MovieEntity?, tvShow: TvShowEntity?) {
        detailBinding.toFavorite.setOnClickListener {
            setFavorite(movie, tvShow)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setFavoriteState(status: Boolean) {
        if (status) {
            detailBinding.toFavorite.setDrawableOff(resources.getDrawable(R.drawable.ic_favorite_24))
        } else {
            detailBinding.toFavorite.setDrawableOff(resources.getDrawable(R.drawable.ic_favorite_border_24))

        }
    }

    private fun showSnackBar(msg: String) {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT).show()
    }

    private fun setFavorite(movie: MovieEntity?, tvShow: TvShowEntity?) {
        if (movie != null) {
            if (movie.isFavorite) {
                showSnackBar("${movie.title} Removed from favorite")
            } else {
                showSnackBar("${movie.title} Added to favorite")
            }
            viewModel.setFavoriteMovie(movie)
        } else {
            if (tvShow != null) {
                if (tvShow.isFavorite) {
                    showSnackBar("${tvShow.name} Removed from favorite")
                } else {
                    showSnackBar("${tvShow.name} Removed from favorite")
                }
                viewModel.setFavoriteTvShow(tvShow)
            }
        }
    }

    private fun setColorByPalette(poster: Bitmap) {
        Palette.from(poster).generate { palette ->
            val defValue =
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    resources.getColor(R.color.blue_dark, theme)
                } else {
                    ContextCompat.getColor(applicationContext, R.color.blue_dark)
                }
            detailBinding.cardDetail.setCardBackgroundColor(
                palette?.getDarkMutedColor(defValue) ?: defValue
            )
            detailBinding.collapsing.setContentScrimColor(
                palette?.getDarkMutedColor(defValue) ?: defValue
            )
            window.statusBarColor = palette?.getDarkMutedColor(defValue) ?: defValue
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (mMaxScrollSize == 0) mMaxScrollSize = appBarLayout!!.totalScrollRange

        val currentScrollPercentage: Int = (abs(verticalOffset) * 100 / mMaxScrollSize)

        if (currentScrollPercentage >= percentageToShowImage) {
            if (!mIsImageHidden) {
                mIsImageHidden = true
            }
        }

        if (currentScrollPercentage < percentageToShowImage) {
            if (mIsImageHidden) {
                mIsImageHidden = false
            }
        }
    }
}