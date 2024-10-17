package com.epiaedu.ac01cotitzacionsdecriptomonedes

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var numberDisplay: TextView
    private lateinit var cryptoDisplay: TextView
    private lateinit var selectedCrypto: TextView

    private var hasComma: Boolean = false

    private var actualCryptoPrize = 0.0
    private var bitcoinPrize = 0.0
    private var etherumPrize = 0.0
    private var tetherPrize = 0.0
    private var xrpPrize = 0.0

    /*-------------------- CONSTRUCTOR --------------------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberDisplay = findViewById(R.id.textViewNumberDisplay)
        cryptoDisplay = findViewById(R.id.textViewCryptoDisplay)
        selectedCrypto = findViewById(R.id.textViewSelectedCrypto)

        // Add event listeners to the layout buttons && ImageViews
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
            // Number buttons
            R.id.btnValue1 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue1).text.toString())
            // ask witch way is better
            // R.id.btnValue1 -> addNumberToDisplay("1")

            R.id.btnValue2 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue2).text.toString())
            R.id.btnValue3 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue3).text.toString())
            R.id.btnValue4 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue4).text.toString())
            R.id.btnValue5 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue5).text.toString())
            R.id.btnValue6 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue6).text.toString())
            R.id.btnValue7 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue7).text.toString())
            R.id.btnValue8 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue8).text.toString())
            R.id.btnValue9 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue9).text.toString())
            R.id.btnValue0 -> addDigitToDisplay(findViewById<Button>(R.id.btnValue0).text.toString())

            // Crypto buttons
            R.id.imgCryptoBitcoin -> setBitcoinCrypto()
            R.id.imgCryptoEtherum -> setEtherumCrypto()
            R.id.imgCryptoTether -> setTetherCrypto()
            R.id.imgCryptoXrp -> setXrpCrypto()

            // Functional buttons
            R.id.btnClear -> clearDisplay()
            R.id.imgDelete -> deleteLastDigit()
            R.id.btnValueComma -> addCommaToDisplay(findViewById<Button>(R.id.btnValueComma).text.toString())


        }
    }

    /*---------------------- CRYPTOS ----------------------*/

    private fun setBitcoinCrypto() {
        // Set the selected crypto to Bitcoin
        if(bitcoinPrize == 0.0) {
            bitcoinPrize = setCryptoPrize()
        }
        updateCryptoLetters("BTC")
        actualCryptoPrize = bitcoinPrize
        updateCryptoDisplay()
    }

    private fun setEtherumCrypto() {
        // Set the selected crypto to Etherum
        if(etherumPrize == 0.0) {
            etherumPrize = setCryptoPrize()
        }
        updateCryptoLetters("ETH")
        actualCryptoPrize = etherumPrize
        updateCryptoDisplay()
    }

    private fun setTetherCrypto() {
        // Set the selected crypto to Tether
        if(tetherPrize == 0.0) {
            tetherPrize = setCryptoPrize()
        }
        updateCryptoLetters("USDT")
        actualCryptoPrize = tetherPrize
        updateCryptoDisplay()
    }

    private fun setXrpCrypto() {
        // Set the selected crypto to XRP
        if(xrpPrize == 0.0) {
            xrpPrize = setCryptoPrize()
        }
        updateCryptoLetters("XRP")
        actualCryptoPrize = xrpPrize
        updateCryptoDisplay()
    }

    private fun setCryptoPrize(): Double {
        // Set the crypto prize
        // TODO: do a dialog to ask the user for the prize

        return 3.0
    }

    /*---------------------- DISPLAYS ---------------------*/

    private fun addDigitToDisplay(digit: String) {

        // Add the number to the display
        if(numberDisplay.text == "0") {
            if(digit == ","){
                numberDisplay.text ="0" + digit
            } else {
                numberDisplay.text = digit // if the digit is 0 wont be concatenated on the display.
            }

        } else {
            numberDisplay.text = numberDisplay.text.toString() + digit
        }

        updateCryptoDisplay()
    }

    private fun addCommaToDisplay(comma: String) {
        if(hasComma){
            val parentLayout = findViewById<View>(android.R.id.content)
            val snack = Snackbar.make(parentLayout, "Numbers can only have 1 comma", Snackbar.LENGTH_LONG)
            snack.show()
        } else {
            hasComma = true
            addDigitToDisplay(comma)
        }
    }

    private fun updateCryptoDisplay() {
        // Update the crypto display
        cryptoDisplay.text = calculateCryptoValue()
    }

    private fun updateCryptoLetters(crypto: String) {
        // Update the selected crypto
        selectedCrypto.text = crypto

    }

    private fun deleteLastDigit() {
        // Delete the last digit
        if(numberDisplay.text.length > 1) {
            numberDisplay.text = numberDisplay.text.dropLast(1)

            if(!numberDisplay.text.contains(",")) { // if the number doesn't have a comma the hasComma variable should be false
                hasComma = false
            }

        } else {
            numberDisplay.text = "0"
        }

        updateCryptoDisplay()
    }

    private fun clearDisplay() {
        // Clear the display
        numberDisplay.text = "0"
        hasComma = false

        updateCryptoDisplay() // we all this method because the number value will be 0 and 0xnumber = 0 so it will clear the crypto display
    }

    /*-------------------- OPERATIONS ---------------------*/

    private fun calculateCryptoValue(): String {
        // Calculate the crypto value
        if(numberDisplay.text == "0" || actualCryptoPrize == 0.0) { // if the number is 0 or the crypto is not selected the display should show 0 instead of NaN
            return "0"
        }
        val result = numberDisplay.text.toString().toDouble() / actualCryptoPrize
        return result.toString()
    }
}