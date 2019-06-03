package com.example.examen

import android.os.Parcel
import android.os.Parcelable

class Actor  (var id: Int,
              var nombreActor: String,
              var apellidoActor: String,
              var fechaNacimientoActor: String,
              var numeroPeliculas: Int,
              var retirado: Boolean,
              var opc: Int): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombreActor)
        parcel.writeString(apellidoActor)
        parcel.writeString(fechaNacimientoActor)
        parcel.writeInt(numeroPeliculas)
        parcel.writeByte(if (retirado) 1 else 0)
        parcel.writeInt(opc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Actor> {
        override fun createFromParcel(parcel: Parcel): Actor {
            return Actor(parcel)
        }

        override fun newArray(size: Int): Array<Actor?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "${nombreActor.toUpperCase()} ${apellidoActor.toUpperCase()}"
    }

}