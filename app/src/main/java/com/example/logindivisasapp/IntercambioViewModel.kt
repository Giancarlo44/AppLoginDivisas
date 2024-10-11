package com.example.logindivisasapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IntercambioViewModel : ViewModel() {
    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> get() = _resultado

    fun convertir(amount: Double) {
        val resultDollars = convertToDollars(amount)
        val resultEuros = convertToEuros(amount)
        val resultPesosMx = convertToPesosMx(amount)

        _resultado.value = "Resultado:\n" +
                "Dólares: $resultDollars\n" +
                "Euros: $resultEuros\n" +
                "Pesos MX: $resultPesosMx"
    }

    private fun convertToDollars(amount: Double): Double {
        val conversionRate = 0.27
        return amount * conversionRate
    }

    private fun convertToEuros(amount: Double): Double {
        val conversionRate = 0.24
        return amount * conversionRate
    }

    private fun convertToPesosMx(amount: Double): Double {
        val conversionRate = 5.28
        return amount * conversionRate
    }
}
