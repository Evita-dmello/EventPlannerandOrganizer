package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class GuestsPage : AppCompatActivity() {

    private lateinit var editGuestName: EditText
    private lateinit var editGuestEmail: EditText
    private lateinit var editGuestPhone: EditText
    private lateinit var editGuestAddress: EditText
    private lateinit var editGuestNote: EditText
    private lateinit var buttonSave: Button
    private lateinit var chevronGroup: ImageView
    private lateinit var chevronMenu: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guests_page)

        // Initialize views
        editGuestName = findViewById(R.id.editGuestName)
        editGuestEmail = findViewById(R.id.editGuestEmail)
        editGuestPhone = findViewById(R.id.editGuestPhone)
        editGuestAddress = findViewById(R.id.editGuestAddress)
        editGuestNote = findViewById(R.id.editGuestNote)
        buttonSave = findViewById(R.id.buttonSaved)
        chevronGroup = findViewById(R.id.imageView30) // Ensure you have different IDs for the two ImageViews
        chevronMenu = findViewById(R.id.imageView31) // Assuming you have another ImageView with this ID for menu

        // Set click listener for the save button

        val buttonArrow: ImageView = findViewById(R.id.arrow)

        buttonArrow.setOnClickListener {
            startActivity(Intent(this, Guests::class.java))
        }
        buttonSave.setOnClickListener {
            onSaveClicked()
        }


        // Set click listener for the chevronGroup
        chevronGroup.setOnClickListener {
            showGroupDialog()
        }

        // Set click listener for the chevronMenu
        chevronMenu.setOnClickListener {
            showMenuDialog()
        }
    }

    private fun onSaveClicked() {
        val guestName = editGuestName.text.toString()
        val guestEmail = editGuestEmail.text.toString()
        val guestPhone = editGuestPhone.text.toString()
        val guestAddress = editGuestAddress.text.toString()
        val guestNote = editGuestNote.text.toString()

        if (guestName.isEmpty() || guestEmail.isEmpty() || guestPhone.isEmpty() || guestAddress.isEmpty() || guestNote.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val guestInfo = """
            Name: $guestName
            Email: $guestEmail
            Phone: $guestPhone
            Address: $guestAddress
            Note: $guestNote
        """.trimIndent()

        val resultIntent = Intent()
        resultIntent.putExtra("guestInfo", guestInfo)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    private fun showGroupDialog() {
        val options = arrayOf("Unassigned Group", "Family", "Friends", "Colleagues", "Other")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose a Group")
        builder.setItems(options) { _, which ->
            Toast.makeText(this, "${options[which]} selected", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    private fun showMenuDialog() {
        val options = arrayOf(
            "Unassigned Group",
            "Adult Menu",
            "Children Menu",
            "Vegetarian Menu",
            "Non-Vegetarian Menu",
            "Diet Menu",
            "Other"
        )
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose a Menu")
        builder.setItems(options) { _, which ->
            Toast.makeText(this, "${options[which]} selected", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }
}

