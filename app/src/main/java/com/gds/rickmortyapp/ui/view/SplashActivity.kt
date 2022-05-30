package com.gds.rickmortyapp.ui.view

import android.annotation.SuppressLint
import androidx.lifecycle.lifecycleScope
import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.repository.CharacterRepository
import com.gds.rickmortyapp.data.repository.EpisodeRepository
import com.gds.rickmortyapp.databinding.ActivitySplashBinding
import com.gds.rickmortyapp.di.InstanceRetrofit
import com.gds.rickmortyapp.ui.viewmodel.SplashViewModel
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    override val viewModel: SplashViewModel by lazy { SplashViewModel() }
    override fun getLayoutBinding() = ActivitySplashBinding.inflate(layoutInflater)
    override fun getViewRoot() = binding.root
    override fun codeInject() {

    }

}