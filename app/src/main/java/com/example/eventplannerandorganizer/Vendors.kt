package com.example.eventplannerandorganizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Vendors : AppCompatActivity() {

    private lateinit var buttonAddVendor: ImageView
    private lateinit var buttonAddBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendors)

        buttonAddVendor = findViewById(R.id.imageViewAddVendor)
        buttonAddVendor.setOnClickListener {
            val intent = Intent(this, VendorsPage::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_VENDOR)
        }

        buttonAddBack = findViewById(R.id.arrow)
        buttonAddBack.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_VENDOR)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_VENDOR && resultCode == Activity.RESULT_OK) {
            // Retrieve data from the Intent
            val vendorName = data?.getStringExtra("vendorName")
            val vendorAddress = data?.getStringExtra("vendorAddress")
            val vendorPhone = data?.getStringExtra("vendorPhone")
            val vendorEmail = data?.getStringExtra("vendorEmail")
            val vendorNote = data?.getStringExtra("vendorNote")
            val vendorAmount = data?.getStringExtra("vendorAmount")
            val vendorStatus = data?.getStringExtra("vendorStatus")

            // Display the vendor information
            val vendorInfo = "Vendor Name: $vendorName\nVendor Address: $vendorAddress\nVendor Phone: $vendorPhone\nVendor Email: $vendorEmail\nVendor Note: $vendorNote\nVendor Amount: $vendorAmount\nVendor Status: $vendorStatus"
            // Assuming you have a TextView in your layout to display the vendor information
            val textViewVendorInfo: TextView = findViewById(R.id.textViewEventInfo)
            textViewVendorInfo.text = vendorInfo
        }
    }

    companion object {
        private const val REQUEST_CODE_ADD_VENDOR = 1003
    }
}
