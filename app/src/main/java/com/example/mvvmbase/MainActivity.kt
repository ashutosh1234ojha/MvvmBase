package com.example.mvvmbase

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.fragment.app.Fragment
import com.example.mvvmbase.today.TodayWeatherFragment
import kotlinx.android.synthetic.main.layout_header.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHeading.text = "Today's Weather"


        bottomNavigation.setOnNavigationItemSelectedListener(bottomNat)

    }

    val bottomNat = BottomNavigationView.OnNavigationItemSelectedListener {

        when (it.itemId) {
            R.id.navigation_today -> {
                tvHeading.text = "Today's Weather"

                loadFragment(TodayWeatherFragment.newInstance())
            }
            R.id.navigation_7days -> {
                tvHeading.text = "7day's Weather"

            }
            R.id.navigation_setting -> {
                tvHeading.text = "Setting"

            }
        }
        return@OnNavigationItemSelectedListener false

    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
