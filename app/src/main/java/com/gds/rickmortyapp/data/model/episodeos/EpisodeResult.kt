package com.gds.rickmortyapp.data.model.episodeos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class EpisodeResult(
    @SerializedName("air_date")
    @ColumnInfo val airDate: String,

    @SerializedName("characters")
    @ColumnInfo val characters: List<String>,

    @SerializedName("created")
    @ColumnInfo val created: String,

    @SerializedName("episode")
    @ColumnInfo val episode: String,

    @SerializedName("id")
    @PrimaryKey val id: Int,

    @SerializedName("name")
    @ColumnInfo val name: String,

    @SerializedName("url")
    @ColumnInfo val url: String
)