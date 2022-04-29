package com.ashutosh1234ojha.mvvmbase.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 * Created by Ashutosh Ojha on 03,March,2022
 */
class LoginRequest(_email: String, _password: String) : BaseObservable() {
    // val email: String = _email
    // val password: String = _password

    @get:Bindable
    var email = _email
        set(value) {
            if (value != email) {
                field = value
                notifyChange()
            }
        }

    @get:Bindable
    var password = _password
        set(value) {
            if (value != password) {
                field = value
                notifyChange()
            }
        }

    override fun toString(): String {
        return "Email: $email\n" +
                "password: $password\n"
    }
}