package com.example.moviesapp.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.moviesapp.R
import com.example.moviesapp.adapter.PhotoGridAdapter
import com.example.moviesapp.databinding.FragmentMovieListBinding
import com.example.moviesapp.viewmodel.MoviesViewModel


class MovieListFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
    var binding: FragmentMovieListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.movie_genre_menu, menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.all_movies -> {
                moviesViewModel.getMovies()
            }
            R.id.action_item  -> {
                moviesViewModel.getMoviesByGenre(28)
            }
            R.id.adventure_item  -> {
                moviesViewModel.getMoviesByGenre(12)
            }
            R.id.drama_item  -> {
                moviesViewModel.getMoviesByGenre(35)
            }
            R.id.comedy_item  -> {
                moviesViewModel.getMoviesByGenre(18)
            }
            R.id.crime_item -> {
                moviesViewModel.getMoviesByGenre(80)
            }

            R.id.release_date -> {
                moviesViewModel.sortMoviesByReleaseDate("primary_release_date.asc")
            }


        }
        return true
    }

}