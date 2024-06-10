package com.example.eventplannerandorganizer

// EventsPage.kt
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class EventsPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events_page)

        // Find views
        val buttonSave: Button = findViewById(R.id.buttonSave)
        val buttonArrow: ImageView = findViewById(R.id.arrow)

        // Set click listener for the save button
        buttonSave.setOnClickListener {
            saveEvent()
        }

        // Set click listener for the arrow button to navigate back to the previous activity
        buttonArrow.setOnClickListener {
            startActivity(Intent(this, Events::class.java))
        }


    }


    private fun saveEvent() {
        // Find input fields
        val editTextEventName: EditText = findViewById(R.id.editTextEventName)
        val editTextEventDate: EditText = findViewById(R.id.editTextEventDate)
        val editTextEventTime: EditText = findViewById(R.id.editTextEventTime)
        val editTextEventBudget: EditText = findViewById(R.id.editTextEventBudget)

        // Retrieve text from input fields
        val eventName = editTextEventName.text.toString()
        val eventDate = editTextEventDate.text.toString()
        val eventTime = editTextEventTime.text.toString()
        val eventBudget = editTextEventBudget.text.toString()

        // Here you can perform any processing or validation on the input data
        // For now, let's just print the values to the console
        println("Event Name: $eventName")
        println("Event Date: $eventDate")
        println("Event Time: $eventTime")
        println("Event Budget: $eventBudget")

        // If you want to pass data back to the Events activity, you can use an Intent
        val intent = Intent()
        intent.putExtra("eventName", eventName)
        intent.putExtra("eventDate", eventDate)
        intent.putExtra("eventTime", eventTime)
        intent.putExtra("eventBudget", eventBudget)
        setResult(RESULT_OK, intent)
        finish() // Finish EventsPage activity and return to Events activity
    }
}

