package com.example.a02_android

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private var tienePermisosLocalizacion = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        solicitarPermisosLocalizacion()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        establecerConfiguracionMapa(googleMap
        )

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-0.210047, -78.4885) //aqui se pone la latitud y longitud para ubicarnos en un lugar especifico
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 17f)) //cambiar a zoom para activarlo
    }

    fun establecerConfiguracionMapa(mapa:GoogleMap){
        with(mapa){

            this.uiSettings.isZoomControlsEnabled = true
            uiSettings.isMyLocationButtonEnabled = true
        }
    }

    fun solicitarPermisosLocalizacion(){
        val tienePermisosFineLocation = ContextCompat.checkSelfPermission(
            this.applicationContext, android.Manifest.permission.ACCESS_FINE_LOCATION
        )

        val tienePermiso = tienePermisosFineLocation ==PackageManager.PERMISSION_GRANTED

        if(tienePermiso){
            Log.i("mapa", "Tiene permisos Fine Location")
            this.tienePermisosLocalizacion = true
        }else{
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1 //codigo que vamos a esperar
            )
        }

    }
}
