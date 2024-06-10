package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity


class VendorsPage : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editAddress: EditText
    private lateinit var editPhone: EditText
    private lateinit var editEmail: EditText
    private lateinit var editNote: EditText
    private lateinit var editAmount: EditText
    private lateinit var radioButtonReserved: RadioButton
    private lateinit var radioButtonRejected: RadioButton
    private lateinit var radioButtonPending: RadioButton
    private lateinit var buttonSaveVendor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendors_page)

        editName = findViewById(R.id.editName)
        editAddress = findViewById(R.id.editAddress)
        editPhone = findViewById(R.id.editPhone)
        editEmail = findViewById(R.id.editEmail)
        editNote = findViewById(R.id.editNote)
        editAmount = findViewById(R.id.editAmount)
        radioButtonReserved = findViewById(R.id.radioButtonReserved)
        radioButtonRejected = findViewById(R.id.radioButtonRejected)
        radioButtonPending = findViewById(R.id.radioButtonPending)
        buttonSaveVendor = findViewById(R.id.buttonSaveVendor)

        val backButton: ImageView = findViewById(R.id.arrow)
        backButton.setOnClickListener {
            val intent = Intent(this, Vendors::class.java)
            startActivityForResult(intent, CheckPage.REQUEST_CODE_CHECKLIST)
        }

        buttonSaveVendor.setOnClickListener {
            val vendorName = editName.text.toString()
            val vendorAddress = editAddress.text.toString()
            val vendorPhone = editPhone.text.toString()
            val vendorEmail = editEmail.text.toString()
            val vendorNote = editNote.text.toString()
            val vendorAmount = editAmount.text.toString()
            val vendorStatus = when {
                radioButtonReserved.isChecked -> "Reserved"
                radioButtonRejected.isChecked -> "Rejected"
                radioButtonPending.isChecked -> "Pending"
                else -> ""
            }

            val resultIntent = Intent()
            resultIntent.putExtra("vendorName", vendorName)
            resultIntent.putExtra("vendorAddress", vendorAddress)
            resultIntent.putExtra("vendorPhone", vendorPhone)
            resultIntent.putExtra("vendorEmail", vendorEmail)
            resultIntent.putExtra("vendorNote", vendorNote)
            resultIntent.putExtra("vendorAmount", vendorAmount)
            resultIntent.putExtra("vendorStatus", vendorStatus)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
