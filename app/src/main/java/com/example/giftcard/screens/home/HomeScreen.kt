package com.example.giftcard.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    var email by remember { mutableStateOf("Hello") }

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Welcome to HomeScreen !")
            TextField(
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = {
                    Text(text = "Search for Gift Cards")
                },
                label = { Text(text = "Gift Card Search") },
            )
        }

    }
}