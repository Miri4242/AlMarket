package com.example.almarket.instance

import com.example.almarket.data.ProductApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance{
    val api: ProductApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://6805db86ca467c15be6a2a6a.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }
}