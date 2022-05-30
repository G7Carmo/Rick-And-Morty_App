package com.gds.rickmortyapp.data.repository

import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.model.personagem.CharacterResult
import com.gds.rickmortyapp.data.model.personagem.core.enums.GenderPersonage
import com.gds.rickmortyapp.data.model.personagem.core.enums.LifeStatus

class CharacterRepository(
    private val database: RickMortyDatabase,
    private val apiDataSource: ApiDataSource
) {

    //RemoteApi
    suspend fun getAllCharacter() = apiDataSource.getAllCharacters()
    suspend fun getCharacter(id: Int) = apiDataSource.getCharacter(id)

    suspend fun getCharacters(id: IntArray) = apiDataSource.getCharacters(id)

    suspend fun getCharacterFromFilter(
        name: String,
        status: LifeStatus?,
        specie: String?,
        type: String?,
        gender: GenderPersonage
    ) = apiDataSource.getCharacterFromFilter(name, status, specie, type, gender)

    //Local
    suspend fun insertCharacters(vararg character: CharacterResult) =
        database.daoCharacter().insertCharacters(
            *character
        )

    suspend fun insertCharacter(character: CharacterResult) =
        database.daoCharacter().insertCharacter(character)

    suspend fun deleteCharacters(vararg character: CharacterResult) =
        database.daoCharacter().deleteCharacters(*character)

    suspend fun deleteCharacter(character: CharacterResult) =
        database.daoCharacter().deleteCharacter(character)

    suspend fun updateCharacters(vararg character: CharacterResult) =
        database.daoCharacter().updateCharacters(*character)

    suspend fun updateCharacter(character: CharacterResult) =
        database.daoCharacter().updateCharacter(character)

    suspend fun getAllCharacterDb() = database.daoCharacter().getAllCharacterDb()


}