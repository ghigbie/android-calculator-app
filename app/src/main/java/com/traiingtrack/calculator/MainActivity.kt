package com.traiingtrack.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var result: EditText
    private lateinit var newNumber: EditText
    private val displayOperation by lazy {findViewById<TextView>(R.id.operation)}

    private var operand1: Double? = null
    private var operand2: Double = 0.0
    private var pendingOperation = "="

    private fun performOperation(value: String, operation: String) {
        displayOperation.text = operation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result)
        newNumber = findViewById(R.id.newNumber)

        //data input buttons
        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonDot: Button = findViewById(R.id.buttonDot)

        //operation buttons
        val buttonEquals = findViewById<Button>(R.id.buttonEquals)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonMinus = findViewById<Button>(R.id.buttonMinus)

        val listener = View.OnClickListener { v ->
            val b = v as Button
            newNumber.append(b.text)
        }

        val dataButtons: ArrayList<Button> = arrayListOf(
            button0, button1, button2, button3,
            button4, button5, button6, button7, button8, button9, buttonDot
        )

        for (button in dataButtons) {
            button.setOnClickListener(listener)
        }

        val opListener = View.OnClickListener { v ->
            val op = (v as Button).text.toString()
            val value = newNumber.text.toString()
            if (value.isNotEmpty()) {
                performOperation(value, op)
            }
            pendingOperation = op
            displayOperation.text = pendingOperation
        }

        val operationButtons: ArrayList<Button> = arrayListOf(
            buttonEquals, buttonDivide,
            buttonMultiply, buttonMinus
        )

        for (button in operationButtons) {
            button.setOnClickListener(opListener)
        }

    }
}
