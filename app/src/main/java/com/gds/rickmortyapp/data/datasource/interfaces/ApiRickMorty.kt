package com.gds.rickmortyapp.data.datasource.interfaces

import com.gds.rickmortyapp.data.model.episodeos.Episode
import com.gds.rickmortyapp.data.model.localizacao.Location
import com.gds.rickmortyapp.data.model.personagem.Character
import com.gds.rickmortyapp.data.model.personagem.core.enums.GenderPersonage
import com.gds.rickmortyapp.data.model.personagem.core.enums.LifeStatus
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRickMorty {

    @GET("/character")
    suspend fun getAllCharacters(): Response<Character>

    @GET("/character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): Response<Character>

    @GET("/character/{id}")
    suspend fun getCharacters(
        @Path("id") id: IntArray
    ): Response<Character>

    @GET("/character/?")
    suspend fun getCharacterFromFilter(
        @Query("name") name: String,
        @Query("status") status: LifeStatus?,
        @Query("species") specie: String?,
        @Query("type") type: String?,
        @Query("gender") gender: GenderPersonage
    ): Response<Character>


    @GET("/location")
    suspend fun getAllLocation(): Response<Location>

    @GET("/location/{id}")
    suspend fun getLocation(
        @Path("id") id: Int
    ): Response<Location>

    @GET("/location/{id}")
    suspend fun getLocations(
        @Path("id") id: IntArray
    ): Response<Location>

    @GET("/location/?")
    suspend fun getLocationFromFilter(
        @Query("name") name: String,
        @Query("type") type: String?,
        @Query("dimension") dimension: String?
    ): Response<Location>


    @GET("/episode")
    suspend fun getAllEpisodes(): Response<Episode>

    @GET("/episode/{id}")
    suspend fun getEpisode(
        @Path("id") id: Int
    ): Response<Episode>

    @GET("/episode/{id}")
    suspend fun getEpisodes(
        @Path("id") id: IntArray
    ): Response<Episode>

    @GET("/episode/?")
    suspend fun getEpisodesWithFilter(
        @Query("name") name: String,
        @Query("episode") episode: Int
    ): Response<Episode>


}