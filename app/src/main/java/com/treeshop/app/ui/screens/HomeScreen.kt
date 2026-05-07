package com.treeshop.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.treeshop.app.data.TreeRepository
import com.shoeshop.app.ui.components.CategoryChip
import com.treeshop.app.ui.components.TreeCard
import com.treeshop.app.ui.theme.OrangeRed
import com.treeshop.app.ui.theme.OrangeRedDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onTreeClick: (Int) -> Unit,
) {
    var selectedCategory by remember { mutableStateOf("All") }

    val filteredTrees = remember(selectedCategory) {
        TreeRepository.getTreesByCategory(selectedCategory)
    }

    val featuredTree = TreeRepository.trees.first()

    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Discover", style = MaterialTheme.typography.headlineLarge)
                Text(
                    "Find your perfect tree",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                )
            }

            IconButton(onClick = { }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(160.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(OrangeRedDark, OrangeRed)
                    )
                )
        ) {

            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(20.dp)
            ) {
                Text("New Arrival", color = Color.White)

                Text(
                    text = featuredTree.name,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { onTreeClick(featuredTree.id) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = OrangeRed
                    )
                ) {
                    Text("Explore")
                }
            }

            AsyncImage(
                model = featuredTree.imageUrl,
                contentDescription = featuredTree.name,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 16.dp)
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(TreeRepository.categories) { category ->
                CategoryChip(
                    label = category,
                    selected = category == selectedCategory,
                    onClick = { selectedCategory = category }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (selectedCategory == "All") "All Trees" else selectedCategory,
                style = MaterialTheme.typography.titleLarge
            )

            TextButton(onClick = { }) {
                Text("See All", color = OrangeRed)
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(filteredTrees) { tree ->
                TreeCard(
                    tree = tree,
                    onClick = { onTreeClick(tree.id) },
                )
            }
        }
    }
}