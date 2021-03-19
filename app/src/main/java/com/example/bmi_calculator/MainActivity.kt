package com.example.bmi_calculator

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TILWeight: TextInputEditText = findViewById(R.id.TILWeight)
        val TILHeight: TextInputEditText = findViewById(R.id.TILHeight)
        var BMI: Float = 0F

        val BmiInfo: TextView = findViewById(R.id.tvBMIinfo)

        val weightImage: ImageView = findViewById(R.id.representation)

        val calculate = findViewById<Button>(R.id.button)
        var drawableResource: Int = R.drawable.normal_size

        if (calculate != null && TILHeight != null && TILWeight != null){
            calculate.setOnClickListener {
                val height = TILHeight.text.toString().toFloatOrNull()
                val weight = TILWeight.text.toString().toFloatOrNull()

                if(weight != null && height != null) {
                    BMI = weight / (height/100).pow(2)
                    Math.round(BMI * 100)/100
                }
                if(BMI == 0F){
                    BmiInfo.text = "Invalid inputs"
                    drawableResource = R.drawable.normal_size
                } else if(BMI < 18.5F){
                    BmiInfo.text = "Under Weight"
                    drawableResource = R.drawable.under_weight_size_foreground
                } else if (BMI >= 18.5F && BMI <= 25F){
                    BmiInfo.text = "Normal Weight"
                    drawableResource = R.drawable.normal_size
                } else if (BMI > 25F && BMI <= 30F){
                    BmiInfo.text = "Over Weight"
                    drawableResource = R.drawable.over_weight_size_foreground
                } else {
                    BmiInfo.text = "Obese"
                    drawableResource = R.drawable.obese_size_foreground
                }
                weightImage.setImageResource(drawableResource)


            }

        }
    }
}