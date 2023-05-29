package com.fgascon.pokedex.data.network

import com.google.gson.annotations.SerializedName

data class RemotePokedex(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("next")
    var next: String? = null,
    @SerializedName("previous")
    var previous: String? = null,
    @SerializedName("results")
    var pokemons: List<RemotePokemon> = emptyList()
)