package com.example.a02_android

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)

        btn_devolver_respuesta.setOnClickListener { devolverRespuesta() }
    }

    fun devolverRespuesta(){
        val nombre = "Jenny"
        val edad = 22

        val intentRespuesta = Intent()

        intentRespuesta.putExtra("Nombre de Usuario", nombre)
        intentRespuesta.putExtra("Edad Usuario", edad)

        this.setResult(
            RESULT_OK, //Podemos enviar RESULT_OK o RESULT_CANCELED
            intentRespuesta
        )

    }
}
