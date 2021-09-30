package com.example.registroproductoparcia_1.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.registroproductoparcia_1.R
import com.example.registroproductoparcia_1.databinding.ProductoListFragmentBinding

class ProductoListFragment : Fragment() {

    companion object {
        fun newInstance() = ProductoListFragment()
    }
    private var _binding: ProductoListFragment? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // _binding = ProductoListFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this,ProductoListViewModel.Factory(requireActivity().application))
            .get(ProductoListViewModel::class.java)


        //return binding.root
        return inflater.inflate(R.layout.producto_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductoListViewModel::class.java)
        // TODO: Use the ViewModel

    }

}

/*
package com.example.registroproductoparcia_1.ui

import androidx.fragment.app.Fragment

class ProductoListFragment :Fragment() {
    companion object{
        fun newInstance() = ProductoListFragment()
    }

    private var _binding: ProductoListFragment? = null
    private val binding get() = _binding

    private lateinit var  viewModel :ProductoList


}*/