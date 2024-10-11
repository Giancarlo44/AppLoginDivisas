package com.example.logindivisasapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.logindivisasapp.databinding.ActivityIntercambioBinding

class IntercambioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntercambioBinding
    private lateinit var viewModel: IntercambioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntercambioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(IntercambioViewModel::class.java)

        viewModel.resultado.observe(this) { resultado ->
            binding.tvResultado.text = resultado
        }

        binding.btnConvertir.setOnClickListener {
            val amount = binding.etMonto.text.toString().toDoubleOrNull()
            if (amount != null) {
                viewModel.convertir(amount)
            } else {
                binding.tvResultado.text = "Por favor, ingrese una cantidad válida"
            }
        }

        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

