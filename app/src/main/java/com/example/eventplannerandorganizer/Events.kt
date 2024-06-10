package com.example.eventplannerandorganizer

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Events : AppCompatActivity() {

    private lateinit var buttonAddEvent: ImageView
    private lateinit var buttonAddEvents: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        buttonAddEvent = findViewById(R.id.imageView28)
        buttonAddEvent.setOnClickListener {
            // Start EventsPage activity for result
            startActivityForResult(Intent(this, EventsPage::class.java), REQUEST_CODE_ADD_EVENT)
        }

        buttonAddEvents = findViewById(R.id.arrow)
        buttonAddEvents.setOnClickListener {
            // Start EventsPage activity for result
            startActivityForResult(Intent(this, MenuPage::class.java), REQUEST_CODE_ADD_EVENT)
        }

        // Retrieve data from the Intent that started this activity
        val imageClicked = intent.getBooleanExtra("imageClicked", false)
        val textClicked = intent.getBooleanExtra("textClicked", false)

        if (imageClicked) {
            // Handle the case when the image was clicked
            // Do something if needed
        }

        if (textClicked) {
            // Handle the case when the text was clicked
            // Do something if needed
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_EVENT && resultCode == RESULT_OK) {
            // Retrieve data from the Intent
            val eventName = data?.getStringExtra("eventName")
            val eventDate = data?.getStringExtra("eventDate")
            val eventTime = data?.getStringExtra("eventTime")
            val eventBudget = data?.getStringExtra("eventBudget")

            // Display the event information
            val eventInfo = "Event Name: $eventName\nEvent Date: $eventDate\nEvent Time: $eventTime\nEvent Budget: $eventBudget"
            // Assuming you have a TextView in your layout to display the event information
            val textViewEventInfo: TextView = findViewById(R.id.textViewEventInfo)
            textViewEventInfo.text = eventInfo
        }
    }

    companion object {
        private const val REQUEST_CODE_ADD_EVENT = 1002
    }
}
