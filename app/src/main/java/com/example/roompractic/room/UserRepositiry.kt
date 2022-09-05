package com.example.roompractic.room

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllDate: LiveData<List<UserDataModel>> = userDao.readAllData()
    suspend fun addUse(data: UserDataModel) {
        userDao.addUsr(data)
    }

    suspend fun updateUser(user:UserDataModel){
         userDao.updateUser(user=user)
    }
}