package com.gds.rickmortyapp.data.repository

import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.firebase.RealtimeDatabase
import com.gds.rickmortyapp.data.model.user.NewUser

class UserRepository(
    private val dbLocal: RickMortyDatabase,
    private val dbRemote: RealtimeDatabase
) {
    //Local
    suspend fun saveUserLocal(newUser: NewUser) = dbLocal.daoUser().insert(newUser)
    suspend fun deleteUserLocal(newUser: NewUser) = dbLocal.daoUser().delete(newUser)
    suspend fun updateUserLocal(newUser: NewUser) = dbLocal.daoUser().update(newUser)
    suspend fun getUserLocal(newUser: NewUser) = dbLocal.daoUser().getUsers(newUser.id.toString())
    suspend fun getAllUsersLocal() = dbLocal.daoUser().getAllUsers()
    //Remote
    suspend fun saveUserRemote(newUser: NewUser) = dbRemote.registerSaveUser(newUser)
    suspend fun deleteUserRemote(newUser: NewUser) = dbRemote.deleteDataUser(newUser)
    suspend fun updateUserRemote(newUser: NewUser) = dbRemote.updateDataUser(newUser)
    suspend fun getUserRemote(newUser: NewUser) = dbRemote.getUser(newUser)
    suspend fun getAllUsersRemote() = dbRemote.getAllUsers()

}
