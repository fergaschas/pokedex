package com.fgascon.pokedex.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage


@Composable
fun PokemonScreen(
    viewModel: PokemonViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    val pokemon = state.value.pokemon
    AsyncImage(
        contentDescription = pokemon.name,
        model = pokemon.imageUrl,
        modifier = Modifier.fillMaxSize()
    )
}