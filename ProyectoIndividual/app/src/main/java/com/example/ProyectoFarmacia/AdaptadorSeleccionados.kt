package com.example.ProyectoFarmacia

import androidx.constraintlayout.widget.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView

class AdaptadorSeleccionados(private val listaMedicinas: List<MedicamentoAux>,

                             private val contexto: GestionRecetas,
                             private val recyclerView: androidx.recyclerview.widget.RecyclerView,
                             private val opcion: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorSeleccionados.MyViewHolder>() {


    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var nombreMed: TextView
        var tipoMed: TextView
        var precioMed: TextView
        var botonSeleccionar: ImageButton

        var layout: ConstraintLayout
        var indice: Int
        var idSeleccionado: Int

        init {
            nombreMed = view.findViewById(R.id.txts_nombreMed) as TextView
            tipoMed = view.findViewById(R.id.txts_tipoMed) as TextView
            precioMed = view.findViewById(R.id.txts_precioMed) as TextView
            botonSeleccionar= view.findViewById(R.id.btn_deleteSeleccionado)

            layout = view.findViewById(R.id.layout_seleccionados) as ConstraintLayout
            indice = -1
            idSeleccionado=-1
            botonSeleccionar.setOnClickListener {
                contexto.quitar(idSeleccionado)
            }
        }
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_seleccionados,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaMedicinas.size
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
        val med = listaMedicinas[position]
        myViewHolder.nombreMed.text = med.nombreMedicina
        myViewHolder.tipoMed.text = med.tipoMedicina
        myViewHolder.precioMed.text = med.precio.toString()
        myViewHolder.idSeleccionado= med.idRelacion
        myViewHolder.indice = position

    }
}