package com.gds.rickmortyapp.data.repository

import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.firebase.RealtimeDatabase
import com.gds.rickmortyapp.data.datasource.firebase.UserDataSource
import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.data.model.user.NewUser

class UserRepository(
    private val dbLocal: RickMortyDatabase,
    private val dbRemote: RealtimeDatabase,
    private val userDataSource: UserDataSource
) {
    //Local
    suspend fun saveUserLocal(user: LoggedInUser) = dbLocal.daoUser().insert(user)
    suspend fun deleteUserLocal(user: LoggedInUser) = dbLocal.daoUser().delete(user)
    suspend fun updateUserLocal(user: LoggedInUser) = dbLocal.daoUser().update(user)
    suspend fun getUserLocal(user: LoggedInUser) = dbLocal.daoUser().getUsers(user.userId.toString())
    suspend fun getAllUsersLocal() = dbLocal.daoUser().getAllUsers()
    //Remote
    suspend fun saveUserRemote(user: LoggedInUser) = dbRemote.registerSaveUser(user)
    suspend fun deleteUserRemote(user: LoggedInUser) = dbRemote.deleteDataUser(user)
    suspend fun updateUserRemote(user: LoggedInUser) = dbRemote.updateDataUser(user)
    suspend fun getUserRemote(user: LoggedInUser) = dbRemote.getUser(user)
    suspend fun getAllUsersRemote() = dbRemote.getAllUsers()
    //recuperandoDadosFirebase
    fun userKey()  = userDataSource.userKey()
    suspend fun currentUser()= userDataSource.currentUser()
    suspend fun isUserLogged()= userDataSource.verifyCurrentUser()

}
