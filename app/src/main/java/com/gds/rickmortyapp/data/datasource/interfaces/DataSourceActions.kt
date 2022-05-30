package com.gds.rickmortyapp.data.datasource.interfaces

import com.gds.rickmortyapp.data.model.episodeos.Episode
import com.gds.rickmortyapp.data.model.localizacao.Location
import com.gds.rickmortyapp.data.model.personagem.Character
import com.gds.rickmortyapp.data.model.personagem.core.enums.GenderPersonage
import com.gds.rickmortyapp.data.model.personagem.core.enums.LifeStatus
import retrofit2.Response

interface DataSourceActions {
    suspend fun getAllCharacters(): Response<Character>

    suspend fun getCharacter(id: Int): Response<Character>

    suspend fun getCharacters(id: IntArray): Response<Character>

    suspend fun getCharacterFromFilter(
        name: String,
        status: LifeStatus?,
        specie: String?,
        type: String?,
        gender: GenderPersonage
    ): Response<Character>

    suspend fun getAllLocation(): Response<Location>

    suspend fun getLocation(id: Int): Response<Location>

    suspend fun getLocations(id: IntArray): Response<Location>

    suspend fun getLocationFromFilter(
        name: String,
        type: String?,
        dimension: String?
    ): Response<Location>


    suspend fun getAllEpisodes(): Response<Episode>

    suspend fun getEpisode(id: Int): Response<Episode>

    suspend fun getEpisodes(id: IntArray): Response<Episode>

    suspend fun getEpisodesWithFilter(
        name: String,
        episode: Int
    ): Response<Episode>


}