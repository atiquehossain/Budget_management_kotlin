package com.example.budgetmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav = findViewById(R.id.bottomNavigationView) as BottomNavigationView

        bottomNav.setOnNavigationItemReselectedListener {

        }
    }
}