package com.example.roompractic.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Data>>
    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDataBase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllDate
    }


    fun addUser(data: Data) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUse(data)
        }
    }
}