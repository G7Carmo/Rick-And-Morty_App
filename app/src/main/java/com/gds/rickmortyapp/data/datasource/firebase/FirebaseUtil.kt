package com.gds.rickmortyapp.data.datasource.firebase
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface FirebaseUtil {

    interface Authenticator{
        suspend fun registerUser(
            email: String,
            password: String
        ): Task<AuthResult>

        suspend fun login(
            email: String,
            password: String,
        ): Task<AuthResult>

        suspend fun resetPassword(
            email: String,
        ): Task<Void>

        suspend fun logout()
    }

    interface RealtimeDatabase{

    }

    interface Storage{

    }
}