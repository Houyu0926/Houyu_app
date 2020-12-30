package com.example.houyuapp.domain.usecase

import com.example.houyuapp.data.repository.UserRepository
import com.example.houyuapp.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetAccountUseCaseTest {
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = GetAccountUseCase(userRepository)

    @Test
    fun `invoke with invalid email and password`(){
        runBlocking {
            //Given
            val email = ""
            val password = ""
            coEvery { userRepository.getAccount(email, password) } returns null

            //When
            val result = classUnderTest.invoke(email,password)

            //Then
            coVerify (exactly = 1){ userRepository.getAccount(email,password) }
            assertEquals(result, null)
        }
    }

    @Test
    fun `invoke with valid email and password`(){
        runBlocking {
            //Given
            val email = "h@h.com"
            val password = "1234"
            val expectedUser = User("h@h.com", "1234")
            coEvery { userRepository.getAccount(email, password) } returns expectedUser

            //When
            val result = classUnderTest.invoke(email,password)

            //Then
            coVerify (exactly = 1){ userRepository.getAccount(email,password) }
            assertEquals(result, null)
        }
    }
}