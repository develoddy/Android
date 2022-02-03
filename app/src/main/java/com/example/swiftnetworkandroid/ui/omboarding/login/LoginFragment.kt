package com.example.swiftnetworkandroid.ui.omboarding.login

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
import com.example.swiftnetworkandroid.core.SessionManager
import com.example.swiftnetworkandroid.data.remote.login.LoginDataSource
import com.example.swiftnetworkandroid.databinding.FragmentLoginBinding
import com.example.swiftnetworkandroid.presentation.LoginViewModelFactory
import com.example.swiftnetworkandroid.repository.login.LoginRepositoryImpl
import com.example.swiftnetworkandroid.ui.TabsActivity
import com.example.swiftnetworkandroid.ui.omboarding.registration.RegisterFragment
import com.example.swiftnetworkandroid.presentation.LoginViewModel
import com.example.swiftnetworkandroid.webservice.RetrofitClient

//TODO: Fragment
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var sessionManager: SessionManager

    // TODO: PROPERTIES
    private lateinit var binding: FragmentLoginBinding
    private lateinit var email: EditText
    private lateinit var password: EditText
    private val viewModel by viewModels<LoginViewModel> {
        LoginViewModelFactory(
            LoginRepositoryImpl(
                LoginDataSource(RetrofitClient.webservice)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupView(view)
        this.login(view)
        this.register(view)

        requireActivity().run {
            sessionManager = SessionManager(this)
        }


    }

    private fun setupView(view: View) {
        email = view.findViewById(R.id.email_et)
        password = view.findViewById(R.id.password_et)
        email.setText("eddylujann@gmail.com")
        password.setText("secret")

    }

    private fun register(view: View) {
        val button = view.findViewById<Button>(R.id.account_btn)
        button.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragment_container_view, RegisterFragment())
                addToBackStack("LoginFragment")
            }
        }
    }

    // TODO: SE LLAMA AL VIEWMODEL
    private fun login(view: View) {
        val loginBtn = view.findViewById<Button>(R.id.login_btn)
        loginBtn.setOnClickListener {
            email = view.findViewById(R.id.email_et)
            password = view.findViewById(R.id.password_et)
            val email = this.email.text.toString()
            val password = this.password.text.toString()

            binding = FragmentLoginBinding.bind(view)
            viewModel.fetchUserToken(email, password).observe(viewLifecycleOwner, Observer { result ->
                when(result) {
                    is Resource.Loading -> {
                        Log.d("LiveData", "Loading...")
                        binding.progressCircular.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressCircular.visibility = View.GONE
                        //Log.d("LiveData", "${result.data}")
                        // SAVE TOKEN
                        sessionManager.saveAuthToken(result.data.token)
                        Log.d("LiveDataToken", "${sessionManager.fetchAuthToken()}")

                        requireActivity().run {
                            val intent = Intent(this, TabsActivity::class.java)
                            intent.putExtra("token", result.data.token)
                            startActivity(intent)
                            finish()
                        }
                    }
                    is Resource.Failure -> {
                        binding.progressCircular.visibility = View.GONE
                        Log.d("LiveData", "${result.exception}")
                        Toast.makeText(activity, "!Email or password incorrect!", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}