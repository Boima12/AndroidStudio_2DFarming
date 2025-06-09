package com.example.a2dfarming.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.a2dfarming.R

@Composable
fun AJumpscareDialog(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = R.drawable.duy_vertical),
            contentDescription = "Jumpscare background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
        )
    }
}
