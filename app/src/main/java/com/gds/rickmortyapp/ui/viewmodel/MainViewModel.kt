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
) : ViewModel() {


}