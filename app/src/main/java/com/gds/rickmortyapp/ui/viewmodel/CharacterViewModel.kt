package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gds.rickmortyapp.data.model.personagem.Character
import com.gds.rickmortyapp.data.repository.CharacterRepository
import com.gds.rickmortyapp.util.result.ResultUtil
import kotlinx.coroutines.launch

class CharacterViewModel(
    charRepo: CharacterRepository,
) : ViewModel() {
    private val characterRepo: CharacterRepository

    init {
        this.characterRepo = charRepo
        getCharacterList()

    }
    private val _characterList = MutableLiveData<ResultUtil<Character>>()
    val characterList: LiveData<ResultUtil<Character>> get() = _characterList

    private fun getCharacterList() = viewModelScope.launch {
        _characterList.value = ResultUtil.Loading
        val allCharacter = characterRepo.getAllCharacter()
        if (allCharacter.isSuccessful) {
            allCharacter.body()?.let {
                _characterList.value = ResultUtil.Success(it)
            }
        } else {
            _characterList.value = ResultUtil.Error(allCharacter.message())
        }
    }


}