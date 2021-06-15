package com.example.santander

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santander.data.Conta
import com.example.santander.ui.MainViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class ViewConta : AppCompatActivity() {

    lateinit var menuIcon : ImageView
    lateinit var localIcon : ImageView

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_conta)

        menuIcon = findViewById(R.id.ic_menu)
        localIcon = findViewById(R.id.ic_localization)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)


        menuIcon.setOnClickListener{
            openViewConheca()
        }

        localIcon.setOnClickListener {
            openMaps()
        }

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta : Conta) {
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_conta_corretora).text = conta.numero
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_limite).text = conta.limite
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tv_cartao_final_value).text = conta.cartao.numeroCartao
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