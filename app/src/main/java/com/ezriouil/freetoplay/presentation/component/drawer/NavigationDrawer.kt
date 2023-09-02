package com.ezriouil.freetoplay.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationDrawer(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(rememberScrollState()),

    ) {
        header()
        content()
    }
}