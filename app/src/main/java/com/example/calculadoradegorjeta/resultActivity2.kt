package com.example.calculadoradegorjeta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class resultActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result2)

        val valorConta = intent.getDoubleExtra("valorConta", 0.0)
        val valorGorjeta = intent.getDoubleExtra("valorGorjeta", 0.0)
        val totalConta = intent.getDoubleExtra("totalConta", 0.0)
        val valorPorPessoa = intent.getDoubleExtra("valorPorPessoa", 0.0)
        val btn_novocalculo = findViewById<Button>(R.id.btn_novocalculo)

        findViewById<TextView>(R.id.txtValorConta).text = "Valor da Conta: R$ %.2f".format(valorConta)
        findViewById<TextView>(R.id.txtValorGorjeta).text = "Valor da Gorjeta: R$ %.2f".format(valorGorjeta)
        findViewById<TextView>(R.id.txtTotalConta).text = "Total da Conta: R$ %.2f".format(totalConta)
        findViewById<TextView>(R.id.txtValorPorPessoa).text = "Valor por Pessoa: R$ %.2f".format(valorPorPessoa)

        btn_novocalculo.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)

        }

        }
    }
