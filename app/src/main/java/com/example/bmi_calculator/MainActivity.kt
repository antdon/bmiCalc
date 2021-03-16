package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TILWeight: TextInputEditText = findViewById(R.id.TILWeight)
        val TILHeight: TextInputEditText = findViewById(R.id.TILHeight)
        lateinit var BMIout: String

        val BmiInfo: TextView = findViewById(R.id.tvBMIinfo)

        val calculate = findViewById<Button>(R.id.button)

        if (calculate != null && TILHeight != null && TILWeight != null){
            calculate.setOnClickListener {
                val height = TILHeight.text.toString().toFloatOrNull()
                val weight = TILWeight.text.toString().toFloatOrNull()

                if(weight != null && height != null) {
                    val BMI: Float = weight / (height).pow(2)
                    Math.round(BMI * 100)/100
                    BMIout = BMI.toString()
                }

                BmiInfo.text = BMIout

            }

        }
    }
}