package com.example.roompractic.ui.fragment.screens.userlistscreens

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roompractic.databinding.ItemRvBinding
import com.example.roompractic.room.Data

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListHolder>() {

    private var userList = mutableListOf<Data>()

    class UserListHolder(val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.userIdTv.text = data.id.toString()
            binding.nameTv.text = data.name
            binding.secondNameTv.text = data.secondName
            binding.ageTv.text = data.age.toString()
            binding.itemRv.setOnClickListener {
                val action = UsersListFragmentDirections.actionShowFragmentToUpdateFragment(data)
                itemView.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListHolder {
        return UserListHolder(
            ItemRvBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserListHolder, position: Int) {
        val user = userList[position]
        with(holder) {
            bind(user)
        }
    }

    override fun getItemCount() = userList.size

    fun setData(list: List<Data>) {
        userList.addAll(list)
        notifyDataSetChanged()
    }
}


