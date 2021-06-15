package com.example.santander

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.santander.data.local.Localizacao
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ViewMaps : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_maps)
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

        // Add a marker in Sydney and move the camera
        val SantJoseOtoni = LatLng(-23.49221800, -46.43957500)
        val SantTatuape = LatLng(-23.535281, -46.574697)
        val SantAvGui = LatLng(-23.517084, -46.588533)
        val SantPatriarca = LatLng(-23.547902, -46.63732)
        val SantItaqua = LatLng(-23.476463, -46.351944)
        val SantPoa = LatLng(-23.520412, -46.342872)
        val SantSuzano = LatLng(-23.54428, -46.311913)
        val SantMogi = LatLng(-23.524211, -46.195472)
        val SantCumbica = LatLng(-23.451703, -46.474597)
        val SantGuarulhos = LatLng(-23.464251, -46.52656)
        val SantMaua = LatLng(-23.666428, -46.457503)
        val SantSaoMiguel = LatLng(-23.493373, -46.441063)
        val SantItaim = LatLng(-23.497378, -46.39945)
        val SantArtuhAlvin = LatLng(-23.538572, -46.490293)

        mMap.addMarker(MarkerOptions().position(SantJoseOtoni).title("Marca em Agencia 2194"))
        mMap.addMarker(MarkerOptions().position(SantPatriarca).title("Marca em Agencia 0319"))
        mMap.addMarker(MarkerOptions().position(SantTatuape).title("Marca em Agencia 3863"))
        mMap.addMarker(MarkerOptions().position(SantAvGui).title("Marca em Agencia 0319"))
        mMap.addMarker(MarkerOptions().position(SantItaqua).title("Marca em Agencia 0350"))
        mMap.addMarker(MarkerOptions().position(SantPoa).title("Marca em Agencia 0353"))
        mMap.addMarker(MarkerOptions().position(SantSuzano).title("Marca em Agencia 3620"))
        mMap.addMarker(MarkerOptions().position(SantMogi).title("Marca em Agencia 4562"))
        mMap.addMarker(MarkerOptions().position(SantCumbica).title("Marca em Agencia 1036"))
        mMap.addMarker(MarkerOptions().position(SantGuarulhos).title("Marca em Agencia 4527"))
        mMap.addMarker(MarkerOptions().position(SantMaua).title("Marca em Agencia 4609"))
        mMap.addMarker(MarkerOptions().position(SantSaoMiguel).title("Marca em Agencia 4281"))
        mMap.addMarker(MarkerOptions().position(SantItaim).title("Marca em Agencia 0696"))
        mMap.addMarker(MarkerOptions().position(SantArtuhAlvin).title("Marca em Agencia 0652"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SantItaqua, 10f))
    }
}



