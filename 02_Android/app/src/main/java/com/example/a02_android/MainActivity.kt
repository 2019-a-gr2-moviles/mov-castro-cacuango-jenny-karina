package com.example.a02_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irAParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )

        val jenny=Usuario("Jenny",
            22,
            Date(),
            130.00)
        
        intentExplicito.putExtra("usuario", jenny)
    }
}
