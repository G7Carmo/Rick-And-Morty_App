package com.gds.rickmortyapp.data.datasource.firebase
import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.data.model.user.NewUser
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot

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
        suspend fun registerSaveUser(user: LoggedInUser): Task<Void>
        suspend fun deleteDataUser(user: LoggedInUser): Task<Void>
        suspend fun updateDataUser(user: LoggedInUser): Task<Void>
        suspend fun getUser(user: LoggedInUser): Task<DataSnapshot>
        suspend fun getAllUsers(): Task<DataSnapshot>
    }

    interface Storage{

    }

    interface UserData{
        suspend fun currentUser(): FirebaseUser?
        fun userKey(): String
        suspend fun verifyCurrentUser(): Boolean
    }
}