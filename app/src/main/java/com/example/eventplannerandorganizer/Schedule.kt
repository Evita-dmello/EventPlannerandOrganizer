package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Schedule : AppCompatActivity() {

    private lateinit var buttonAddEvent: ImageView
    private lateinit var buttonAddBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        buttonAddEvent = findViewById(R.id.imageViewAddEvent)
        buttonAddEvent.setOnClickListener {
            val intent = Intent(this, SchedulePage::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_EVENT)
        }

        buttonAddBack = findViewById(R.id.arrow)
        buttonAddBack.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_EVENT && resultCode == Activity.RESULT_OK) {
            // Retrieve data from the Intent
            val scheduleName = data?.getStringExtra("scheduleName")
            val scheduleDate = data?.getStringExtra("scheduleDate")
            val scheduleTime = data?.getStringExtra("scheduleTime")
            val scheduleNote = data?.getStringExtra("scheduleNote")

            // Display the event information
            val eventInfo = "Event Name: $scheduleName\nDate: $scheduleDate\nTime: $scheduleTime\nNote: $scheduleNote"
            // Assuming you have a TextView in your layout to display the event information
            val textViewEventInfo: TextView = findViewById(R.id.textViewEventInfo)
            textViewEventInfo.text = eventInfo
        }
    }

    companion object {
        private const val REQUEST_CODE_ADD_EVENT = 1001
    }
}
