package com.example.RickAndMorty.model

import com.google.gson.annotations.SerializedName

data class Info (
    @SerializedName("count")val count: String,
    @SerializedName("pages")val pages: String,
    @SerializedName("next")val next: String,
        )