package com.example.swiftnetworkandroid.scenes.omboarding.login

//class LoginInteractor(private val remoteDataManeger: LoginContract.RemoteDataManager) : LoginContract.Interactor {
class LoginInteractor(): LoginContract.Interactor {

    private var remoteDataManeger: LoginContract.RemoteDataManager? = LoginRemoteDataManager()


    override fun interactorGetData(email: String, password: String) {
        // TODO: LLAMAR AL REMOTE DATA MANAGER
        this.remoteDataManeger?.remoteGetData(email, password)
    }
}