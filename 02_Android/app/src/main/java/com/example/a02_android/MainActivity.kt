package com.example.a02_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
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
        btn_adapter.setOnClickListener{
            irAListView()}
        btn_recicler_view.setOnClickListener {
            irArecyclerView() }
        btn_respuesta.setOnClickListener {
            irAIntentRespuesta() }

        btn_http.setOnClickListener {
            irAConexionHttp()
        }
        btn_mapa.setOnClickListener {
            irAMapa() }

        btn_cicloVida.setOnClickListener {
            irCicloVida() }

        btn_fragment.setOnClickListener {
            irAFragment() }
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

    fun irArecyclerView(){
        val intentExplicito = Intent(
            this,
            ReciclerViewActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAIntentRespuesta(){
        val intentExplicito = Intent(
            this,
            IntentRespuestaActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAConexionHttp(){
        val intentExplicito = Intent(
            this,
            ConexionHttpActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAMapa(){
        val intentExplicito = Intent(
            this,
            MapsActivity::class.java
        )
        startActivity(intentExplicito)
    }
    fun irCicloVida(){
        val intentExplicito = Intent(
            this,
            CicloDeVida::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAFragment(){
        val intentExplicito = Intent(
            this,
            FragmentosActivity::class.java
        )
        startActivity(intentExplicito)
    }






    //Para enviar un correo
//    val addressees = arrayOf("direccion@unocom", "direccion@dos.com")
//    val intent = Intent(Intent.ACTION_SEND)
//    intent.type = "text/html"
//    intent.putExtra(Intent.EXTRA_EMAIL, addressees)
//    intent.putExtra(Intent.EXTRA_SUBJECT, "Sujeto")
//    intent.putExtra(Intent.EXTRA_TEXT, "Texto.")
//    startActivity(intent)



}
