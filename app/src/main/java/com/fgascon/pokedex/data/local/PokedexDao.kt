package com.fgascon.pokedex.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokedexDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: PokemonEntity)

    @Delete
    suspend fun deletePokemon(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemons")
    fun getPokemon(): Flow<List<PokemonEntity>>

    @Query("SELECT * FROM pokemons WHERE name LIKE :name")
    suspend fun getPokemonFiltered(name: String): List<PokemonEntity>

    @Query("Select * FROM pokemons where id = :id")
    suspend fun getPokemonById(id: Int): PokemonEntity
}
