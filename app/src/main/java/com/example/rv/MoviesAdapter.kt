package com.example.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmbase.R
import com.example.mvvmbase.databinding.RecyclerviewMovieBinding

class MoviesAdapter(private val list: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {


    inner class MovieViewHolder(val recyclerviewMovieBinding: RecyclerviewMovieBinding) :
        RecyclerView.ViewHolder(recyclerviewMovieBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {


        holder.recyclerviewMovieBinding.movie = list[position]
    }
}