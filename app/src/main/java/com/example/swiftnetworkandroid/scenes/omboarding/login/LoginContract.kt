package com.example.swiftnetworkandroid.scenes.omboarding.login

interface LoginContract {

    interface View {
    }

    interface Presenter {
        fun presenterGetData(email: String, password: String)
        fun unbindView()
        fun onViewCreated()
        fun onItemClicked(email: String, password: String)
        fun onBackClicked()
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
}