package com.example.mychef

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment?
                ?: NavHostFragment.create(R.navigation.nav_graph)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, navHostFragment)
            .setPrimaryNavigationFragment(navHostFragment)
            .commit()


    }
}


