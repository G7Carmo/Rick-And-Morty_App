package com.gds.rickmortyapp.data.model.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewUser(
    @PrimaryKey(autoGenerate = true)
    override val id: String? = "",
    @ColumnInfo override val email: String,
    @ColumnInfo override val passwd: String,
    @ColumnInfo override val displayName: String? = ""
) : User {

}
