package com.example.giftcard.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavOptions
import com.example.giftcard.navigation.NavInfo
import com.example.giftcard.navigation.Routes
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashScreen(viewModel: SplashViewModel = hiltViewModel<SplashViewModel>()) {
    LaunchedEffect(key1 = viewModel) {
        timeout(1000L, viewModel)
    }
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to Splash Gift Card!")
            Button(onClick = {
                viewModel.navManager.navigateTo(
                    NavInfo(
                        id = Routes.LOGIN, navOptions = NavOptions.Builder().setPopUpTo(
                            Routes.SPLASH, inclusive = true
                        ).build()
                    )
                )

            }) {
                Text(text = "Go to Login")
            }
        }
    }
}

suspend fun timeout(delay: Long = 2000L, viewModel: SplashViewModel) {
    delay(delay);
    viewModel.navManager.navigateTo(
        NavInfo(
            id = Routes.LOGIN, navOptions = NavOptions.Builder().setPopUpTo(
                Routes.SPLASH, inclusive = true
            ).build()
        )
    )
}