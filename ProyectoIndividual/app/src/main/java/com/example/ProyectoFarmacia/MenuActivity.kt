package com.example.ProyectoFarmacia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity : AppCompatActivity() {
    companion object objetoCompartido {
        var url = "http://172.29.65.65:1337"
        var listaMedicamento = listOf<Medicamento>()
        var opcion:Int =-1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        this.supportActionBar?.hide()
        opcion = intent.getIntExtra("opcion", -1)
        var listaMedicamnetos = arrayListOf<Medicamento>()
        btn_buscarMedicina.setOnClickListener {
            buscar()
        }
        if (opcion == 1) {
            btn_anadirMedicamento.visibility = View.INVISIBLE
        } else {
            btn_anadirMedicamento.setOnClickListener {
                withEditText(Medicamento(-1, "", "", 0.0), 1)
            }
        }
        //si la opcion es 2 es para adminstrador
        cargar(opcion)


    }
    fun buscar(){
        var aux=listaMedicamento.filter {
            it.nombreMedicina.contains(buscarMedicamento.text.toString())

        }
        iniciarRecycleView(aux, this, rv_medicinas, opcion)

    }

    fun cargar(opcion: Int) {
        val url = "${objetoCompartido.url}/Medicamento"
        var lista = listOf<Medicamento>()
        var listaMedicamentoAux = listOf<Medicamento>()
        iniciarRecycleView(listaMedicamentoAux, this, rv_medicinas, opcion)

        url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        var MedParseado = Klaxon().parseArray<Medicamento>(data)
                        lista = MedParseado!!
                        listaMedicamento=lista
                        runOnUiThread {
                            iniciarRecycleView(lista, this, rv_medicinas, opcion)
                        }

                    }
                }
            }
    }



    fun guardarMedicina(medicamento: Medicamento) {
        val url = "${objetoCompartido.url}/Medicamento"
        val bodyJson = """
              {
                "nombreMedicina": "${medicamento.nombreMedicina}",
                "tipoMedicina" : "${medicamento.tipoMedicina}",
                "precio": ${medicamento.precio}
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

    fun editarMedicina(medicina: Medicamento) {
        val url = "${objetoCompartido.url}/medicamento/${medicina.id}"
        val bodyJson = """
  {
            "nombreMedicina": "${medicina.nombreMedicina}",
            "tipoMedicina" : "${medicina.tipoMedicina}",
            "precio": ${medicina.precio}
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
    fun eliminarMedicina(idMedicina: Int){
        val url = "${MenuActivity.url}/medicamento?id=${idMedicina}"
        val urlRelacion = "${MenuActivity.url}/MedicamentoReceta?idMedicamento=${idMedicina}"


        var lista = listOf<Medicamento>()
        urlRelacion
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var MedicamentoParseada = Klaxon().parseArray<MedicamentoReceta>(data)
                        var x=MedicamentoParseada
                        if(MedicamentoParseada!!.size!=0){
                            runOnUiThread {
                                Toast.makeText(applicationContext, "NO SE PUEDE ELIMINAR ", Toast.LENGTH_SHORT).show()
                            }
                        }
                        if(MedicamentoParseada!!.size==0){
                            url
                                .httpDelete()
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

                    }
                }
            }



    }
    fun iniciarRecycleView(lista: List<Medicamento>,
                           actividad: MenuActivity,
                           recycler_view: androidx.recyclerview.widget.RecyclerView, opcion: Int) {
        val adaptadorMedicina = AdaptadorMenu(lista, actividad, recycler_view, opcion)
        rv_medicinas.adapter = adaptadorMedicina
        rv_medicinas.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()

        rv_medicinas.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adaptadorMedicina.notifyDataSetChanged()
    }

    fun withEditText(medicamento: Medicamento, opcion: Int) {

        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("FARMAZUL")
        val dialogLayout = inflater.inflate(R.layout.medicinas, null)

        val nombreMedicina = dialogLayout.findViewById<EditText>(R.id.txt_ingresarMedicina)
        val tipoMedicina = dialogLayout.findViewById<EditText>(R.id.txt_ingresar_tipoMedicina)
        val precioMedicina = dialogLayout.findViewById<EditText>(R.id.txt_ingPrecioMedicina)
        nombreMedicina.setText(medicamento.nombreMedicina.toString())
        tipoMedicina.setText(medicamento.tipoMedicina.toString())
        precioMedicina.setText(medicamento.precio.toString())


        builder.setView(dialogLayout)

        builder.setPositiveButton("Guardar") { dialogInterface, i ->
            if (opcion == 1) {
                medicamento.nombreMedicina = nombreMedicina.text.toString()
                medicamento.tipoMedicina = tipoMedicina.text.toString()
                medicamento.precio = precioMedicina.text.toString().toDouble()
                guardarMedicina(medicamento)
            } else {
                medicamento.nombreMedicina = nombreMedicina.text.toString()
                medicamento.tipoMedicina = tipoMedicina.text.toString()
                medicamento.precio = precioMedicina.text.toString().toDouble()
                editarMedicina(medicamento)
            }
            Toast.makeText(applicationContext, "Medicamento " + nombreMedicina.text.toString(), Toast.LENGTH_SHORT).show()

        }
        builder.show()
    }
}
