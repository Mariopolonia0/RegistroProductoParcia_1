package data

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import model.Producto

@Database(
    entities = [Producto::class],
    version = 1,
    exportSchema = false
)

abstract class ProductoDb :RoomDatabase(){
    abstract val productoDao:ProductoDao

    companion object{
        @Volatile
        private var INSTANCE:ProductoDb? = null

        fun getInstance (context : Context): ProductoDb{
            synchronized(this){

            }
        }
    }

}