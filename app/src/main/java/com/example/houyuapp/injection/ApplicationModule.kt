package com.example.houyuapp.injection

import com.example.houyuapp.MainViewModel
import org.koin.dsl.module

// just declare it
val presentationModule = module {
    factory { MainViewModel() }
}