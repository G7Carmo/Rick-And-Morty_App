package com.gds.rickmortyapp.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.datasource.firebase.RealtimeDatabase
import com.gds.rickmortyapp.data.datasource.firebase.UserDataSource
import com.gds.rickmortyapp.data.repository.*
import com.gds.rickmortyapp.di.Injection

open class ViewModelFactory(
    val context: Context
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
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(
                    authRepo = AuthenticatorRepository(
                        datasource = Authenticator(
                            auth = InstancesFB.auth
                        )
                    ),
                    userRepository = UserRepository(
                        userDataSource = UserDataSource(InstancesFB.auth),
                        dbLocal = RickMortyDatabase.invoke(context),
                        dbRemote = RealtimeDatabase(InstancesFB.remoteDatabase)
                    ),
                    userDataSource = UserDataSource(InstancesFB.auth)
                ) as T
            }
            modelClass.isAssignableFrom(ResetPasswordViewModel::class.java) -> {
                ResetPasswordViewModel(
                    authRepo = AuthenticatorRepository(
                        datasource = Authenticator(
                            auth = InstancesFB.auth
                        )
                    )
                ) as T
            }
            modelClass.isAssignableFrom(CharacterViewModel::class.java)->{
                CharacterViewModel(
                    charRepo = CharacterRepository(
                        database = RickMortyDatabase.invoke(context),
                        apiDataSource = ApiDataSource(Injection.api)
                    )
                ) as T
            }
            modelClass.isAssignableFrom(EpisodeViewModel::class.java)->{
                EpisodeViewModel(
                    epiRepo = EpisodeRepository(
                        database = RickMortyDatabase.invoke(context),
                        apiDataSource = ApiDataSource(Injection.api)
                    )
                ) as T
            }
            modelClass.isAssignableFrom(LocationViewModel::class.java)->{
                LocationViewModel(
                    locRepo = LocationRepository(
                        database = RickMortyDatabase.invoke(context),
                        apiDataSource = ApiDataSource(Injection.api)
                    )
                ) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java)->{
                MainViewModel() as T
            }
            else -> throw IllegalArgumentException("ViewModel Nao encontrado !!")
        }
    }
}