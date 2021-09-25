package com.example.registroproductoparcia_1.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Producto (
    @PrimaryKey (autoGenerate = true)
    var ProductoId : Long,
    var Descricion : String,
    var Existencia : Int,
    var Costo : Float,
    var ValarIntercambio :Float
)