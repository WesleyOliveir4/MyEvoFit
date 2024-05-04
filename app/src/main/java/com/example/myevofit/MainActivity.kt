package com.example.myevofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import com.example.myevofit.databinding.ActivityMainBinding
import com.example.myevofit.presentation.ui.FirstFragment
import com.example.myevofit.presentation.ui.SecondFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)
        replaceFragment(FirstFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.Home -> replaceFragment(FirstFragment())
                R.id.Graph -> replaceFragment(SecondFragment())
                else -> {}
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_top_appbar, menu)
        return true
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_screen,fragment)
        fragmentTransaction.commit()
    }
}