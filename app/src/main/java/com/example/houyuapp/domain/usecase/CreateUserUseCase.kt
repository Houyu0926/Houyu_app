package com.example.houyuapp.domain.usecase

import com.example.houyuapp.data.repository.UserRepository
import com.example.houyuapp.domain.entity.User

class CreateUserUseCase (
    private val userRepository : UserRepository

){
    suspend fun invoke(user: User){
        userRepository.CreateUser(user)
    }
}