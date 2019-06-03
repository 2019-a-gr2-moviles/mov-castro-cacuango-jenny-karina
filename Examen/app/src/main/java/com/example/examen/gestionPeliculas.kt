package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_gestion_peliculas.*

class gestionPeliculas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_peliculas)

        var pelicula: Peliculas = this.intent.getParcelableExtra<Peliculas>("pelicula")
        ingresarPelicula(pelicula)

        Log.i(
            "mod_peli", "${pelicula.nombrePelicula} ${pelicula.anioLanzamiento} " +
                    "${pelicula.rating} ${pelicula.actoresPrincipales} " +
                    "${pelicula.sinopsis} ${pelicula.actorId}"
        )

        btn_eliminar1.setOnClickListener {
            pelicula.opc = 1
            verPeliculas(pelicula)
        }

        btn_actualizar1.setOnClickListener {
            val peliAux = Peliculas(
                pelicula.identificadorPelicula,
                txt_nombrePelicula1.text.toString(),
                txt_anioLanzamiento1.text.toString().toInt(),
                txt_rating1.text.toString().toInt(),
                txt_actoresPrincipales1.text.toString(),
                txt_sinopsis1.text.toString(),
                pelicula.actorId, 2
            )
            verPeliculas(peliAux)
        }
    }

    fun ingresarPelicula(pelicula: Peliculas) {
        txt_nombrePelicula1.setText(pelicula.nombrePelicula)
        txt_anioLanzamiento1.setText(pelicula.anioLanzamiento)
        txt_actoresPrincipales1.setText(pelicula.actoresPrincipales)
        txt_sinopsis1.setText(pelicula.sinopsis)
    }

    fun verPeliculas(pelicula: Peliculas) {
        val intent = Intent(
            this,
            listaPeliculas::class.java
        )
        intent.putExtra("pelicula", pelicula)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    }
