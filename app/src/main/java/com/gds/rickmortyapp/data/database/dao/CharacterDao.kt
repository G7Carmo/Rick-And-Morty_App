package com.gds.rickmortyapp.data.database.dao

import androidx.room.*
import com.gds.rickmortyapp.data.model.personagem.CharacterResult

@Dao
interface CharacterDao {

    @Insert
    suspend fun insertCharacters(vararg character: CharacterResult)

    @Insert
    suspend fun insertCharacter(character: CharacterResult)

    @Delete
    suspend fun deleteCharacters(vararg character: CharacterResult)

    @Delete
    suspend fun deleteCharacter(character: CharacterResult)

    @Update
    suspend fun updateCharacters(vararg character: CharacterResult)

    @Update
    suspend fun updateCharacter(character: CharacterResult)

    @Query("SELECT * FROM CharacterResult")
    suspend fun getAllCharacterDb() : List<CharacterResult>

}