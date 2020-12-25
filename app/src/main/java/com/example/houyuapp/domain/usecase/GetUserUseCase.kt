package com.example.houyuapp.domain.usecase

import com.example.houyuapp.data.repository.UserRepository
import com.example.houyuapp.domain.entity.User

class GetUserUseCase (
    private val userRepository : UserRepository
    ){
        suspend fun invoke(email: String): User{
            return userRepository.getUser(email)
        }
}