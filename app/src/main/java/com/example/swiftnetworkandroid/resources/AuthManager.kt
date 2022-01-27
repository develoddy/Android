package com.example.swiftnetworkandroid.resources

class AuthManager {

    public fun login(email: String?, password: String?): Boolean {
        val emailPrueba = "eddylujann@gmail.com"
        val passPrueba = "secret"
        if (email.equals(emailPrueba) && password.equals(passPrueba)) {
            //Success

            return true
        } else {
            //Error

            return false
        }
    }
}