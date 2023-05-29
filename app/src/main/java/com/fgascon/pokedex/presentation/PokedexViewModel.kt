package com.fgascon.pokedex.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.pokedex.data.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val repository: PokedexRepository
) : ViewModel() {

    private var _state = mutableStateOf(PokedexUIState())
    val state: State<PokedexUIState>
        get() = _state

    init {
        viewModelScope.launch {
            val pokemons = repository.getPokemon().collect {
                _state.value = _state.value.copy(pokemons = it)
            }
        }
    }

}
