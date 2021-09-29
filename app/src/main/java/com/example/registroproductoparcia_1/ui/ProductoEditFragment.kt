package com.example.registroproductoparcia_1.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.registroproductoparcia_1.R
import com.example.registroproductoparcia_1.databinding.ProductoEditFragmentBinding
import com.example.registroproductoparcia_1.model.Producto
import com.google.android.material.snackbar.Snackbar

class ProductoEditFragment : Fragment() {

    companion object {
        fun newInstance() = ProductoEditFragment()
    }
    private lateinit var viewModel: ProductoEditViewModel
    private lateinit var binding :ProductoEditFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductoEditFragmentBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this,ProductoEditViewModel.Factory(requireActivity().application))
            .get(ProductoEditViewModel::class.java)

        binding.guardarbutton.setOnClickListener{ view ->

            Snackbar.make(view, "Hola Mario", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            if(!Validar()){
                Snackbar.make(view, "Verifique los errores para continual", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }else{
                viewModel.Insert(LlenaClase())
                //it.showMenssage
                findNavController().navigateUp()
            }
        }
    }

    fun Validar(): Boolean {
        var esValido = true;

        binding.EditTextLayoutDescripcion.let {
            if(it.text.isNullOrEmpty()){
                it.error = "El Campo Descripcion Esta Vacio"
                esValido = false
            }else
                it.error = null
        }

        binding.EditTextLayoutExistencia.let {
            if(it.text.isNullOrEmpty()){
                it.error = "El Campo Descripcion Esta Vacio"
                esValido = false
            }else
                it.error = null
        }

        binding.EditTextLayoutCosto.let {
            if(it.text.isNullOrEmpty()){
                it.error = "El Campo Descripcion Esta Vacio"
                esValido = false
            }else
                it.error = null
        }

        binding.EditTextLayoutValorInventario.let {
            if(it.text.isNullOrEmpty()){
                it.error = "El Campo Descripcion Esta Vacio"
                esValido = false
            }else
                it.error = null
        }
        return esValido
    }

    fun LlenaClase():Producto{
        return Producto(
                0,
        binding.EditTextLayoutDescripcion.text.toString(),
        binding.EditTextLayoutExistencia.text.toString().toInt(),
        binding.EditTextLayoutExistencia.text.toString().toFloat(),
        binding.EditTextLayoutValorInventario.text.toString().toFloat()
                )
    }
}