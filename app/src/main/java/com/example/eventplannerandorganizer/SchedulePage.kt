package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SchedulePage : AppCompatActivity() {

    private lateinit var editScheduleName: EditText
    private lateinit var editTime: EditText
    private lateinit var editDate: EditText
    private lateinit var editScheduleNote: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_page)

        // Initialize views
        editScheduleName = findViewById(R.id.editScheduleName)
        editTime = findViewById(R.id.editTime)
        editDate = findViewById(R.id.editDate)
        editScheduleNote = findViewById(R.id.editScheduleNote)

        // Initialize back button
        val backButton: ImageView = findViewById(R.id.arrow)
        backButton.setOnClickListener {
            finish() // Simply go back without returning data
        }

        // Initialize save button
        val buttonSave: Button = findViewById(R.id.buttonSaveEvent)
        buttonSave.setOnClickListener {
            saveSchedule()
        }
    }

    private fun saveSchedule() {
        // Get input values from EditText fields
        val scheduleName = editScheduleName.text.toString()
        val scheduleTime = editTime.text.toString()
        val scheduleDate = editDate.text.toString()
        val scheduleNote = editScheduleNote.text.toString()

        // Prepare data to be sent back to the calling activity
        val resultIntent = Intent()
        resultIntent.putExtra("scheduleName", scheduleName)
        resultIntent.putExtra("scheduleTime", scheduleTime)
        resultIntent.putExtra("scheduleDate", scheduleDate)
        resultIntent.putExtra("scheduleNote", scheduleNote)

        // Set the result to OK and pass the data back
        setResult(Activity.RESULT_OK, resultIntent)

        // Finish this activity and return to the previous activity
        finish()
    }
}
