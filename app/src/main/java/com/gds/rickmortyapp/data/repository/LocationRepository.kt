package com.gds.rickmortyapp.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.model.localizacao.LocationResult
import com.gds.rickmortyapp.data.model.personagem.CharacterResult
import com.gds.rickmortyapp.data.model.personagem.core.enums.GenderPersonage
import com.gds.rickmortyapp.data.model.personagem.core.enums.LifeStatus

class LocationRepository(
    private val database: RickMortyDatabase,
    private val apiDataSource: ApiDataSource
) {
    //RemoteApi
    suspend fun getAllLocation() = apiDataSource.getAllLocation()
    suspend fun getLocation(id: Int) = apiDataSource.getLocation(id)

    suspend fun getLocations(id: IntArray) = apiDataSource.getLocations(id)
    suspend fun getLocationFromFilter(
        name: String,
        type: String?,
        dimension: String?
    ) = apiDataSource.getLocationFromFilter(name, type, dimension)

    //Local
    suspend fun insertLocation(vararg location: LocationResult) = database.daoLocation().insertLocation(*location)

    suspend fun insertLocation(location: LocationResult) = database.daoLocation().insertLocation(location)

    suspend fun deleteLocation(vararg location: LocationResult)= database.daoLocation().deleteLocation(*location)

    suspend fun deleteLocation(location: LocationResult)= database.daoLocation().deleteLocation(location)

    suspend fun updateLocation(vararg location: LocationResult) = database.daoLocation().updateLocation(*location)

    suspend fun updateLocation(location: LocationResult) = database.daoLocation().updateLocation(location)

    suspend fun getAllLocationDb() = database.daoLocation().getAllLocationDb()


}