package com.treeshop.app.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.treeshop.app.R
import com.treeshop.app.ui.theme.OrangeRed
import com.treeshop.app.ui.theme.OrangeRedDark
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    val alpha = remember { Animatable(0f) }
    val scale = remember { Animatable(0.8f) }

    LaunchedEffect(Unit) {
        alpha.animateTo(1f, animationSpec = tween(800))
        scale.animateTo(1f, animationSpec = tween(800))
        delay(1500)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(OrangeRedDark, OrangeRed)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .alpha(alpha.value)
                .scale(scale.value)
        ) {

            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(80.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "TREE SHOP",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White,
                letterSpacing = 6.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Grow Your Perfect Space",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
        }
    }
}