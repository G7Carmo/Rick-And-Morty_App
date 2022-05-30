package com.gds.rickmortyapp.ui.view.login

import android.view.View
import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.databinding.ActivityLoginBinding
import com.gds.rickmortyapp.ui.view.base.BaseActivity
import com.gds.rickmortyapp.ui.view.base.BaseFactoryActivity
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory

class LoginActivity : BaseFactoryActivity<ActivityLoginBinding, ViewModelFactory>() {
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

    }
}