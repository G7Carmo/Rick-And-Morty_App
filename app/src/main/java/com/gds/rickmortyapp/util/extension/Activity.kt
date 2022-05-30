package com.gds.rickmortyapp.util.extension

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.splashTimer(milliseconds : Long , activity: AppCompatActivity){
    Handler(Looper.myLooper()!!).postDelayed({
        nextScreen(activity)
    },milliseconds)
}
fun AppCompatActivity.nextScreen(activity: AppCompatActivity){
    Intent(this,activity::class.java).apply {
        startActivity(this)
    }
}