package com.gds.rickmortyapp.data.repository

import com.gds.rickmortyapp.data.datasource.firebase.Authenticator

class AuthenticatorRepository(datasource : Authenticator) {
    private val auth : Authenticator
    init {
        auth = datasource
    }
    suspend fun registerUser(email : String,password : String) {
        auth.registerUser(email, password)
    }
    suspend fun login(email: String,password: String) = auth.login(email, password)
    suspend fun resetPassword(email: String) = auth.resetPassword(email)
    suspend fun logout() = auth.logout()
}