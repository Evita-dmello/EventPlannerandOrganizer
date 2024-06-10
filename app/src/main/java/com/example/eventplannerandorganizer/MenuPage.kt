package com.example.eventplannerandorganizer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_page)

        val myImageView: ImageView = findViewById(R.id.imageView9)
        val myTextView: TextView = findViewById(R.id.textView14)

        myImageView.setOnClickListener {
            Log.d("MenuPage", "Image clicked")
            val intent = Intent(this, Events::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myTextView.setOnClickListener {
            Log.d("MenuPage", "Text clicked")
            val intent = Intent(this, Events::class.java)
            intent.putExtra("textClicked", true)
            startActivity(intent)
        }

        val myImageMenu: ImageView = findViewById(R.id.imageView8)
        val myTextMenu: TextView = findViewById(R.id.textView2)

        myImageMenu.setOnClickListener {
            Log.d("MenuPage", "Image clicked")
            val intent = Intent(this, Menu::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myTextMenu.setOnClickListener {
            Log.d("MenuPage", "Text clicked")
            val intent = Intent(this, Menu::class.java)
            intent.putExtra("textClicked", true)
            startActivity(intent)
        }

        val myImageCheck: ImageView = findViewById(R.id.imageView17)
        val myImageChecklist: ImageView = findViewById(R.id.imageView13)
        val myTextCheck: TextView = findViewById(R.id.textView20)
        val myTextChecklist: TextView = findViewById(R.id.textView6)

        myImageCheck.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, CheckPage::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }
        myImageChecklist.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, CheckPage::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myTextCheck.setOnClickListener {
            Log.d("MenuPage", "Checklist text clicked")
            val intent = Intent(this, CheckPage::class.java)
            intent.putExtra("textClicked", true)
            startActivity(intent)
        }

        myTextChecklist.setOnClickListener {
            Log.d("MenuPage", "Checklist text clicked")
            val intent = Intent(this, CheckPage::class.java)
            intent.putExtra("textClicked", true)
            startActivity(intent)
        }

        val myImageVendor: ImageView = findViewById(R.id.imageView6)
        val myImageVendors: ImageView = findViewById(R.id.imageView12)
        val myTextVendor: TextView = findViewById(R.id.textView19)
        val myTextVendors: TextView = findViewById(R.id.textView13)

        myImageVendor.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Vendors::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }
        myImageVendors.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Vendors::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myTextVendor.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Vendors::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }
        myTextVendors.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Vendors::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        val myImageSchedule: ImageView = findViewById(R.id.imageView20)
        val myTextSchedule: TextView = findViewById(R.id.textView17)

        myImageSchedule.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Schedule::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myTextSchedule.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Schedule::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        val myImageBudget: ImageView = findViewById(R.id.imageView19)
        val myImageBudgets: ImageView = findViewById(R.id.imageView11)
        val myTextBudget: TextView = findViewById(R.id.textView16)
        val myTextBudgets: TextView = findViewById(R.id.textView5)

        myImageBudget.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Budget::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myImageBudgets.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Budget::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myTextBudget.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Budget::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myTextBudgets.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Budget::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        val myImageGuest: ImageView = findViewById(R.id.imageView21)
        val myImageGuestss: ImageView = findViewById(R.id.imageView22)
        val myImageGuests: ImageView = findViewById(R.id.imageView27)
        val myTextGuest: TextView = findViewById(R.id.textView15)
        val myTextGuests: TextView = findViewById(R.id.textView24)
        val myTextGuestss: TextView = findViewById(R.id.textView7)

        myImageGuest.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Guests::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }
        myImageGuestss.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Guests::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }
        myImageGuests.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Guests::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myTextGuest.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Guests::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        myTextGuestss.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Guests::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)

        myTextGuests.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, Guests::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

        val myImageHome: ImageView = findViewById(R.id.imageView1)
        val myTextHome: TextView = findViewById(R.id.textView8)


        myImageHome.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, InstructionPage::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }


        myTextHome.setOnClickListener {
            Log.d("MenuPage", "Checklist image clicked")
            val intent = Intent(this, InstructionPage::class.java)
            intent.putExtra("imageClicked", true)
            startActivity(intent)
        }

}}}


