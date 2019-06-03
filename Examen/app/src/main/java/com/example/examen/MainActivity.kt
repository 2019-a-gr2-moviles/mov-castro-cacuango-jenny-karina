package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_ingresar.setOnClickListener {
            Informacion.usuario= txt_nuevoUsuario.text.toString()
            irsubmenuGestion()
        }
    }

    fun irsubmenuGestion(){
        val intent = Intent(
            this,
            submenu_gestion::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
