package com.gds.rickmortyapp.data.datasource.firebase

import com.google.firebase.auth.FirebaseAuth

class UserDataSource(userAuth : FirebaseAuth) : FirebaseUtil.UserData {
    private val userLogged : FirebaseAuth
    init {
        userLogged = userAuth
    }

    override suspend fun currentUser() = userLogged.currentUser
    override fun userKey() = userLogged.uid.toString()
    override suspend fun verifyCurrentUser() = userLogged.currentUser != null

}