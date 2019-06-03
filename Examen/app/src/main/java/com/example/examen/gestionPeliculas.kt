package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.Editable
import android.util.Log
import kotlinx.android.synthetic.main.activity_gestion_peliculas.*
import kotlinx.android.synthetic.main.activity_lista_peliculas.*

class gestionPeliculas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_peliculas)
        var medicamento: Peliculas = this.intent.getParcelableExtra<Peliculas>("pelicula")
        colocarDatosMed(medicamento)

        Log.i(
            "ACTUALIZAR-MEDICAMENTO", "${medicamento.nombrePelicula} ${medicamento.anioLanzamiento} " +
                    "${medicamento.rating} ${medicamento.actoresPrincipales} " +
                    "${medicamento.sinopsis}  " +
                    "${medicamento.actorId}"
        )
        //        txt_gra_med_act.text=medicamento.gramosAIngerir.toString() as Editable
//        txt_num_pas_med_act.setText (medicamento.gramosAIngerir.toInt())

        btn_eliminar1.setOnClickListener {
            medicamento.opc = 1
            irListaMedicamentos(medicamento)
        }

        btn_actualizar1.setOnClickListener {
            val medicamentoAux = Peliculas(
                medicamento.identificadorPelicula,
                txt_nombrePelicula1.text.toString(),
                txt_anioLanzamiento1.text.toString().toInt(),
                txt_rating1.text.toString().toInt(),
                txt_actoresPrincipales1.text.toString(),
                txt_sinopsis1.text.toString(),
                medicamento.actorId, 2
            )
            irListaMedicamentos(medicamentoAux)
        }
    }

    fun colocarDatosMed(medicamento: Peliculas) {
        txt_nombrePelicula1.setText(medicamento.nombrePelicula)
        //txt_anioLanzamiento1.setText(medicamento.anioLanzamiento)
//        txt_gra_med_act.text=medicamento.gramosAIngerir.toString() as Editable
//        txt_num_pas_med_act.setText (medicamento.gramosAIngerir.toInt())
        //txt_rating1.setText(medicamento.rating)
        txt_actoresPrincipales1.setText(medicamento.actoresPrincipales)
        txt_sinopsis1.setText(medicamento.sinopsis)
    }

    fun irListaMedicamentos(medicamento: Peliculas) {
        val intent = Intent(
            this,
            listaPeliculas::class.java
        )
        intent.putExtra("pelicula", medicamento)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


}
