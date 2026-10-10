package com.example.reproducer.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reproducer.theme.ReproducerTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) = Box(
    modifier = modifier
        .fillMaxSize()
        .background(Color.Red)
) {
    Text(
        text = "UNSAFE TOP INSET",
        modifier = Modifier
            .align(Alignment.TopCenter)
            .windowInsetsTopHeight(WindowInsets.safeDrawing),
        color = Color.White
    )

    Box(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .drawWithContent {
                drawContent()
                drawRect(
                    color = Color.Blue,
                    style = Stroke(width = 2.dp.toPx())
                )
            }
            .background(Color.Green)
    ) {
        Text(
            "Safe drawing area",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    ReproducerTheme { MainScreen() }
}
