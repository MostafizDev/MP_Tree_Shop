package com.treeshop.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.treeshop.app.model.Tree

@Composable
fun TreeCard(
    tree: Tree,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        Column(modifier = Modifier.padding(12.dp)) {

            AsyncImage(
                model = tree.imageUrl,
                contentDescription = tree.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE8F5E9)),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = tree.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = tree.species,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFC107))
                Spacer(modifier = Modifier.width(4.dp))
                Text("${tree.rating}", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "(${tree.reviewCount})",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "$${tree.price}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

//            Button(
//                onClick = {},
//                modifier = Modifier.fillMaxWidth(),
//                contentPadding = PaddingValues(vertical = 6.dp)
//            ) {
//                Icon(Icons.Default.Add, contentDescription = null)
//                Spacer(modifier = Modifier.width(4.dp))
//                Text("Add")
//            }
        }
    }
}