package com.example.santander

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class ViewLogin : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    lateinit var cpf : EditText
    lateinit var acessar : Button
    lateinit var menuIcon : ImageView
    lateinit var localIcon : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_login)

        cpf = findViewById(R.id.et_cpf)
        acessar = findViewById(R.id.btn_acessar)
        menuIcon = findViewById(R.id.ic_menu)
        localIcon = findViewById(R.id.ic_localization)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)


        acessar.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?) {
                if(cpf.text.toString().equals("54798733207")){
                    openInicial()
                    Toast.makeText(applicationContext, "Bem-Vindo!", Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(applicationContext, "CPF não cadastrado", Toast.LENGTH_SHORT).show()
            }
        })


        menuIcon.setOnClickListener{
            openViewConheca()
        }

        localIcon.setOnClickListener {
            openMaps()
        }

    }

    private fun openInicial(){
        val TelaInicial = Intent(this, ViewConta::class.java)//setando tela  a  variavel
        startActivity(TelaInicial)//iniciar a nova variavel(tela()
        finish()//fecha tela  anterior
    }

    private fun openViewConheca(){
        val TelaConheca = Intent(this, ViewConheca::class.java)//setando tela  a  variavel
        startActivity(TelaConheca)//iniciar a nova variavel(tela()
        finish()//fecha tela  anterior
    }

    private fun openMaps() {
        val TelaMaps = Intent(this, ViewMaps::class.java)//setando tela  a  variavel
        startActivity(TelaMaps)//iniciar a nova variavel(tela()
        LocalUser() //fecha tela  anterior
    }

    fun LocalUser() {
        val task = fusedLocationProviderClient.lastLocation

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                101
            )
            return
        }
        task.addOnSuccessListener {
            if (it != null) {

                Toast.makeText(
                    applicationContext,
                    "${it.latitude} ${it.longitude}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}