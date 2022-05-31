package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.util.result.ResultUtil
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.coroutines.launch

class ResetPasswordViewModel(
    private val authRepo: AuthenticatorRepository
) : ViewModel() {
    private val _resetPassword = MutableLiveData<ResultUtil<String>>()
    val resetPassword: LiveData<ResultUtil<String>> get() = _resetPassword

    fun reset(email: String) = viewModelScope.launch {
        _resetPassword.value = ResultUtil.Loading
        authRepo.resetPassword(email)
            .addOnSuccessListener {
                _resetPassword.value = ResultUtil.Success(it.toString())
            }.addOnFailureListener { exception ->
                val msg = try {
                    throw exception
                } catch (e: FirebaseAuthInvalidCredentialsException) {
                    "Email incorretos"
                } catch (e: FirebaseAuthException) {
                    "Falha ao logar " + e.message
                }
                _resetPassword.value = ResultUtil.Error(msg)
            }
    }
}