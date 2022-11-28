package com.example.budgetmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.budgetmanagement.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(HomeFragment())


        bottomNav = findViewById(R.id.bottomNavigationView) as BottomNavigationView


        bottomNav.setOnItemSelectedListener {


            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.history -> replaceFragment(HistoryFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.settings -> replaceFragment(SettingsFragment())
                else ->{

                }
            }
            true

        }

    }

    private  fun replaceFragment(fragment: Fragment){
        val bundle = Bundle()
        bundle.putString("inputText", "Data fssggf")


        val  fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_layout,fragment)
        fragment.arguments = bundle
        fragmentTransaction.addToBackStack("dfef")
        fragmentTransaction.commit()

    }
}