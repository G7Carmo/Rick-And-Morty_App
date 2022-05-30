package com.gds.rickmortyapp.data.model.personagem

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gds.rickmortyapp.data.model.personagem.core.CharacterLocation
import com.gds.rickmortyapp.data.model.personagem.core.CharacterOrigin
import com.google.gson.annotations.SerializedName

@Entity
data class CharacterResult(
    @SerializedName("created")
    @ColumnInfo val created: String,

    @SerializedName("episode")
    @ColumnInfo val episode: List<String>,

    @SerializedName("gender")
    @ColumnInfo val gender: String,

    @SerializedName("id")
    @PrimaryKey val id: Int,

    @SerializedName("image")
    @ColumnInfo val image: String,

    @SerializedName("location")
    @Embedded val location: CharacterLocation,

    @SerializedName("name")
    @ColumnInfo val name: String,

    @SerializedName("origin")
    @Embedded val origin: CharacterOrigin,

    @SerializedName("species")
    @ColumnInfo val species: String,

    @SerializedName("status")
    @ColumnInfo val status: String,

    @SerializedName("type")
    @ColumnInfo val type: String,

    @SerializedName("url")
    @ColumnInfo val url: String
)