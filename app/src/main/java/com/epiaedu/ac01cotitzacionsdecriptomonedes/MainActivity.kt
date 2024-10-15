package com.epiaedu.ac01cotitzacionsdecriptomonedes

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /*-------------------- CONSTRUCTOR --------------------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Add event listeners to the layout buttons
        initOnClickListeners()
    }

    /*--------------------- LISTENERS ---------------------*/

    private fun initOnClickListeners() {

        // Add event listeners to the layout buttons
        findViewById<Button>(R.id.btnValue1).setOnClickListener(this)
        findViewById<Button>(R.id.btnValue2).setOnClickListener(this)
        findViewById<Button>(R.id.btnValue3).setOnClickListener(this)
        findViewById<Button>(R.id.btnValue4).setOnClickListener(this)
        findViewById<Button>(R.id.btnValue5).setOnClickListener(this)
        findViewById<Button>(R.id.btnValue6).setOnClickListener(this)
        findViewById<Button>(R.id.btnValue7).setOnClickListener(this)
        findViewById<Button>(R.id.btnValue8).setOnClickListener(this)
        findViewById<Button>(R.id.btnValue9).setOnClickListener(this)

        // Add event listeners to the layout crypto buttons
        findViewById<ImageView>(R.id.imgCryptoBitcoin).setOnClickListener(this)
        findViewById<ImageView>(R.id.imgCryptoEtherum).setOnClickListener(this)
        findViewById<ImageView>(R.id.imgCryptoTether).setOnClickListener(this)
        findViewById<ImageView>(R.id.imgCryptoXrp).setOnClickListener(this)

        // Add event listeners to the layout functional buttons
        findViewById<Button>(R.id.btnClear).setOnClickListener(this)
        findViewById<Button>(R.id.btnValueComma).setOnClickListener(this)
        findViewById<ImageView>(R.id.imgDelete).setOnClickListener(this)
        findViewById<Button>(R.id.btnValue0).setOnClickListener(this) // the 0 button is included here instead on layout buttons because it has different interactions
        findViewById<ImageView>(R.id.imageViewEditPrice).setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        // Handle click events here
        when(v?.id){
            R.id.btnValue1 -> addNumberToDisplay(findViewById<Button>(R.id.btnValue1).text.toString())
            R.id.btnValue2 -> addNumberToDisplay("2")
            R.id.btnValue3 -> addNumberToDisplay("3")
            R.id.btnValue4 -> addNumberToDisplay("4")
            R.id.btnValue5 -> addNumberToDisplay("5")
            R.id.btnValue6 -> addNumberToDisplay("6")
            R.id.btnValue7 -> addNumberToDisplay("7")
            R.id.btnValue8 -> addNumberToDisplay("8")
            R.id.btnValue9 -> addNumberToDisplay("9")

        }
    }

    /*---------------------- DISPLAYS ---------------------*/

    private fun addNumberToDisplay(number: String) {
        // Add the number to the display
        val display = findViewById<TextView>(R.id.textViewNumberDisplay)
        display.text = display.text.toString() + number
    }
}