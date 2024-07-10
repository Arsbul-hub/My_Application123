package com.arsbulapps.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arsbulapps.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentLayout.id, FirstFragment()).commit()
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentLayout.id, FirstFragment()).commit()
                }

                R.id.navigation_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentLayout.id, SecondFragment()).commit()
                }
            }
            true
        }
    }
}