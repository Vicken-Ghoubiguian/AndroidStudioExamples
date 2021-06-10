package com.example.robotchicken_itsalive

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText

// Definition of the 'MainActivity' class which define the main activity controller...
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

        //

    }

    //
    override fun onInit(status: Int) {

    }

    // Overriden function to destroy the main activity...
    public override fun onDestroy() {

        // Shutdown TTS (which is also an attribute of the 'MainActivity' class)...
        if (this.tts != null) {
            this.tts!!.stop()
            this.tts!!.shutdown()
        }

        // Destroy the activity...
        super.onDestroy()
    }
}