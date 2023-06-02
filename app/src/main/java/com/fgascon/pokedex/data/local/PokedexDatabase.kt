package com.fgascon.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [PokemonEntity::class], version = 2)
abstract class PokedexDatabase : RoomDatabase() {
    abstract fun getPokedexDao(): PokedexDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE pokemons ADD COLUMN imageUrl TEXT NOT NULL DEFAULT ''")
    }
}