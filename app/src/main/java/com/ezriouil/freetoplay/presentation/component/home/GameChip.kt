package com.ezriouil.freetoplay.presentation.component.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun GameChip(
    platform: String,
    textColor: Color = MaterialTheme.colors.surface,
    backgroundColor: Color = MaterialTheme.colors.primaryVariant
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(all = 2.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
    ) {
        //titleInsideTheBox
        Text(
            text = platform,
            style = MaterialTheme.typography.h6,
            color = textColor,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            textAlign = TextAlign.Center
        )
    }
}