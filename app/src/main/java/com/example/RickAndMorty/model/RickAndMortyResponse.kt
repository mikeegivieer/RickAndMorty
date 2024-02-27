package com.example.RickAndMorty.model

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse (
    @SerializedName("info")  val info : Info,
    @SerializedName("results") val characters : List<Character>
        )
