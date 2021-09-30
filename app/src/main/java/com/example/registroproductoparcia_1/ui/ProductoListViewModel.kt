package com.example.registroproductoparcia_1.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.registroproductoparcia_1.model.Producto
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ProductoListViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    /*fun Insert(producto: Producto)=viewModelScope.launch{
        productoRepository.insert(producto)
    }*/

    class Factory (val app: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProductoEditViewModel::class.java)){
                @Suppress("UNCHECKER_CAST")
                return ProductoEditViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}