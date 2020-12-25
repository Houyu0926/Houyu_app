package com.example.houyuapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel(){

    fun onClickedIncrement(){
        count.value = (count.value ?: 0) + 1
    }
   val count: MutableLiveData<Int> = MutableLiveData()

    init{
        count.value = 0

    }
}