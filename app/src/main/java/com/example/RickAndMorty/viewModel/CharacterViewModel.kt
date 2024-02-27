package com.example.RickAndMorty.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.RickAndMorty.model.Character
import com.example.RickAndMorty.model.RickAndMortyResponse
import com.example.RickAndMorty.network.ApiService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    var movieListResponse:List<Character> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {

                apiService.getCharacters().enqueue(object : Callback<RickAndMortyResponse> {
                    override fun onResponse(call: Call<RickAndMortyResponse>, response: Response<RickAndMortyResponse>) {
                        if (response.isSuccessful) {
                            movieListResponse= response.body()!!.characters
                        } else {
                            // Manejar error de respuesta
                        }
                    }

                    override fun onFailure(call: Call<RickAndMortyResponse>, t: Throwable) {
                    }
                })




            }
            catch (e: Exception) {
                errorMessage = e.message.toString()

            }
        }
    }
}