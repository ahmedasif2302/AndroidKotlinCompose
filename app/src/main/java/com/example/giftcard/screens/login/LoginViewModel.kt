package com.example.giftcard.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giftcard.model.UsersItem
import com.example.giftcard.network.dataRepository.UserDataRepository
import com.example.giftcard.network.module.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


data class User(
    val email: String = "",
    val name: String = ""
)


@HiltViewModel
class LoginViewModel @Inject constructor(
    val userDataRepository: UserDataRepository
) :
    ViewModel() {

    private var _users = MutableStateFlow<Resource<List<UsersItem>>?>(Resource.loading())

    val users: MutableStateFlow<Resource<List<UsersItem>>?> get() = _users

    init {
        getAllUsers()
    }

    fun getAllUsers() {
        viewModelScope.launch {
            try {
                _users.value = Resource.loading()
                val response: Response<List<UsersItem>?> = userDataRepository.getAllUsers()

                if (response.isSuccessful) {
                    _users.value = Resource.success(data = response.body())
                } else {
                    _users.value = Resource.error(message = "Error fetching users", data = null)
                }
            } catch (e: Exception) {
                _users.value =
                    Resource.error(data = null, message = e.message ?: "An error occurred")
            }
        }
    }

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