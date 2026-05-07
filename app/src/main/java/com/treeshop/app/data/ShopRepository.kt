package com.treeshop.app.data

import com.treeshop.app.model.Tree

object TreeRepository {

    val categories = listOf("All", "Ornamental", "Fruit", "Evergreen")

    val trees: List<Tree> = listOf(

        Tree(
            id = 1,
            name = "Red Maple",
            species = "Acer rubrum",
            category = "Ornamental",
            price = 129.99,
            rating = 4.8f,
            reviewCount = 1245,
            heightMeters = 4.5,
            description = "A classic ornamental tree known for brilliant red foliage in autumn and adaptability to many soils.",
            imageRes = "tree_red_maple",
            imageUrl = "https://i.etsystatic.com/19254641/r/il/bc79d2/2264068187/il_fullxfull.2264068187_6app.jpg",
            isNewArrival = true
        ),

        Tree(
            id = 2,
            name = "Lemon Tree",
            species = "Citrus limon",
            category = "Fruit",
            price = 99.58,
            rating = 4.5f,
            reviewCount = 872,
            heightMeters = 2.0,
            description = "A productive lemon tree suitable for patios and small gardens.",
            imageRes = "tree_lemon",
            imageUrl = "https://paradisenursery.com/cdn/shop/files/Meyer_Lemon_Tree_25Gallon_Standard_ParadiseNursery.webp?v=1770247520",
            isNewArrival = false
        ),

        Tree(
            id = 3,
            name = "Norway Spruce",
            species = "Picea abies",
            category = "Evergreen",
            price = 159.99,
            rating = 4.7f,
            reviewCount = 598,
            heightMeters = 6.0,
            description = "A large evergreen tree with a conical shape.",
            imageRes = "tree_norway_spruce",
            imageUrl = "https://www.exmoortrees.co.uk/cdn/shop/products/Norway-Spuce.jpg?v=1699278966&width=1080",
            isNewArrival = true
        ),

        Tree(
            id = 4,
            name = "Cherry Blossom",
            species = "Prunus serrulata",
            category = "Ornamental",
            price = 75.00,
            rating = 5.0f,
            reviewCount = 733,
            heightMeters = 3.0,
            description = "Known for its stunning spring blossoms.",
            imageRes = "tree_cherry_blossom",
            imageUrl = "https://m.media-amazon.com/images/I/61H+FIDUOCL._AC_UF894,1000_QL80_.jpg",
            isNewArrival = false
        ),

        Tree(
            id = 5,
            name = "Apple Tree",
            species = "Malus domestica",
            category = "Fruit",
            price = 120.00,
            rating = 4.6f,
            reviewCount = 411,
            heightMeters = 3.5,
            description = "Produces apples with beautiful blossoms.",
            imageRes = "tree_apple",
            imageUrl = "https://www.ascentyardcare.com/cms/images/apple-tree-with-fruit1.jpg",
            isNewArrival = true
        ),

        Tree(
            id = 6,
            name = "Eastern Redbud",
            species = "Cercis canadensis",
            category = "Ornamental",
            price = 85.00,
            rating = 4.4f,
            reviewCount = 287,
            heightMeters = 2.5,
            description = "Small tree with striking pink flowers.",
            imageRes = "tree_eastern_redbud",
            imageUrl = "https://clearviewnursery.com/wp-content/uploads/2022/12/Cercis-canadensis.jpg",
            isNewArrival = false
        )
    )

    fun getTreeById(id: Int): Tree? = trees.find { it.id == id }

    fun getTreesByCategory(category: String): List<Tree> =
        if (category == "All") trees else trees.filter { it.category == category }
}
