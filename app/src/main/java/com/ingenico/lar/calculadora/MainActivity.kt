package com.ingenico.lar.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        val button0 = findViewById<Button>(R.id.number0)
        val button1 = findViewById<Button>(R.id.number1)
        val button2 = findViewById<Button>(R.id.number2)
        val button3 = findViewById<Button>(R.id.number3)
        val button4 = findViewById<Button>(R.id.number4)
        val button5 = findViewById<Button>(R.id.number5)
        val button6 = findViewById<Button>(R.id.number6)
        val button7 = findViewById<Button>(R.id.number7)
        val button8 = findViewById<Button>(R.id.number8)
        val button9 = findViewById<Button>(R.id.number9)
        val buttonPlus = findViewById<Button>(R.id.plus)
        val buttonSubtract = findViewById<Button>(R.id.minus)
        val buttonMultiply = findViewById<Button>(R.id.versus)
        val buttonDivide = findViewById<Button>(R.id.split)
        val buttonClear = findViewById<Button>(R.id.clear)
        val buttonEqual = findViewById<Button>(R.id.equal)


        viewModel.display.observe(this){ value ->
            resultsTextView.text = value
        }

        button0.setOnClickListener {
            viewModel.onNumberClick(0)
        }

        button1.setOnClickListener {
            viewModel.onNumberClick(1)
        }

        button2.setOnClickListener {
            viewModel.onNumberClick(2)
        }

        button3.setOnClickListener {
            viewModel.onNumberClick(3)
        }

        button4.setOnClickListener {
            viewModel.onNumberClick(4)
        }

        button5.setOnClickListener {
            viewModel.onNumberClick(5)
        }

        button6.setOnClickListener {
            viewModel.onNumberClick(6)
        }

        button7.setOnClickListener {
            viewModel.onNumberClick(7)
        }

        button8.setOnClickListener {
            viewModel.onNumberClick(8)
        }

        button9.setOnClickListener {
            viewModel.onNumberClick(9)
        }

        buttonPlus.setOnClickListener {
            viewModel.onOperationClick(Operation.ADD)
        }

        buttonSubtract.setOnClickListener {
            viewModel.onOperationClick(Operation.SUBTRACT)
        }

        buttonMultiply.setOnClickListener {
            viewModel.onOperationClick(Operation.MULTIPLY)
        }

        buttonDivide.setOnClickListener {
            viewModel.onOperationClick(Operation.DIVIDE)
        }

        buttonEqual.setOnClickListener {
            viewModel.onEqualClick()
        }

        buttonClear.setOnClickListener {
            viewModel.onClearClick()
        }


    }

    private lateinit var viewModel: CalculatorViewModel


}