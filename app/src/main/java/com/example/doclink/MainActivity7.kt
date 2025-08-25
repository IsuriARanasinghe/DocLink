package com.example.doclink

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity7 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DoctorAdapter
    private lateinit var doctorList: ArrayList<Doctor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        recyclerView = findViewById(R.id.recyclerViewDoctors)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val bottomNavigation = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Already on Home
                    true
                }
                R.id.nav_search -> {
                    // TODO: Open search screen
                    true
                }
                R.id.nav_bookings -> {
                    // TODO: Open bookings screen
                    true
                }
                R.id.nav_profile -> {
                    // TODO: Open profile screen
                    true
                }
                else -> false
            }
        }

        doctorList = arrayListOf(
            Doctor("Dr. Emily Johnson", "Cardiologist", "Mon, Wed, Fri",
                "https://example.com/emily.jpg", 4.8f, 124),
            Doctor("Dr. Alex Chen", "Pediatrician", "Tue, Thu",
                "https://example.com/alex.jpg", 4.9f, 201),
            Doctor("Dr. Sarah Lee", "Dermatologist", "Mon, Tue, Fri",
                "https://example.com/sarah.jpg", 4.7f, 98),
            Doctor("Dr. Robert Davis", "Orthopedic Surgeon", "Wed, Thu",
                "https://example.com/robert.jpg", 4.6f, 150)
        )

        adapter = DoctorAdapter(this, doctorList)
        recyclerView.adapter = adapter
    }
}