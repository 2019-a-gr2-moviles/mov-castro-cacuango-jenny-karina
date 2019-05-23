package com.example.a02_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parcelable.*
import kotlin.math.log

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)
        btn_menu.setOnClickListener{regresarAMenu()}

        val jenny: Usuario? = this.intent.getParcelableExtra<Usuario>("usuario")

        val cachetes:Mascota?=this.intent.getParcelableExtra<Mascota>("mascota")

        Log.i("parcelable", "Nombre ${jenny?.nombre}")
        Log.i("parcelable", "Edad ${jenny?.edad}")
        Log.i("parcelable", "Fecha de Nacimiento ${jenny?.fechaNacimiento}")
        Log.i("parcelable", "Sueldo ${jenny?.sueldo}")

        Log.i("parcelable", "Nombre mascota ${cachetes?.nombre}")
        Log.i("parcelable", "Nombre dueño ${cachetes?.duenio?.nombre}")



    }

    fun regresarAMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentExplicito)

    }
}
