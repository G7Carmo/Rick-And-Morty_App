package com.gds.rickmortyapp.ui.view

import android.annotation.SuppressLint
import com.gds.rickmortyapp.databinding.ActivitySplashBinding
import com.gds.rickmortyapp.ui.view.base.BaseActivity
import com.gds.rickmortyapp.ui.view.login.LoginActivity
import com.gds.rickmortyapp.util.Constants.TIMER_SPLASH
import com.gds.rickmortyapp.util.extension.splashTimer

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override fun getLayoutBinding() = ActivitySplashBinding.inflate(layoutInflater)
    override fun getViewRoot() = binding.root
    override fun codeInject() {
        splashTimer(TIMER_SPLASH, LoginActivity())
    }
}