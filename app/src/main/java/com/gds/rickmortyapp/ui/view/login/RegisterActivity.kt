package com.gds.rickmortyapp.ui.view.login

import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.databinding.ActivityRegisterBinding
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.RegisterViewModel
import com.gds.rickmortyapp.util.extension.nextScreenWithFinish
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : BaseWithViewModelActivity<ActivityRegisterBinding, RegisterViewModel>() {
    private lateinit var name : TextInputEditText
    private lateinit var email : TextInputEditText
    private lateinit var password : TextInputEditText
    private lateinit var confirmPassword : TextInputEditText
    override val viewModel : RegisterViewModel = getMyViewModel()

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

    private fun initViews()= with(binding) {
        name = editInputNome
        email = editInputEmailCadastro
        password = editInputSenhaCad
        confirmPassword = editTextConfirmSenha
    }

    private fun listeners() = with(binding) {
        textLogin.setOnClickListener {
            nextScreenWithFinish(LoginActivity())
            finish()
        }
        btnRegister.setOnClickListener {
            validandoCampos(name,email,password,confirmPassword)
        }
    }

    private fun validandoCampos(
        name: TextInputEditText,
        email: TextInputEditText,
        password: TextInputEditText,
        confirmPassword: TextInputEditText
    ) {
        name.text.toString().trim().isEmpty().apply {
            binding.textInputName.error = "vazio"
        }
    }


    private fun observers() {

    }

}


