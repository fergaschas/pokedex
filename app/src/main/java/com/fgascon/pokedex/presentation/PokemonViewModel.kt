package com.fgascon.pokedex.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.pokedex.data.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokedexRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val _state = mutableStateOf(PokemonState())
        val state: State<PokemonState> = _state

    init {
        val id = savedStateHandle.get<Int>("id") ?: 0
        if (id != 0) {
            viewModelScope.launch {
                val pokemon = repository.getPokemonById(id)
                _state.value = PokemonState(pokemon = pokemon)
            }
        }
    }

}
