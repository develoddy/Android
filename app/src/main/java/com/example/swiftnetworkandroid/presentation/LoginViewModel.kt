package com.example.swiftnetworkandroid.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.swiftnetworkandroid.core.Resource
import com.example.swiftnetworkandroid.repository.login.LoginRepository
import kotlinx.coroutines.Dispatchers

// TODO: ViewModel
class LoginViewModel(private val repo: LoginRepository): ViewModel() {

    fun fetchUserToken( email:String, password:String ) = liveData( Dispatchers.IO ) {
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