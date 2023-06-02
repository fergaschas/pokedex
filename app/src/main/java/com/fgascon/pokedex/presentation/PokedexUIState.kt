package com.fgascon.pokedex.presentation

import com.fgascon.pokedex.model.Pokemon

data class PokedexUIState (
    val pokemons: List<Pokemon> = emptyList()
)
