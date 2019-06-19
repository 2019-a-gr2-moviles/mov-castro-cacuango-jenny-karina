package com.example.deber_outlook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ver_mensaje.*

class VerMensaje : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_mensaje)

        val mensaje:Parcelable?= this.intent.getParcelableExtra<Parcelable>("mensaje")

        if(mensaje?.id_usuario==1){
            img_anuncio.setImageResource(R.mipmap.icon3)
            img_icon.setImageResource(R.mipmap.icon1)

        }else{

            img_anuncio.setImageResource(R.mipmap.icon4)
            img_icon.setImageResource(R.mipmap.icon2)
        }

        txt_nombre1.text = mensaje?.autor
        txt_cabecera.text = mensaje?.cabecera
        txt_contenido.text = mensaje?.recibir
    }
}
