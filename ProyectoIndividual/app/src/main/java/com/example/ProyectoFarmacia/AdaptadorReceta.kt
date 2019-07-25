package com.example.ProyectoFarmacia

import androidx.constraintlayout.widget.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView

class AdaptadorReceta(private val listaReceta: List<Receta>,

                      private val contexto: MenuReceta,
                      private val recyclerView: androidx.recyclerview.widget.RecyclerView,
                      private val opcion:Int): androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorReceta.MyViewHolder>() {



    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view){
        var nombrePaciente: TextView
        var apellidoPaciente: TextView
        var identificacion: TextView
        var botonVerReceta: ImageButton
        var botonEditarReceta: ImageButton
        var botonEliminarReceta: ImageButton
        var layout: ConstraintLayout
        var indice: Int
        var idSeleccionado: Int
        init {
            nombrePaciente= view.findViewById(R.id.txtr_nombre) as TextView
            apellidoPaciente= view.findViewById(R.id.txtc_apellido) as TextView
            identificacion= view.findViewById(R.id.txt_identificacion) as TextView
            botonVerReceta = view.findViewById(R.id.btn_verReceta) as ImageButton
            botonEditarReceta = view.findViewById(R.id.btn_editarReceta) as ImageButton
            botonEliminarReceta = view.findViewById(R.id.btn_eliminarReceta) as ImageButton
            layout = view.findViewById(R.id.layout_combo) as ConstraintLayout
            indice= -1
            idSeleccionado=-1
            botonVerReceta.setOnClickListener {
                contexto.irGestionReceta(idSeleccionado)
            }
            botonEliminarReceta.setOnClickListener {
                contexto.eliminarReceta(idSeleccionado)
            }
            botonEditarReceta.setOnClickListener {
                contexto.editarGuardarReceta(listaReceta[indice], 2)
            }
        }
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorReceta.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_recetas,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaReceta.size
    }
    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
        val receta = listaReceta[position]
        myViewHolder.nombrePaciente.text = receta.nombrePaciente
        myViewHolder.apellidoPaciente.text = receta.apellidoPaciente
        myViewHolder.identificacion.text = receta.identificacion.toString()
        myViewHolder.indice = position
        myViewHolder.idSeleccionado=receta.id!!
    }


}