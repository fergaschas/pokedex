package com.fgascon.pokedex.data

import com.fgascon.pokedex.Pokemon
import com.fgascon.pokedex.data.local.PokedexDao
import com.fgascon.pokedex.data.network.PokedexApi
import com.fgascon.pokedex.mappers.toDomain
import com.fgascon.pokedex.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PokedexRepository @Inject constructor(
    private val api: PokedexApi,
    private val dao: PokedexDao
) {

    suspend fun getPokemon(): Flow<List<Pokemon>> {
        return dao.getPokemon().map { pokemonEntity ->
            pokemonEntity.map { it.toDomain() }
        }.onEach {
            if (it.isEmpty()) {
                refreshPokemon()
            }
        }
    }

    private suspend fun refreshPokemon() {
        api.getPokemon().pokemons.forEach(){
            dao.insertPokemon(it.toEntity())
        }
    }

}
