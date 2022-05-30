package com.gds.rickmortyapp.data.datasource.firebase
import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.util.result.ResultUtil

interface Firebase {

    interface Authenticator{
        suspend fun registerUser(
            email: String,
            password: String
        ): ResultUtil<LoggedInUser>

        suspend fun login(
            email: String,
            password: String,
        ): ResultUtil<LoggedInUser>

        suspend fun resetPassword(
            email: String,
        ): ResultUtil<String>

        suspend fun logout()
    }

    interface RealtimeDatabase{

    }

    interface Storage{

    }
}