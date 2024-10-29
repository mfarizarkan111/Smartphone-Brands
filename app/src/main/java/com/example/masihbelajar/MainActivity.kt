package com.example.masihbelajar

import MyAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Detailbrand>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Set Toolbar sebagai ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageId = arrayOf(
            R.drawable.apple,
            R.drawable.asus,
            R.drawable.lg,
            R.drawable.nokia,
            R.drawable.oneplus,
            R.drawable.poco,
            R.drawable.realme,
            R.drawable.samsung,
            R.drawable.vivo,
            R.drawable.xiami
        )

        heading = resources.getStringArray(R.array.brand_name)

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Detailbrand>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val detailbrand = Detailbrand(imageId[i], heading[i])
            newArrayList.add(detailbrand)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}
