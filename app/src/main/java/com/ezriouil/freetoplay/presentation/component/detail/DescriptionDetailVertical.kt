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
fun DescriptionDetailVertical(modifier: Modifier = Modifier, question: String?, answer: String?) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Text(text = question ?: "", style = MaterialTheme.typography.h4, color = Color.White)
        Spacer(modifier = modifier.height(5.dp))
        Text(
            text = answer ?: "",
            style = MaterialTheme.typography.h6,
            color = Color.LightGray,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }

}