package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ChecklistPage : AppCompatActivity() {

    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checklist_page)

        radioButton1 = findViewById(R.id.radioButtonCompleted)
        radioButton2 = findViewById(R.id.radioButtonPending)

        radioButton1.setOnClickListener {
            onRadioButtonClicked(radioButton1)
        }

        radioButton2.setOnClickListener {
            onRadioButtonClicked(radioButton2)
        }

        val buttonSave: Button = findViewById(R.id.buttonSaved)
        buttonSave.setOnClickListener {
            saveTask()
        }

        val backButton: ImageView = findViewById(R.id.arrow)
        backButton.setOnClickListener {
            val intent = Intent(this, CheckPage::class.java)
            startActivityForResult(intent, CheckPage.REQUEST_CODE_CHECKLIST)
        }

        val chevron: ImageView = findViewById(R.id.imageView30)
        chevron.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val options = arrayOf(
            "Unassigned category",
            "Attire and Accessories",
            "Health and Beauty",
            "Music and Show",
            "Flowers and Decor",
            "Photo and Video",
            "Accessories",
            "Reception",
            "Transportation",
            "Accommodation"
        )

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose a category")
        builder.setItems(options) { _, which ->
            Toast.makeText(this, "${options[which]} selected", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    private fun onRadioButtonClicked(view: android.view.View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.id) {
                R.id.radioButtonCompleted -> if (checked) {
                    Toast.makeText(this, "Completed selected", Toast.LENGTH_SHORT).show()
                }
                R.id.radioButtonPending -> if (checked) {
                    Toast.makeText(this, "Pending selected", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun saveTask() {
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextNote: EditText = findViewById(R.id.editTextNote)
        val radioButton1: RadioButton = findViewById(R.id.radioButtonCompleted)
        val radioButton2: RadioButton = findViewById(R.id.radioButtonPending)
        val editTextDate: EditText = findViewById(R.id.editTextDate)

        val textName = editTextName.text.toString()
        val textNote = editTextNote.text.toString()
        val selectedButton = if (radioButton1.isChecked) radioButton1.text.toString() else radioButton2.text.toString()
        val textDate = editTextDate.text.toString()

        val eventInfo = "Name: $textName\nNote: $textNote\nSelected Button: $selectedButton\nDate: $textDate"

        // Pass data back to CheckPage
        val resultIntent = Intent()
        resultIntent.putExtra("eventInfo", eventInfo)
        setResult(Activity.RESULT_OK, resultIntent)
        finish() // Finish ChecklistPage activity
    }
}



