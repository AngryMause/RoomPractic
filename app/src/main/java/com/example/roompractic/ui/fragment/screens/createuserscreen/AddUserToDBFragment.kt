package com.example.roompractic.createuserscreen

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roompractic.R
import com.example.roompractic.databinding.FragmentEditBinding
import com.example.roompractic.fragment.BaseFragment
import com.example.roompractic.room.Data
import com.example.roompractic.room.DataViewModel

class AddUserToDBFragment : BaseFragment<FragmentEditBinding>(FragmentEditBinding::inflate) {

    private lateinit var userViewModel: DataViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        binding.saveDataCreate.setOnClickListener {
            insertDataToDataBase()
        }
    }

    private fun insertDataToDataBase() {
        val firstName = binding.nameCreate.text.toString()
        val secondName = binding.secondNameCreate.text.toString()
        val age = binding.ageCreate.text
        try {
            if (inputCheck(firstName, secondName, age)) {
                val user = Data(0, firstName, secondName, Integer.parseInt(age.toString()))
                userViewModel.addUser(user)
                Toast.makeText(requireContext(), "Good ", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_editFragment_to_showFragment)
            } else {
                Toast.makeText(requireContext(), "Oooops... ", Toast.LENGTH_SHORT).show()

            }
        } catch (e: Exception) {

        }

    }

    private fun inputCheck(firstName: String, secondName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }


}