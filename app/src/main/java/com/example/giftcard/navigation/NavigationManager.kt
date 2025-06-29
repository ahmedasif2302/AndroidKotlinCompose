package com.example.giftcard.navigation

import android.util.Log
import androidx.navigation.NavOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton


data class NavInfo(val id: String? = null, val navOptions: NavOptions? = null);

@Singleton
class NavigationManager @Inject constructor() {
    private val _routeInfo = MutableStateFlow(NavInfo())
    val routeInfo: StateFlow<NavInfo> = _routeInfo;

    fun navigateTo(routeInfo: NavInfo?) {
        Log.d("NavigationManager", "Navigating to: ${routeInfo?.id ?: "null"}")
        _routeInfo.update { routeInfo ?: NavInfo() }
    }
}