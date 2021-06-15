package com.example.santander.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.santander.data.Conta
import com.example.santander.data.local.FakeData

class MainViewModel : ViewModel(){

    //Tem a responsabilidade de estar setando um valor, você pode estar setando um dado que vai ser observado.
    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente() : LiveData<Conta> {//passa os dados armazenados para a LiveData
        mutableLiveData.value = FakeData().getLocalData()
        return mutableLiveData

    }

}