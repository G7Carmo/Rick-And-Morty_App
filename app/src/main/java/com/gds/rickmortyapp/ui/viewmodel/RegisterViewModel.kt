package com.gds.rickmortyapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.firebase.UserDataSource
import com.gds.rickmortyapp.data.model.user.LoggedInUser
import com.gds.rickmortyapp.data.model.user.NewUser
import com.gds.rickmortyapp.data.repository.AuthenticatorRepository
import com.gds.rickmortyapp.data.repository.UserRepository
import com.gds.rickmortyapp.util.result.ResultUtil
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val authRepo: AuthenticatorRepository,
    private val userRepository: UserRepository,
    private val userDataSource: UserDataSource
) : ViewModel() {
    private val _userRegister = MutableLiveData<ResultUtil<LoggedInUser>>()
    val userRegister: LiveData<ResultUtil<LoggedInUser>> get() = _userRegister
    private val _saveDataUser = MutableLiveData<Boolean>()
    val saveDataUser: LiveData<Boolean> = _saveDataUser

    private val _dataUser = MutableLiveData<ResultUtil<Boolean>>()
    val dataUser: LiveData<ResultUtil<Boolean>> get() = _dataUser

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

    fun saveUser(newUser: LoggedInUser) = viewModelScope.launch {
        val local = salvandoUsuarioLocal(newUser)
        if (local){
            salvandoUsuarioRemoto(newUser)
        }
    }

    private suspend fun salvandoUsuarioRemoto(newUser: LoggedInUser) {
        _dataUser.value = ResultUtil.Loading
        try {
            userRepository.saveUserRemote(newUser)
                .addOnSuccessListener {
                    _dataUser.value = ResultUtil.Success(true)
                }.addOnFailureListener { exception ->
                    val msg = try {
                        throw exception
                    } catch (e: FirebaseException) {
                        "Exception -> ${e.message}"
                    }
                    _dataUser.value = ResultUtil.Error(msg)
                }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    private suspend fun salvandoUsuarioLocal(newUser: LoggedInUser): Boolean {
        return try {
            userRepository.saveUserLocal(newUser)
            true
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            false
        }
    }

    fun userId() = userDataSource.userKey()

}