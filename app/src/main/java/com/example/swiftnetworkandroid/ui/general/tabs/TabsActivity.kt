package com.example.swiftnetworkandroid.ui.general.tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.ui.general.tabs.fragment.ExploreFragment
import com.example.swiftnetworkandroid.ui.general.tabs.fragment.HomeFragment
import com.example.swiftnetworkandroid.ui.general.tabs.fragment.NotificationFragment
import com.example.swiftnetworkandroid.ui.general.tabs.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TabsActivity : AppCompatActivity() {

    lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        val fragment = HomeFragment()
        openFragment(fragment)

        // TODO - Options fragments
        navigation = findViewById(R.id.bottom_navigation)
        navigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    val fragment = HomeFragment()
                    openFragment(fragment)
                    true
                }
                R.id.search -> {
                    val fragment = ExploreFragment()
                    openFragment(fragment)
                    true
                }
                R.id.bell -> {
                    val fragment = NotificationFragment()
                    openFragment(fragment)
                    true
                }
                R.id.user -> {
                    val fragment = ProfileFragment()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }



    // TODO - Load fragments
    // Todo - Home, Search, Notification, User
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}