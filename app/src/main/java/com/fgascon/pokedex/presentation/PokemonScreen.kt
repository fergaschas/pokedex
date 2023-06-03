package com.fgascon.pokedex.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage


@Composable
fun PokemonScreen(
    viewModel: PokemonViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()
    AsyncImage(
        contentDescription = state.value.pokemon.name,
        model = state.value.pokemon.imageUrl,
        modifier = Modifier.fillMaxSize()
    )
}