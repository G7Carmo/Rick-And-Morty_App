package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.data.repository.CharacterRepository
import com.gds.rickmortyapp.data.repository.EpisodeRepository
import com.gds.rickmortyapp.data.repository.LocationRepository

open class ViewModelFactory(
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(
                    authRepo = AuthenticatorRepository(
                        datasource = Authenticator(
                            auth = InstancesFB.auth
                        )
                    )
                ) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                RegisterViewModel(
                    authRepo = AuthenticatorRepository(
                        datasource = Authenticator(
                            auth = InstancesFB.auth
                        )
                    )
                ) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                ResetPasswordViewModel(
                    authRepo = AuthenticatorRepository(
                        datasource = Authenticator(
                            auth = InstancesFB.auth
                        )
                    )
                ) as T
            }
            else -> throw IllegalArgumentException("ViewModel Nao encontrado !!")
        }
    }
}