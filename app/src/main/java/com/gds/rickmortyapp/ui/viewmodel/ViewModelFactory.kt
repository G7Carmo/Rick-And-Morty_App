package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.data.repository.CharacterRepository
import com.gds.rickmortyapp.data.repository.EpisodeRepository
import com.gds.rickmortyapp.data.repository.LocationRepository

open class ViewModelFactory(
    private val charRepo: CharacterRepository? = null,
    private val locRepo : LocationRepository? = null,
    private val epiRepo : EpisodeRepository? = null
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(SplashViewModel::class.java)->SplashViewModel() as T
            modelClass.isAssignableFrom(LoginViewModel::class.java)->LoginViewModel() as T
            else -> throw IllegalArgumentException("ViewModel Nao encontrado !!")
        }
    }
}