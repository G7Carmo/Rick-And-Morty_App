package com.gds.rickmortyapp.ui.view

import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.model.episodeos.EpisodeResult
import com.gds.rickmortyapp.data.repository.EpisodeRepository
import com.gds.rickmortyapp.databinding.ActivityEpisodeBinding
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.EpisodeViewModel
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory
import com.gds.rickmortyapp.util.extension.dialog
import com.gds.rickmortyapp.util.result.ResultUtil

class EpisodeActivity : BaseWithViewModelActivity<ActivityEpisodeBinding, EpisodeViewModel>() {
    private lateinit var episodeList: List<EpisodeResult>
    override fun getLayoutBinding() = ActivityEpisodeBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun getMyViewModel(): EpisodeViewModel {
        return ViewModelProvider(this,ViewModelFactory(this))[EpisodeViewModel::class.java]
    }

    override fun codeInject() {
        observers()
    }

    private fun observers() {
        viewModel.episodeList.observe(this) { result ->
            when (result) {
                is ResultUtil.Success -> {
//                    binding.pbMain.hide()
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
//        binding.pbMain.show()
    }

    private fun errorResult(result: ResultUtil.Error) {
//        binding.pbMain.hide()
        dialog("Falha", result.msg)
    }
}