package com.example.swiftnetworkandroid.scenes.omboarding.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.scenes.omboarding.login.fragment.LoginFragment

class LoginActivity: AppCompatActivity(), LoginContract.View {

    //lateinit var presenter: LoginPresenter
    //var presenter: LoginContract.Presenter? = LoginPresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.addFragment()
        //presenter.presenterGetData("eee","ppppp")


    }

    private fun addFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view, LoginFragment())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy")
        //presenter = null
    }
}