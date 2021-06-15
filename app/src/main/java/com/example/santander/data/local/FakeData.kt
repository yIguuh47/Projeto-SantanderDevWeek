package com.example.santander.data.local
import com.example.santander.data.Cartao
import com.example.santander.data.Cliente
import com.example.santander.data.Conta

class FakeData{

    fun getLocalData() : Conta {//dados ficticios..
        val cliente = Cliente("Igor")
        val cartao = Cartao("47.897.564-5")

        return Conta(
            "4758-9328",
                "54798733207",
            "00135-9",
            "R$ 3.598,00",
            "R$ 5.369,00",
            cliente,
            cartao);
    }


}