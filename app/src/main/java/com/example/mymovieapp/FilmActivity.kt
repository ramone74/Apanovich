package com.example.mymovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymovieapp.model.Movie
import com.example.mymovieapp.ui.theme.MyMovieAppTheme

class FilmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MovieDescription()
                }
            }
        }
    }
}

@Composable
fun MovieDescription(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val intent = (context as FilmActivity).intent

    val title = intent.getStringExtra("Title")
    val description = intent.getStringExtra("Description")
    val genre = intent.getStringExtra("Genre")
    val country = intent.getStringExtra("Country")
    val poster = intent.getIntExtra("Poster", 0)

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top
    ){
        Image(painter = painterResource(id = poster),
            contentDescription = "",

            modifier = Modifier
                .size(620.dp),
        )
        Text(

            text = title ?: "No title",
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 6.dp)
        )
        Text(
            text =  description ?: "No description",
            color = Color.Gray,
            fontSize = 19.sp,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = "Жанры: " + (genre ?: "No genre"),
            color = Color.Gray,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 8.dp)
        )
        Text(

            text = "Страна: " + (country ?: "No country"),
            color = Color.Gray,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 8.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MyMovieAppTheme {
    }
}