package com.example.houyuapp.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.houyuapp.domain.entity.User
import com.example.houyuapp.domain.usecase.ConfirmRegistrationUseCase
import com.example.houyuapp.domain.usecase.CreateAccountUseCase
import com.example.houyuapp.domain.usecase.GetAccountUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel (
    private val createAccountUseCase: CreateAccountUseCase,
    private val getAccountUseCase: GetAccountUseCase,
    private val confirmRegistrationUseCase: ConfirmRegistrationUseCase
) : ViewModel()
{
    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()
    val registerLiveData: MutableLiveData<RegisterStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getAccountUseCase.invoke(emailUser, password)

            val loginStatus =  if (user != null){
                LoginSuccess(user.email, user.password)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }

        }
    }

    fun verifyRegister(newUser: String){

        viewModelScope.launch(Dispatchers.IO) {
            val newEmail = confirmRegistrationUseCase.invoke(newUser)
            val registerStatus = if (newEmail != null){
                RegisterError(newEmail.email)
            }else{
                RegisterSuccess
            }
            withContext(Dispatchers.Main){
                registerLiveData.value = registerStatus
            }

        }

    }

    fun onClickedRegister (newUser:User){
        viewModelScope.launch(Dispatchers.IO) {
            createAccountUseCase.invoke(newUser)

        }

    }
}