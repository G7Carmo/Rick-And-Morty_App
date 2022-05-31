package com.gds.rickmortyapp.ui.view

import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.model.episodeos.EpisodeResult
import com.gds.rickmortyapp.data.model.localizacao.Location
import com.gds.rickmortyapp.data.model.localizacao.LocationResult
import com.gds.rickmortyapp.data.model.personagem.CharacterResult
import com.gds.rickmortyapp.data.repository.CharacterRepository
import com.gds.rickmortyapp.data.repository.EpisodeRepository
import com.gds.rickmortyapp.data.repository.LocationRepository
import com.gds.rickmortyapp.databinding.ActivityMainBinding
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.MainViewModel
import com.gds.rickmortyapp.util.extension.dialog
import com.gds.rickmortyapp.util.extension.hide
import com.gds.rickmortyapp.util.extension.show
import com.gds.rickmortyapp.util.result.ResultUtil

class MainActivity : BaseWithViewModelActivity<ActivityMainBinding, MainViewModel>() {
    private lateinit var characterList: List<CharacterResult>
    private lateinit var locationList: List<LocationResult>
    private lateinit var episodeList: List<EpisodeResult>
    override val viewModel: MainViewModel = getMainViewModel()

    private fun getMainViewModel(): MainViewModel {
        return MainViewModel(
            CharacterRepository(RickMortyDatabase.invoke(this), ApiDataSource(Injection.api)),
            LocationRepository(RickMortyDatabase.invoke(this), ApiDataSource(Injection.api)),
            EpisodeRepository(RickMortyDatabase.invoke(this), ApiDataSource(Injection.api)),
        )
    }

    override fun getLayoutBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun codeInject() {
        observers()
    }

    private fun observers() {
        viewModel.characterList.observe(this) { result ->
            when (result) {
                is ResultUtil.Success -> {
                    binding.pbMain.hide()
                    characterList = result.data.results
                }
                is ResultUtil.Error -> {
                    errorResult(result)
                }
                is ResultUtil.Loading -> {
                    showLoading()
                }
            }
        }
        viewModel.locationList.observe(this) { result ->
            when (result) {
                is ResultUtil.Success -> {
                    binding.pbMain.hide()
                    locationList = result.data.results
                }
                is ResultUtil.Error -> {
                    errorResult(result)
                }
                is ResultUtil.Loading -> {
                    showLoading()
                }
            }
        }
        viewModel.episodeList.observe(this) { result ->
            when (result) {
                is ResultUtil.Success -> {
                    binding.pbMain.hide()
                    episodeList = result.data.results
                }
                is ResultUtil.Error -> {
                    errorResult(result)
                }
                is ResultUtil.Loading -> {
                    showLoading()
                }
            }
        }
    }

    private fun showLoading() {
        binding.pbMain.show()
    }

    private fun errorResult(result: ResultUtil.Error) {
        binding.pbMain.hide()
        dialog("Falha", result.msg)
    }

}