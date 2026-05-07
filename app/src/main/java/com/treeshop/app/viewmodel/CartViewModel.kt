package com.treeshop.app.viewmodel

import androidx.lifecycle.ViewModel
import com.treeshop.app.model.CartItem
import com.treeshop.app.model.Tree
import kotlinx.coroutines.flow.MutableStateFlow

class CartViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())

    val cartItemCount: Int
        get() = _cartItems.value.sumOf { it.quantity }

    fun addToCart(tree: Tree) {

    }

    fun decreaseQuantity(tree: Tree) {

    }

    fun removeFromCart(tree: Tree) {

    }

    fun updateQuantity(tree: Tree, newQuantity: Int) {

    }

    fun clearCart() {

    }
}