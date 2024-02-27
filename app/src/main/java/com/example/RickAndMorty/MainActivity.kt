package com.example.RickAndMorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.RickAndMorty.model.Character
import com.example.RickAndMorty.ui.theme.RetrofitAPIInJetpackComposeTheme
import com.example.RickAndMorty.view.CharacterItem
import com.example.RickAndMorty.viewModel.CharacterViewModel

class MainActivity : ComponentActivity() {

    val characterViewModel by viewModels<CharacterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitAPIInJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MovieList(movieList = characterViewModel.movieListResponse)
                    characterViewModel.getMovieList()

                }
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Character>) {
    LazyColumn {
        itemsIndexed(items = movieList) { index, item ->
            CharacterItem(character = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RetrofitAPIInJetpackComposeTheme {
            val character = Character(
                "Rick Sanchez",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                "",
                "",
                "",
                ""
            )

            CharacterItem(character = character )

    }
}