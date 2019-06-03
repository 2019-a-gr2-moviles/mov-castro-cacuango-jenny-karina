package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_crear_peliculas.*

class crearPeliculas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_peliculas)

        var actor: Actor = this.intent.getParcelableExtra<Actor>("actor")
        Log.i("nuevaPeli", actor.nombreActor)


        btn_registrar.setOnClickListener {
            val pelicula: Peliculas = Peliculas(
                0,
                txt_nombrePelicula.text.toString(),
                txt_anioLanzamiento.text.toString().toInt(),
                txt_rating.text.toString().toInt(),
                txt_actoresPrincipales.text.toString(),
                txt_sinopsis.text.toString(),
                actor.id,
                0
            )
            listaPeliculas(pelicula)
        }
    }

    private fun listaPeliculas(pelicula: Peliculas) {
        val intent = Intent(
            this,
            listaPeliculas::class.java
        )
        intent.putExtra("pelicula", pelicula)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)

    }
}

