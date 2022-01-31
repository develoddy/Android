package com.example.swiftnetworkandroid.ui.omboarding.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.ui.omboarding.fragment.LoginFragment

//TODO: Activity
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.addFragment()
    }

    //TODO: Add fragment LoginFragment.
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
    }


    /*
    private fun configureText() {
        email = findViewById(R.id.email_et)
        password = findViewById(R.id.password_et)
        email.setText("eddylujann@gmail.com")
        password.setText("secret")
    }

    fun login(view: View) {

        val auth = AuthManager()
        email = findViewById(R.id.email_et)
        password = findViewById(R.id.password_et)
        val validate = auth.login(email.text.toString(), password.text.toString())

        // Success Login.
        if (validate) {
            val intent = Intent(this, TabBarController::class.java)
            startActivity(intent)
            // Destroy activity MainActivity.
            finish()
        } else {
            // Error.
            Toast.makeText(
                getApplicationContext(),
                "!Email or password incorrect!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun didTapCreateAccountButton(view: View) {
        println("click registration.....")
        startActivity(Intent(this, RegistrationViewController::class.java))
    }
    */
}