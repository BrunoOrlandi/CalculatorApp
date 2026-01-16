package com.ingenico.lar.calculadora

import com.ingenico.lar.calculadora.Operation.*

class CalculatorEngine {

    private var currentInput: String = "0"
    private var currentValue: Double = 0.0
    private var storedValue: Double? = null
    private var currentOperation: Operation? = null

    private var isNewInput = true


    fun inputNumber(digit: Int){

        if (isNewInput) {
            currentInput = digit.toString()
            isNewInput = false
        } else {
            if (currentInput == "0"){
                currentInput = digit.toString()
            } else {
                currentInput += digit.toString()
            }
        }
    }

    fun setOperation(op: Operation){

        if (storedValue != null && currentOperation != null){
            calculateResult()
        } else {
            storedValue = currentInput.toDouble()
        }

        currentOperation = op

        isNewInput = true

    }

    fun clear(){

        storedValue = null
        currentOperation = null
        isNewInput = true

    }

    fun calculateResult(){

        currentInput = when (currentOperation) {
            ADD -> (storedValue!! + currentInput.toDouble()).toString()
            SUBTRACT -> (storedValue!! - currentInput.toDouble()).toString()
            MULTIPLY -> (storedValue!! * currentInput.toDouble()).toString()
            DIVIDE -> {
                if (currentInput.toDouble() == 0.0) {
                    handleError()
                    return
                } else {
                    (storedValue!! / currentInput.toDouble()).toString()
                }
            }
            null -> return
        }


        storedValue = currentInput.toDouble()
        currentOperation = null
        isNewInput = true


    }

    private fun handleError() {
        currentInput = "Error"
        storedValue = null
        currentOperation = null
        isNewInput = true
    }

    fun getDisplayValue(): String {

        return currentInput
    }

}