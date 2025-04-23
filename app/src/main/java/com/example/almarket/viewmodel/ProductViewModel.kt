package com.example.almarket.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.almarket.instance.RetrofitInstance
import com.example.almarket.model.Product
import kotlinx.coroutines.launch

class ProductViewModel :ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>> = _products

    init {
        fetchProducts()
    }
    private fun fetchProducts(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProducts()
                _products.value = response
            }
            catch (e:Exception){

            }
        }
    }
}