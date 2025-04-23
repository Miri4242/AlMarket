package com.example.almarket.data
import com.example.almarket.model.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts():List<Product>
}