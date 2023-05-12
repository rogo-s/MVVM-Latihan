package com.example.mvvm_latihan.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_latihan.databinding.ItemUserBinding
import com.example.mvvm_latihan.model.getAllUserItem

class UserAdapter(var listUser: List<getAllUserItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(private var binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: getAllUserItem){
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listUser[position])
//    holder.binding.tvNama.text = listUser[position].nama
//    holder.binding.tvUmur.text = listUser[position].age.toString
//    holder.binding.tvAlamat.text = listUser[position].alamat
}