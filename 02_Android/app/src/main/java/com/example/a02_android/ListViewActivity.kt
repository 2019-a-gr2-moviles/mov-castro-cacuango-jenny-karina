package com.example.a02_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*
import com.google.android.material.snackbar.Snackbar
import android.view.View


class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listaNombres = arrayListOf<String>()
        listaNombres.add("Jenny")
        listaNombres.add("Karina")
        listaNombres.add("Jenny")
        listaNombres.add("Jenny")
        listaNombres.add("Jenny")
        listaNombres.add("Jenny")
        listaNombres.add("Jenny")

        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1, listaNombres)

        lv_ejemplo.adapter=adapter
        lv_ejemplo.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.i("list-view" ,"Position $position")
            mostrarSnack(view, "Nombre ${listaNombres[position]}, $id")

        }



        }

    fun mostrarSnack(view: View, texto:String){
        Snackbar
            .make(view, texto, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()

    }


    }



