package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividad_dos.*
import kotlinx.android.synthetic.main.content_main.*

class ActividadDos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dos)

        val nombre=intent.getStringExtra("nombre")
        val edad=intent.getIntExtra("edad", 0)
        println(nombre)
        println(edad)

        Log.i("intents","Nombre: $nombre")
        Log.i("intents","Nombre: $edad")


        btn_actividad_uno.setOnClickListener { this.irActividadMain()
            irActividadMain()

        }
    }

    fun irActividadMain(){
        val  intent = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intent)
    }
}
