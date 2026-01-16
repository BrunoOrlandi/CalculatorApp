package com.ingenico.lar.calculadora

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val engine = CalculatorEngine()

    private val _display = MutableLiveData<String>()
    val display: LiveData<String> = _display

    init {
        _display.value = engine.getDisplayValue()
    }

    fun onNumberClick(digit: Int){
        engine.inputNumber(digit)
        _display.value = engine.getDisplayValue()
    }

    fun onOperationClick(op: Operation){
        engine.setOperation(op)
        _display.value = engine.getDisplayValue()
    }

    fun onEqualClick(){
        engine.calculateResult()
        _display.value = engine.getDisplayValue()
    }

    fun onClearClick(){
        engine.clear()
        _display.value = engine.getDisplayValue()
    }


}