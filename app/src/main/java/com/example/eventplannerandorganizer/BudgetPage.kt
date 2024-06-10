package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class BudgetPage : AppCompatActivity() {

    private lateinit var editBudgetName: EditText
    private lateinit var editBudgetAmount: EditText
    private lateinit var budgetMenu: TextView
    private lateinit var editBudgetNote: EditText
    private lateinit var buttonSaveBudget: Button

    private var selectedCategory: String = "Unassigned category"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_page)

        // Initialize views
        editBudgetName = findViewById(R.id.editBudgetName)
        editBudgetAmount = findViewById(R.id.editBudgetAmount)
        budgetMenu = findViewById(R.id.budgetMenu)
        editBudgetNote = findViewById(R.id.editBudgetNote)
        buttonSaveBudget = findViewById(R.id.buttonBudgetSaved)

        // Set click listener for the category selection
        val chevron: ImageView = findViewById(R.id.imageView30)
        chevron.setOnClickListener {
            showAlertDialog()
        }

        // Set click listener for the save button

        val backButton: ImageView = findViewById(R.id.arrow)
        backButton.setOnClickListener {
            finish() // Simply go back without returning data
        }

        buttonSaveBudget.setOnClickListener {
            saveBudget()
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
            selectedCategory = options[which]
            budgetMenu.text = selectedCategory
            Toast.makeText(this, "$selectedCategory selected", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    private fun saveBudget() {
        // Get input values from EditText fields
        val budgetName = editBudgetName.text.toString()
        val budgetAmount = editBudgetAmount.text.toString()
        val budgetNote = editBudgetNote.text.toString()

        // Prepare data to be sent back to the calling activity
        val resultIntent = Intent()
        resultIntent.putExtra("budgetName", budgetName)
        resultIntent.putExtra("budgetAmount", budgetAmount)
        resultIntent.putExtra("budgetCategory", selectedCategory)
        resultIntent.putExtra("budgetNote", budgetNote)

        // Set the result to OK and pass the data back
        setResult(Activity.RESULT_OK, resultIntent)

        // Finish this activity
        finish()
    }
}
