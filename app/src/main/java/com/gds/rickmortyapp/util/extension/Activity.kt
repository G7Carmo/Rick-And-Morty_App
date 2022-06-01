package com.gds.rickmortyapp.util.extension

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.gds.rickmortyapp.R
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.util.Constants.LOGIN_AUTOMATIC
import com.google.android.material.textfield.TextInputLayout

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
fun AppCompatActivity.dialog(title:String,msg:String){
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(msg)
        .setPositiveButton(R.string.ok){ _, _->
        }.show()
}

fun AppCompatActivity.message(msg: String){
    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.launchError(msg: String, vararg text: TextInputLayout){
    text.forEach {
        it.error = msg
    }
}