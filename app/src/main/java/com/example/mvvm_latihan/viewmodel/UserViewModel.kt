package com.example.mvvm_latihan.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_latihan.model.getAllUserItem
import com.example.mvvm_latihan.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel (private val app: Application): AndroidViewModel(app) {
    val user = MutableLiveData<List<getAllUserItem>>()

    fun getLiveDataUser() : MutableLiveData<List<getAllUserItem>>{
        return user
    }

    fun getAllUser(){
        ApiClient.instance.getAllUser().enqueue(object : Callback<List<getAllUserItem>> {
            override fun onResponse(
                call : Call<List<getAllUserItem>>,
                response: Response<List<getAllUserItem>>
            ) {
                if (response.isSuccessful){
                    user.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<getAllUserItem>>, t: Throwable) {
                Toast.makeText(getApplication(), t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}