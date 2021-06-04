package com.aldi.movienjam.ui.content.movie


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.databinding.FragmentMovieBinding
import com.aldi.movienjam.ui.content.ContentCallback
import com.aldi.movienjam.ui.content.ContentViewModel
import com.aldi.movienjam.ui.detail.DetailActivity
import com.aldi.movienjam.utils.Helper.TYPE_MOVIE
import com.aldi.movienjam.viewmodel.ViewModelFactory
import com.aldi.movienjam.vo.Status
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class MovieFragment : DaggerFragment(), ContentCallback {


    companion object {
        val TAG: String = MovieFragment::class.java.simpleName
    }

    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var viewModel: ContentViewModel
    private lateinit var adapter: MovieAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            requireActivity(),
            factory
        )[ContentViewModel::class.java]
        adapter = MovieAdapter(this)
        viewModel.getMovie().observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        showRecyclerView(movies.data)
                    }
                    Status.ERROR -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }

    private fun showRecyclerView(movies: PagedList<MovieEntity>?) {
        fragmentMovieBinding.rvMovie.setHasFixedSize(true)
        val movieAdapter = MovieAdapter(this)
        movieAdapter.submitList(movies)
        movieAdapter.notifyDataSetChanged()
        fragmentMovieBinding.rvMovie.layoutManager = GridLayoutManager(context, 2)
        fragmentMovieBinding.rvMovie.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        fragmentMovieBinding.rvMovie.adapter = movieAdapter
    }

    override fun onItemClicked(moId: Int) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DATA, moId)
        intent.putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        context?.startActivity(intent)

    }


}