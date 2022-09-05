package com.example.roompractic.ui.fragment.screens.createuserscreen

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.roompractic.room.UserDataModel
import com.example.roompractic.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(application: Application) :BaseViewModel(application) {

    fun addUser(data: UserDataModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUse(data)
        }
    }



}