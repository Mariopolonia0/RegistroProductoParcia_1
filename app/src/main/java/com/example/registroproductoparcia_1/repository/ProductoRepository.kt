package com.example.registroproductoparcia_1.repository

import androidx.lifecycle.LiveData
import com.example.registroproductoparcia_1.data.ProductoDb
import com.example.registroproductoparcia_1.model.Producto

class ProductoRepository(private val database :ProductoDb) {

    suspend fun insert(producto: Producto){
        database.productoDao.insert(producto)
    }

    fun allProducto():LiveData<List<Producto>>{
        return database.productoDao.getAllProducto()
    }

}