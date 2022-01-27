package com.example.swiftnetworkandroid.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.swiftnetworkandroid.core.Resource
//import com.example.swiftnetworkandroid.data.model.Login
import com.example.swiftnetworkandroid.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import retrofit2.http.Body

//TODO: ViewModel -> Repository
class LoginViewModel(private val repo: LoginRepository): ViewModel() {

    /**
     * Create a method that will communicate with the repository.
     */
    fun fetchUserToken( email:String, password:String ) = liveData( Dispatchers.IO ) {

        println(email)
        println(password)
        // It is necessary to communicate in sight that there are 3 types of status.
        // 1. Status loading
        // 2. Status success
        // 3. Status error

        // We notify the user that he is loading the data.
        emit( Resource.Loading() )
        try {
            emit( Resource.Success( repo.getToken( email, password ) ) )
        } catch (e: Exception) {
            emit( Resource.Failure( e ) )
        }
    }
}

class LoginViewModelFactory(private val repo: LoginRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(LoginRepository::class.java).newInstance(repo)
    }
}