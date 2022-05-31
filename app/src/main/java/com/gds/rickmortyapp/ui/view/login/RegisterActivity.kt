package com.gds.rickmortyapp.ui.view.login

import com.gds.rickmortyapp.R
import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.model.user.NewUser
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.databinding.ActivityRegisterBinding
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.RegisterViewModel
import com.gds.rickmortyapp.util.extension.nextScreenWithFinish

class RegisterActivity : BaseWithViewModelActivity<ActivityRegisterBinding, RegisterViewModel>() {
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var confirmPassword: String
    override val viewModel: RegisterViewModel = getMyViewModel()

    private fun getMyViewModel(): RegisterViewModel {
        return RegisterViewModel(AuthenticatorRepository(Authenticator(InstancesFB.auth)))
    }

    override fun getLayoutBinding() = ActivityRegisterBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun codeInject() {
        initViews()
        listeners()
        observers()
    }

    private fun initViews() = with(binding) {
        name = editInputNome.text.toString().trim()
        email = editInputEmailCadastro.text.toString().trim()
        password = editInputSenhaCad.text.toString().trim()
        confirmPassword = editTextConfirmSenha.text.toString().trim()
    }

    private fun listeners() = with(binding) {
        textLogin.setOnClickListener {
            nextScreenWithFinish(LoginActivity())
            finish()
        }
        btnRegister.setOnClickListener {
            validandoCampos(name, email, password, confirmPassword)
        }
    }

    private fun validandoCampos(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        if (name.isNotEmpty()) {
            if (email.isNotEmpty()) {
                if (password.isNotEmpty()) {
                    if (confirmPassword.isNotEmpty()) {
                        if (password == confirmPassword) {
                            val user = NewUser(displayName = name, email = email, passwd = password)
                            registerAndSaveDataUser(user)
                        }
                    } else {
                        binding.textInputName.error = getString(R.string.campo_vazio)
                    }
                } else {
                    binding.textInputName.error = getString(R.string.campo_vazio)
                }
            } else {
                binding.textInputName.error = getString(R.string.campo_vazio)
            }
        } else {
            binding.textInputName.error = getString(R.string.campo_vazio)
        }
    }

    private fun registerAndSaveDataUser(user: NewUser) {
        viewModel.register(user.email.toString(),user.passwd.toString())
    }

    private fun observers() {

    }

}


