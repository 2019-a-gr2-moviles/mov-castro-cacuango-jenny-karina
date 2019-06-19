package com.example.deber_outlook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_ver_mensaje.*


class VerMensaje : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_mensaje)

        val mensaje:Parcelable?= this.intent.getParcelableExtra<Parcelable>("mensaje")
        //Log.i("mensaje", "Mensajee ${mensaje?.autor}")

        if(mensaje?.id_usuario==1){
            img_anuncio.setImageResource(R.mipmap.icon3)
            txt_nombre1.text =mensaje.autor
        }
    }





}
