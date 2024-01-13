package com.miguelrodriguez.roca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btnAcceder:Button
    private lateinit var tvOlvide:TextView
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
        initUI()
    }

    private fun initComponent() {
        btnAcceder=findViewById(R.id.btnAcceder)
        tvOlvide=findViewById(R.id.tvOlvide)
    }

    private fun initUI() {
        btnAcceder.setOnClickListener {
            val intent=Intent(this,SeleccionarActividad::class.java)
            startActivity(intent)
        }
        tvOlvide.setOnClickListener { Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show() }
    }
}