package com.fgascon.pokedex.mappers

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import com.fgascon.pokedex.Pokemon
import com.fgascon.pokedex.data.local.PokemonEntity
import com.fgascon.pokedex.data.network.RemotePokemon


fun PokemonEntity.toDomain(): Pokemon {
    return Pokemon(
        pokedexIndex = this.id,
        name = this.name
    )
}

fun RemotePokemon.toEntity(): PokemonEntity {
    return PokemonEntity(
        id = this.url?.takePokedexIndex() ?: 0,
        name = this.name?.capitalize(Locale.current) ?: "MissingNo",
    )
}

fun String.takePokedexIndex(): Int {
    return try {
        this.dropLast(1).split("/").last().toInt()
    }catch (_: Exception){
        0
    }
}