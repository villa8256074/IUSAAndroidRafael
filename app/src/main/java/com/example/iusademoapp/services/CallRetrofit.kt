package com.example.iusademoapp.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CallRetrofit {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.12:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}