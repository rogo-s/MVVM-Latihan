package com.example.mvvm_latihan.network

import com.example.mvvm_latihan.model.getAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("user")
    fun getAllUser() : Call<List<getAllUserItem>>
}