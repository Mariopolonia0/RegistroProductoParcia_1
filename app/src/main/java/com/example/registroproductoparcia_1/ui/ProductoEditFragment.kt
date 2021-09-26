package com.example.registroproductoparcia_1.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.registroproductoparcia_1.R

class ProductoEditFragment : Fragment() {

    companion object {
        fun newInstance() = ProductoEditFragment()
    }

    private lateinit var viewModel: ProductoEditViewModel2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.producto_edit_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductoEditViewModel2::class.java)
        // TODO: Use the ViewModel
    }

}