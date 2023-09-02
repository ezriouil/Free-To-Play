package com.ezriouil.freetoplay.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun NavigationDrawerItem(
    modifier: Modifier = Modifier,
    text: String,
    icon: Painter,
    colorIcon: Color = Color.White,
    colorText: Color = Color.White,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = colorIcon,
            modifier = modifier.padding(end = 5.dp)
        )
        Text(text = text, style = MaterialTheme.typography.subtitle1, color = colorText)
    }
}