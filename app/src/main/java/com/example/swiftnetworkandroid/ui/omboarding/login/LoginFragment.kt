package com.example.swiftnetworkandroid.ui.omboarding.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
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
import com.example.swiftnetworkandroid.presentation.LoginViewModel
import com.example.swiftnetworkandroid.webservice.RetrofitClient

//TODO: Fragment
class LoginFragment : Fragment(R.layout.fragment_login) {

    // PROPERTIES
    private lateinit var sessionManager: SessionManager
    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel> {
        LoginViewModelFactory(
            LoginRepositoryImpl(
                LoginDataSource(RetrofitClient.webservice)
            )
        )
    }

    // FUNCTIONS
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        val email = binding.emailEt
        val password = binding.passwordEt
        email.setText("eddylujann@gmail.com")
        password.setText("secret")
        doLogin()
        requireActivity().run { sessionManager = SessionManager(this) }
    }

    // LOGIN
    private fun doLogin() {
        binding.loginBtn.setOnClickListener {
            val email = binding.emailEt.text.toString().trim()
            val password = binding.passwordEt.text.toString().trim()
            validateCredentials(email, password)
            signIn(email,password)
        }
    }

    // VALIDATE CREDENTIALS LOGIN
    private fun validateCredentials(email: String, password: String) {
        if (email.isEmpty()) {
            binding.emailEt.error = "E-mail is empty"
            return
        }
        if (password.isEmpty()) {
            binding.passwordEt.error = "Password is empty"
            return
        }
    }

    // CALL PRESENTATION
    private fun signIn(email: String, password: String) {
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