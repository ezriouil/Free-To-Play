package com.ezriouil.freetoplay.presentation.component.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ezriouil.freetoplay.R

@ExperimentalMaterialApi
@Composable
fun GameCard(
    modifier: Modifier = Modifier,
    title: String? = "",
    description: String? = "",
    image: String,
    placeholder: Painter = painterResource(id = R.drawable.ic_launcher_foreground),
    platform: String,
    onClick: ()-> Unit
) {
    Card(
        modifier = modifier
            .height(350.dp)
            .fillMaxWidth()
            .padding(5.dp),
        shape = RoundedCornerShape(4.dp),
        backgroundColor = MaterialTheme.colors.surface,
        border = BorderStroke(width = 1.dp, color = Color.White),
        elevation = 8.dp,
        onClick = onClick
    ) {
        Column(modifier = modifier.fillMaxSize()) {

            //Image
            Image(
                painter = rememberAsyncImagePainter(model = image, placeholder = placeholder),
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                //Space
                Spacer(modifier = modifier.height(5.dp))
                //Title
                Text(
                    text = title!!,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onBackground,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 3.dp, end = 3.dp)
                )
                //Description
                Text(
                    text = description!!,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSurface,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 4,
                    modifier = modifier
                        .fillMaxWidth(0.95f)
                        .padding(all = 5.dp)
                )
                //Footer
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(5.dp), horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //FirstItem
                    GameChip(platform = platform)
                    //Space
                    Spacer(modifier = modifier.width(5.dp))
                    //LastItem
                    Icon(
                        painter = if (platform.equals(
                                "PC (Windows)",
                                ignoreCase = true
                            )
                        ) painterResource(id = R.drawable.ic_windows_brands) else painterResource(
                            id = R.drawable.ic_window_maximize_solid
                        ), tint = Color.White,
                        modifier = modifier
                            .fillMaxWidth(0.3f)
                            .size(30.dp),
                        contentDescription = null
                    )
                }
            }
        }
    }
}