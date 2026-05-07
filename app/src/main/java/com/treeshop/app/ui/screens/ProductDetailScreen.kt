package com.treeshop.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.treeshop.app.data.TreeRepository
import com.treeshop.app.ui.theme.OrangeRed
import com.treeshop.app.ui.theme.StarYellow
import com.treeshop.app.viewmodel.CartViewModel
import coil.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    treeId: Int,
    cartViewModel: CartViewModel,
    onBack: () -> Unit,
) {
    val tree = TreeRepository.getTreeById(treeId) ?: return
    var isAdded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = onBack,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = "Tree Details",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = tree.imageUrl,
                    contentDescription = tree.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                if (tree.isNewArrival) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(12.dp)
                            .background(OrangeRed, RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text("New", color = Color.White, fontSize = 10.sp)
                    }
                }

                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(Icons.Filled.FavoriteBorder, contentDescription = null, tint = OrangeRed)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier.padding(horizontal = 20.dp)) {

                Text(
                    text = tree.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Star, null, tint = StarYellow, modifier = Modifier.size(16.dp))
                    Text(
                        text = " ${tree.rating} (${tree.reviewCount})",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = tree.species,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = tree.description,
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "$${tree.price}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (!isAdded) {
                        cartViewModel.addToCart(tree)
                        isAdded = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isAdded) Color.Gray else OrangeRed
                ),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text(
                    text = if (isAdded) "✓ Added" else "Add to Cart",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}