package com.gds.rickmortyapp.data.datasource.firebase

import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB.auth
import com.google.firebase.auth.FirebaseAuth


class Authenticator(auth : FirebaseAuth) : FirebaseUtil.Authenticator {
    private val authenticator : FirebaseAuth
    init {
        authenticator = auth
    }
    override suspend fun registerUser(
        email: String,
        password: String
    ) = authenticator.createUserWithEmailAndPassword(email, password)


    override suspend fun login(email: String, password: String) =
        authenticator.signInWithEmailAndPassword(email, password)

    override suspend fun resetPassword(email: String) = authenticator.sendPasswordResetEmail(email)

    override suspend fun logout() = authenticator.signOut()
}