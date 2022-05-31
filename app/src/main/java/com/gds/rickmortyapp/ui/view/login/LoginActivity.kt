package com.gds.rickmortyapp.ui.view.login

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.databinding.ActivityLoginBinding
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.ui.view.base.BaseFactoryActivity
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.LoginViewModel
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory
import com.gds.rickmortyapp.util.Constants.LOGIN_AUTOMATIC
import com.gds.rickmortyapp.util.extension.nextScreen

class LoginActivity : BaseWithViewModelActivity<ActivityLoginBinding, LoginViewModel>() {
    private lateinit var email: String
    private lateinit var password: String


    override fun getLayoutBinding() = ActivityLoginBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun getMyViewModel(): LoginViewModel {
        return ViewModelProvider(this,ViewModelFactory())[LoginViewModel::class.java]
    }

    override fun codeInject() {
        setupActivity()
    }

    private fun setupActivity() {
        initView()
        listeners()
        observers()
    }

    private fun initView() = with(binding) {
        email = editInputEmail.text.toString().trim()
        password = editInputSenha.text.toString().trim()
    }

    private fun listeners() = with(binding) {
        textRegister.setOnClickListener {
            nextScreen(RegisterActivity())
        }
        btnLogin.setOnClickListener {

        }
        loginAutmatico.setOnClickListener { view ->
            setAutomaticLogin(view)
        }
        resetPassword.setOnClickListener {
            nextScreen(ResetPasswordActivity())
        }
    }

    private fun setAutomaticLogin(view: View) {
        if (view.isActivated) {
            Injection
                .getPref(this@LoginActivity)
                .setBoolean(LOGIN_AUTOMATIC, true)
        } else {
            Injection
                .getPref(this@LoginActivity)
                .setBoolean(LOGIN_AUTOMATIC, false)
        }
    }

    private fun observers() {

    }

}