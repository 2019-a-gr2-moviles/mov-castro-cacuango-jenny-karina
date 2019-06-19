package com.example.deber_outlook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        var listaInicio = arrayListOf<Parcelable>()

        listaInicio.add(
            Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            1)
        )

        listaInicio.add(Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            2))

        listaInicio.add(Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            3))

        listaInicio.add(Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            4))

        listaInicio.add(Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            5))

        listaInicio.add(Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            6))

        listaInicio.add(Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            7))

        listaInicio.add(Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            8))

        listaInicio.add(Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            9))

        listaInicio.add(Parcelable(
            "CEC-EPN",
            "CEC-EPN descuentos para graduados",
            "Dudas o inconvenientes, contáctenos",
            10))


        iniciarRecylerView(listaInicio, this,rv_mensaje)
    }

    fun iniciarRecylerView(
        lista: List<Parcelable>,
        actividad: ReciclerView,
        recycler_view: RecyclerView
    ) {
        val adaptadorMensaje = AdaptadorMensaje(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorMensaje
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorMensaje.notifyDataSetChanged()
    }

//    fun irAChatAcivity(mensaje: Mensaje){
//        val intentExplicito = Intent(
//            this,
//            ChatActivity::class.java
//        )
//
//
//        intentExplicito.putExtra("mensaje",mensaje)
//        startActivity(intentExplicito)
//
//
//    }

}
