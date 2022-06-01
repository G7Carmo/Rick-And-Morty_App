package com.gds.rickmortyapp.data.datasource.firebase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RealtimeDatabase(realtime : DatabaseReference): FirebaseUtil.RealtimeDatabase {
    private val realtimeDB : DatabaseReference
    init {
        realtimeDB = realtime
    }
    override suspend fun registerSaveUser() {
//        realtimeDB.child()
    }
}