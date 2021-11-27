package com.example.moviesapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.adapter.PhotoGridAdapter
import com.example.moviesapp.databinding.FragmentMovieListBinding
import com.example.moviesapp.viewmodel.MoviesViewModel


class MovieListFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
    var binding: FragmentMovieListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = FragmentMovieListBinding.inflate(inflater,container, false)

        binding?.lifecycleOwner = this

        binding?.viewModel = moviesViewModel
        binding?.movieListId?.adapter = PhotoGridAdapter()
        return binding!!.root

    }


}