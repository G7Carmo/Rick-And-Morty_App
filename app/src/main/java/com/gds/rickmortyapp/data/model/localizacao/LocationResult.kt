package com.gds.rickmortyapp.data.model.localizacao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class LocationResult(
    @SerializedName("created")
    @ColumnInfo val created: String,

    @SerializedName("dimension")
    @ColumnInfo val dimension: String,

    @SerializedName("id")
    @PrimaryKey val id: Int,

    @SerializedName("name")
    @ColumnInfo val name: String,

    @SerializedName("residents")
    @ColumnInfo val residents: List<String>,

    @SerializedName("type")
    @ColumnInfo val type: String,

    @SerializedName("url")
    @ColumnInfo val url: String
)