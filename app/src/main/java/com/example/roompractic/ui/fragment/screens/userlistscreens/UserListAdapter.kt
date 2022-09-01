package com.example.roompractic.userlistscreens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roompractic.databinding.ItemRvBinding
import com.example.roompractic.room.Data

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListHolder>() {
    private var userList = mutableListOf<Data>()

    class UserListHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(id: Int, name: String, secondName: String, age: Int) {
            binding.userIdTv.text = id.toString()
            binding.nameTv.text = name
            binding.secondNameTv.text = secondName
            binding.ageTv.text = age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListHolder {

        return UserListHolder(
            ItemRvBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserListHolder, position: Int) {
        val name = userList[position]
        with(holder) {
            bind(name.id, name.name, name.secondName, name.age)
        }
    }

    override fun getItemCount() = userList.size

    fun setData(list: List<Data>) {
        userList.addAll(list)
        notifyItemInserted(userList.lastIndex)
    }
}