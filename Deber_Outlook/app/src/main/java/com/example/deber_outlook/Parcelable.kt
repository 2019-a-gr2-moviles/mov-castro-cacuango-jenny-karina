package com.example.deber_outlook

import android.os.Parcel
import android.os.Parcelable

class Parcelable (var autor: String, var mensaje:String, var anuncio: String, var id_usuario: Int ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(autor)
        parcel.writeString(mensaje)
        parcel.writeString(anuncio)
        parcel.writeInt(id_usuario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Parcelable> {
        override fun createFromParcel(parcel: Parcel): Parcelable {
            return Parcelable(parcel)
        }

        override fun newArray(size: Int): Array<Parcelable?> {
            return arrayOfNulls(size)
        }
    }


}