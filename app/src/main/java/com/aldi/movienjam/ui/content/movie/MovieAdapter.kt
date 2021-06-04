package com.aldi.movienjam.ui.content.movie


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.aldi.movienjam.BuildConfig
import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.databinding.ItemRowDataBinding
import com.aldi.movienjam.ui.content.ContentCallback
import com.aldi.movienjam.utils.Helper.loadFromUrl
import kotlinx.android.synthetic.main.item_row_data.view.*

class MovieAdapter(private val contentCallback: ContentCallback) :
    PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemRowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }

    }

    inner class MovieViewHolder(binding: ItemRowDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MovieEntity) {
            with(itemView) {
                item_poster_title.text = data.title
                itemView.setOnClickListener { contentCallback.onItemClicked(data.movieId) }
                data.posterPath.let {
                    img_data.loadFromUrl(BuildConfig.IMAGE_URL  + it)
                }


            }

        }

    }
}