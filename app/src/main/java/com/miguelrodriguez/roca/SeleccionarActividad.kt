package com.miguelrodriguez.roca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miguelrodriguez.roca.RecycleViews.ObrasClientes.ClaseObrasClientes
import com.miguelrodriguez.roca.RecycleViews.ObrasClientes.ObrasClientesAdapter

class SeleccionarActividad : AppCompatActivity() {

    private  lateinit var listaObras:MutableList<ClaseObrasClientes>
    private lateinit var rvObrasDeClientes:RecyclerView
    private lateinit var listaObrasAdapter:ObrasClientesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccionar_actividad)

        initComponet()
        initUI()


    }

    private fun initComponet() {
        listaObras= mutableListOf()
        listaObras.add(ClaseObrasClientes("Obra irapuato",112))
        listaObras.add(ClaseObrasClientes("Obra salamanca",213))

        rvObrasDeClientes=findViewById(R.id.rvObrasDeClientes)

        listaObrasAdapter =
            ObrasClientesAdapter(listaObras,
                onItemSelected = { position -> onItemSelected(position) })
        rvObrasDeClientes.layoutManager = LinearLayoutManager(this)
        rvObrasDeClientes.adapter = listaObrasAdapter



    }

    private fun onItemDelete(position: Int) {
    }

    private fun onItemSelected(position: Int) {


        Toast.makeText(this, listaObras[position].Obra, Toast.LENGTH_SHORT).show()


//        editarMuestreoMaterial = true
//        reporteSelecionadoMuestroMaterial = listaObrasmutableListOf[position]
//        val intent = Intent(this, RegistroMecanica::class.java)
//        startActivity(intent)

    }

    private fun initUI() {
    }
}