package com.gds.rickmortyapp.ui.view.login

import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.R
import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.data.model.user.NewUser
import com.gds.rickmortyapp.databinding.ActivityRegisterBinding
import com.gds.rickmortyapp.ui.view.MainActivity
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.RegisterViewModel
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory
import com.gds.rickmortyapp.util.extension.*
import com.gds.rickmortyapp.util.result.ResultUtil
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : BaseWithViewModelActivity<ActivityRegisterBinding, RegisterViewModel>() {
    private lateinit var name : String
    private lateinit var email : String
    private lateinit var password : String
    private lateinit var confirmPassword : String

    override fun getLayoutBinding() = ActivityRegisterBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun getMyViewModel(): RegisterViewModel {
        return ViewModelProvider(this,ViewModelFactory(this))[RegisterViewModel::class.java]
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
        name = editInputNome.extractString()
        email = editInputEmailCadastro.extractString()
        password = editInputSenhaCad.extractString()
        confirmPassword = editTextConfirmSenha.extractString()
        validString(name,email,password,confirmPassword)
    }

    private fun validString(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        verifyValueString(name,binding.textInputName)
        verifyValueString(email,binding.textInputEmailCadastro)
        verifyValueString(password,binding.textInputSenhaCad)
        verifyValueString(confirmPassword,binding.textInputConfirSenha)
        if (password.isEmpty() || confirmPassword.isEmpty()){
            launchError(getString(R.string.campo_vazio),binding.textInputSenhaCad,binding.textInputConfirSenha)
        }else{
            launchError(getString(R.string.vazio),binding.textInputSenhaCad,binding.textInputConfirSenha)
            if (password != confirmPassword){
                launchError("Campos diferentes",binding.textInputSenhaCad,binding.textInputConfirSenha)
            }else{
                launchError(getString(R.string.vazio),binding.textInputSenhaCad,binding.textInputConfirSenha)
                registerAndSaveDataUser(generateNewUser(name, email, password))
            }
        }
    }


    private fun verifyValueString(value: String, inputLayout: TextInputLayout){
        if (value.isEmpty()) launchError(getString(R.string.campo_vazio),inputLayout)
        if (value.isNotEmpty()) launchError("",inputLayout)
    }

    private fun generateNewUser(name: String, email: String, password: String): NewUser {
        return NewUser(email = email, passwd = password, displayName = name)
    }

    private fun registerAndSaveDataUser(user: NewUser) {
        viewModel.register(user.email.toString(),user.passwd.toString())
    }

    private fun observers() {
        viewModel.userRegister.observe(this){
            when(it){
                is ResultUtil.Success->{
                    binding.pbRegister.hide()
                    val user = gerandoDadosParaSalvar(it.data)
                    viewModel.saveUser(user)
                    nextScreen(MainActivity())
                }
                is ResultUtil.Error->{
                    binding.pbRegister.hide()
                    dialog("Falha ao cadastrar",it.msg)
                }
                is ResultUtil.Loading->{
                    binding.pbRegister.show()
                }
            }
        }
        viewModel.saveDataUser.observe(this){result->
            when(result){
                true -> {
                    message("Dados salvos com sucesso")
                }
                false -> {
                    message("falha ao salvar os dados")
                }
            }
        }
    }

    private fun gerandoDadosParaSalvar(data: LoggedInUser): LoggedInUser {
        return LoggedInUser(
            email = data.email,
            displayName = data.displayName,
            userId = viewModel.userId()
        )
    }


}



