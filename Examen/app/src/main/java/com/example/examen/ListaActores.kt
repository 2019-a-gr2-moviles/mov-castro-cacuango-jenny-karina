package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_actores.*

class ListaActores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_actores)


        var actor: Actor? = this.intent.getParcelableExtra<Actor>("actor")
        if (actor != null) {
            when (actor.opc) {
                0 -> {
                    actor.id = Informacion.nuevoActor()
                    Informacion.listActor.add(actor)

                }
                1 -> {
                    val lActorAux = Informacion.listActor.filter { actorAux ->
                        actorAux.id != actor.id
                    }
                    Informacion.listActor = lActorAux as ArrayList<Actor>
                }
                2 -> {
                    Informacion.listActor.map { actorAux ->
                        if (actorAux.id == actor.id) {
                            actorAux.nombreActor = actor.nombreActor
                            actorAux.apellidoActor = actor.apellidoActor
                            actorAux.fechaNacimientoActor = actor.fechaNacimientoActor
                            actorAux.numeroPeliculas= actor.numeroPeliculas
                            actorAux.retirado = actor.retirado
                        }
                    }
                }
            }
            Snackbar
                .make(lista_actores, Informacion.mensaje(actor.opc), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Informacion.listActor)
        lista_actores.adapter = adapter
        lista_actores.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            infoActor(Informacion.listActor[id.toInt()])
        }
    }

    private fun infoActor(actorN: Actor) {
        val intent = Intent(
            this,
            InfoActor::class.java
        )
        intent.putExtra("actor", actorN)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}

