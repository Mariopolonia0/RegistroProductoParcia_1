package com.example.registroproductoparcia_1.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import com.example.registroproductoparcia_1.data.ProductoDb
import com.example.registroproductoparcia_1.model.Producto
import com.example.registroproductoparcia_1.repository.ProductoRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ProductoEditViewModel(application: Application) :ViewModel(){
    private val productoRepository = ProductoRepository(ProductoDb.getInstance(application))

    fun Insert(producto: Producto) =viewModelScope.launch {
        productoRepository.insert(producto)
    }
    class Factory(val app:Application):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass :Class <T>):T {
            if (modelClass.isAssignableFrom(ProductoEditViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ProductoEditViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to Construct viewmodel")
        }
    }
}