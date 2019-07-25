package com.example.ProyectoFarmacia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_menu_receta.*

class MenuReceta : AppCompatActivity() {
    companion object objetoCompartido {

        var listaReceta = listOf<Receta>()
        var opcion:Int =-1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_receta)
        this.supportActionBar?.hide()
        cargar(0)
        btn_nuevoPaciente.setOnClickListener {
            editarGuardarReceta(Receta(-1, "", "", 0), 1)
        }
        btn_BuscarPaciente.setOnClickListener {
            buscar()
        }
    }
    fun buscar(){
        var aux= listaReceta.filter {
            it.nombrePaciente.contains(inputc_busqueda.text.toString())
        }
        iniciarRecycleView(aux, this, rv_pacientes, opcion)

    }
    fun irGestionReceta(indice:Int){
        val intent= Intent(
            this, GestionRecetas::class.java
        )
        intent.putExtra("indice", indice )
        startActivity(intent);
    }
    fun cargar(opcion: Int){
        val url = "${MenuActivity.objetoCompartido.url}/receta"
        var lista= listOf<Receta>()

        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")
                        var MedParseada = Klaxon().parseArray<Receta>(data)
                        lista=MedParseada!!
                        listaReceta=lista
                        runOnUiThread {
                            iniciarRecycleView(lista, this, rv_pacientes, opcion)
                        }

                    }
                }
            }
    }
    fun iniciarRecycleView(lista: List<Receta>,
                           actividad:MenuReceta,
                           recycler_view: androidx.recyclerview.widget.RecyclerView,
                           opcion: Int){
        val adaptadorMedic= AdaptadorReceta(lista, actividad, recycler_view, opcion)
        rv_pacientes.adapter=adaptadorMedic
        rv_pacientes.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        //Nos falta el layout manager
        rv_pacientes.layoutManager= androidx.recyclerview.widget.LinearLayoutManager(this)
        adaptadorMedic.notifyDataSetChanged()
    }
    fun guardarReceta(receta: Receta) {
        val url = "${MenuActivity.url}/receta"
        val bodyJson = """
              {
                "nombrePaciente": "${receta.nombrePaciente}",
                "apellidoPaciente" : "${receta.apellidoPaciente}",
                "identificacion": ${receta.identificacion}
              }
            """
        url
            .httpPost().body(bodyJson)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "rEQUEST: ${request}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            cargar(opcion)
                        }

                        Log.i("http", "TODO BIIIEN")
                    }
                }
            }

    }

    fun editarReceta(receta: Receta) {
        val url = "${MenuActivity.url}/receta/${receta.id}"
        val bodyJson = """
  {
    "nombrePaciente": "${receta.nombrePaciente}",
    "apellidoPaciente" : "${receta.apellidoPaciente}",
    "identificacion": ${receta.identificacion}
  }
"""
        url.httpPut().body(bodyJson)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "rEQUEST: ${request}")

                    }
                    is Result.Success -> {
                        runOnUiThread {
                            cargar(opcion)
                        }

                        Log.i("http", "TODO BIIIEN")
                    }
                }
            }

    }
    fun eliminarReceta(idreceta: Int){
        val url = "${MenuActivity.url}/receta?id=${idreceta}"
        var lista = listOf<Receta>()

        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {

                        runOnUiThread {
                            cargar(opcion)
                        }

                    }
                }
            }
    }
    fun editarGuardarReceta(reccetaa: Receta, opcion: Int) {

        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("FARMAZUL")
        val dialogLayout = inflater.inflate(R.layout.dialog_recetas, null)

        val nombrePaciente = dialogLayout.findViewById<EditText>(R.id.txt_nuevo_Paciente)
        val apellidoPaciente = dialogLayout.findViewById<EditText>(R.id.txt_ingreso_apellido)
        val identificacion = dialogLayout.findViewById<EditText>(R.id.txt_ingreso_ci)
        nombrePaciente.setText(reccetaa.nombrePaciente.toString())
        apellidoPaciente.setText(reccetaa.apellidoPaciente.toString())
        identificacion.setText(reccetaa.identificacion.toString())


        builder.setView(dialogLayout)

        builder.setPositiveButton("Guardar") { dialogInterface, i ->
            if (opcion == 1) {

                reccetaa.nombrePaciente = nombrePaciente.text.toString()
                reccetaa.apellidoPaciente = apellidoPaciente.text.toString()
                reccetaa.identificacion = identificacion.text.toString().toInt()
                guardarReceta(reccetaa)
            } else {

                reccetaa.nombrePaciente = nombrePaciente.text.toString()
                reccetaa.apellidoPaciente = apellidoPaciente.text.toString()
                reccetaa.identificacion = identificacion.text.toString().toInt()
                editarReceta(reccetaa)
            }
            Toast.makeText(applicationContext, "Paciente: " + nombrePaciente.text.toString(), Toast.LENGTH_SHORT).show()

        }
        builder.show()
    }
}
