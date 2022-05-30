package com.gds.rickmortyapp.data.datasource.firebase

import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.util.result.ResultUtil


class Authenticator : Firebase.Authenticator {
    override suspend fun registerUser(
        email: String,
        password: String
    ): ResultUtil<LoggedInUser> {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String): ResultUtil<LoggedInUser> {
        TODO("Not yet implemented")
    }

    override suspend fun resetPassword(email: String): ResultUtil<String> {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}