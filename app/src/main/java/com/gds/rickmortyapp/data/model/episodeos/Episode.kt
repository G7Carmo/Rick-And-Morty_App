package com.gds.rickmortyapp.data.model.episodeos

data class Episode(
    val id : Int,
    val info: EpisodeInfo,
    val results: List<EpisodeResult>
)