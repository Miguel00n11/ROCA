package com.miguelrodriguez.roca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miguelrodriguez.roca.RecycleViews.ObrasClientes.ClaseObrasClientes
import com.miguelrodriguez.roca.RecycleViews.ObrasClientes.ObrasClientesAdapter
import android.view.Menu
import android.view.MenuItem



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
                onItemSelected = { position -> showPopupMenu(rvObrasDeClientes, position) })

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
    private fun showPopupMenu(view: View, position: Int) {
        val popupMenu = PopupMenu(this, view)

        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu_options_obras, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.option1 -> {
                    Toast.makeText(this, "Opción 1 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.option2 -> {
                    Toast.makeText(this, "Opción 2 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    private fun initUI() {
        // Registra el RecyclerView para el menú contextual

        registerForContextMenu(rvObrasDeClientes)
    }

    // Override para crear el menú contextual
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_options_obras, menu)
    }

    // Override para manejar la selección en el menú contextual
    override fun onContextItemSelected(item: MenuItem): Boolean {
        // Maneja la selección del menú contextual aquí
        return when (item.itemId) {
            R.id.option1 -> {
                // Realizar acciones para la opción 1
                Toast.makeText(this, "Opción 1 seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.option2 -> {
                // Realizar acciones para la opción 2
                Toast.makeText(this, "Opción 2 seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}