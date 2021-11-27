package com.example.moviesapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.moviesapp.R
import com.example.moviesapp.adapter.PhotoGridAdapter
import com.example.moviesapp.databinding.FragmentMovieDetailBinding
import com.example.moviesapp.databinding.FragmentMovieListBinding
import com.example.moviesapp.viewmodel.MoviesViewModel


class MovieDetailFragment : Fragment() {
    private val moviesViewModel: MoviesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMovieDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.movieViewModel = moviesViewModel




        arguments.let {

            moviesViewModel.setDetails(it?.getInt("movieIndex")!!)
        }




        return binding.root
    }



}