package com.example.houyuapp.data.repository

import android.provider.ContactsContract
import com.example.houyuapp.data.local.DatabaseDao
import com.example.houyuapp.data.local.models.toData
import com.example.houyuapp.data.local.models.toEntity
import com.example.houyuapp.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {
    suspend fun CreateUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String): User?{
        val userLocal = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }
}