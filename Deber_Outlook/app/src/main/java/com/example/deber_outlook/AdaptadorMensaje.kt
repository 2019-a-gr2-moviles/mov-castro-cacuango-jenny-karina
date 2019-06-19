package com.example.deber_outlook

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class AdaptadorMensaje (
    private val listaMensaje: List<Parcelable>,
    private val contexto: ReciclerView,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorMensaje.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var nombreTextView: TextView
        var descriptionTextView: TextView
        var anuncioTextView: TextView
        var idUsuario: Int =0

        init {
            nombreTextView = view.findViewById(R.id.txt_nombre) as TextView
            descriptionTextView = view.findViewById(R.id.txt_description) as TextView
            anuncioTextView = view.findViewById(R.id.txt_anuncio) as TextView

            val layout = view.findViewById(R.id.RelativeLayout) as RelativeLayout

            layout
                .setOnClickListener {

                    Log.i("recycler-view", "Layout presionado")

                }



            }


        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )

        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {

        return listaMensaje.size

    }

    override fun onBindViewHolder(myViewHolder: AdaptadorMensaje.MyViewHolder, position: Int) {
        val mensaje = listaMensaje[position]


        myViewHolder.nombreTextView.text = mensaje.autor
        myViewHolder.descriptionTextView.text = mensaje.mensaje
        myViewHolder.anuncioTextView.text = mensaje.anuncio
        myViewHolder.idUsuario = mensaje.id_usuario


    }

}

