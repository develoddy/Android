package com.example.swiftnetworkandroid.scenes.omboarding.login

import com.example.swiftnetworkandroid.data.model.ResultLogin

interface LoginContract {

    interface View {
    }

    interface Presenter {
        fun onDestroy()
        fun presenterGetData(email: String, password: String)

    }

    interface Interactor {
        fun interactorGetData(email: String, password: String)
    }

    interface WireFrame {
        fun gotoTabBar()
    }

    interface RemoteDataManager {
        fun remoteGetData(email: String, password: String)
    }

    interface Repo {
        suspend fun getToken(email: String, password: String): ResultLogin //Single<List<Joke>>
    }
}