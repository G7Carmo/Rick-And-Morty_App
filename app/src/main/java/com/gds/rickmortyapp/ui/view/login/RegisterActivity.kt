package com.gds.rickmortyapp.ui.view.login

import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.R
import com.gds.rickmortyapp.data.model.user.NewUser
import com.gds.rickmortyapp.databinding.ActivityRegisterBinding
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.RegisterViewModel
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory
import com.gds.rickmortyapp.util.extension.nextScreenWithFinish
import com.gds.rickmortyapp.util.extension.stringValid

class RegisterActivity : BaseWithViewModelActivity<ActivityRegisterBinding, RegisterViewModel>() {

    override fun getLayoutBinding() = ActivityRegisterBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun getMyViewModel(): RegisterViewModel {
        return ViewModelProvider(this,ViewModelFactory())[RegisterViewModel::class.java]
    }

    override fun codeInject() {
        listeners()
        observers()
    }

    private fun listeners() = with(binding) {
        textLogin.setOnClickListener {
            nextScreenWithFinish(LoginActivity())
            finish()
        }
        btnRegister.setOnClickListener {
            initViews()
        }
    }

    private fun initViews() = with(binding) {
        val name = editInputNome.stringValid().apply {
            this.isEmpty().apply {
                textInputName.error = getString(R.string.campo_vazio)
            }
        }
        val email = editInputEmailCadastro.stringValid().apply {
            this.isEmpty().apply {
                textInputName.error = getString(R.string.campo_vazio)
            }
        }
        val password = editInputSenhaCad.stringValid().apply {
            this.isEmpty().apply {
                textInputName.error = getString(R.string.campo_vazio)
            }
        }
        val confirmPassword = editTextConfirmSenha.stringValid().apply {
            this.isEmpty().apply {
                textInputName.error = getString(R.string.campo_vazio)
            }
        }

    }

    private fun registerAndSaveDataUser(user: NewUser) {
        viewModel.register(user.email.toString(),user.passwd.toString())
    }

    private fun observers() {

    }

}



