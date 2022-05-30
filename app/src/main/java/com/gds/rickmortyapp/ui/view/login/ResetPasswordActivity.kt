package com.gds.rickmortyapp.ui.view.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.databinding.ActivityResetPasswordBinding
import com.gds.rickmortyapp.ui.view.base.BaseFactoryActivity
import com.gds.rickmortyapp.ui.viewmodel.ResetPasswordViewModel
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory

class ResetPasswordActivity :
    BaseFactoryActivity<ActivityResetPasswordBinding, ViewModelFactory>() {
    override val viewModel: ViewModelFactory = ViewModelFactory(
        authRepo = AuthenticatorRepository(
            Authenticator(
                InstancesFB.auth
            )
        )
    )
    override fun getLayoutBinding() = ActivityResetPasswordBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun codeInject() {

    }

}