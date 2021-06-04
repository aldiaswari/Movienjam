package com.aldi.movienjam.ui.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.databinding.FragmentFavoriteMovieBinding
import com.aldi.movienjam.ui.content.ContentCallback
import com.aldi.movienjam.ui.content.movie.MovieAdapter
import com.aldi.movienjam.ui.detail.DetailActivity
import com.aldi.movienjam.ui.favorite.FavoriteViewModel
import com.aldi.movienjam.utils.Helper.TYPE_MOVIE
import com.aldi.movienjam.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteMovieFragment : DaggerFragment(), ContentCallback {

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var binding: FragmentFavoriteMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        parentFragment?.let {
            viewModel = ViewModelProvider(it, factory)[FavoriteViewModel::class.java]
        }
        observeFavoriteMovies()

    }

    private fun observeFavoriteMovies() {
        viewModel.getListFavoriteMovie().observe(viewLifecycleOwner, { movies ->
            if (movies.isNotEmpty()) {
                binding.progressBar.visibility = GONE

            } else {
                binding.progressBar.visibility = VISIBLE

            }
            setupRecyclerView(movies)
        })

    }

    private fun setupRecyclerView(movies: PagedList<MovieEntity>?) {
        binding.rvFavoriteMovie.setHasFixedSize(true)
        val movieAdapter = MovieAdapter(this)
        movieAdapter.submitList(movies)
        movieAdapter.notifyDataSetChanged()
        binding.rvFavoriteMovie.layoutManager = GridLayoutManager(context, 2)
        binding.rvFavoriteMovie.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.rvFavoriteMovie.adapter = movieAdapter
    }


    override fun onItemClicked(moId: Int) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, moId)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

}