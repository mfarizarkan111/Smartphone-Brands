package com.example.masihbelajar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Ambil data dari Intent
        val brandImage = intent.getIntExtra("brandImage", 0)
        val brandHeading = intent.getStringExtra("brandHeading")
        val brandDescription = intent.getStringExtra("brandDescription")

        // Inisialisasi Views
        val imageView: ImageView = findViewById(R.id.detail_image)
        val headingTextView: TextView = findViewById(R.id.detail_heading)
        val descriptionTextView: TextView = findViewById(R.id.detail_description)

        // Set data ke Views
        imageView.setImageResource(brandImage)
        headingTextView.text = brandHeading
        descriptionTextView.text = brandDescription
    }
}
