package com.example.moviesapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.moviesapp.adapter.PhotoGridAdapter
import com.example.moviesapp.databinding.FragmentMovieListBinding
import com.example.moviesapp.viewmodel.MoviesViewModel


class MovieListFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMovieListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = moviesViewModel
        binding.movieListId.adapter = PhotoGridAdapter()
        return binding.root

    }

}