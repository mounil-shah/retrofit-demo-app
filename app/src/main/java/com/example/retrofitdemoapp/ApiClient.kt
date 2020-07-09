package com.example.retrofitdemoapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://api.larntech.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun createUserService(): UserService = createRetrofit().create(UserService::class.java)

}