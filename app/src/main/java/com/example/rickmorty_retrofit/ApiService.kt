package com.example.rickmorty_retrofit
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET ("character")
    fun getRick(): Call<ResponseRick>
}
//membuat permintaan HTTP GET ke "character" dan meminta respons objek dari tipe ResponseRick