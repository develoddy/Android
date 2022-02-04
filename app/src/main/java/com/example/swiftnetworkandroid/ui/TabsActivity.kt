package com.example.swiftnetworkandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.ui.explore.ExploreFragment
import com.example.swiftnetworkandroid.ui.home.HomeFragment
import com.example.swiftnetworkandroid.ui.notification.NotificationFragment
import com.example.swiftnetworkandroid.ui.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TabsActivity : AppCompatActivity() {

    private lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        openFragment(HomeFragment())

        // TODO - Options fragments
        navigation = findViewById(R.id.bottom_navigation)
        navigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    openFragment(HomeFragment())
                    true
                }
                R.id.search -> {
                    openFragment(ExploreFragment())
                    true
                }
                R.id.bell -> {
                    openFragment(NotificationFragment())
                    true
                }
                R.id.user -> {
                    openFragment(ProfileFragment())
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
        transaction.commit()
    }
}