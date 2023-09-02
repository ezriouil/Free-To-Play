package com.ezriouil.freetoplay.presentation.component.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun Description(text: String?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = text?:"",
            color = Color.LightGray,
            style = MaterialTheme.typography.h6,
            maxLines = 7,
            overflow = TextOverflow.Ellipsis,
        )
    }
}