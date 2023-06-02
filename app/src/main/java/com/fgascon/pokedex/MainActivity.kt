package com.fgascon.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.fgascon.pokedex.model.Pokemon
import com.fgascon.pokedex.navigation.MainNavigation
import com.fgascon.pokedex.presentation.PokedexScreen
import com.fgascon.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PokedexTheme {
                MainNavigation(
                    navController = navController,
                    startDestination = "pokedex"
                )
            }
        }
    }

}
