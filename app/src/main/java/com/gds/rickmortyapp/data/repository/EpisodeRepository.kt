package com.gds.rickmortyapp.data.repository

import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.model.episodeos.EpisodeResult

class EpisodeRepository(
    private val database: RickMortyDatabase,
    private val apiDataSource: ApiDataSource
) {

    //Api
    suspend fun getAllEpisodes() = apiDataSource.getAllEpisodes()

    suspend fun getEpisode(id: Int) = apiDataSource.getEpisode(id)

    suspend fun getEpisodes(id: IntArray) = apiDataSource.getEpisodes(id)

    suspend fun getEpisodesWithFilter(name: String, episode: Int) =
        apiDataSource.getEpisodesWithFilter(name, episode)

    //Local

    suspend fun insertEpisodes(vararg episode: EpisodeResult) = database.daoEpisode().insertEpisodes(*episode)

    suspend fun insertEpisode(episode: EpisodeResult)= database.daoEpisode().insertEpisode(episode)

    suspend fun deleteEpisodes(vararg episode: EpisodeResult)= database.daoEpisode().deleteEpisodes(*episode)

    suspend fun deleteEpisode(episode: EpisodeResult)= database.daoEpisode().deleteEpisode(episode)

    suspend fun updateEpisodes(vararg episode: EpisodeResult)= database.daoEpisode().updateEpisodes(*episode)

    suspend fun updateEpisode(episode: EpisodeResult)= database.daoEpisode().updateEpisode(episode)

    suspend fun getAllEpisodeDb() = database.daoEpisode().getAllEpisodeDb()
}