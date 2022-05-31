package com.gds.rickmortyapp.ui.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gds.rickmortyapp.R
import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.util.helper.Login.isPasswordValid
import com.gds.rickmortyapp.util.helper.Login.isUserNameValid
import com.gds.rickmortyapp.util.result.ResultUtil
import com.gds.rickmortyapp.util.state.LoginFormState
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val authRepo: AuthenticatorRepository
) : ViewModel() {
    private val _userRegister = MutableLiveData<ResultUtil<LoggedInUser>>()
    val userRegister: LiveData<ResultUtil<LoggedInUser>> get() = _userRegister
    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm



    fun register(email: String, password: String) = viewModelScope.launch {
        _userRegister.value = ResultUtil.Loading
        authRepo.registerUser(email, password)
            .addOnSuccessListener {
                val user = LoggedInUser(it.user?.uid, it.user?.email, it.user?.displayName)
                _userRegister.value = ResultUtil.Success(user)
            }.addOnFailureListener {exception->
                var msg = ""
                try {
                    throw exception
                } catch (e: FirebaseAuthWeakPasswordException) {
                    msg = "Digite uma senha Mais Forte"
                } catch (e: FirebaseAuthInvalidCredentialsException) {
                    msg = "Formato de email invalido"
                } catch (e: FirebaseAuthUserCollisionException) {
                    msg = "Endereço de usuario ja cadastrado"
                } catch (e: Exception) {
                    msg = " Erro ao cadastrar usuario " + e.message
                    e.printStackTrace()
                }
                _userRegister.value = ResultUtil.Error(msg)
            }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }


}