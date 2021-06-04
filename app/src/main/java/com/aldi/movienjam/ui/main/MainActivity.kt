package com.aldi.movienjam.ui.main


import android.os.Bundle
import android.view.Window
import android.view.WindowManager.LayoutParams.*
import androidx.fragment.app.Fragment
import com.aldi.movienjam.R
import com.aldi.movienjam.ui.content.ContentViewModel
import com.aldi.movienjam.ui.content.movie.MovieFragment
import com.aldi.movienjam.ui.content.tv.TvShowFragment
import com.aldi.movienjam.utils.CheckInternetConnection
import com.aldi.movienjam.viewmodel.ViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.aldi.movienjam.ui.favorite.FavoriteFragment
import dagger.android.support.DaggerAppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel: ContentViewModel
    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        CheckInternetConnection(this).checkConnection()

        viewModel = ViewModelProvider(
            this@MainActivity,
            factory
        )[ContentViewModel::class.java]
        imageSlide()
        initNav()
        initMovie()


    }

    private fun imageSlide() {

        slider.setImageList(viewModel.getSlider())


    }


    private fun initNav() {

        equal_navigation_bar.setNavigationChangeListener { view, _ ->
            when (view.id) {
                R.id.nav_movie -> setFragment(
                    MovieFragment()
                )
                R.id.nav_fav-> setFragment(
                    FavoriteFragment()
                )
                R.id.nav_tv_show -> setFragment(
                    TvShowFragment()
                )
            }
        }

    }


    private fun initMovie() {
        var fragment = supportFragmentManager.findFragmentByTag(MovieFragment.TAG)
        if (fragment == null) {
            fragment = MovieFragment()
            addFragment(fragment, R.id.container_main_fragment)
        }
    }

    private fun addFragment(fragment: MovieFragment, id: Int) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(id, fragment)
        ft.commit()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.container_main_fragment, fragment)
        }.commit()
    }


}

