package com.example.swiftnetworkandroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.swiftnetworkandroid.core.Resource
import com.example.swiftnetworkandroid.repository.login.LoginRepository
import kotlinx.coroutines.Dispatchers

//TODO: ViewModel -> Repository
class LoginViewModel(private val repo: LoginRepository): ViewModel() {

    // TODO: SE LLAMA A LA INTERFAZ/REPOSITORY
    fun fetchUserToken( email:String, password:String ) = liveData( Dispatchers.IO ) {
        // It is necessary to communicate in sight that there are 3 types of status.
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
