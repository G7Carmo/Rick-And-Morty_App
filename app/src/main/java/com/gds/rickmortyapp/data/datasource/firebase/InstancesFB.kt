package com.gds.rickmortyapp.data.datasource.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

object InstancesFB {
    val auth by lazy { FirebaseAuth.getInstance() }
    val remoteDatabase by lazy { FirebaseDatabase.getInstance().reference }
    val storage by lazy { FirebaseStorage.getInstance() }
}