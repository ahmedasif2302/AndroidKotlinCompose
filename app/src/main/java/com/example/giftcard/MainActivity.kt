package com.example.giftcard

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.giftcard.navigation.AppNavigation
import com.example.giftcard.navigation.NavigationManager
import com.example.giftcard.network.dataRepository.ProductDataRepository
import com.example.giftcard.ui.theme.GiftCardTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navManager: NavigationManager

    @Inject
    lateinit var productDataRepository: ProductDataRepository

    private fun fetchProducts() {
        lifecycleScope.launchWhenStarted {
            productDataRepository.makeProductsCall().onEach {
                Log.d("Products", "Fetched products: $it")
            }.collect()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        fetchProducts()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GiftCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavigationContainer()
                }
            }
        }
    }

    @Composable
    fun NavigationContainer() {
        var navController: NavHostController = rememberNavController()

        AppNavigation(navController)

        val navInfo = navManager.routeInfo.collectAsState().value

        Log.d("NavigationManager", "MainActivity to: $navInfo")

        LaunchedEffect(key1 = navInfo) {
            Log.d("NavigationManager", "MainActivity to: $navInfo")
            navInfo?.id?.let {
                navController.navigate(it, navInfo.navOptions)
            }
        }
    }


}
