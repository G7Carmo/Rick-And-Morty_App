package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gds.rickmortyapp.data.model.localizacao.Location
import com.gds.rickmortyapp.data.repository.LocationRepository
import com.gds.rickmortyapp.util.result.ResultUtil
import kotlinx.coroutines.launch

class LocationViewModel(
    locRepo: LocationRepository
) : ViewModel() {
    private val locationRepo : LocationRepository
    init {
        this.locationRepo = locRepo
        getLocationList()
    }

    private val _locationList = MutableLiveData<ResultUtil<Location>>()
    val locationList : LiveData<ResultUtil<Location>> get() = _locationList

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
}