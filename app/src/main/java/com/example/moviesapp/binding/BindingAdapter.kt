package com.example.moviesapp.binding

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

import coil.load
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.adapter.PhotoGridAdapter
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



//@BindingAdapter("imageUrl")
//fun bindImage(imgView: ImageView, imgUrl: String?){
//    imgUrl.let {
//        val imageLoader = ImageLoader.Builder(imgView.context)
//            .componentRegistry { add(SvgDecoder(imgView.context)) }
//            .build()
//
//        val request = ImageRequest.Builder(imgView.context)
//            .placeholder(R.drawable.loading_animation)
//            .data(imgUrl)
//            .target(imgView)
//            .build()
//
//        imageLoader.enqueue(request)
//    }
//
//
//}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ResultsItem>?){

    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}




