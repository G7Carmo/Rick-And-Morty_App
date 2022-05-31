package com.gds.rickmortyapp.ui.view

import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.model.personagem.CharacterResult
import com.gds.rickmortyapp.data.repository.CharacterRepository
import com.gds.rickmortyapp.databinding.ActivityCharacterBinding
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.CharacterViewModel
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory
import com.gds.rickmortyapp.util.extension.dialog
import com.gds.rickmortyapp.util.extension.hide
import com.gds.rickmortyapp.util.extension.show
import com.gds.rickmortyapp.util.result.ResultUtil

class CharacterActivity :
    BaseWithViewModelActivity<ActivityCharacterBinding, CharacterViewModel>() {
    private lateinit var characterList: List<CharacterResult>
    override fun getLayoutBinding() = ActivityCharacterBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun getMyViewModel(): CharacterViewModel {
        return ViewModelProvider(this,ViewModelFactory())[CharacterViewModel::class.java]
    }

    override fun codeInject() {
        observers()
    }

    private fun observers() {
        viewModel.characterList.observe(this) { result ->
            when (result) {
                is ResultUtil.Success -> {
//                    binding.progressBar.hide()
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
    }
    private fun showLoading() {
//        binding.pbMain.show()
    }

    private fun errorResult(result: ResultUtil.Error) {
//        binding.pbMain.hide()
        dialog("Falha", result.msg)
    }

}