package com.example.giftcard.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen() {
    Scaffold { innerPadding ->
        Text(text = "Welcome to LoginScreen !", modifier = Modifier.padding(innerPadding))
    }
}