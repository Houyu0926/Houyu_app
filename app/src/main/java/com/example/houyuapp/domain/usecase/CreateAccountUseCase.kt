package com.example.houyuapp.domain.usecase

import com.example.houyuapp.data.local.models.UserLocal
import com.example.houyuapp.data.repository.UserRepository
import com.example.houyuapp.domain.entity.User

class CreateAccountUseCase (
    private val userRepository : UserRepository

){
    suspend fun invoke(user: User) {
        userRepository.createAccount(user)
    }
}