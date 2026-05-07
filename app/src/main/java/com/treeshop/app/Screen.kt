package com.treeshop.app

sealed class Screen(val route: String) {

    data object Splash : Screen("splash")

    data object Home : Screen("home")

    data object ProductDetail : Screen("product_detail/{treeId}") {
        fun createRoute(treeId: Int) = "product_detail/$treeId"
    }

    data object Cart : Screen("cart")

    data object Profile : Screen("profile")
}