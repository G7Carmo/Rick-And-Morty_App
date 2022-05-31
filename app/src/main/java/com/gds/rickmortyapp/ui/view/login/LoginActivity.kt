package com.gds.rickmortyapp.ui.view.login

import android.graphics.Color
import android.view.View
import com.gds.rickmortyapp.R
import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.preferences.PreferencesUtil
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.databinding.ActivityLoginBinding
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.ui.view.base.BaseFactoryActivity
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory
import com.gds.rickmortyapp.util.Constants.LOGIN_AUTOMATIC
import com.gds.rickmortyapp.util.extension.nextScreen

class LoginActivity : BaseFactoryActivity<ActivityLoginBinding, ViewModelFactory>() {
    private lateinit var email: String
    private lateinit var password: String
    override val viewModel: ViewModelFactory = ViewModelFactory(
        authRepo = AuthenticatorRepository(
            Authenticator(
                InstancesFB.auth
            )
        )
    )

    override fun getLayoutBinding() = ActivityLoginBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

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
        loginAutmatico.setOnClickListener {view->
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