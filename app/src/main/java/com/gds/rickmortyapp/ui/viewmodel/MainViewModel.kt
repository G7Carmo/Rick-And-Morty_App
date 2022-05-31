package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gds.rickmortyapp.data.model.episodeos.Episode
import com.gds.rickmortyapp.data.model.localizacao.Location
import com.gds.rickmortyapp.data.model.personagem.Character
import com.gds.rickmortyapp.data.repository.CharacterRepository
import com.gds.rickmortyapp.data.repository.EpisodeRepository
import com.gds.rickmortyapp.data.repository.LocationRepository
import com.gds.rickmortyapp.util.result.ResultUtil
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(
    charRepo : CharacterRepository,
    locRepo : LocationRepository,
    epiRepo : EpisodeRepository
) : ViewModel(){
    private val characterRepo : CharacterRepository
    private val locationRepo : LocationRepository
    private val episodeRepo : EpisodeRepository

    private val _characterList = MutableLiveData<ResultUtil<Character>>()
    val characterList : LiveData<ResultUtil<Character>> get() = _characterList

    private val _locationList = MutableLiveData<ResultUtil<Location>>()
    val locationList : LiveData<ResultUtil<Location>> get() = _locationList

    private val _episodeList = MutableLiveData<ResultUtil<Episode>>()
    val episodeList : LiveData<ResultUtil<Episode>> get() = _episodeList
    init {
        this.characterRepo = charRepo
        this.locationRepo = locRepo
        this.episodeRepo = epiRepo
        getLists()
    }

    private fun getLists() {
        getCharacterList()
        getLocationList()
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

    private fun getLocationList() = viewModelScope.launch{
        _locationList.value = ResultUtil.Loading
        val allCharacter = locationRepo.getAllLocation()
        if (allCharacter.isSuccessful){
            allCharacter.body()?.let {
                _locationList.value = ResultUtil.Success(it)
            }
        }else{
            _locationList.value = ResultUtil.Error(allCharacter.message())
        }
    }

    private fun getCharacterList() = viewModelScope.launch{
        _characterList.value = ResultUtil.Loading
        val allCharacter = characterRepo.getAllCharacter()
        if (allCharacter.isSuccessful){
            allCharacter.body()?.let {
                _characterList.value = ResultUtil.Success(it)
            }
        }else{
            _characterList.value = ResultUtil.Error(allCharacter.message())
        }
    }

}