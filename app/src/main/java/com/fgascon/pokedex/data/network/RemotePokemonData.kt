package com.fgascon.pokedex.data.network

import com.google.gson.annotations.SerializedName

data class RemotePokemon(
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null
)
