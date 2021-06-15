package com.example.santander.data

data class Conta(
    val numero: String,
    val cpf: String,
    val agencia: String,
    val saldo: String,
    val limite: String,
    val cliente: Cliente,
    val cartao: Cartao
)