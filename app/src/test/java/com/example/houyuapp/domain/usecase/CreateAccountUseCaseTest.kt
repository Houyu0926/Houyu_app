package com.example.houyuapp.domain.usecase

import com.example.houyuapp.data.repository.UserRepository
import com.example.houyuapp.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateAccountUseCaseTest {
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = CreateAccountUseCase(userRepository)

    @Test
    fun invoke(){
        runBlocking {
            //Given
            val user = User("","")
            coEvery { userRepository.createAccount(user) } returns Unit

            //When
            classUnderTest.invoke(user)

            //Then
            coVerify (exactly = 1){ userRepository.createAccount(user) }
        }
    }
}