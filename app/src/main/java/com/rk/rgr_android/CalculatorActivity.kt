package com.rk.rgr_android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val edit1 = findViewById<EditText>(R.id.editNum1)
        val edit2 = findViewById<EditText>(R.id.editNum2)
        val button = findViewById<Button>(R.id.buttonAdd)
        val result = findViewById<TextView>(R.id.resultText)

        button.setOnClickListener {
            val sum = (edit1.text.toString().toIntOrNull() ?: 0) + (edit2.text.toString().toIntOrNull() ?: 0)
            result.text = "Result: $sum"
        }
    }
}