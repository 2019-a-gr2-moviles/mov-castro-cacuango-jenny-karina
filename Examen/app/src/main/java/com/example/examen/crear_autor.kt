package com.example.examen

import android.content.ComponentName
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.Editable
import android.util.Log
import kotlinx.android.synthetic.main.activity_crear_autor.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat

class crear_autor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_autor)
        btn_guardar.setOnClickListener {

            irActorLista(
                txt_nombresActor.text,
                txt_apellidoActor.text,
                txt_fechaNacimiento.text,
                txt_numPeliculas.text,
                sw_Retirado.isChecked
            )
        }
    }

    public fun irActorLista(
        nombreActor: Editable,
        apellidoActor: Editable,
        fechaNacimientoActor: Editable,
        numeroPeliculas: Editable,
        retirado: Boolean
    ) {


        val intent = Intent(
            this,
            ListaActores::class.java
        )

        val actor = Actor(
            0,
            nombreActor.toString(),
            apellidoActor.toString(),
            fechaNacimientoActor.toString(),
            numeroPeliculas.toString().toInt(),
            retirado, 0
        )

        intent.putExtra("actor", actor)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}


