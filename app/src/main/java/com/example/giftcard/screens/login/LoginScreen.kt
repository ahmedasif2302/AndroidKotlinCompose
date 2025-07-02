package com.example.giftcard.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val name by viewModel.name.observeAsState(initial = "")

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp)
        ) {
            Text(text = "Welcome to LoginScreen ${name}!")
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = {
                    viewModel.onUpdateName(it)
                },
                placeholder = {
                    Text(text = "Search for Gift Cards")
                },
                label = { Text(text = "Gift Card Search") },
            )
        }

    }
}