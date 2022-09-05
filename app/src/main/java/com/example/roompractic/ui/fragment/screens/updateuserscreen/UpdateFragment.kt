package com.example.roompractic.ui.fragment.screens.updateuserscreen

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roompractic.R
import com.example.roompractic.databinding.FragmentUpdateBinding
import com.example.roompractic.room.UserDataModel
import com.example.roompractic.ui.fragment.BaseFragment

class UpdateFragment : BaseFragment<FragmentUpdateBinding>(FragmentUpdateBinding::inflate) {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var updateViewModel: UpdateViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDateToEditText()
        updateViewModel = ViewModelProvider(this).get(UpdateViewModel::class.java)
    }

    private fun setDateToEditText() {
        binding.nameUpdate.setText(args.currentUser.name)
        binding.secondNameUpdate.setText(args.currentUser.secondName)
        binding.ageUpdate.setText(args.currentUser.age.toString())
        binding.saveDataUpdate.setOnClickListener {
            updateUser()
        }
    }


    private fun updateUser() {
        val name = binding.nameUpdate.text.toString()
        val secondName = binding.secondNameUpdate.text.toString()
        val age = binding.ageUpdate.text

        if (inputCheck(name, secondName, binding.ageUpdate.text)) {
            val updateUser =
                UserDataModel(args.currentUser.id, name, secondName, Integer.parseInt(age.toString()))
            updateViewModel.updateUser(updateUser)
            findNavController().navigate(R.id.action_updateFragment_to_showFragment)

        }

    }

    private fun inputCheck(firstName: String, secondName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }

}