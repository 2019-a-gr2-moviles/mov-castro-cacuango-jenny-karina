package com.example.a02_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        btn_primero.setOnClickListener {
            abrirPrimerFragmento()
        }

        btn_segundo.setOnClickListener {
            abrirSegundoFragmento()
        }
    }

    fun abrirPrimerFragmento(){
        //Manager
        val fragmenttManager = supportFragmentManager
        //Empezar la transaccion
        val transaccion = fragmenttManager.beginTransaction()
        //definir la instancia del fragmento
        val primerFragmento = primerFragment()
        //reemplazamos el fragmento
        transaccion.replace(R.id.cly_fragmentos, primerFragmento)
        //terminar transacción
        transaccion.commit()
    }

    fun abrirSegundoFragmento(){
        //Manager
        val fragmenttManager = supportFragmentManager
        //Empezar la transaccion
        val transaccion = fragmenttManager.beginTransaction()
        //definir la instancia del fragmento
        val primerFragmento = primerFragment()
        //reemplazamos el fragmento
        transaccion.replace(R.id.cly_fragmentos, primerFragmento)
    }
}
