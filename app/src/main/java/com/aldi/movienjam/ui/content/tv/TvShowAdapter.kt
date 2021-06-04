package com.aldi.movienjam.ui.content.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aldi.movienjam.BuildConfig
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import com.aldi.movienjam.databinding.ItemRowDataBinding
import com.aldi.movienjam.ui.content.ContentCallback
import com.aldi.movienjam.utils.Helper.loadFromUrl
import kotlinx.android.synthetic.main.item_row_data.view.*

class TvShowAdapter(private val contentCallback: ContentCallback) :
    PagedListAdapter<TvShowEntity, TvShowAdapter.TvViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val binding = ItemRowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(binding)
    }


    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }

    }

    inner class TvViewHolder(binding: ItemRowDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TvShowEntity) {
            with(itemView) {
                item_poster_title.text = data.name
                itemView.setOnClickListener { contentCallback.onItemClicked(data.tvShowId) }
                data.posterPath?.let {
                    img_data.loadFromUrl(BuildConfig.IMAGE_URL + it)
                }

            }

        }


    }
}