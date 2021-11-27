package com.example.moviesapp.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.adapter.PhotoGridAdapter
import com.example.moviesapp.viewmodel.ApiStatus
import com.example.moviesapp.viewmodel.ResultsItem



@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
             Glide
            .with(imgView.context)
            .load("https://image.tmdb.org/t/p/w500${imgUrl}")
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .into(imgView)

    }
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ResultsItem>?){
    if(recyclerView.adapter == null){
        recyclerView.adapter = PhotoGridAdapter()
    }

    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}




@BindingAdapter("apiStatus")
fun ImageView.bindStatus(status: ApiStatus){
    when (status){
        ApiStatus.LOADING -> {
            this.visibility = View.VISIBLE
            this.setImageResource(R.drawable.loading_animation)
        }
        ApiStatus.ERROR -> {
            this.visibility = View.VISIBLE
            this.setImageResource(R.drawable.ic_connection_error)
        }

        ApiStatus.DONE -> {
            this.visibility = View.GONE

        }
    }


}


