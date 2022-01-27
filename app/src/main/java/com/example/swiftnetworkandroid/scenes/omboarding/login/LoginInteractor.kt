package com.example.swiftnetworkandroid.scenes.omboarding.login

//class LoginInteractor(private val remoteDataManeger: LoginContract.RemoteDataManager) : LoginContract.Interactor {
class LoginInteractor(): LoginContract.Interactor {

    var remoteDataManeger: LoginContract.RemoteDataManager? = LoginRemoteDataManager()

    // TODO: LLAMAR AL REMOTE DATA MANAGER
    override fun interactorGetData(email: String, password: String) {
        //
    }
}