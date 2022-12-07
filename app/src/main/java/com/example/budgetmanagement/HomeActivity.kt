package com.example.budgetmanagement

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView



class HomeActivity : AppCompatActivity() {
    //variable
   private lateinit var bottomNav : BottomNavigationView
    var tools: Tools? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //initial
        tools = Tools(this)

        replaceFragment(HomeFragment())

        bottomNav = findViewById(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.history -> replaceFragment(HistoryFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.settings -> replaceFragment(SettingsFragment())
                R.id.add -> replaceFragment(EntireCreditFragment())
                else ->{

                }
            }
            true
        }

    }

    private  fun replaceFragment(fragment: Fragment){

        val greeting : String? = tools?.getGreetingMsg()
        val bundle = Bundle()

        bundle.putString("greeting", greeting)
        val  fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_layout,fragment)
        fragment.arguments = bundle
        fragmentTransaction.addToBackStack("dfef")
        fragmentTransaction.commit()


    }




}