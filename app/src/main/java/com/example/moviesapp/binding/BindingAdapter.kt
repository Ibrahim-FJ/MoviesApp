package com.example.moviesapp.binding

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.adapter.PhotoGridAdapter
import com.example.moviesapp.viewmodel.ResultsItem

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
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




