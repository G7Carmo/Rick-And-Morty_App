package com.gds.rickmortyapp.data.model.user

data class LoggedInUser(
    val userId: String?,
    val email: String?,
    val displayName: String?
) {

}
fun LoggedInUser.toMap(): MutableMap<String, Any> {
    val map = mutableMapOf<String, Any>()
    map["id"] = this.userId.toString()
    map["email"] = this.email.toString()
    map["nome"] = this.displayName.toString()
    return map

}