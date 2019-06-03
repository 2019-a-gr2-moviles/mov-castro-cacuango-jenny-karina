package com.example.examen

import android.os.Parcel
import android.os.Parcelable

class Peliculas (var identificadorPelicula: Int,
                 var nombrePelicula: String,
                 var anioLanzamiento: Int,
                 var rating: Int,
                 var actoresPrincipales: String,
                 var sinopsis: String,
                 var actorId: Int,
                 var opc: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(identificadorPelicula)
        parcel.writeString(nombrePelicula)
        parcel.writeInt(anioLanzamiento)
        parcel.writeInt(rating)
        parcel.writeString(actoresPrincipales)
        parcel.writeString(sinopsis)
        parcel.writeInt(actorId)
        parcel.writeInt(opc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Peliculas> {
        override fun createFromParcel(parcel: Parcel): Peliculas {
            return Peliculas(parcel)
        }

        override fun newArray(size: Int): Array<Peliculas?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "${nombrePelicula.toUpperCase()}"
    }

}