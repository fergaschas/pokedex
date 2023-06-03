package com.fgascon.pokedex.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.pokedex.data.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokedexRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state: MutableStateFlow<PokemonState> = MutableStateFlow(PokemonState())
    val state = _state.asStateFlow()

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
