package com.example.eventplannerandorganizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val instrucButton: Button = findViewById(R.id.instructionButton)
        val startButton: Button = findViewById(R.id.button)

        instrucButton.setOnClickListener {
            val intent = Intent(this, InstructionPage::class.java)
            intent.putExtra("showPopup", true)
            startActivity(intent)
        }
    }
}