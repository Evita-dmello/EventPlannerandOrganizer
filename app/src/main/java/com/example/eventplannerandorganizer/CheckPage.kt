package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CheckPage : AppCompatActivity() {

    private lateinit var textViewEventInfo: TextView


    companion object {
        const val REQUEST_CODE_CHECKLIST = 1001
        private const val PREFS_NAME = "CheckPagePrefs"
        private const val KEY_NAME = "name"
        private const val KEY_NOTE = "note"
        private const val KEY_SELECTED_BUTTON = "selectedButton"
        private const val KEY_DATE = "date"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_page)

        textViewEventInfo = findViewById(R.id.textViewEventInfo)

        // Find the plus button
        val plusButton: ImageView = findViewById(R.id.imageView28)
        plusButton.setOnClickListener {
            val intent = Intent(this, ChecklistPage::class.java)
            startActivityForResult(intent, REQUEST_CODE_CHECKLIST)
        }

        val backButton: ImageView = findViewById(R.id.arrow)
        backButton.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivityForResult(intent, REQUEST_CODE_CHECKLIST)
        }

        // Retrieve and display saved data
        val savedData = retrieveData(this)
        if (savedData[KEY_NAME].isNullOrEmpty() && savedData[KEY_NOTE].isNullOrEmpty() &&
            savedData[KEY_SELECTED_BUTTON].isNullOrEmpty() && savedData[KEY_DATE].isNullOrEmpty()) {
            textViewEventInfo.visibility = TextView.GONE
        } else {
            val eventInfo = "Name: ${savedData[KEY_NAME]}\n" +
                    "Note: ${savedData[KEY_NOTE]}\n" +
                    "Selected Button: ${savedData[KEY_SELECTED_BUTTON]}\n" +
                    "Date: ${savedData[KEY_DATE]}"
            textViewEventInfo.text = eventInfo
            textViewEventInfo.visibility = TextView.VISIBLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHECKLIST && resultCode == Activity.RESULT_OK) {
            val eventInfo = data?.getStringExtra("eventInfo")
            if (!eventInfo.isNullOrEmpty()) {
                textViewEventInfo.text = eventInfo
                textViewEventInfo.visibility = TextView.VISIBLE

                // Save data using SharedPreferences
                val parsedData = parseEventInfo(eventInfo)
                saveData(this, parsedData[KEY_NAME]!!, parsedData[KEY_NOTE]!!, parsedData[KEY_SELECTED_BUTTON]!!, parsedData[KEY_DATE]!!)
            }
        }
    }

    private fun saveData(context: Context, name: String, note: String, selectedButton: String, date: String) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_NOTE, note)
        editor.putString(KEY_SELECTED_BUTTON, selectedButton)
        editor.putString(KEY_DATE, date)
        editor.apply()
    }

    private fun retrieveData(context: Context): Map<String, String> {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return mapOf(
            KEY_NAME to prefs.getString(KEY_NAME, "").toString(),
            KEY_NOTE to prefs.getString(KEY_NOTE, "").toString(),
            KEY_SELECTED_BUTTON to prefs.getString(KEY_SELECTED_BUTTON, "").toString(),
            KEY_DATE to prefs.getString(KEY_DATE, "").toString()
        )
    }

    private fun parseEventInfo(eventInfo: String?): Map<String, String> {
        val data = mutableMapOf<String, String>()
        eventInfo?.lines()?.forEach { line ->
            val parts = line.split(": ")
            if (parts.size == 2) {
                when (parts[0]) {
                    "Name" -> data[KEY_NAME] = parts[1]
                    "Note" -> data[KEY_NOTE] = parts[1]
                    "Selected Button" -> data[KEY_SELECTED_BUTTON] = parts[1]
                    "Date" -> data[KEY_DATE] = parts[1]
                }
            }
        }
        return data
    }
}
