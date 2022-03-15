package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operador: Char = '0'


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        /*   limpiamos el edit text con clear*/
        binding.buttonAC.setOnClickListener {
            binding.editTextNumber.text.clear()
        }
        /*delete*/
        binding.buttonDelete.setOnClickListener {
            //binding.editTextNumber.text.append(".")
            binding.editTextNumber.setText(binding.editTextNumber.text.dropLast(1))
        }
        binding.buttonIgual.setOnClickListener {
            when(operador){
                '+' -> {binding.editTextNumber .setText( "${ firstValue + binding.editTextNumber.text.toString().toDouble()} ")
            }
                '-' -> {binding.editTextNumber .setText( "${ firstValue - binding.editTextNumber.text.toString().toDouble()} ")
                }
                '*' -> {binding.editTextNumber .setText( "${ firstValue * binding.editTextNumber.text.toString().toDouble()} ")
                }

                '/' -> {binding.editTextNumber .setText( "${ firstValue / binding.editTextNumber.text.toString().toDouble()} ")
                }
                else -> binding.editTextNumber.setText("Error")
            }

        }
        binding.buttonPorcentaje.setOnClickListener {
            //

                   binding.editTextNumber.setText(percentaje(operador))

        }
    }


        fun percentaje(operatorToUse: Char) : String{
            when(operatorToUse){
                '+' -> {return "${firstValue + (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}" }
                '-' -> {return "${firstValue - (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"}
                else -> { return "ERROR"}

            }

            return ""
        }
    fun getOperator(view: View){
        val button = view as Button


        operador =button.text.get(0)


       /* operador = when(button.id){
            binding.buttonDividir.id -> {'/'}
            binding.buttonMultiplication.id -> {'x'}
            binding.buttonAddition.id -> {'+'}
            binding.buttonSubtration.id -> {'-'}

            else ->{'0'}
        }*/
        //necesitamos guardar el valor de nuestro primer numero
        firstValue = binding.editTextNumber.text.toString().toDouble()
        //limpiamos la paltalla o nuestro textview
        binding.editTextNumber.text.clear()

    }
    fun numberButtonCliked(view: View){
        val button = view as Button
        if(button.id.equals(binding.buttondecimal.id) ){
            if( !binding.editTextNumber.text.contains('.')){
                binding.editTextNumber.text.append(button.text)
            }
        }else{
            binding.editTextNumber.text.append(button.text)
        }




    }
}