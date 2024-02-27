package com.example.RickAndMorty.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("name")val name: String,
    @SerializedName("image")val image: String,
    @SerializedName("species")val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type")val type: String,
    @SerializedName("gender")val gender: String
)