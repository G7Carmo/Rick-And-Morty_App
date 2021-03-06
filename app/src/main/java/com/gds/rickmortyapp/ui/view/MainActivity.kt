package com.gds.rickmortyapp.ui.view

import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.model.episodeos.EpisodeResult
import com.gds.rickmortyapp.data.model.localizacao.LocationResult
import com.gds.rickmortyapp.data.model.personagem.CharacterResult
import com.gds.rickmortyapp.data.repository.CharacterRepository
import com.gds.rickmortyapp.data.repository.EpisodeRepository
import com.gds.rickmortyapp.data.repository.LocationRepository
import com.gds.rickmortyapp.databinding.ActivityMainBinding
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.EpisodeViewModel
import com.gds.rickmortyapp.ui.viewmodel.MainViewModel
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory
import com.gds.rickmortyapp.util.extension.dialog
import com.gds.rickmortyapp.util.extension.hide
import com.gds.rickmortyapp.util.extension.show
import com.gds.rickmortyapp.util.result.ResultUtil

class MainActivity : BaseWithViewModelActivity<ActivityMainBinding, MainViewModel>() {

    override fun getLayoutBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun getMyViewModel(): MainViewModel {
        return ViewModelProvider(this, ViewModelFactory(this))[MainViewModel::class.java]
    }

    override fun codeInject() {
    }





}