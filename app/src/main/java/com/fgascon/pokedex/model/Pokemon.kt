package com.fgascon.pokedex.model

import retrofit2.http.Url

data class Pokemon (
    val name: String,
    val pokedexIndex: Int,
    val imageUrl: String,
)
