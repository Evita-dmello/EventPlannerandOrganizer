package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Budget : AppCompatActivity() {

    private lateinit var imageViewAddBudget: ImageView
    private lateinit var imageViewAddArrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget)

        // Initialize views
        imageViewAddBudget = findViewById(R.id.imageViewAddBudget)

        // Set click listener for the add budget button
        imageViewAddBudget.setOnClickListener {
            val intent = Intent(this, BudgetPage::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_BUDGET)
        }

        imageViewAddArrow = findViewById(R.id.arrow)

        // Set click listener for the add budget button
        imageViewAddArrow.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_BUDGET)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_BUDGET && resultCode == Activity.RESULT_OK) {
            // Retrieve data from the Intent
            val budgetName = data?.getStringExtra("budgetName")
            val budgetAmount = data?.getStringExtra("budgetAmount")
            val budgetCategory = data?.getStringExtra("budgetCategory")
            val budgetNote = data?.getStringExtra("budgetNote")

            // Display the budget information
            val budgetInfo = "Budget Name: $budgetName\nBudget Amount: $budgetAmount\nCategory: $budgetCategory\nBudget Note: $budgetNote"
            val textViewBudgetInfo: TextView = findViewById(R.id.textViewEventInfo)
            textViewBudgetInfo.text = budgetInfo
        }
    }

    companion object {
        private const val REQUEST_CODE_ADD_BUDGET = 1004
    }
}
