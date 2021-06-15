package com.example.santander

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.card.MaterialCardView

class ViewAtendimento : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var backIcon: ImageView
    lateinit var mcvAtendi: MaterialCardView
    lateinit var mcvAvalia: MaterialCardView
    lateinit var mcvTermos: MaterialCardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_atendimento)

        backIcon = findViewById(R.id.iv_atendimento_back)
        mcvAtendi = findViewById(R.id.mcv_atend_por_agencia)
        mcvAvalia = findViewById(R.id.mcv_avaliar)
        mcvTermos = findViewById(R.id.mcv_termos)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)


        backIcon.setOnClickListener {
            backMenu()
        }

        mcvAtendi.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "Agencias proximas", Toast.LENGTH_LONG).show()

            }
        })

        mcvAvalia.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val viewPop = View.inflate(this@ViewAtendimento, R.layout.popup, null)

                val builder = AlertDialog.Builder(this@ViewAtendimento)
                builder.setView(viewPop)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            }
        })

        mcvTermos.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "Redirecionando..", Toast.LENGTH_LONG).show()
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.santander.com.br/institucional-santander/seguranca/politica-de-privacidade")
                    )
                );
            }
        })
    }

    private fun fetchLocatio() {
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


    private fun backMenu() {
        val TelaMenu = Intent(this, ViewMenu::class.java)//setando tela  a  variavel
        startActivity(TelaMenu)//iniciar a nova variavel(tela()
        finish()//fecha tela  anterior
    }

}