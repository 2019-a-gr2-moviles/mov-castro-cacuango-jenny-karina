package com.example.ProyectoFarmacia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_gestion_receta.*

class GestionRecetas : AppCompatActivity() {
    companion object objetoCompartido {
        var url = "http://172.29.65.65:1337"
        var idPacienteAux:Int=-1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_receta)
        this.supportActionBar?.hide()
        val idMedicina = intent.getIntExtra("indice", -1)
        idPacienteAux=idMedicina
        var lista = ArrayList<Medicamento>()

        cargarMedicinas(idMedicina)

    }

    fun cargarMedicinas(indice: Int) {
        val url = "${MenuActivity.objetoCompartido.url}/Medicamento"
        val urlSelec = "${MenuActivity.objetoCompartido.url}/MedicamentoReceta/?fkReceta=${indice}"

        var lista = listOf<Medicamento>()
        var listaSelec = listOf<MedicamentoReceta>()
        var medicamentoSelec = ArrayList<MedicamentoAux>()
        var medicamentosDisponibles = ArrayList<Medicamento>()

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
                        var MedicamentoParseado = Klaxon().parseArray<Medicamento>(data)
                        lista = MedicamentoParseado!!
                        urlSelec
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
                                        var historialParseada = Klaxon().parseArray<MedicamentoReceta>(data)
                                        listaSelec = historialParseada!!
                                        lista.forEach {
                                            medicamentosDisponibles.add(it)
                                        }
                                        listaSelec.forEach {
                                            Log.i("http", "LISTA OBJETOS !!!! ${it.fkMedicamento.nombreMedicina}")
                                            var medicamentoAux:MedicamentoAux=MedicamentoAux(it.fkMedicamento.id,
                                                it.fkMedicamento.nombreMedicina, it.fkMedicamento.tipoMedicina,
                                                it.fkMedicamento.precio, it.id)

                                            medicamentoSelec.add(medicamentoAux)
                                            var id=it.fkMedicamento.id
                                            var med= medicamentosDisponibles.find {

                                               it.id==id
                                            }
                                            medicamentosDisponibles.remove(med)
                                        }

                                        runOnUiThread {
                                            iniciarRecycleViewDisponibles(medicamentosDisponibles, this, rv_disponibles, 1)
                                            iniciarRecycleViewSeleccionados(medicamentoSelec, this, rv_seleccionados, 1)
                                        }


                                    }
                                }
                            }
                    }
                }
            }
    }
    fun quitar(idRelacion: Int){
        val url = "${MenuActivity.url}/MedicamentoReceta?id=${idRelacion}"
        var lista = listOf<Medicamento>()

        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {

                        runOnUiThread {
                            cargarMedicinas(idPacienteAux)
                        }

                    }
                }
            }
    }
    fun seleccionar(idMedicina:Int){
        val url = "${MenuActivity.url}/MedicamentoReceta"
        val bodyJson = """
              {
                "fkMedicamento": ${idMedicina},
                "fkReceta" : ${idPacienteAux}

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
                        Log.i("http", "rEQUEST!!!!!!!!!1TODO BIIIIIIIIIIIIIIIIIEN: ${request}")
                        runOnUiThread {
                            cargarMedicinas(idPacienteAux)
                        }
                    }
                }
            }

    }

    fun iniciarRecycleViewDisponibles(
        lista: List<Medicamento>,
        actividad: GestionRecetas,
        recycler_view: androidx.recyclerview.widget.RecyclerView,
        opcion: Int
    ) {
        val adaptadorMedicina = AdaptadorDisponibles(lista, actividad, recycler_view, opcion)
        rv_disponibles.adapter = adaptadorMedicina
        rv_disponibles.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()

        rv_disponibles.layoutManager = LinearLayoutManager(this)
        adaptadorMedicina.notifyDataSetChanged()
    }

    fun iniciarRecycleViewSeleccionados(
        lista: List<MedicamentoAux>,
        actividad: GestionRecetas,
        recycler_view: androidx.recyclerview.widget.RecyclerView,
        opcion: Int
    ) {
        val adaptadorMed = AdaptadorSeleccionados(lista, actividad, recycler_view, opcion)
        rv_seleccionados.adapter = adaptadorMed
        rv_seleccionados.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()

        rv_seleccionados.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adaptadorMed.notifyDataSetChanged()
    }

}
