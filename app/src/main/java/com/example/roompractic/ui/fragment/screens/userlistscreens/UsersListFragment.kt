package com.example.roompractic.ui.fragment.screens.userlistscreens

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roompractic.R
import com.example.roompractic.databinding.FragmentShowBinding
import com.example.roompractic.ui.fragment.BaseFragment
import com.example.roompractic.ui.fragment.screens.createuserscreen.DataViewModel
import com.example.roompractic.ui.viewmodel.BaseViewModel

class UsersListFragment : BaseFragment<FragmentShowBinding>(FragmentShowBinding::inflate) {

    private lateinit var userViewModel: BaseViewModel
    private lateinit var userListAdapter: UserListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUserListAdapter()
        userViewModel = ViewModelProvider(this)[BaseViewModel::class.java]
        userViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            userListAdapter.setData(it)
        })
        binding.floatingActionButton.setOnClickListener { findNavController().navigate(R.id.action_showFragment_to_createFragment) }
    }

    fun initUserListAdapter() {
        userListAdapter = UserListAdapter()
        binding.userListRv.apply {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


}