package com.example.examen

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class Informacion {
    companion object {
        var listActor: ArrayList<Actor> = listActorInicial()
        var listaPeliculas: ArrayList<Peliculas> = listPeliculas()
        private var idActor: Int = 0
        private var idPelicula: Int = 0
        var usuario = ""

        fun mensaje(opc: Int): String {
            return when (opc) {
                0 -> {
                    return StringBuilder().append(usuario).append(" Ha ingresado un nuevo dato.").toString()
                }
                1 -> {
                    return StringBuilder().append(usuario).append(" Ha eliminado uno de los datos").toString()
                }
                2 -> {
                    return StringBuilder().append(usuario).append(" Ha actualizado información").toString()
                }

                else -> {
                    return "nada"
                }
            }
        }

        private fun listActorInicial(): ArrayList<Actor> {
            val list = arrayListOf<Actor>()
            list.add(Actor(nuevoActor(),
                "Paul",
                "Walker",
                "12/09/1973",
                8,
                true,
                -1))
            return list
        }

        private fun listPeliculas(): ArrayList<Peliculas> {
            val listaPeliculas = arrayListOf<Peliculas>()
            listaPeliculas.add(Peliculas(nuevaPelicula(),
                "Rapidos y Furiosos 7",
                2001,
                3,
                "Vin Diesel",
                "El hermano de un hombre muerto busca vengarse de la pandilla de Toretto.",
                0,
                -1))
            return listaPeliculas
        }

        fun nuevoActor(): Int {
            idActor++
            return (idActor - 1)
        }

        fun nuevaPelicula(): Int {
            idPelicula++
            return (idPelicula - 1)
        }
    }
}