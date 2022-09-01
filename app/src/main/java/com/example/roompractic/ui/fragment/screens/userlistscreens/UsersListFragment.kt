package com.example.roompractic.userlistscreens

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roompractic.R
import com.example.roompractic.databinding.FragmentShowBinding
import com.example.roompractic.fragment.BaseFragment
import com.example.roompractic.room.DataViewModel

class UsersListFragment : BaseFragment<FragmentShowBinding>(FragmentShowBinding::inflate) {
    private lateinit var userViewModel:DataViewModel
    private lateinit var userListAdapter: UserListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUserListAdapter()

        userViewModel=ViewModelProvider(this).get(DataViewModel::class.java)
        userViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            userListAdapter.setData(it)
        })


        binding.floatingActionButton.setOnClickListener { findNavController().navigate(R.id.action_showFragment_to_editFragment) }
    }

    fun initUserListAdapter() {
        userListAdapter = UserListAdapter()
        binding.userListRv.apply {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


}