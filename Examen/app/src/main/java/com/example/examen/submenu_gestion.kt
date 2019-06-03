package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_submenu_gestion.*

class submenu_gestion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submenu_gestion)

        btn_gestAutor.setOnClickListener {
            listaActores()
        }

        btn_crearAutor.setOnClickListener {
            gestionCrearAutor()
        }
    }

    private fun listaActores() {
        val intent = Intent(
            this,
            ListaActores::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun gestionCrearAutor() {
        val intent = Intent(
            this,
            crear_autor::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


}
