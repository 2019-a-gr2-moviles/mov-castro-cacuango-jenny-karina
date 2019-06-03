package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_peliculas.*
import kotlinx.android.synthetic.main.activity_lista_actores.*

class listaPeliculas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        var paciente: Actor? = this.intent.getParcelableExtra<Actor>("actor")
        var medicamento: Peliculas? = this.intent.getParcelableExtra<Peliculas>("pelicula")
        var listaMedicamentosFiltrada: ArrayList<Peliculas> = arrayListOf<Peliculas>()

        if (paciente != null) {
            listaMedicamentosFiltrada = listaFiltrada(paciente.id)

        } else if (medicamento != null) {
            when (medicamento.opc) {
                0 -> {
                    medicamento.identificadorPelicula = Informacion.nuevaPelicula()
                    Informacion.listaPeliculas.add(medicamento)
                }
                1 -> {
                    val listaAux =
                        Informacion.listaPeliculas.filter { medicamentoAux -> medicamentoAux.identificadorPelicula != medicamento.identificadorPelicula }
                    Informacion.listaPeliculas = listaAux as ArrayList<Peliculas>
                }
                2 -> {
                    Informacion.listaPeliculas.map { medAux ->
                        if (medAux.identificadorPelicula == medicamento.identificadorPelicula) {
                            medAux.nombrePelicula = medicamento.nombrePelicula
                            medAux.anioLanzamiento = medicamento.anioLanzamiento
                            medAux.rating = medicamento.rating
                            medAux.actoresPrincipales = medicamento.actoresPrincipales
                            medAux.sinopsis = medicamento.sinopsis
                            medAux.actorId = medicamento.actorId
                        }
                    }


                    Informacion.listaPeliculas.forEach { med ->
                        Log.i(
                            "###",
                            "${medicamento.nombrePelicula} ${medicamento.anioLanzamiento} ${medicamento.rating} ${medicamento.actoresPrincipales} ${medicamento.sinopsis}"
                        )
                    }
                }
                else -> {

                }
            }
            Log.i("idP@C", "${medicamento.actorId}")
            listaMedicamentosFiltrada =
                Informacion.listaPeliculas.filter { medAux -> medAux.actorId == medicamento.actorId } as ArrayList<Peliculas>
            Snackbar
                .make(lista_Peliculas, Informacion.mensaje(medicamento.opc), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMedicamentosFiltrada)
        lista_Peliculas.adapter = adapter

        lista_Peliculas.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            listaMedicamentosFiltrada.forEach { med -> Log.i("idP@C", "${med.actorId}") }
            Log.i("ll", listaMedicamentosFiltrada[id.toInt()].toString())
            irGestionarMedicamento(listaMedicamentosFiltrada[id.toInt()])
        }
    }


    private fun listaFiltrada(id: Int): ArrayList<Peliculas> {
        return Informacion.listaPeliculas.filter { medicamento -> medicamento.actorId == id } as ArrayList<Peliculas>
    }

    private fun irGestionarMedicamento(medicamento: Peliculas) {
        val intent = Intent(
            this,
            gestionPeliculas::class.java
        )

        intent.putExtra("pelicula", medicamento)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
