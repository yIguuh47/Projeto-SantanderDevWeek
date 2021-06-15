package com.example.santander.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.santander.R

class MainActivity : AppCompatActivity() {

    lateinit var btn_criar_conta : Button
    lateinit var txt_sou_cliente: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_criar_conta = findViewById(R.id.btn_abrir_conta)
        txt_sou_cliente = findViewById(R.id.tv_sou_cliente)


        btn_criar_conta.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?){
                Toast.makeText(applicationContext, "Redirecionando para site", Toast.LENGTH_LONG).show()
            startActivity( Intent (Intent.ACTION_VIEW, Uri.parse("https://abrasuaconta.santander.com.br")));
            }
        })


        txt_sou_cliente.setOnClickListener{
            ViewMenu()
        }
    }

    private fun ViewMenu(){

        val TelaMenu = Intent(this,com.example.santander.ViewMenu::class.java)//setando tela  a  variavel
        startActivity(TelaMenu)//iniciar a nova variavel(tela()
        finish()//fecha tela  anterior
    }
}