package com.example.roompractic.ui.fragment.screens.updateuserscreen

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.roompractic.room.UserDataModel
import com.example.roompractic.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateViewModel(application: Application) : BaseViewModel(application) {

    fun updateUser(user:UserDataModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }
}

