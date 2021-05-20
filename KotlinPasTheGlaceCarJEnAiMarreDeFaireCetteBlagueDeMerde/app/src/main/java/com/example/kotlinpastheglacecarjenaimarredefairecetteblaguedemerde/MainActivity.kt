package com.example.kotlinpastheglacecarjenaimarredefairecetteblaguedemerde

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val extraitsDeTextes: TextView = findViewById(R.id.extraitsDeTextes)
        extraitsDeTextes.text = "Jack Malhonette...FBI, CBI, NCIS et tous le bordel !!!!"
    }
}