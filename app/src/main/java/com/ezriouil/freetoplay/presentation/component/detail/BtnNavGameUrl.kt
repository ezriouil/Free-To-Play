package com.ezriouil.freetoplay.presentation.component.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ezriouil.freetoplay.R

@Composable
fun BtnNavGameUrl(btnClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = btnClick,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primaryVariant),
        modifier = modifier
            .height(54.dp)
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Row(
            modifier = modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_sign_in_alt_solid),
                contentDescription = "",
                tint = Color.Black
            )
            Spacer(modifier = modifier.width(4.dp))
            Text(
                text = "Go Play",
                style = MaterialTheme.typography.h3,
                color = Color.Black
            )
        }
    }
}