package com.example.a02_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_de_vida.*

class CicloDeVida : AppCompatActivity() {

    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_de_vida)

        Log.i("cicloVida", "onCreate")

        btn_contador.setOnClickListener {
            aumentarContador()
            txt_contador.text = this.contador.toString()
        }
    }

    fun aumentarContador(){
        contador ++
    }

    override fun onStart() {
        super.onStart()
        Log.i("cicloVida", "onStar")
    }

    override fun onResume() {
        super.onResume()
        Log.i("cicloVida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("cicloVida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("cicloVida", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("cicloVida", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("cicloVida", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle?) {

        Log.i("cicloVida", "onSaveInstanceState")

        outState?.run {
            putInt("contadorGuardado", contador)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("cicloVida", "onRestoreInstanceState")
        val contadorRecuperado= savedInstanceState?.getInt("contadorGuardaddo")

        if(contadorRecuperado!=null){
            this.contador = contadorRecuperado
            txt_contador.text = this.contador.toString()

        }
    }

}
