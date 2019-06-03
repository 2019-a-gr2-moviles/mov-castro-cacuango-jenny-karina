package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info_actor.*

class InfoActor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_actor)

        var actor: Actor = this.intent.getParcelableExtra<Actor>("actor")
        insertarDatos(actor)
        btn_eliminar.setOnClickListener {
            actor.opc = 1
            irActores(actor)
        }
        btn_gestionarPeliculas.setOnClickListener {
            irPeliculas(actor)
        }

        btn_crearPeliculas.setOnClickListener {
            nuevaPelicula(actor)
        }

        btn_Actualizar.setOnClickListener {
            val pacAct = Actor(
                actor.id,
                txt_nombresActor1.text.toString(),
                txt_apellidoActor1.text.toString(),
                txt_fechaNacimiento1.text.toString(),
                txt_numPeliculas1.text.toString().toInt(),
                sw_Retirado1.isChecked,
                2
            )
            irActores(pacAct)
        }
    }

    private fun irActores(actor: Actor) {
        val intent = Intent(
            this,
            ListaActores::class.java
        )
        intent.putExtra("actor", actor)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun insertarDatos(actor: Actor) {
        txt_nombresActor1.setText(actor.nombreActor)
        txt_apellidoActor1.setText(actor.apellidoActor)
        txt_fechaNacimiento1.setText(actor.fechaNacimientoActor)

        sw_Retirado1.isChecked = actor.retirado
    }

    private fun irPeliculas(actor: Actor) {
        val intent = Intent(
            this,
            listaPeliculas::class.java
        )
        intent.putExtra("actor", actor)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun nuevaPelicula(actor: Actor) {
        val intent = Intent(
            this,
            crearPeliculas::class.java
        )
        intent.putExtra("actor", actor)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}

