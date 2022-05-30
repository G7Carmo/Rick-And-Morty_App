package com.gds.rickmortyapp.data.database.dao

import androidx.room.*
import com.gds.rickmortyapp.data.model.localizacao.LocationResult

@Dao
interface LocationDao {

    @Insert
    suspend fun insertLocation(vararg location: LocationResult)

    @Insert
    suspend fun insertLocation(location: LocationResult)

    @Delete
    suspend fun deleteLocation(vararg location: LocationResult)

    @Delete
    suspend fun deleteLocation(location: LocationResult)

    @Update
    suspend fun updateLocation(vararg location: LocationResult)

    @Update
    suspend fun updateLocation(location: LocationResult)

    @Query("SELECT * FROM LocationResult")
    suspend fun getAllLocationDb() : List<LocationResult>

}