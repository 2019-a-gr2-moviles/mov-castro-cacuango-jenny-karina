package com.example.myapplication

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.a02_android.Persona
import com.example.a02_android.R
import com.example.a02_android.ReciclerViewActivity
import kotlinx.android.synthetic.main.layout.*

class AdaptadorPersona(
    private val listaPersonas: List<Persona>,
    private val contexto: ReciclerViewActivity,
    private val recyclerView: RecyclerView
) :


    RecyclerView.Adapter<AdaptadorPersona.MyViewHolder>() {

    override fun getItemCount(): Int {
        //regresa cuantos item se tiene en la lista
        return listaPersonas.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorPersona.MyViewHolder, position: Int) {
        //sacar a la persona por la posición
        val persona = listaPersonas[position]
        myViewHolder.nombreTextureView.text=persona.nombre
        myViewHolder.cedulaTextureView.text=persona.cedula

    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int):
            AdaptadorPersona.MyViewHolder {

        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )

        return MyViewHolder(itemView)

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //constructor primario
        var nombreTextureView:TextView
        var cedulaTextureView:TextView
        var accionBoton:Button

        init {
            nombreTextureView=view.findViewById(R.id.txt_nombre) as TextView
            cedulaTextureView=view.findViewById(R.id.txt_nombre) as TextView
            accionBoton=view.findViewById(R.id.btn_accion) as Button

            val layout = view.findViewById(R.id.linear_layout) as LinearLayout

            layout
                .setOnClickListener {

                    Log.i("recycler-view","Layout presionado")

                }

            accionBoton.setOnClickListener { nombreTextureView.text="ME CAMBIAROON !!"}
        }

    }
}