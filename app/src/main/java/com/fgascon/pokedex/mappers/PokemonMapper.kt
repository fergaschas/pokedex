package com.fgascon.pokedex.mappers

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import com.fgascon.pokedex.model.Pokemon
import com.fgascon.pokedex.data.local.PokemonEntity
import com.fgascon.pokedex.data.network.RemotePokemon


fun PokemonEntity.toDomain(): Pokemon {
    return Pokemon(
        pokedexIndex = this.id,
        name = this.name,
        imageUrl = this.imageUrl
    )
}

fun RemotePokemon.toEntity(): PokemonEntity {
    val pokedexIndex = this.url?.takePokedexIndex() ?: 0
    val imageUrl = pokedexIndex.toImageUrl()
    return PokemonEntity(
        id = this.url?.takePokedexIndex() ?: 0,
        name = this.name?.capitalize(Locale.current) ?: "MissingNo",
        imageUrl = imageUrl,
    )
}

private fun String.takePokedexIndex(): Int {
    return try {
        this.dropLast(1).split("/").last().toInt()
    }catch (_: Exception){
        0
    }
}

private fun Int.toImageUrl(): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this}.png"
}