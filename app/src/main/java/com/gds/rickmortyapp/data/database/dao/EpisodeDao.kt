package com.gds.rickmortyapp.data.database.dao

import androidx.room.*
import com.gds.rickmortyapp.data.model.episodeos.EpisodeResult

@Dao
interface EpisodeDao {

    @Insert
    suspend fun insertEpisodes(vararg episode: EpisodeResult)

    @Insert
    suspend fun insertEpisode(episode: EpisodeResult)

    @Delete
    suspend fun deleteEpisodes(vararg episode: EpisodeResult)

    @Delete
    suspend fun deleteEpisode(episode: EpisodeResult)

    @Update
    suspend fun updateEpisodes(vararg episode: EpisodeResult)

    @Update
    suspend fun updateEpisode(episode: EpisodeResult)

    @Query("SELECT * FROM EpisodeResult")
    suspend fun getAllEpisodeDb() : List<EpisodeResult>

}