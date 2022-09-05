package com.example.roompractic.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roompractic.room.UserDataModel
import com.example.roompractic.room.UserDataBase
import com.example.roompractic.room.UserRepository

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<UserDataModel>>
    protected val repository: UserRepository
    init {
        val userDao = UserDataBase.getDataBase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllDate
    }
}