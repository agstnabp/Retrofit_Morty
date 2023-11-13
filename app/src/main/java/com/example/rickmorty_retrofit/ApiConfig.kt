package com.example.rickmorty_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    const val baseURL = "https://rickandmortyapi.com/api/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService():ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}
//membuat instance dari Retrofit dengan konfigurasi tertentu dan
// mendapatkan instance dari ApiService yang dapat digunakan untuk melakukan HTTP requests ke server.