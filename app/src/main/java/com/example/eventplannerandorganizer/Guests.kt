package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Guests : AppCompatActivity() {

    private lateinit var imageViewAddGuestlist: ImageView
    private lateinit var textViewGuestInfo: TextView
    private lateinit var imageViewAddArrow: ImageView

    companion object {
        const val REQUEST_CODE_ADD_GUEST = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guests)

        // Initialize views
        imageViewAddGuestlist = findViewById(R.id.imageViewAddGuestlist)
        imageViewAddArrow = findViewById(R.id.arrow)
        textViewGuestInfo = findViewById(R.id.textViewEventInfo) // Initialize textViewGuestInfo

        // Set click listener for the add guest list button
        imageViewAddGuestlist.setOnClickListener {
            val intent = Intent(this, GuestsPage::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_GUEST)
        }

        imageViewAddArrow.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_GUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_GUEST && resultCode == Activity.RESULT_OK) {
            val guestInfo = data?.getStringExtra("guestInfo")
            textViewGuestInfo.text = guestInfo
        }
    }
}

