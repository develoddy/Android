package com.example.swiftnetworkandroid.ui.base

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface BaseActivityRouter {
    // Activity
    fun intent(activity: Context): Intent
    fun launch(activity: Context) = activity.startActivity(intent(activity))
}

interface BaseFragmentRouter {
    // Fragment

    fun fragment(): Fragment
    //fun add(manager: FragmentManager, containerId: Int, tag: String) = manager.beginTransaction().add(containerId,tag)
}