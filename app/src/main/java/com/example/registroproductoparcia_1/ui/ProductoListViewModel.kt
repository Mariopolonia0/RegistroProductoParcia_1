package com.example.registroproductoparcia_1.ui

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.registroproductoparcia_1.model.Producto
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ProductoListViewModel() : ViewModel(), Parcelable {
    // TODO: Implement the ViewModel

    constructor(parcel: Parcel) : this() {
    }

    class Factory (val app: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProductoEditViewModel::class.java)){
                @Suppress("UNCHECKER_CAST")
                return ProductoEditViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductoListViewModel> {
        override fun createFromParcel(parcel: Parcel): ProductoListViewModel {
            return ProductoListViewModel(parcel)
        }

        override fun newArray(size: Int): Array<ProductoListViewModel?> {
            return arrayOfNulls(size)
        }
    }
}