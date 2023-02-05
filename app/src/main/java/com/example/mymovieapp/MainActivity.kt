package com.example.mymovieapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.mymovieapp.data.Datasource
import com.example.mymovieapp.model.Movie
import com.example.mymovieapp.ui.theme.MyMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MovieApp()
                }
            }
        }
    }
}

@Composable
fun MovieApp() {
    MyMovieAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            MovieList(movieList = Datasource().loadMovies())
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>, modifier: Modifier = Modifier){
    LazyColumn {
        items(movieList) {
                movie -> MovieCard(movie = movie)
        }
    }

}

@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier){

    val context = LocalContext.current

    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {
                val intent = Intent(context, FilmActivity::class.java)
                intent.putExtra("Title", context.getString(movie.stringResourceIdTitle))
                intent.putExtra("Description", context.getString(movie.stringResourceIdDescr))
                intent.putExtra("Genre", context.getString(movie.stringResourceIdGenre))
                intent.putExtra("Country", context.getString(movie.stringResourceIdCountry))
                intent.putExtra("Poster", movie.imageResourceId)
                context.startActivity(intent)
            }
            ),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Image(painter = painterResource(id = movie.imageResourceId),
                contentDescription = "",
                modifier = Modifier
                    .height(110.dp),

            )
            Column(modifier = Modifier
                .padding(16.dp)
            ) {
                Text(
                    text = LocalContext.current.getString(movie.stringResourceIdTitle),
                    modifier = Modifier,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = LocalContext.current.getString(movie.stringResourceIdGenre),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyMovieAppTheme {
        MovieCard(Movie(R.string.movie_tittle1, R.string.movie_descr1, R.string.movie_genre1, R.string.movie_country1, R.drawable.image1))
    }
}