package com.example.giftcard.screens.splash

import androidx.lifecycle.ViewModel
import com.example.giftcard.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(val navManager: NavigationManager) : ViewModel() {
}