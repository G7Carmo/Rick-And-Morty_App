package com.gds.rickmortyapp.di

import android.content.Context
import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.interfaces.ApiRickMorty
import com.gds.rickmortyapp.data.preferences.PreferencesUtil
import com.gds.rickmortyapp.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    private val retrofit: Retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val api: ApiRickMorty by lazy {
        retrofit.create(ApiRickMorty::class.java)
    }

    fun getPref(context: Context): PreferencesUtil {
        return PreferencesUtil(context)
    }

    fun getDatabase(context: Context) : RickMortyDatabase{
        return RickMortyDatabase.invoke(context)
    }
}