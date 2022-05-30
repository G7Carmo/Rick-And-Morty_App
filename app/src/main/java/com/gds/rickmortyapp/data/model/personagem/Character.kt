package com.gds.rickmortyapp.data.model.personagem

import com.gds.rickmortyapp.data.model.personagem.core.CharacterInfo

data class Character(
    val info: CharacterInfo,
    val results: List<CharacterResult>
)