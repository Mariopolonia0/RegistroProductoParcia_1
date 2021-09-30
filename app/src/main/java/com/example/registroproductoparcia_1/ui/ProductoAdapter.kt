package com.example.registroproductoparcia_1.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.registroproductoparcia_1.databinding.VistaProductoBinding
import com.example.registroproductoparcia_1.model.Producto


class ProductoAdapter():RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {
    private var productoList = emptyList<Producto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val binding = VistaProductoBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(productoList[position])
    }

    override fun getItemCount(): Int {
        return productoList.size
    }

    fun submitList(list :List<Producto>){
        productoList = list
        notifyDataSetChanged()
    }

    inner class ProductoViewHolder(private val binding: VistaProductoBinding) :
            RecyclerView.ViewHolder(binding.root){
                 fun bind(item:Producto){
                     binding.ProductoIDTextView.text = item.ProductoId.toString()
                     binding.DescripcionTextView.text = item.Descricion
                     binding.ExistenciaTextView.text = item.Existencia.toString()
                     binding.PrecioTextView.text = item.Costo.toString()
                 }
            }
}