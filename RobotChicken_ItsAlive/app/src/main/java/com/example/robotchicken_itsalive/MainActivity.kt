package com.example.robotchicken_itsalive

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.*

// Definition of the 'MainActivity' class which define the main activity controller...
/*
 * For informations:
 *  - 'AppCompatActivity':
 *  - 'TextToSpeech.OnInitListener':
 */
class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    // Declaration of all elements for this little Android app...
    private var tts: TextToSpeech? = null
    private var validationButton: Button? = null
    private var textToSayEntry: EditText? = null

    // Overriden function to create the main activity...
    override fun onCreate(savedInstanceState: Bundle?) {

        // Definition of the main activity...
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialization of the text to say entry...
        this.textToSayEntry = findViewById(R.id.textToSayEntry)

        // Initialization of the Text to Speech (TTS) object...
        this.tts = TextToSpeech(this, this)

        // Initialization of the validation button and its onClick listener...
        this.validationButton = findViewById(R.id.validationButton)
        this.validationButton!!.setOnClickListener {

            // Retrieve the value entered in 'textToSay' Entry and convert to String, then make it say...
            val textToSay = this.textToSayEntry!!.text.toString()
            this.tts!!.speak(textToSay, TextToSpeech.QUEUE_FLUSH, null, "")
        }
    }

    // Overriden function to initialize the TTS attribute of the main activity...
    override fun onInit(status: Int) {

        //
        if (status == TextToSpeech.SUCCESS) {

            // Set US English as language for tts
            val result = tts!!.setLanguage(Locale.US)

            //
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {

                // Display a log about TTS saying that the language specified is not supported...
                Log.e("TTS","The Language specified is not supported !")

            // In the other case...
            } else {

                // The validation button is enabled...
                validationButton!!.isEnabled = true
            }

        // In the other case...
        } else {

            // Display a log about TTS saying that the initialization failed...
            Log.e("TTS", "Initilization Failed !")
        }
    }

    // Overriden function to destroy the main activity...
    public override fun onDestroy() {

        // Shutdown TTS (which is also an attribute of the 'MainActivity' class)...
        if (this.tts != null) {

            //
            this.tts!!.stop()
            this.tts!!.shutdown()
        }

        // Destroy the activity...
        super.onDestroy()
    }
}