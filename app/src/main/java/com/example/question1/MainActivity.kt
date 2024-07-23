package com.example.question1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.question1.R

class MainActivity : AppCompatActivity() {

    private lateinit var etValue1: EditText
    private lateinit var etValue2: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etValue1 = findViewById(R.id.ednum1)
        etValue2 = findViewById(R.id.ednum2)
        tvResult = findViewById(R.id.t2)
        btnAdd = findViewById(R.id.add)
        btnSubtract = findViewById(R.id.sub)
        btnMultiply = findViewById(R.id.mul)
        btnDivide = findViewById(R.id.div)

        btnAdd.setOnClickListener { performOperation("add") }
        btnSubtract.setOnClickListener { performOperation("sub") }
        btnMultiply.setOnClickListener { performOperation("mul") }
        btnDivide.setOnClickListener { performOperation("div") }
    }

    private fun performOperation(operation: String) {
        val value1Str = etValue1.text.toString()
        val value2Str = etValue2.text.toString()

        if (value1Str.isNotEmpty() && value2Str.isNotEmpty()) {
            val value1 = value1Str.toDouble()
            val value2 = value2Str.toDouble()
            val result = when (operation) {
                "add" -> value1 + value2
                "sub" -> value1 - value2
                "mul" -> value1 * value2
                "div" -> {
                    if (value2 != 0.0) {
                        value1 / value2
                    } else {
                        "Cannot divide by zero"
                    }
                }
                else -> "Invalid operation"
            }
            tvResult.text = "Result: $result"
        } else {
            tvResult.text = "Please enter valid numbers"
        }
    }
}
