package com.fgascon.pokedex.data.network

import retrofit2.http.GET

interface PokedexApi {
    @GET("pokemon?limit=1281")
    suspend fun getPokemon(): RemotePokedex
}
