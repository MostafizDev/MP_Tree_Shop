package com.treeshop.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class DummyCartItem(
    val id: Int,
    val name: String,
    val price: Double,
    var quantity: Int
)

@Composable
fun CartScreen(onBack: () -> Unit) {

    var cartItems by remember {
        mutableStateOf(
            listOf(
                DummyCartItem(1, "Red Maple", 129.99, 1),
                DummyCartItem(2, "Lemon Tree", 99.58, 2),
                DummyCartItem(3, "Cherry Blossom", 75.00, 1)
            )
        )
    }

    val total = cartItems.sumOf { it.price * it.quantity }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Text(
                text = "My Cart(Dummy)",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Your cart is empty 🌱")
            }
        } else {

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(cartItems, key = { it.id }) { item ->

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {

                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = "$${item.price}",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Row(verticalAlignment = Alignment.CenterVertically) {

                                    IconButton(
                                        onClick = {
                                            cartItems = cartItems.map {
                                                if (it.id == item.id && it.quantity > 1)
                                                    it.copy(quantity = it.quantity - 1)
                                                else it
                                            }
                                        }
                                    ) {
                                        Icon(Icons.Default.Remove, null)
                                    }

                                    Text(item.quantity.toString())

                                    IconButton(
                                        onClick = {
                                            cartItems = cartItems.map {
                                                if (it.id == item.id)
                                                    it.copy(quantity = it.quantity + 1)
                                                else it
                                            }
                                        }
                                    ) {
                                        Icon(Icons.Default.Add, null)
                                    }
                                }

                                IconButton(
                                    onClick = {
                                        cartItems = cartItems.filter { it.id != item.id }
                                    }
                                ) {
                                    Icon(Icons.Default.Delete, contentDescription = "Remove")
                                }
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Total: $${"%.2f".format(total)}",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Checkout")
                }
            }
        }
    }
}