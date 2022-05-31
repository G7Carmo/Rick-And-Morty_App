package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gds.rickmortyapp.data.model.episodeos.Episode
import com.gds.rickmortyapp.data.repository.EpisodeRepository
import com.gds.rickmortyapp.util.result.ResultUtil
import kotlinx.coroutines.launch

class EpisodeViewModel(
    epiRepo : EpisodeRepository
) : ViewModel() {
    private val episodeRepo : EpisodeRepository

    private val _episodeList = MutableLiveData<ResultUtil<Episode>>()
    val episodeList : LiveData<ResultUtil<Episode>> get() = _episodeList
    init {
        this.episodeRepo = epiRepo
        getLists()
    }

    private fun getLists() {
        getEpisodeList()
    }

    private fun getEpisodeList()  = viewModelScope.launch{
        _episodeList.value = ResultUtil.Loading
        val allCharacter = episodeRepo.getAllEpisodes()
        if (allCharacter.isSuccessful){
            allCharacter.body()?.let {
                _episodeList.value = ResultUtil.Success(it)
            }
        }else{
            _episodeList.value = ResultUtil.Error(allCharacter.message())
        }
    }

}