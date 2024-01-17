package com.miguelrodriguez.roca.RecycleViews.ObrasClientes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miguelrodriguez.roca.R

class ObrasClientesViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private var tvObrasDeClientes:TextView=view.findViewById(R.id.tvObrasDeClientes)
    private var tvExpedientesDeClientes:TextView=view.findViewById(R.id.tvExpedientesDeClientes)
    fun render(claseObrasClientes: ClaseObrasClientes) {
        tvObrasDeClientes.text= claseObrasClientes.Obra
        tvExpedientesDeClientes.text= claseObrasClientes.expediente.toString()

    }

    fun bind(
        claseObrasClientes: ClaseObrasClientes,
        onItemSelected: (Int) -> Unit
    ) {


        itemView.setOnClickListener {
            onItemSelected(adapterPosition)
        }
    }
}