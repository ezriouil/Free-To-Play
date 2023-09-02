package com.ezriouil.freetoplay.presentation.component.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DescriptionDetailHorizontal(question: String, answer: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = question, color = Color.White, style = MaterialTheme.typography.h4)
        Text(text = answer ?: "...", color = Color.LightGray, style = MaterialTheme.typography.h6)
    }
}