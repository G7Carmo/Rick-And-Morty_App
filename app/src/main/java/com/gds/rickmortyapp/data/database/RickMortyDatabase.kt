package com.gds.rickmortyapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gds.rickmortyapp.data.database.dao.CharacterDao
import com.gds.rickmortyapp.data.database.dao.EpisodeDao
import com.gds.rickmortyapp.data.database.dao.LocationDao
import com.gds.rickmortyapp.data.model.episodeos.Episode
import com.gds.rickmortyapp.data.model.localizacao.Location
import com.gds.rickmortyapp.data.model.personagem.Character
import com.gds.rickmortyapp.util.Constants.DATABASE_NAME
import com.gds.rickmortyapp.util.Constants.VERSION_DB

@Database(
    entities = [
        Episode::class,
        Location::class,
        Character::class
    ], version = VERSION_DB, exportSchema = false
)
@TypeConverters(Converter::class)
abstract class RickMortyDatabase : RoomDatabase() {
    abstract fun daoCharacter(): CharacterDao
    abstract fun daoLocation(): LocationDao
    abstract fun daoEpisode(): EpisodeDao

    companion object {

        @Volatile
        private var instance: RickMortyDatabase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            instance ?: createDataBase(context).also { database ->
                instance = database
            }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RickMortyDatabase::class.java,
                DATABASE_NAME
            ).build()

    }
}