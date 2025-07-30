package com.example.giftcard.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.giftcard.model.UsersItem
import com.example.giftcard.network.module.Status

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val name by viewModel.name.observeAsState(initial = "");
    val email by viewModel.email.collectAsState();
    val user by viewModel.user.collectAsState();
    val liveUser by viewModel.liveUser.observeAsState(initial = User(email = "", name = ""))

    val users by viewModel.users.collectAsState()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp)
        ) {
            Text(text = "Welcome to LoginScreen ${liveUser.email}!")
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = liveUser.email,
                onValueChange = {
                    viewModel.onUpdateLiveUser(it, "email")
                },
                placeholder = {
                    Text(text = "Enter your email")
                },
                label = { Text(text = "Email") },
            )
            Spacer(modifier = Modifier.height(10.dp))
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
            UserList()
        }

    }
}

@Composable
fun UserList(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val users by viewModel.users.collectAsState()

    when (users?.status) {
        Status.LOADING -> {
            Text(text = "Loading users...")
        }

        Status.SUCCESS -> {
            val userList: List<UsersItem> = users?.data.orEmpty()

            if (userList.isEmpty()) {
                Text(text = "No users found")
            } else {
                LazyColumn {
                    itemsIndexed(userList) { index, user ->
                        Text(
                            text = "User: ${user.name?.firstname}, Email: ${user.email}",
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }

        else -> {
            Text(text = "No case to display")
        }
    }


}