package com.example.santander

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.card.MaterialCardView

class ViewConheca : AppCompatActivity() {

    lateinit var closeIcon : ImageView
    lateinit var mcvWhay : MaterialCardView
    lateinit var mcvEsfera : MaterialCardView
    lateinit var mcvToro : MaterialCardView
    lateinit var mcvSim : MaterialCardView
    lateinit var mcvEmdia : MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_conheca)

        closeIcon = findViewById(R.id.ic_close_menu)
        mcvWhay = findViewById(R.id.mcv_whay)
        mcvEsfera = findViewById(R.id.mcv_esfera)
        mcvToro = findViewById(R.id.mcv_toro)
        mcvSim = findViewById(R.id.mcv_sim)
        mcvEmdia = findViewById(R.id.mcv_emdia)


        closeIcon.setOnClickListener {
            closeConheca()
        }

        mcvWhay.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?){
                Toast.makeText(applicationContext, "Redirecionando para site", Toast.LENGTH_LONG).show()
                startActivity( Intent (Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=br.com.santander.way")));
            }
        })

        mcvEsfera.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?){
                Toast.makeText(applicationContext, "Redirecionando para site", Toast.LENGTH_LONG).show()
                startActivity( Intent (Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=br.com.vcesfera")));
            }
        })

        mcvToro.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?){
                Toast.makeText(applicationContext, "Redirecionando para site", Toast.LENGTH_LONG).show()
                startActivity( Intent (Intent.ACTION_VIEW, Uri.parse("https://www.toroinvestimentos.com.br/")));
            }
        })

        mcvSim.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?){
                Toast.makeText(applicationContext, "Redirecionando para site", Toast.LENGTH_LONG).show()
                startActivity( Intent (Intent.ACTION_VIEW, Uri.parse("https://emprestimosim.com.br/")));
            }
        })

        mcvEmdia.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?){
                Toast.makeText(applicationContext, "Redirecionando para site", Toast.LENGTH_LONG).show()
                startActivity( Intent (Intent.ACTION_VIEW, Uri.parse("https://euemdia.com.br/")));
            }
        })

    }

    private fun closeConheca(){
        val TelaMenu = Intent(this, ViewMenu::class.java)//setando tela  a  variavel
        startActivity(TelaMenu)//iniciar a nova variavel(tela()
        finish()//fecha tela  anterior
    }
}