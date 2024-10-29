package com.example.masihbelajar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

//@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Ambil data dari Intent
        val brandImage = intent.getIntExtra("brandImage", 0)
        val brandHeading = intent.getStringExtra("brandHeading")
        val brandDescription = intent.getStringExtra("brandDescription")
        val brandDeveloper = intent.getStringExtra("developerName")
        val brandYear = intent.getStringExtra("yearCreated")
        val brandFirst = intent.getStringExtra("firstSmartphone")

        // Inisialisasi Views
        val imageView: ImageView = findViewById(R.id.detail_image)
        val headingTextView: TextView = findViewById(R.id.detail_heading)
        val descriptionTextView: TextView = findViewById(R.id.detail_description)
        val developerTextView: TextView = findViewById(R.id.developer_name)
        val yearTextView: TextView = findViewById(R.id.year_created)
        val firstSmartphoneTextView: TextView = findViewById(R.id.first_smartphone)



        // Set toolbar as ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set title if needed
        supportActionBar?.title = "Detail Brand"

        // Set data ke Views
        imageView.setImageResource(brandImage)
        headingTextView.text = brandHeading
        descriptionTextView.text = brandDescription
        developerTextView.text = brandDeveloper
        yearTextView.text = brandYear
        firstSmartphoneTextView.text = brandFirst
    }
    // Handle back button click
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Goes back to previous activity
        return true


    }
}
