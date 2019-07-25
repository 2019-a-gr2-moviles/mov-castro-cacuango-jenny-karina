package com.example.ProyectoFarmacia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_gestionar_farmacia.*

class GestionFarmacia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestionar_farmacia)
        btn_gestMedicamento.setOnClickListener {
            irAGestionMedicina(2)
        }
        btn_gestReceta.setOnClickListener {
            irAGestionReceta(2)
        }
    }
    fun irAGestionMedicina(opcion: Int){
        val intent= Intent(
            this, MenuActivity::class.java
        )
        intent.putExtra("opcion", opcion )
        startActivity(intent);
    }
    fun irAGestionReceta(opcion: Int){
        val intent= Intent(
            this, MenuReceta::class.java
        )
        intent.putExtra("opcion", opcion )
        startActivity(intent);
    }
}
