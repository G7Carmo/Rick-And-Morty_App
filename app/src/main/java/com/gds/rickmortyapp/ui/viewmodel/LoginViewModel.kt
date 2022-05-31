package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository

class LoginViewModel(
    private val authRepo: AuthenticatorRepository
) : ViewModel() {

}