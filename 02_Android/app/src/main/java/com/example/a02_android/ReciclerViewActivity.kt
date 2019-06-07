package com.example.a02_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.example.myapplication.AdaptadorPersona
import kotlinx.android.synthetic.main.recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recicler_view)

        val lista = arrayListOf<Persona>()
        val recicler_view = rv_personas
        val activity= this

        lista.add(Persona("Jenny", "1725052292"))
        lista.add(Persona("Ramiro", "1712363652"))
        lista.add(Persona("Veronica", "1712090164"))

        val adaptadorPersona = AdaptadorPersona(lista, activity, recicler_view)

        recicler_view.adapter=adaptadorPersona
        rv_personas.itemAnimator=DefaultItemAnimator()
        rv_personas.layoutManager=LinearLayoutManager(this)

        //Coge la posición y las va poniendo en los campos de nombre y cedula
        adaptadorPersona.notifyDataSetChanged()
    }
}
