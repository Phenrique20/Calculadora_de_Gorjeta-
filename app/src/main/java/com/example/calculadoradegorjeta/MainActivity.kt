package com.example.calculadoradegorjeta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtconta = findViewById<TextInputEditText>(R.id.edt_conta)
        val edtpessoa = findViewById<TextInputEditText>(R.id.edt_pessoa)
        val radiogroup = findViewById<RadioGroup>(R.id.radio_group)
        val btncalculcar = findViewById<Button>(R.id.btn_calcular)


        btncalculcar.setOnClickListener {
            val conta = edtconta.text.toString().toDoubleOrNull() ?: 0.0
            val pessoa = edtpessoa.text.toString().toDoubleOrNull() ?: 1

            val porcentagemGorjeta = when (radiogroup.checkedRadioButtonId) {
                R.id.btn_10 -> 0.10
                R.id.btn_15-> 0.15
                R.id.btn_20 -> 0.20
                R.id.btn_25 -> 0.25
                else -> 0.0
            }
            val valorGorjeta = conta * porcentagemGorjeta
            val totalConta = conta + valorGorjeta
            val valorPorPessoa = totalConta / pessoa.toDouble()

            val intent = Intent(this, resultActivity2::class.java).apply {
                putExtra("valorConta", conta)
                putExtra("valorGorjeta", valorGorjeta)
                putExtra("totalConta", totalConta)
                putExtra("valorPorPessoa", valorPorPessoa)
            }

            startActivity(intent)

        }
    }
}
