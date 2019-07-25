package com.example.ProyectoFarmacia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()


        btn_catalogo.setOnClickListener {
            irAcatalogo(1)
        }
        btn_gestFarmacia.setOnClickListener {
            irGestionarFramacia()
        }
    }
    fun irAcatalogo(opcion: Int){
        val intent= Intent(
            this, MenuActivity::class.java
        )
        intent.putExtra("opcion", opcion )
        startActivity(intent);
    }
    fun irGestionarFramacia(){
        val intent= Intent(
            this, GestionFarmacia::class.java
        )

        startActivity(intent);
    }

    fun withEditText() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("FARMAZUL")
        val dialogLayout = inflater.inflate(R.layout.medicinas, null)
        val editText  = dialogLayout.findViewById<EditText>(R.id.txt_ingresarMedicina)
        builder.setView(dialogLayout)
        val dialogLayout2 = inflater.inflate(R.layout.medicinas, null)
        val editText2  = dialogLayout.findViewById<EditText>(R.id.txt_ingresarMedicina)
        builder.setView(dialogLayout2)
        builder.setPositiveButton("Guardar") { dialogInterface, i ->
            Toast.makeText(applicationContext, "Mensaje: " + editText.text.toString(), Toast.LENGTH_SHORT).show()

        }
        builder.show()
    }
}
