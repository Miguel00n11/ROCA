package com.miguelrodriguez.roca.RecycleViews.ObrasClientes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miguelrodriguez.roca.R

class ObrasClientesAdapter(
    private val listaObra:MutableList<ClaseObrasClientes>,
    private val onItemSelected:(Int)->Unit
):RecyclerView.Adapter<ObrasClientesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObrasClientesViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.item_obras_del_cliente,parent,false)
        return ObrasClientesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObrasClientesViewHolder, position: Int) {
        holder.render(listaObra[position])
        holder.itemView.setOnClickListener {onItemSelected(position) }
        holder.bind(listaObra[position], onItemSelected)
    }

    override fun getItemCount(): Int {
        return listaObra.size
    }
}