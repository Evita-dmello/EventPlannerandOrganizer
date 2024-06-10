package com.example.eventplannerandorganizer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.PopupWindow
import androidx.annotation.ContentView

class InstructionPage : AppCompatActivity() {
    private lateinit var showPopupInstruct: Button
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showPopupInstruct = findViewById(R.id.instructionButton)
        startButton = findViewById(R.id.button)

        showPopupInstruct.setOnClickListener{
            showPopup()
        }

        startButton.setOnClickListener {
            startActivity(Intent(this, MenuPage::class.java))
        }
    }

    private fun showPopup(){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.activity_instruction_page, null)

        val width = 1000
        val height = 1200

        val instructWindow = PopupWindow(popupView, width, height, true)
        instructWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        val closeButton = popupView.findViewById<Button>(R.id.button2)
        closeButton.setOnClickListener{
            instructWindow.dismiss()
        }
    }
}