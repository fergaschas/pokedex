package com.fgascon.pokedex.presentation

import com.fgascon.pokedex.Pokemon

data class PokedexUIState (
    val pokemons: List<Pokemon> = emptyList()
)
