package com.gds.rickmortyapp.data.database.dao

import androidx.room.*
import com.gds.rickmortyapp.data.model.user.NewUser

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: NewUser)

    @Delete
    suspend fun delete(user: NewUser)

    @Update
    suspend fun update(user: NewUser)

    @Query("SELECT id FROM NewUser")
    suspend fun getUsers(id : String)

    @Query("SELECT * FROM NewUser")
    suspend fun getAllUsers()
}