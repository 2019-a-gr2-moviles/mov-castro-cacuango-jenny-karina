package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_peliculas.*

class listaPeliculas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        var actor: Actor? = this.intent.getParcelableExtra<Actor>("actor")
        var pelicula: Peliculas? = this.intent.getParcelableExtra<Peliculas>("pelicula")
        var listaBuscarPeliculas: ArrayList<Peliculas> = arrayListOf<Peliculas>()

        if (actor != null) {
            listaBuscarPeliculas = listaFiltrada(actor.id)

        } else if (pelicula != null) {
            when (pelicula.opc) {
                0 -> {
                    pelicula.identificadorPelicula = Informacion.nuevaPelicula()
                    Informacion.listaPeliculas.add(pelicula)
                }
                1 -> {
                    val listaAux =
                        Informacion.listaPeliculas.filter { peliculaAux -> peliculaAux.identificadorPelicula != pelicula.identificadorPelicula }
                    Informacion.listaPeliculas = listaAux as ArrayList<Peliculas>
                }
                2 -> {
                    Informacion.listaPeliculas.map { peliAux ->
                        if (peliAux.identificadorPelicula == pelicula.identificadorPelicula) {
                            peliAux.nombrePelicula = pelicula.nombrePelicula
                            peliAux.anioLanzamiento = pelicula.anioLanzamiento
                            peliAux.rating = pelicula.rating
                            peliAux.actoresPrincipales = pelicula.actoresPrincipales
                            peliAux.sinopsis = pelicula.sinopsis
                            peliAux.actorId = pelicula.actorId
                        }
                    }

                    Informacion.listaPeliculas.forEach { pelicula ->
                        Log.i(
                            "###",
                            "${pelicula.nombrePelicula} ${pelicula.anioLanzamiento}  ${pelicula.actoresPrincipales} ${pelicula.sinopsis}"
                        )
                    }
                }
                else -> {

                }
            }
            Log.i("idPeli", "${pelicula.actorId}")
            listaBuscarPeliculas =
                Informacion.listaPeliculas.filter { peliAux -> peliAux.actorId == pelicula.actorId } as ArrayList<Peliculas>
            Snackbar
                .make(lista_Peliculas, Informacion.mensaje(pelicula.opc), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaBuscarPeliculas)
        lista_Peliculas.adapter = adapter

        lista_Peliculas.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            listaBuscarPeliculas.forEach { peli -> Log.i("idPeli", "${peli.actorId}") }
            Log.i("ll", listaBuscarPeliculas[id.toInt()].toString())
            gestionarPeliculas(listaBuscarPeliculas[id.toInt()])
        }
    }


    private fun listaFiltrada(id: Int): ArrayList<Peliculas> {
        return Informacion.listaPeliculas.filter { peli -> peli.actorId == id } as ArrayList<Peliculas>
    }

    private fun gestionarPeliculas(pelicula: Peliculas) {
        val intent = Intent(
            this,
            gestionPeliculas::class.java
        )

        intent.putExtra("pelicula", pelicula)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
