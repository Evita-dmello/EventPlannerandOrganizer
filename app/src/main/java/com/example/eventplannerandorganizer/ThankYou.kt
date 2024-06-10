package com.example.eventplannerandorganizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ThankYou : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)

        val buttonSave: Button = findViewById(R.id.button4)

        // Set click listener for the arrow button to navigate back to the previous activity
        buttonSave.setOnClickListener {
            startActivity(Intent(this, InstructionPage::class.java))
        }
    }
}