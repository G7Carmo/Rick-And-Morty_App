package com.gds.rickmortyapp.util.extension

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.util.Constants.LOGIN_AUTOMATIC

fun AppCompatActivity.splashTimer(milliseconds: Long,action : () -> Unit) {
    Handler(Looper.myLooper()!!).postDelayed({
        action()
    }, milliseconds)
}

fun AppCompatActivity.nextScreen(activity: AppCompatActivity) {
    Intent(this, activity::class.java).apply {
        startActivity(this)
    }
}
fun AppCompatActivity.nextScreenWithFinish(activity: AppCompatActivity) {
    Intent(this, activity::class.java).apply {
        startActivity(this)
        finish()
    }
}

fun AppCompatActivity.isLoginAutomatic(activitySuccess: AppCompatActivity,activityFailure : AppCompatActivity) {
    when (Injection.getPref(this).getBoolean(LOGIN_AUTOMATIC)) {
        true -> {
            nextScreen(activitySuccess)
        }
        false -> {
            nextScreen(activityFailure)
        }
    }

}

