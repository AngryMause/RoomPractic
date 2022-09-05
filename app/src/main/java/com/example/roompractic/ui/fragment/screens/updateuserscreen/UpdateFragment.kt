package com.example.roompractic.ui.fragment.screens.updateuserscreen

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roompractic.R
import com.example.roompractic.databinding.FragmentUpdateBinding
import com.example.roompractic.room.Data
import com.example.roompractic.ui.fragment.BaseFragment

class UpdateFragment : BaseFragment<FragmentUpdateBinding>(FragmentUpdateBinding::inflate) {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var updateViewModel: UpdateViewModel
    private lateinit var menuHost: MenuHost

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuHost()
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
                Data(args.currentUser.id,
                    name,
                    secondName,
                    Integer.parseInt(age.toString()))
            updateViewModel.updateUser(updateUser)
            findNavController().navigate(R.id.action_updateFragment_to_showFragment)
        }
    }

    private fun initMenuHost() {
        menuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.delete_menu -> {
                        showAlert()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun inputCheck(firstName: String, secondName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }

    fun showAlert() {
        val alertBuilder = android.app.AlertDialog.Builder(requireContext())
        alertBuilder.setPositiveButton("Yes") { _, _ ->
            updateViewModel.delete(args.currentUser)
            Toast.makeText(requireContext(),
                "User ${args.currentUser.name} was deleted ",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_showFragment)

        }
        alertBuilder.setNegativeButton("No") { _, _ -> }
        alertBuilder.setTitle("You want delete ${args.currentUser.name}? ")
        alertBuilder.show()
    }


}