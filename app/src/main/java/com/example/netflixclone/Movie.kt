package com.example.netflixclone

import java.io.Serializable

data class Movie(var movieID: Int,
                 var movieName: String,
                 var moviePic: String,
                 var movieDescription: String) : Serializable {

}
