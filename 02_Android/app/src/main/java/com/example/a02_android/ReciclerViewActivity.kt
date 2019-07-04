package com.example.a02_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.AdaptadorPersona
import kotlinx.android.synthetic.main.recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recicler_view)

        val lista = arrayListOf<Persona>()
        //val recicler_view = rv_personas
        //val activity= this

        lista.add(Persona("Jenny", "1725052292"))
        lista.add(Persona("Ramiro", "1712363652"))
        lista.add(Persona("Veronica", "1712090164"))

        iniciarRecylerView(lista, this, rv_personas)

        //val adaptadorPersona = AdaptadorPersona(lista, activity, recicler_view)

        //recicler_view.adapter=adaptadorPersona
        //rv_personas.itemAnimator=DefaultItemAnimator()
        //rv_personas.layoutManager=LinearLayoutManager(this)

        //Coge la posición y las va poniendo en los campos de nombre y cedula
        //adaptadorPersona.notifyDataSetChanged()
    }

    fun cambiarNBombreTextView(texto: String){
        txv_titulo_rv.text = texto
    }

    fun iniciarRecylerView(
        lista: List<Persona>,
        actividad: ReciclerViewActivity,
        recycler_view: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorPersona = AdaptadorPersona(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorPersona
        recycler_view.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }
}
