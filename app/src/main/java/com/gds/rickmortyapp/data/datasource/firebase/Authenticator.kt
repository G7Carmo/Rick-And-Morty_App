package com.gds.rickmortyapp.data.datasource.firebase

import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB.auth


class Authenticator : FirebaseUtil.Authenticator {
    override suspend fun registerUser(
        email: String,
        password: String
    ) = auth.createUserWithEmailAndPassword(email, password)


    override suspend fun login(email: String, password: String) =
        auth.signInWithEmailAndPassword(email, password)

    override suspend fun resetPassword(email: String) = auth.sendPasswordResetEmail(email)

    override suspend fun logout() = auth.signOut()
}