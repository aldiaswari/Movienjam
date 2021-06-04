package com.aldi.movienjam.ui.content.tv

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import com.aldi.movienjam.databinding.FragmentTvShowBinding
import com.aldi.movienjam.ui.content.ContentCallback
import com.aldi.movienjam.ui.content.ContentViewModel
import com.aldi.movienjam.ui.detail.DetailActivity
import com.aldi.movienjam.utils.Helper
import com.aldi.movienjam.vo.Status

class TvShowFragment : Fragment(), ContentCallback {

    private lateinit var viewModel: ContentViewModel
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
    private lateinit var adapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentTvShowBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.NewInstanceFactory()
        )[ContentViewModel::class.java]
        adapter = TvShowAdapter(this)
        viewModel.getTvShow().observe(viewLifecycleOwner, { Tv ->
            if (Tv != null) {
                when (Tv.status) {
                    Status.LOADING -> fragmentTvShowBinding.progressbarTv.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentTvShowBinding.progressbarTv.visibility = View.GONE
                        showRecyclerView(Tv.data)
                    }
                    Status.ERROR -> {
                        fragmentTvShowBinding.progressbarTv.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }

    private fun showRecyclerView(tv: PagedList<TvShowEntity>?) {
        fragmentTvShowBinding.rvTv.setHasFixedSize(true)
        val tvShowAdapter = TvShowAdapter(this)
        tvShowAdapter.submitList(tv)
        tvShowAdapter.notifyDataSetChanged()
        fragmentTvShowBinding.rvTv.layoutManager = GridLayoutManager(context, 2)
        fragmentTvShowBinding.rvTv.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        fragmentTvShowBinding.rvTv.adapter = tvShowAdapter
    }

    override fun onItemClicked(moId: Int) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DATA, moId)
        intent.putExtra(DetailActivity.EXTRA_TYPE, Helper.TYPE_TVSHOW)
        context?.startActivity(intent)

    }

}