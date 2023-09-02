package com.ezriouil.freetoplay.presentation.component.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun HeaderEachParte(headerText: String) {
    Text(
        text = headerText,
        textDecoration = TextDecoration.Underline,
        style = MaterialTheme.typography.h2,
        modifier = Modifier.padding(start = 5.dp),
        color = Color.White
    )
}