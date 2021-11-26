package com.example.moviesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.MovieCardBinding
import com.example.moviesapp.viewmodel.ResultsItem

class PhotoGridAdapter : ListAdapter<ResultsItem, PhotoGridAdapter.MovieViewHolder>(DiffCallback) {

      class MovieViewHolder( var binding: MovieCardBinding): RecyclerView.ViewHolder(binding.root) {
          fun bind(views: ResultsItem) {
              binding.resultItem = views
              // This is important, because it forces the data binding to execute immediately,
              // which allows the RecyclerView to make the correct view size measurements
              binding.executePendingBindings()
          }
      }
    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of
     * [MarsPhoto] has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<ResultsItem>() {
        override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem.posterPath == newItem.posterPath
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        return MovieViewHolder(
            MovieCardBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val moviePhoto = getItem(position)
        holder.bind(moviePhoto)
    }
}