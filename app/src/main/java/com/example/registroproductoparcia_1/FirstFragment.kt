package com.example.registroproductoparcia_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.registroproductoparcia_1.databinding.FragmentFirstBinding
import com.example.registroproductoparcia_1.ui.ProductoAdapter
import com.example.registroproductoparcia_1.ui.ProductoEditViewModel
import com.example.registroproductoparcia_1.ui.ProductoListViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel :ProductoEditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this,ProductoEditViewModel.Factory(requireActivity().application))
                .get(ProductoEditViewModel::class.java)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listarecyclerView.adapter = ProductoAdapter()
        val adapter = binding.listarecyclerView.adapter as ProductoAdapter

        viewModel.listaProducto.observe(viewLifecycleOwner,Observer{
            adapter.submitList(it)
        })

        binding.agregarProductofloatingActionButton.setOnClickListener(){
            findNavController().navigate(R.id.action_FirstFragment_to_productoEditFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}