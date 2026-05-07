package com.treeshop.app.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.treeshop.app.ui.theme.ForestGreen
import com.treeshop.app.ui.theme.LeafGreen
import com.treeshop.app.ui.theme.MintGreen

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Text(text = "Profile", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(ForestGreen, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "MR",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Md Mostafizur Rahman",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Software Engineer",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .background(MintGreen.copy(alpha = 0.2f), RoundedCornerShape(50))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        "MSc CS - Lakehead University",
                        style = MaterialTheme.typography.labelSmall,
                        color = ForestGreen,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Divider()
        Spacer(modifier = Modifier.height(12.dp))

        val context = LocalContext.current

        ProfileItem(Icons.Default.Phone, "+1 807-358-6139") {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+18073586139")
            }
            context.startActivity(intent)
        }

        ProfileItem(Icons.Default.Email, "mostafiz1713.official@gmail.com") {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:mostafiz1713.official@gmail.com")
            }
            context.startActivity(intent)
        }

        ProfileItem(Icons.Default.LocationOn, "Thunder Bay, ON, Canada") {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=Thunder+Bay+Ontario+Canada")
            }
            context.startActivity(intent)
        }

        ProfileItem(Icons.Default.Language, "v0-mostafizdev.vercel.app") {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://v0-mostafizdev.vercel.app")
            }
            context.startActivity(intent)
        }

        ProfileItem(Icons.Default.Person, "linkedin.com/in/mostafizdev17") {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://linkedin.com/in/mostafizdev17")
            }
            context.startActivity(intent)
        }

        Spacer(modifier = Modifier.height(24.dp))
        Divider()
        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle(title = "Work Experience")

        Spacer(modifier = Modifier.height(16.dp))

        WorkExperienceCard(
            role = "Associate Software Engineer",
            company = "Business Automation Ltd.",
            location = "Dhaka, Bangladesh",
            period = "Dec 2023 – Nov 2025",
            highlights = listOf(
                "Flutter apps for government clients (e-Hajj, e-Namjari)",
                "REST APIs, Firebase (Firestore, Storage, Push) & Socket.IO",
                "Collaborated with Laravel & FastAPI backend teams",
                "Offline-first storage & sync with Couchbase"
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        WorkExperienceCard(
            role = "Software Engineer",
            company = "Merchant Bay Ltd.",
            location = "Dhaka, Bangladesh",
            period = "Nov 2021 – Dec 2023",
            highlights = listOf(
                "Flutter apps for B2B marketplace & order management",
                "Web features with React and Django",
                "Auth, API integration, state management (Provider/GetX)",
                "Agile team across multiple client & in-house projects"
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        WorkExperienceCard(
            role = "Mobile App Developer (Part-Time)",
            company = "Vemate",
            location = "London, UK",
            period = "Sep 2021 – Jul 2023",
            highlights = listOf(
                "Led team building Flutter app with Firebase backend",
                "Real-time features, push notifications, remote config",
                "Coordinated UI design, API integration & release cycles"
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = ForestGreen),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Logout")
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Composable
fun SectionTitle(title: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(20.dp)
                .background(ForestGreen, RoundedCornerShape(2.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun WorkExperienceCard(
    role: String,
    company: String,
    location: String,
    period: String,
    highlights: List<String>
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = role,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = period,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "$company · $location",
                style = MaterialTheme.typography.bodyMedium,
                color = ForestGreen,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(10.dp))

            highlights.forEach { point ->
                Row(
                    modifier = Modifier.padding(bottom = 4.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "•",
                        color = LeafGreen,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 6.dp, top = 1.dp)
                    )
                    Text(
                        text = point,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f),
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = ForestGreen,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            textDecoration = TextDecoration.Underline
        )
    }
}