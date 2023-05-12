package com.example.mvvm_latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.mvvm_latihan.databinding.ActivityMainBinding
import com.example.mvvm_latihan.view.UserAdapter
import com.example.mvvm_latihan.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter

    class MainActivity : AppCompatActivity() {
        private var binding: ActivityMainBinding? = null
        private val userVM: UserViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding!!.root)
            getAllUser()
        }

        fun getAllUser() {
            userVM.getAllUser()
            userVM.user.observe(this) { user ->
                binding?.rvHome?.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding?.rvHome?.adapter = UserAdapter(user)
            }
        }
    }
}