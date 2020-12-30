package com.example.houyuapp.domain.usecase

import com.example.houyuapp.data.repository.UserRepository
import com.example.houyuapp.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ConfirmRegistrationUseCaseTest {
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = ConfirmRegistrationUseCase(userRepository)

    @Test
    fun `invoke with valid newEmail`(){
        runBlocking {
            //Given
            val newEmail = "s@h.com"
            coEvery { userRepository.confirmRegistration(newEmail) } returns null

            //When
            val result = classUnderTest.invoke(newEmail)

            //Then
            coVerify (exactly = 1){ userRepository.confirmRegistration(newEmail) }
            assertEquals(result, null)
        }
    }


    @Test
    fun `invoke with invalid newEmail`(){
        runBlocking {
            //Given
            val newEmail = "s@h.com"
            val expectedNewEmail = User("s@h.com", "")
            coEvery { userRepository.confirmRegistration(newEmail) } returns expectedNewEmail

            //When
            val result = classUnderTest.invoke(newEmail)

            //Then
            coVerify (exactly = 1){ userRepository.confirmRegistration(newEmail) }
            assertEquals(result, expectedNewEmail)
        }
    }
}