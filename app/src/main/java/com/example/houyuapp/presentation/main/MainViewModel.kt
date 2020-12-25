package com.example.houyuapp.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.houyuapp.domain.entity.User
import com.example.houyuapp.domain.usecase.CreateUserUseCase
import com.example.houyuapp.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel (
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel()
{
   val count: MutableLiveData<Int> = MutableLiveData()

    init{
        count.value = 0
    }

    fun onClickedIncrement(emailUser : String){
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("ok"))
            val user = getUserUseCase.invoke("ok")
            val debug ="debug"
        }
        //count.value = (count.value ?: 0) + 1
    }
}