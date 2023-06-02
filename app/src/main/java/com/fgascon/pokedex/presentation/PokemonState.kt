package com.fgascon.pokedex.presentation

import com.fgascon.pokedex.model.Pokemon

data class PokemonState(
    val pokemon: Pokemon = Pokemon(
        pokedexIndex = 0,
        name = "MissingNo",
        imageUrl = ""
    )
)
