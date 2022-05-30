package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.util.result.ResultUtil
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val authRepo: AuthenticatorRepository
) : ViewModel() {
    private val _userRegister = MutableLiveData<ResultUtil<LoggedInUser>>()
    val userRegister: LiveData<ResultUtil<LoggedInUser>> get() = _userRegister


    fun register(email: String, password: String) = viewModelScope.launch {
        _userRegister.value = ResultUtil.Loading
        authRepo.registerUser(email, password)
            .addOnSuccessListener {
                val user = LoggedInUser(it.user?.uid, it.user?.email, it.user?.displayName)
                _userRegister.value = ResultUtil.Success(user)
            }.addOnFailureListener {
                var msg = ""
                try {
                    throw it
                } catch (e: FirebaseAuthInvalidCredentialsException) {
                    msg = "Email ou senha incorretos"
                } catch (e: FirebaseAuthInvalidUserException) {
                    msg = "Email incorreto ou nao cadastrado "
                } catch (e: Exception) {
                    msg = "Falha ao logar " + e.message
                    e.printStackTrace()
                }
                _userRegister.value = ResultUtil.Error(msg)
            }
    }
}