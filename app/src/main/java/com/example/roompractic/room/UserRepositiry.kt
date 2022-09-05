package com.example.roompractic.room

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllDate: LiveData<List<Data>> = userDao.readAllData()
    suspend fun addUse(data: Data) {
        userDao.addUsr(data)
    }

    suspend fun updateUser(user: Data) {
        userDao.updateUser(user = user)
    }

    suspend fun deleteUser(user: Data) {
        userDao.deleteUser(user)
    }
}