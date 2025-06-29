package com.example.giftcard.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.giftcard.navigation.NavInfo
import com.example.giftcard.navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashScreen(viewModel: SplashViewModel = hiltViewModel<SplashViewModel>()) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Welcome to Splash Gift Card!")
            Button(onClick = {
                viewModel.navManager.navigateTo(NavInfo(id = Routes.LOGIN))
            }) {
                Text(text = "Go to Login")
            }
        }
    }
}