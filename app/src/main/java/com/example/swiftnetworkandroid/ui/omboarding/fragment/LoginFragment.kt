package com.example.swiftnetworkandroid.ui.omboarding.fragment

import android.R.attr.name
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.swiftnetworkandroid.R
import com.example.swiftnetworkandroid.core.Resource

import com.example.swiftnetworkandroid.data.remote.LoginDataSource
import com.example.swiftnetworkandroid.presentation.LoginViewModel
import com.example.swiftnetworkandroid.presentation.LoginViewModelFactory
import com.example.swiftnetworkandroid.repository.LoginRepositoryImpl
import com.example.swiftnetworkandroid.repository.RetrofitClient
import com.example.swiftnetworkandroid.resources.AuthManager
import com.example.swiftnetworkandroid.ui.general.tabs.TabsActivity


//TODO: Fragment
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var email: EditText

    private lateinit var password: EditText

    // TODO: Dependency injection to create a single instance.
    //  It serves to not have implementation logic within each of the modules.
    private val viewModel by viewModels<LoginViewModel> { LoginViewModelFactory(LoginRepositoryImpl(
        LoginDataSource(RetrofitClient.webservice)
    )) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.setupView(view)
        this.login(view)
        this.register(view)
    }

    //TODO: add values a properties email & password.
    private fun setupView(view: View) {
        email = view.findViewById(R.id.email_et)
        password = view.findViewById(R.id.password_et)
        email.setText("eddylujann@gmail.com")
        password.setText("secret")

    }

    //TODO: OnClick Register.
    private fun register(view: View) {
        val button = view.findViewById<Button>(R.id.account_btn)
        button.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragment_container_view, RegisterFragment())
                addToBackStack("LoginFragment")
            }
        }
    }

    //TODO: OnClick Login.
    private fun login(view: View) {
        val loginBtn = view.findViewById<Button>(R.id.login_btn)
        loginBtn.setOnClickListener {
            //val auth = AuthManager()
            email = view.findViewById(R.id.email_et)
            password = view.findViewById(R.id.password_et)

            val email    = this.email.text.toString()
            val password = this.password.text.toString()

            viewModel.fetchUserToken(email, password).observe(viewLifecycleOwner, Observer { result ->
                when( result ) {
                    is Resource.Loading -> {
                        Log.d("LiveData", "Loading...")
                    }
                    is Resource.Success -> {
                        Log.d("LiveData", "${result.data}")
                    }
                    is Resource.Failure -> {
                        Log.d("LiveData", "${result.exception}")
                    }
                }
            })

            //val validate = auth.login( email.text.toString(), password.text.toString() )
            //if ( validate ) {
                //requireActivity().run {
                    //startActivity(Intent(this, TabsActivity::class.java))
                    //finish()
                //}
            //} else {
                //Toast.makeText(activity, "!Email or password incorrect!", Toast.LENGTH_SHORT).show()
            //}
        }
    }
}