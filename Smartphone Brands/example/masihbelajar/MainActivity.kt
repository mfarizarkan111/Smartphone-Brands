package com.example.masihbelajar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        heading = arrayOf(
            "Apple",
            "Asus",
            "LG",
            "Nokia",
            "Oneplus",
            "Poco",
            "Realme",
            "Samsung",
            "Vivo",
            "Xiaomi"
        )
        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Detailbrand>()
        getUserdata()
    }

    private fun getUserdata() {

        for (i in imageId.indices){
            val detailbrand = Detailbrand(imageId[i], heading[i])
            newArrayList.add(detailbrand)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}