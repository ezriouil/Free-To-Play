package com.ezriouil.freetoplay.presentation.component.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String,
    textColor: Color,
    iconStart: Painter,
    iconStartColor: Color,
    iconStartSize: Dp = 30.dp,
    iconStartClick: () -> Unit,
    iconEnd: Painter,
    iconEndColor: Color,
    iconEndSize: Dp = 30.dp,
    iconEndClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = modifier.size(iconStartSize),
            onClick = iconStartClick
        ) {
            Icon(
                painter = iconStart,
                contentDescription = null,
                tint = iconStartColor
            )
        }
        Text(text = title, color = textColor, style = MaterialTheme.typography.h1)
        IconButton(
            modifier = modifier.size(iconEndSize),
            onClick = iconEndClick
        ) {
            Icon(
                painter = iconEnd,
                contentDescription = null,
                tint = iconEndColor,
            )
        }
    }
}