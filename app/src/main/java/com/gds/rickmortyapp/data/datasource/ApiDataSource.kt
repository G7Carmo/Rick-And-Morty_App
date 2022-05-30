package com.gds.rickmortyapp.data.datasource

import com.gds.rickmortyapp.data.datasource.interfaces.ApiRickMorty
import com.gds.rickmortyapp.data.datasource.interfaces.DataSourceActions
import com.gds.rickmortyapp.data.model.personagem.core.enums.GenderPersonage
import com.gds.rickmortyapp.data.model.personagem.core.enums.LifeStatus

class ApiDataSource(api: ApiRickMorty) : DataSourceActions {
    private val api: ApiRickMorty

    init {
        this.api = api
    }

    override suspend fun getAllCharacters() = api.getAllCharacters()


    override suspend fun getCharacter(id: Int) = api.getCharacter(id)
    override suspend fun getCharacters(id: IntArray) = api.getCharacters(id)

    override suspend fun getCharacterFromFilter(
        name: String,
        status: LifeStatus?,
        specie: String?,
        type: String?,
        gender: GenderPersonage
    )= api.getCharacterFromFilter(name, status, specie, type, gender)

    override suspend fun getAllLocation() = api.getAllLocation()

    override suspend fun getLocation(id: Int) = api.getLocation(id)

    override suspend fun getLocations(id: IntArray) = api.getLocations(id)

    override suspend fun getLocationFromFilter(
        name: String,
        type: String?,
        dimension: String?
    ) = api.getLocationFromFilter(name, type, dimension)

    override suspend fun getAllEpisodes() = api.getAllEpisodes()

    override suspend fun getEpisode(id: Int) = api.getEpisode(id)

    override suspend fun getEpisodes(id: IntArray) = api.getEpisodes(id)

    override suspend fun getEpisodesWithFilter(name: String, episode: Int) =
        api.getEpisodesWithFilter(name, episode)

}