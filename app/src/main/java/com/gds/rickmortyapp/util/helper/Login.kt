package com.gds.rickmortyapp.util.helper

import android.util.Patterns

object Login {
    fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

}