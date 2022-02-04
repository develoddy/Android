package com.example.swiftnetworkandroid.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.swiftnetworkandroid.core.Resource
import com.example.swiftnetworkandroid.repository.home.HomeRepository
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val repo: HomeRepository): ViewModel() {

    fun fetchUserPost(token: String?) = liveData( Dispatchers.IO ) {
    //fun fetchUserPost(token: String?) = liveData( viewModelScope.coroutineContext + Dispatchers.Main) {
        println("Soy ViewModel (HomeViewModel)")
        println(token)

        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getUserPost(token)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}

class HomeViewModelFactory(private val repo: HomeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HomeRepository::class.java).newInstance(repo)
    }
}