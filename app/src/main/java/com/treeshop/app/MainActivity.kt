package com.treeshop.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.treeshop.app.ui.components.BottomNavBar
import com.treeshop.app.ui.screens.*
import com.treeshop.app.ui.theme.TreeShopTheme
import com.treeshop.app.viewmodel.CartViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TreeShopTheme {

                val navController = rememberNavController()
                val cartViewModel: CartViewModel = viewModel()

                // Track current route
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    modifier = Modifier.fillMaxSize(),

                    // Bottom Navigation
                    bottomBar = {
                        if (currentRoute != Screen.Splash.route &&
                            currentRoute != Screen.ProductDetail.route
                        ) {
                            BottomNavBar(
                                currentRoute = currentRoute ?: "",
                                onNavigate = { route ->
                                    navController.navigate(route) {
                                        popUpTo(Screen.Home.route) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }

                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Splash.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        // Splash
                        composable(Screen.Splash.route) {
                            SplashScreen(
                                onSplashFinished = {
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(Screen.Splash.route) { inclusive = true }
                                    }
                                }
                            )
                        }

                        // Home
                        composable(Screen.Home.route) {
                            HomeScreen(
                                onTreeClick = { treeId ->
                                    navController.navigate(
                                        Screen.ProductDetail.createRoute(treeId)
                                    )
                                }
                            )
                        }

                        // Product Detail
                        composable(
                            route = Screen.ProductDetail.route,
                            arguments = listOf(navArgument("treeId") {
                                type = NavType.IntType
                            })
                        ) { backStackEntry ->

                            val treeId = backStackEntry.arguments?.getInt("treeId")
                                ?: return@composable

                            ProductDetailScreen(
                                treeId = treeId,
                                cartViewModel = cartViewModel,
                                onBack = { navController.popBackStack() }
                            )
                        }

                        // Cart (dummy screen)
                        composable(Screen.Cart.route) {
                            CartScreen(
                                onBack = { navController.popBackStack() }
                            )
                        }

                        // Profile
                        composable(Screen.Profile.route) {
                            ProfileScreen()
                        }
                    }
                }
            }
        }
    }
}