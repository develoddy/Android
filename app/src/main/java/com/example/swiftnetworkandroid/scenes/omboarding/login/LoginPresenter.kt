package com.example.swiftnetworkandroid.scenes.omboarding.login

/*
class LoginPresenter(private val wireFrame: LoginContract.WireFrame,
                     private val interactor: LoginContract.Interactor) : LoginContract.Presenter {*/

class LoginPresenter(var view: LoginContract.View?): LoginContract.Presenter {

    var interactor: LoginContract.Interactor? = LoginInteractor()

    //private var view: LoginContract.View? = null


    override fun presenterGetData(email: String, password: String) {
        println("SOY EL PRESENTER Y ME HA VENIDO DEL VIEW:")
        println(email)
        println(password)
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated() {
        // TODO: LLAMAR AL INTERACTOR
    }

    override fun onItemClicked(email: String, password: String) {
        // TODO: LLAMAR AL INTERACTOR
    }

    override fun onBackClicked() {
        // TODO: LLAMAR AL WIREFRAME
    }
}