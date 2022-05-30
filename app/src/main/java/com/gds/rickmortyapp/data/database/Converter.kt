package com.gds.rickmortyapp.data.database

import androidx.room.TypeConverter
import com.gds.rickmortyapp.data.model.personagem.core.CharacterLocation
import com.gds.rickmortyapp.data.model.personagem.core.CharacterOrigin

class Converter {

    @TypeConverter
    fun fromCharacterOrigin(characterOrigin: CharacterOrigin): String {
        return characterOrigin.name
    }

    @TypeConverter
    fun toCharacterOrigin(name: String, url: String): CharacterOrigin {
        return CharacterOrigin(name, url)
    }

    @TypeConverter
    fun fromCharacterLocation(characterLocation: CharacterLocation): String {
        return characterLocation.name
    }

    @TypeConverter
    fun toCharacterLocation(name: String, url: String): CharacterLocation {
        return CharacterLocation(name, url)
    }
}