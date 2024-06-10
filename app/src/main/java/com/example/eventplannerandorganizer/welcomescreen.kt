package com.example.eventplannerandorganizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class welcomescreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomescreen)
        android.os.Handler().postDelayed({
            startActivity(Intent(this,InstructionPage::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
