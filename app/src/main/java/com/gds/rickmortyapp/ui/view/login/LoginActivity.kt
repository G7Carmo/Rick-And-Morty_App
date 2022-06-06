package com.gds.rickmortyapp.ui.view.login

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.R
import com.gds.rickmortyapp.data.model.user.NewUser
import com.gds.rickmortyapp.databinding.ActivityLoginBinding
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.ui.view.MainActivity
import com.gds.rickmortyapp.ui.view.base.BaseFactoryActivity
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.LoginViewModel
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory
import com.gds.rickmortyapp.util.Constants.LOGIN_AUTOMATIC
import com.gds.rickmortyapp.util.extension.*
import com.gds.rickmortyapp.util.result.ResultUtil

class LoginActivity : BaseWithViewModelActivity<ActivityLoginBinding, LoginViewModel>() {
    private lateinit var email: String
    private lateinit var password: String


    override fun getLayoutBinding() = ActivityLoginBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun getMyViewModel(): LoginViewModel {
        return ViewModelProvider(this, ViewModelFactory(this))[LoginViewModel::class.java]
    }

    override fun codeInject() {
        setupActivity()
    }

    private fun setupActivity() {
        listeners()
        observers()
    }

    private fun listeners() = with(binding) {
        textRegister.setOnClickListener {
            nextScreen(RegisterActivity())
        }
        btnLogin.setOnClickListener {
            initViews()
        }
        loginAutmatico.setOnClickListener { view ->
            setAutomaticLogin(view)
        }
        resetPassword.setOnClickListener {
            nextScreen(ResetPasswordActivity())
        }
    }

    private fun initViews() = with(binding) {
        email = editInputEmail.extractString()
        password = editInputSenha.extractString()
        if (verifyValues(email) && verifyValues(password)){
            loginUser(generateUser(email, password))
        }
    }

    private fun loginUser(user: NewUser) {
        viewModel.login(user.email, user.passwd)
    }

    private fun generateUser(email: String, password: String): NewUser {
        return NewUser(email = email, passwd = password)
    }

    private fun verifyValues(value: String): Boolean {
        return if (value.isEmpty()) {
            launchError(getString(R.string.campo_vazio))
            false
        } else {
            launchError(getString(R.string.vazio))
            true
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
        viewModel.userLogged.observe(this) { result ->
            when (result) {
                is ResultUtil.Success -> {
                    binding.pbLogin.show()
                    nextScreenWithFinish(MainActivity())
                }
                is ResultUtil.Error -> {
                    binding.pbLogin.show()
                    dialog("Falha ao Logar", result.msg)
                }
                is ResultUtil.Loading -> {
                    binding.pbLogin.show()
                }
            }
        }
    }

}