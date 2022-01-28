package com.example.swiftnetworkandroid.scenes.omboarding.login

class LoginPresenter(var view: LoginContract.View?): LoginContract.Presenter {

    // TODO: PROPERTIES
    private var interactor: LoginContract.Interactor? = LoginInteractor()

    override fun onDestroy() {
        view = null
        interactor = null
    }

    // TODO: LLAMAR AL INTERACTOR
    override fun presenterGetData(email: String, password: String) {
        println("SOY EL PRESENTER Y ME HA VENIDO DEL VIEW:")
        println(email)
        println(password)
        this.interactor?.interactorGetData(email,password)
    }
}