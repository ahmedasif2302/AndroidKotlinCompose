package com.example.giftcard.screens.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private var _name = MutableLiveData<String>()
    val name: MutableLiveData<String> = _name

    fun onUpdateName(newName: String) {
        _name.value = newName
    }
}