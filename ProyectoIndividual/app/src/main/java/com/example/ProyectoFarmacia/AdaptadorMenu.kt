package com.example.ProyectoFarmacia

import androidx.constraintlayout.widget.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class AdaptadorMenu(
    private val listaMed: List<Medicamento>,

    private val contexto: MenuActivity,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView,
    private val opcion: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorMenu.MyViewHolder>() {

    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var nombreMedicina: TextView
        var tipoMedicina: TextView
        var precioMedicina: TextView
        var botonEliminar: ImageButton

        var layout: ConstraintLayout
        var indice: Int
        var idMedicina: Int

        init {
            nombreMedicina = view.findViewById(R.id.txt_nombreMedicina) as TextView
            tipoMedicina = view.findViewById(R.id.txt_tipoMedicina) as TextView
            precioMedicina = view.findViewById(R.id.txt_precioMedicina) as TextView
            botonEliminar= view.findViewById(R.id.btn_eliminarMed) as ImageButton



            layout = view.findViewById(R.id.layout_menu) as ConstraintLayout
            indice = -1
            idMedicina= -1


            if (opcion == 2) {
                layout.setOnClickListener {
                    contexto.withEditText(listaMed[indice], 0)
                }
                botonEliminar.setOnClickListener {
                    contexto.eliminarMedicina( idMedicina )
                }

            }else{
                botonEliminar.visibility=View.INVISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return listaMed.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorMenu.MyViewHolder, position: Int) {
        val medicina = listaMed[position]
        myViewHolder.nombreMedicina.text = medicina.nombreMedicina
        myViewHolder.tipoMedicina.text = medicina.tipoMedicina
        myViewHolder.precioMedicina.text = medicina.precio.toString()
        myViewHolder.indice = position
        myViewHolder.idMedicina= medicina.id!!
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorMenu.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_menu,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

}