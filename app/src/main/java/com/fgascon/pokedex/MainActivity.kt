package com.fgascon.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.fgascon.pokedex.presentation.PokedexScreen
import com.fgascon.pokedex.presentation.PokedexViewModel
import com.fgascon.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlin.math.abs

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val navController = rememberNavController()
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokedexScreen()
                }
            }
        }
    }


}

private fun getPokemon(): List<Pokemon> {
    return listOf(
        Pokemon("Bulbasaur", 1),
        Pokemon("Ivysaur", 2),
        Pokemon("Venusaur", 3),
        Pokemon("Charmander", 4),
        Pokemon("Charmeleon", 5),
        Pokemon("Charizard", 6),
        Pokemon("Squirtle", 7),
        Pokemon("Wartortle", 8),
        Pokemon("Blastoise", 9),
        Pokemon("Caterpie", 10),
        Pokemon("Metapod", 11),
        Pokemon("Butterfree", 12),
        Pokemon("Weedle", 13),
        Pokemon("Kakuna", 14),
        Pokemon("Beedrill", 15),
        Pokemon("Pidgey", 16),
        Pokemon("Pidgeotto", 17),
        Pokemon("Pidgeot", 18),
        Pokemon("Rattata", 19),
        Pokemon("Raticate", 20),
        Pokemon("Spearow", 21),
        Pokemon("Fearow", 22),
        Pokemon("Ekans", 23),
        Pokemon("Arbok", 24),
        Pokemon("Pikachu", 25),
        Pokemon("Raichu", 26),
        Pokemon("Sandshrew", 27),
        Pokemon("Sandslash", 28),
        Pokemon("Nidoran", 29),
        Pokemon("Nidorina", 30),
        Pokemon("Nidoqueen", 31),
        Pokemon("Nidoran", 32),
        Pokemon("Nidorino", 33),
        Pokemon("Nidoking", 34),
        Pokemon("Clefairy", 35),
        Pokemon("Clefable", 36),
        Pokemon("Vulpix", 37),
        Pokemon("Ninetales", 38),
        Pokemon("Jigglypuff", 39),
        Pokemon("Wigglytuff", 40),
    )
}



