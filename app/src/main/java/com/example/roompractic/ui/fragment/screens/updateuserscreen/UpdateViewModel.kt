package com.example.roompractic.ui.fragment.screens.updateuserscreen

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.roompractic.room.Data
import com.example.roompractic.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UpdateViewModel(application: Application) : BaseViewModel(application) {

    fun updateUser(user: Data) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun delete(user: Data) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user = user)
        }
    }
}

