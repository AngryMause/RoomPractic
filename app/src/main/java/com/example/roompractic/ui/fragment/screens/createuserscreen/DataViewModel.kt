package com.example.roompractic.ui.fragment.screens.createuserscreen

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.roompractic.room.Data
import com.example.roompractic.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(application: Application) :BaseViewModel(application) {

    fun addUser(data: Data) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUse(data)
        }
    }



}