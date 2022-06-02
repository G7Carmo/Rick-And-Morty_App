package com.gds.rickmortyapp.data.datasource.firebase

import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.data.model.user.NewUser
import com.gds.rickmortyapp.data.model.user.toMap
import com.google.firebase.database.DatabaseReference

class RealtimeDatabase(realtime: DatabaseReference) : FirebaseUtil.RealtimeDatabase {
    private val realtimeDB: DatabaseReference

    init {
        realtimeDB = realtime
    }

    override suspend fun registerSaveUser(user: LoggedInUser) =
        realtimeDB.child(USUARIOS).child(user.userId.toString()).setValue(user)

    override suspend fun deleteDataUser(user: LoggedInUser) =
        realtimeDB.child(USUARIOS).child(user.userId.toString()).removeValue()


    override suspend fun updateDataUser(user: LoggedInUser) =
        realtimeDB.child(USUARIOS).child(user.userId.toString()).updateChildren(user.toMap())


    override suspend fun getUser(user: LoggedInUser) =
        realtimeDB.child(USUARIOS).child(user.userId.toString()).get()


    override suspend fun getAllUsers() =
        realtimeDB.child(USUARIOS).get()



    companion object{
        const val USUARIOS = "Usuarios"
    }

}