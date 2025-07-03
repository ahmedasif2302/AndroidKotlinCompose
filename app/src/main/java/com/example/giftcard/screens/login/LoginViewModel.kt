package com.example.giftcard.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


data class User(
    val email: String = "",
    val name: String = ""
)


@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private var _user = MutableStateFlow<User>(User())
    val user: StateFlow<User> = _user

    private var _liveUser = MutableLiveData<User>()
    val liveUser: LiveData<User> = _liveUser

    private var _email = MutableStateFlow<String>("")
    val email: StateFlow<String> = _email

    private var _name = MutableLiveData<String>()
    val name: MutableLiveData<String> = _name

    fun onUpdateLiveUser(value: String, type: String) {
        when (type) {
            "email" -> {
                _liveUser.value = _liveUser.value?.copy(email = value) ?: User(email = value)
            }

            "name" -> {
                _liveUser.value = _liveUser.value?.copy(name = value) ?: User(name = value)
            }
        }
    }

    fun onUpdateUser(value: String, type: String) {
        when (type) {
            "email" -> {
                _user.value = _user.value.copy(email = value)
            }

            "name" -> {
                _user.value = _user.value.copy(name = value)
            }
        }
    }

    fun onUpdateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun onUpdateName(newName: String) {
        _name.value = newName
    }
}