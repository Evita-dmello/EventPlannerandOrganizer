package com.example.eventplannerandorganizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonArrow: ImageView = findViewById(R.id.arrow)

        // Set click listener for the arrow button to navigate back to the previous activity
        buttonArrow.setOnClickListener {
            startActivity(Intent(this, ThankYou::class.java))
        }
    }
}