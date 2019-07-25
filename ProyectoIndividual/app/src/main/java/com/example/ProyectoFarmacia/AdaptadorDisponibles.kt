package com.example.ProyectoFarmacia

import androidx.constraintlayout.widget.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView

class AdaptadorDisponibles(private val listaMedicamentos: List<Medicamento>,

                           private val contexto: GestionRecetas,
                           private val recyclerView: androidx.recyclerview.widget.RecyclerView,
                           private val opcion: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorDisponibles.MyViewHolder>() {


    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var nombreMedicamento: TextView
        var tipoMedicamento: TextView
        var precioMedicamento: TextView
        var botonSeleccionar: ImageButton
        var layout: ConstraintLayout
        var indice: Int
        var idMedicamento: Int

        init {
            nombreMedicamento = view.findViewById(R.id.txtd_nombreMedicina) as TextView
            tipoMedicamento = view.findViewById(R.id.txtd_tipoMedicina) as TextView
            precioMedicamento = view.findViewById(R.id.txtd_precioMedicina) as TextView
            layout = view.findViewById(R.id.layout_disponibles) as ConstraintLayout
            botonSeleccionar= view.findViewById(R.id.btn_addSeleccionado) as ImageButton
            indice = -1
            idMedicamento= -1
            botonSeleccionar.setOnClickListener {
                contexto.seleccionar(idMedicamento)
            }

        }
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_disponibles,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaMedicamentos.size
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
        val medicina = listaMedicamentos[position]
        myViewHolder.nombreMedicamento.text = medicina.nombreMedicina
        myViewHolder.tipoMedicamento.text = medicina.tipoMedicina
        myViewHolder.precioMedicamento.text = medicina.precio.toString()
        myViewHolder.idMedicamento= medicina.id!!
        myViewHolder.indice = position
    }
}