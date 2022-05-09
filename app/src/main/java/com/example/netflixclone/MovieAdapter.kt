package com.example.netflixclone

import android.content.Context
import android.content.res.Resources
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclone.databinding.MovieCardBinding
import com.google.android.material.snackbar.Snackbar
import java.net.URI

class MovieAdapter(var nContext: Context, var movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: MovieCardBinding
        init {
            this.binding = binding

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(nContext)
        val design = MovieCardBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val movie = movieList.get(position)
        val t = holder.binding
        //t.kisiNesnesi = kisi
        t.imageView.setImageResource(nContext.resources.getIdentifier(movie.moviePic, "drawable", nContext.packageName))


        t.imageView.setOnClickListener {
            Snackbar.make(it, "${movie.movieName}", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    Log.e("Güzel film!", "${movie.movieName}")
                }
                .show()
        }

        t.movieCard.setOnClickListener {
            Log.e("${movie.movieName}", "clicked!")
            //val action = HomePageFragmentDirections.kisiDetayGecis(kisi = kisi)
            //Navigation.findNavController(it).navigate(gecis)

        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}