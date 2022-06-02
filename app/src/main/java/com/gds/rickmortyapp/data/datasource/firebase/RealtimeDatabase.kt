package com.gds.rickmortyapp.data.datasource.firebase

import com.gds.rickmortyapp.data.model.user.NewUser
import com.google.firebase.database.DatabaseReference

class RealtimeDatabase(realtime: DatabaseReference) : FirebaseUtil.RealtimeDatabase {
    private val realtimeDB: DatabaseReference

    init {
        realtimeDB = realtime
    }

    override suspend fun registerSaveUser(newUser: NewUser) {
        realtimeDB.child(USUARIOS).child(newUser.id.toString()).setValue(newUser)
    }

    override suspend fun deleteDataUser(newUser: NewUser) {
        realtimeDB.child(USUARIOS).child(newUser.id.toString()).removeValue()
    }

    override suspend fun updateDataUser(newUser: NewUser) {
        realtimeDB.child(USUARIOS).child(newUser.id.toString()).setValue(newUser)
    }

    override suspend fun getUser(newUser: NewUser) {
        realtimeDB.child(USUARIOS).child(newUser.id.toString()).get()
    }

    override suspend fun getAllUsers() {
        realtimeDB.child(USUARIOS).get()
    }


    companion object{
        const val USUARIOS = "Usuarios"
    }

}