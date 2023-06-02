package com.fgascon.pokedex.di

import android.app.Application
import androidx.room.Room
import com.fgascon.pokedex.data.PokedexRepository
import com.fgascon.pokedex.data.local.MIGRATION_1_2
import com.fgascon.pokedex.data.local.PokedexDao
import com.fgascon.pokedex.data.local.PokedexDatabase
import com.fgascon.pokedex.data.network.PokedexApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokedexModule {

    @Singleton
    @Provides
    fun providePokedexRepository(
        api: PokedexApi, dao: PokedexDao
    ): PokedexRepository {
        return PokedexRepository(api, dao)
    }

    @Singleton
    @Provides
    fun providePokedexDao(application: Application): PokedexDao {
        val db = Room.databaseBuilder(
            application, PokedexDatabase::class.java, "pokedex"
        )
            .addMigrations(MIGRATION_1_2)
            .build()
        return db.getPokedexDao()
    }

    @Singleton
    @Provides
    fun providePokedexApi(): PokedexApi {
        val client = OkHttpClient.Builder().build()

        return Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build().create()
    }
}