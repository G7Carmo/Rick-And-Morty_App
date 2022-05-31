package com.gds.rickmortyapp.ui.view.login

import androidx.lifecycle.ViewModelProvider
import com.gds.rickmortyapp.data.datasource.firebase.Authenticator
import com.gds.rickmortyapp.data.datasource.firebase.InstancesFB
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.databinding.ActivityResetPasswordBinding
import com.gds.rickmortyapp.ui.view.base.BaseFactoryActivity
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.ResetPasswordViewModel
import com.gds.rickmortyapp.ui.viewmodel.ViewModelFactory

class ResetPasswordActivity :
    BaseWithViewModelActivity<ActivityResetPasswordBinding,ResetPasswordViewModel>() {
    override fun getLayoutBinding() = ActivityResetPasswordBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun getMyViewModel(): ResetPasswordViewModel {
        return ViewModelProvider(this,ViewModelFactory())[ResetPasswordViewModel::class.java]
    }

    override fun codeInject() {
        initViews()
    }

    private fun initViews() = with(binding) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}