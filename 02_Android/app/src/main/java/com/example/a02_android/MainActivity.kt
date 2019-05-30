package com.example.a02_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_parcelable.setOnClickListener{
            irAParcelable()
        }
        btn_adapter.setOnClickListener{irAListView()}
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
        startActivity(intentExplicito)

        val cachetes = Mascota("Cachetes", jenny)
        intentExplicito.putExtra("mascota", cachetes)
        startActivity(intentExplicito)
    }

    fun irAListView(){
        val intentExplicito= Intent(this, ListViewActivity::class.java)
        startActivity(intentExplicito)
    }


}
