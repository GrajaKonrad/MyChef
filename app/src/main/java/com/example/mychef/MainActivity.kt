package com.example.mychef

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.logo_image_view)

        val slideDownAnimator = ObjectAnimator.ofFloat(imageView, "translationY", -1000f, 0f)
        slideDownAnimator.duration = 1000

        val rotationAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f)
        rotationAnimator.duration = 3000
        rotationAnimator.repeatCount = 0

        val fadeOutAnimator = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f)
        fadeOutAnimator.duration = 500
        fadeOutAnimator.startDelay = 2000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(slideDownAnimator, rotationAnimator, fadeOutAnimator)
        animatorSet.start()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment?
                ?: NavHostFragment.create(R.navigation.nav_graph)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, navHostFragment)
            .setPrimaryNavigationFragment(navHostFragment)
            .commit()
    }
}




