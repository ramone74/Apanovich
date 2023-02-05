package com.example.mymovieapp.data

import com.example.mymovieapp.R
import com.example.mymovieapp.model.Movie

class Datasource {
    fun loadMovies(): List<Movie> {
        return listOf<Movie>(
            Movie(R.string.movie_tittle1, R.string.movie_descr1, R.string.movie_genre1, R.string.movie_country1, R.drawable.image1),
            Movie(R.string.movie_tittle2, R.string.movie_descr2, R.string.movie_genre2, R.string.movie_country2, R.drawable.image2),
            Movie(R.string.movie_tittle3, R.string.movie_descr3, R.string.movie_genre3, R.string.movie_country3, R.drawable.image3),
            Movie(R.string.movie_tittle4, R.string.movie_descr4, R.string.movie_genre4, R.string.movie_country4, R.drawable.image4),
            Movie(R.string.movie_tittle5, R.string.movie_descr5, R.string.movie_genre5, R.string.movie_country5, R.drawable.image5),
            Movie(R.string.movie_tittle6, R.string.movie_descr6, R.string.movie_genre6, R.string.movie_country6, R.drawable.image6),
            Movie(R.string.movie_tittle7, R.string.movie_descr7, R.string.movie_genre7, R.string.movie_country7, R.drawable.image7),
            Movie(R.string.movie_tittle8, R.string.movie_descr8, R.string.movie_genre8, R.string.movie_country8, R.drawable.image8)
        )
    }
}