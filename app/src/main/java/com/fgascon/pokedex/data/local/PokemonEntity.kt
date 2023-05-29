package com.fgascon.pokedex.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class PokemonEntity (
    @PrimaryKey() val id:Int,
    val name:String,
)
