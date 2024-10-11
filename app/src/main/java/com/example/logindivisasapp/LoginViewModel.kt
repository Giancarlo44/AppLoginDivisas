package com.example.logindivisasapp

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    fun authenticateUser(username: String, password: String, callback: (Boolean) -> Unit) {
        if (username == "Giancarlo" && password == "123456789") {
            callback(true)
        } else {
            callback(false)
        }
    }
}
