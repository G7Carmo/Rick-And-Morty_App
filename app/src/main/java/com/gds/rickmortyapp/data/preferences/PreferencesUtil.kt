package com.gds.rickmortyapp.data.preferences

import android.content.Context
import com.gds.rickmortyapp.util.Constants.RICK_MORTY_PREF

class PreferencesUtil(context: Context) {
    private val _sharedPreferences = context.getSharedPreferences(RICK_MORTY_PREF,Context.MODE_PRIVATE)

    fun setString(key : String,value : String){
        _sharedPreferences.edit().putString(key,value).apply()
    }
    fun getString(key:String): String {
        return _sharedPreferences.getString(key,"") ?: ""
    }
    fun setInt(key : String,value : Int){
        _sharedPreferences.edit().putInt(key,value).apply()
    }
    fun getInt(key:String): Int {
        return _sharedPreferences.getInt(key,0)
    }
    fun setFloat(key :String,value: Float){
        _sharedPreferences.edit().putFloat(key, value).apply()
    }
    fun getFloat(key: String): Float{
        return _sharedPreferences.getFloat(key,0f)
    }
    fun setLong(key: String,value: Long){
        _sharedPreferences.edit().putLong(key, value).apply()
    }
    fun getLong(key: String) : Long{
        return _sharedPreferences.getLong(key,0)
    }
    fun setBoolean(key: String,value: Boolean){
        _sharedPreferences.edit().putBoolean(key, value).apply()
    }
    fun getBoolean(key: String):Boolean{
        return _sharedPreferences.getBoolean(key,false)
    }
}