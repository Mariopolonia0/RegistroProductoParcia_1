package com.example.registroproductoparcia_1.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.registroproductoparcia_1.model.Producto

@Dao
interface ProductoDao {
    @Insert
    suspend fun insert(producto: Producto)

    @Update
    suspend fun update(producto: Producto)

    @Query("SELECT * FROM producto WHERE ProductoId= :key")
    suspend fun find(key :Long): Producto
}