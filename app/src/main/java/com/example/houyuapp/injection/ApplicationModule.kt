package com.example.houyuapp.injection

import android.content.Context
import androidx.room.Room
import com.example.houyuapp.data.local.AppDatabase
import com.example.houyuapp.data.local.DatabaseDao
import com.example.houyuapp.data.repository.UserRepository
import com.example.houyuapp.domain.usecase.CreateUserUseCase
import com.example.houyuapp.domain.usecase.GetUserUseCase
import com.example.houyuapp.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.security.AccessControlContext

// just declare it
val presentationModule = module {
    factory { MainViewModel(get(), get()) }
}

val domainModule = module{
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module{
    single { UserRepository(get()) }
    single {createDatabase(androidContext())}
}

fun createDatabase(context: Context): DatabaseDao {

    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()

}
