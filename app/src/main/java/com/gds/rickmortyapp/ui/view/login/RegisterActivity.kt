package com.gds.rickmortyapp.ui.view.login

import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.databinding.ActivityRegisterBinding
import com.gds.rickmortyapp.ui.view.base.BaseFactoryActivity
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory

class RegisterActivity : BaseFactoryActivity<ActivityRegisterBinding, ViewModelFactory>() {
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
    }

}