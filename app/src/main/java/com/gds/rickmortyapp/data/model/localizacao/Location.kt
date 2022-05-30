package com.gds.rickmortyapp.data.model.localizacao


data class Location(
    val info: LocationInfo,
    val results: List<LocationResult>
)