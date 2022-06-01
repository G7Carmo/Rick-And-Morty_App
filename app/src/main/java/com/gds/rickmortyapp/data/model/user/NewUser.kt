package com.gds.rickmortyapp.data.model.user

data class NewUser(
    override val id: String? = "",
    override val email: String?,
    override val passwd: String?,
    override val displayName: String? = ""
) : User
