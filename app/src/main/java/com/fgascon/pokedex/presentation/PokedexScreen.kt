package com.fgascon.pokedex.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fgascon.pokedex.model.Pokemon
import com.fgascon.pokedex.R
import com.fgascon.pokedex.ui.theme.PokedexTheme
import kotlin.math.abs


@Composable
fun PokedexScreen(viewModel: PokedexViewModel = hiltViewModel(), onPokemonClick: (Pokemon) -> Unit) {
    val state = viewModel.state
    Column(modifier = Modifier.fillMaxSize()) {
        Filter(
            onValueChange = {
                viewModel.filterPokemon(it)
            },
            modifier = Modifier.fillMaxWidth()
        )
        PokemonList(state.value.pokemons, onPokemonClick = onPokemonClick)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Filter(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            onValueChange(it)
            text = it
        },
        label = {
            Text(text = "Search")
        },
        modifier = modifier
    )
}

@Composable
private fun PokemonList(pokemonList: List<Pokemon>, modifier: Modifier = Modifier, onPokemonClick: (Pokemon) -> Unit) {
    val listState = rememberLazyListState()
    LazyColumn(state = listState) {
        itemsIndexed(items = pokemonList) { index, pokemon ->
            val position = remember {
                derivedStateOf {
                    val total = listState.layoutInfo.visibleItemsInfo.count()
                    val first = listState.firstVisibleItemIndex
                    total / 2 - index + first
                }
            }
            PokedexCard(pokemon = pokemon, position = position.value, onClick = onPokemonClick)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun PokedexCard(pokemon: Pokemon, position: Int, onClick: (Pokemon) -> Unit) {
    Box(
        Modifier
            .padding(start = 10.dp * abs(position))
            .background(
                color = Color.hsl(35f, 1f, 0.5f),
                shape = RoundedCornerShape(corner = CornerSize(20.dp))
            )
            .padding(end = 10.dp)
            .fillMaxSize()
            .clickable {
                onClick(pokemon)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier
                    .weight(2f)
                    .background(
                        color = Color.hsl(35f, 1f, 0.5f),
                        shape = RoundedCornerShape(corner = CornerSize(18.dp)),
                    )
                    .padding(10.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.pokeball_icon),
                contentDescription = "poke ball"
            )
            Row(
                modifier = Modifier
                    .weight(8f)
                    .background(color = Color.White, shape = RoundedCornerShape(24.dp))
                    .padding(18.dp)
            ) {
                Text(text = pokemon.pokedexIndex.toString())
                Spacer(Modifier.width(8.dp))
                Text(text = pokemon.name)
            }
        }
    }

}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun GreetingPreview() {
    PokedexTheme {
        Column {
            Filter(onValueChange = {},Modifier.fillMaxWidth())
            PokemonList(
                pokemonList = listOf(
                    Pokemon(name = "Bulbasaur", pokedexIndex = 1, imageUrl = ""),
                    Pokemon(name = "Ivysaur", pokedexIndex = 2, imageUrl = ""),
                    Pokemon(name = "Venusaur", pokedexIndex = 3, imageUrl = ""),
                    Pokemon(name = "Charmander", pokedexIndex = 4, imageUrl = ""),
                    Pokemon(name = "Charmeleon", pokedexIndex = 5, imageUrl = ""),
                    Pokemon(name = "Charizard", pokedexIndex = 6, imageUrl = ""),
                ), Modifier,{}
            )
        }
    }
}