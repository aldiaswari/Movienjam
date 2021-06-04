package com.aldi.movienjam.ui.favorite.tvshow

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
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import com.aldi.movienjam.databinding.FragmentFavoriteTvshowBinding
import com.aldi.movienjam.ui.content.ContentCallback
import com.aldi.movienjam.ui.content.tv.TvShowAdapter
import com.aldi.movienjam.ui.detail.DetailActivity
import com.aldi.movienjam.ui.favorite.FavoriteViewModel
import com.aldi.movienjam.utils.Helper.TYPE_TVSHOW
import com.aldi.movienjam.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteTvShowFragment : DaggerFragment(), ContentCallback {

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    lateinit var binding: FragmentFavoriteTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteTvshowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        parentFragment?.let {
            viewModel = ViewModelProvider(it, factory)[FavoriteViewModel::class.java]
        }
        observeFavoriteTvShow()

    }

    private fun observeFavoriteTvShow() {
        viewModel.getListFavoriteTvShow().observe(viewLifecycleOwner, { tvShow ->
            if (tvShow.isNotEmpty()) {
                binding.progressBar.visibility = GONE
            } else {
                binding.progressBar.visibility = VISIBLE
            }
            setupRecyclerView(tvShow)
        })
    }

    private fun setupRecyclerView(tvShow: PagedList<TvShowEntity>) {
        binding.rvFavoriteTvshow.setHasFixedSize(true)
        val tvShowAdapter = TvShowAdapter(this)
        tvShowAdapter.submitList(tvShow)
        tvShowAdapter.notifyDataSetChanged()
        binding.rvFavoriteTvshow.layoutManager = GridLayoutManager(context, 2)
        binding.rvFavoriteTvshow.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.rvFavoriteTvshow.adapter = tvShowAdapter
    }

    override fun onItemClicked(moId: Int) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, moId)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_TVSHOW)
        )
    }

}