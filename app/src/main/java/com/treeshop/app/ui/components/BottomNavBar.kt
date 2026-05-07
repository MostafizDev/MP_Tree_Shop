package com.treeshop.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.treeshop.app.ui.theme.OrangeRed

@Composable
fun BottomNavBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {

    val colorScheme = MaterialTheme.colorScheme

    NavigationBar(
        containerColor = colorScheme.surface,   // ✅ uses theme
        tonalElevation = 6.dp
    ) {

        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { onNavigate("home") },
            icon = {
                Icon(Icons.Default.Home, contentDescription = "Home")
            },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = OrangeRed,
                selectedTextColor = OrangeRed,
                indicatorColor = OrangeRed.copy(alpha = 0.15f),
                unselectedIconColor = colorScheme.onSurface.copy(alpha = 0.6f),
                unselectedTextColor = colorScheme.onSurface.copy(alpha = 0.6f)
            )
        )

        NavigationBarItem(
            selected = currentRoute == "cart",
            onClick = { onNavigate("cart") },
            icon = {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
            },
            label = { Text("Cart") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = OrangeRed,
                selectedTextColor = OrangeRed,
                indicatorColor = OrangeRed.copy(alpha = 0.15f),
                unselectedIconColor = colorScheme.onSurface.copy(alpha = 0.6f),
                unselectedTextColor = colorScheme.onSurface.copy(alpha = 0.6f)
            )
        )

        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = { onNavigate("profile") },
            icon = {
                Icon(Icons.Default.Person, contentDescription = "Profile")
            },
            label = { Text("Profile") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = OrangeRed,
                selectedTextColor = OrangeRed,
                indicatorColor = OrangeRed.copy(alpha = 0.15f),
                unselectedIconColor = colorScheme.onSurface.copy(alpha = 0.6f),
                unselectedTextColor = colorScheme.onSurface.copy(alpha = 0.6f)
            )
        )
    }
}