package com.example.santander

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.card.MaterialCardView

class ViewMenu : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    lateinit var menuIcon : ImageView
    lateinit var localIcon : ImageView
    lateinit var pagarQr : TextView
    lateinit var mcvAtendimento : MaterialCardView
    lateinit var mcvIdSantander : MaterialCardView
    lateinit var mcvAcessar : MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_menu)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)


        menuIcon = findViewById(R.id.ic_menu)
        localIcon = findViewById(R.id.ic_localization)
        pagarQr = findViewById(R.id.tv_pagar_cobrar)

        mcvAtendimento = findViewById(R.id.mcv_atendimento)
        mcvIdSantander = findViewById(R.id.mcv_id_san)
        mcvAcessar = findViewById(R.id.mcv_acessar)

        menuIcon.setOnClickListener{
            openViewConheca()
        }

        pagarQr.setOnClickListener{
            Toast.makeText(applicationContext, "Não foi possivel efetuar ação!", Toast.LENGTH_SHORT).show()
        }

        mcvAtendimento.setOnClickListener {
            acessAtendimento()
        }

        localIcon.setOnClickListener {
            openMaps()
        }

        mcvIdSantander.setOnClickListener {
            Toast.makeText(applicationContext, "Faça Login para ter acesso!", Toast.LENGTH_SHORT).show()
        }

        mcvAcessar.setOnClickListener {
            openLogin()
        }

    }

    private fun openViewConheca(){
        val TelaConheca = Intent(this, ViewConheca::class.java)//setando tela  a  variavel
        startActivity(TelaConheca)//iniciar a nova variavel(tela()
        finish()//fecha tela  anterior
    }

    private fun acessAtendimento(){
        val TelaAtend = Intent(this, ViewAtendimento::class.java)//setando tela  a  variavel
        startActivity(TelaAtend)//iniciar a nova variavel(tela()
        finish()//fecha tela  anterior
    }

    private fun openMaps() {
        val TelaMaps = Intent(this, ViewMaps::class.java)//setando tela  a  variavel
        startActivity(TelaMaps)//iniciar a nova variavel(tela()
        LocalUser() //fecha tela  anterior
    }

    private fun openLogin() {
        val TelaLogin = Intent(this, ViewLogin::class.java)//setando tela  a  variavel
        startActivity(TelaLogin)//iniciar a nova variavel(tela()
        finish()//fecha tela  anterior
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