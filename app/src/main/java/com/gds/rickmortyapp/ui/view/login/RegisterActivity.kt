package com.gds.rickmortyapp.ui.view.login

import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.databinding.ActivityRegisterBinding
import com.gds.rickmortyapp.ui.view.base.BaseFactoryActivity
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory
import com.gds.rickmortyapp.util.extension.nextScreen

class RegisterActivity : BaseFactoryActivity<ActivityRegisterBinding, ViewModelFactory>() {
    private lateinit var name : String
    private lateinit var email : String
    private lateinit var password : String
    private lateinit var confirmPassword : String
    override val viewModel =
        ViewModelFactory(
            authRepo = AuthenticatorRepository(
                Authenticator(
                    InstancesFB.auth
                )
            )
        )
    override fun getLayoutBinding() = ActivityRegisterBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun codeInject() {
        initViews()
        listeners()
        observers()
    }

    private fun initViews()= with(binding) {
        name = editInputNome.text.toString().trim()
        email = editInputEmailCadastro.text.toString().trim()
        password = editInputSenhaCad.text.toString().trim()
        confirmPassword = editTextConfirmSenha.text.toString().trim()
    }

    private fun listeners() = with(binding) {
        textLogin.setOnClickListener {
            nextScreen(LoginActivity())
        }
        btnRegister.setOnClickListener {

        }
    }

    private fun observers() {

    }

}