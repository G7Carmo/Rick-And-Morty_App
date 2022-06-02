package com.gds.rickmortyapp.data.database.dao

import androidx.room.*
import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.data.model.user.NewUser

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: LoggedInUser)

    @Delete
    suspend fun delete(user: LoggedInUser)

    @Update
    suspend fun update( user: LoggedInUser)

    @Query("SELECT id FROM NewUser")
    suspend fun getUsers(id : String)

    @Query("SELECT * FROM NewUser")
    suspend fun getAllUsers()
}