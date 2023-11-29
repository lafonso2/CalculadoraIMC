package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        val pesousu: EditText = findViewById(R.id.edtMsg_Peso)
        val alturausu: EditText = findViewById(R.id.edtMsg_Altura)

        btnCalcular.setOnClickListener {

            val alturaStr = alturausu.text.toString()
            val pesoStr = pesousu.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturausu.text.toString().toFloat()
                val alturaquadrado: Float = altura * altura
                val peso: Float = pesousu.text.toString().toFloat()
                val resultado = peso / alturaquadrado

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", resultado)
                    }
                startActivity(intent)

            } else {
                Toast.makeText(this, "Preenche tudo otário", Toast.LENGTH_LONG).show()
            }
        }
    }
}