package com.borbi.boogiemeter


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navController = findNavController(R.id.my_nav_host_fragment)
//        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.my_nav_host_fragment).navigateUp()
    }
}
