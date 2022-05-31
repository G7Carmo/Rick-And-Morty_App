package com.gds.rickmortyapp.data.model.personagem

import com.gds.rickmortyapp.data.model.personagem.core.CharacterInfo
import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("info")
    val info: CharacterInfo,
    @SerializedName("results")
    val results: List<CharacterResult>
)