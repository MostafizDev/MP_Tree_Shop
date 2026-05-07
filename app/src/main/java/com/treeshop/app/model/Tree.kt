package com.treeshop.app.model

data class Tree(
    val id: Int,
    val name: String,
    val species: String,
    val category: String,
    val price: Double,
    val rating: Float,
    val reviewCount: Int,
    val heightMeters: Double,
    val description: String,
    val imageRes: String,   // keep if you still want fallback
    val imageUrl: String,   // 👈 NEW
    val isNewArrival: Boolean
)

data class TreeColor(
    val name: String,
    val hexCode: String
)

// CartItem used by ViewModel/UI. Keeps field names compatible with legacy code (shoe, selectedColor, selectedSize).
data class CartItem(
    val tree: Tree,
    var quantity: Int = 1
)
