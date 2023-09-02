package com.ezriouil.freetoplay.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ezriouil.freetoplay.presentation.component.detail.*
import com.ezriouil.freetoplay.presentation.view_model.DetailViewModel
import com.ezriouil.freetoplay.utils.Resource

@Composable
fun Detail(viewModel: DetailViewModel = hiltViewModel()) {

    val game by viewModel.game.collectAsState()
    val scrollable = rememberScrollState()
    val localUriHandler = LocalUriHandler.current

    when (game) {
        is Resource.Success -> {
            val it = (game as Resource.Success).data
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollable)
            ) {
                //Header Title
                HeaderDetail(title = it.title!!)
                Spacer(modifier = Modifier.height(15.dp))
                //Carousel
                Carousel(listOfImages = it.screenshot)
                Spacer(modifier = Modifier.height(15.dp))
                //Description
                HeaderEachParte("Description")
                Spacer(modifier = Modifier.height(15.dp))
                Description(text = it.shortDescription)
                Spacer(modifier = Modifier.height(15.dp))
                //Q and A Horizontal
                HeaderEachParte("Details")
                Spacer(modifier = Modifier.height(8.dp))
                DescriptionDetailHorizontal("gender", it.genre)
                Spacer(modifier = Modifier.height(3.dp))
                DescriptionDetailHorizontal("platform", it.platform)
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionDetailHorizontal("publisher", it.publisher)
                Spacer(modifier = Modifier.height(3.dp))
                DescriptionDetailHorizontal("developer", it.developer)
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionDetailHorizontal("status", it.status)
                Spacer(modifier = Modifier.height(3.dp))
                DescriptionDetailHorizontal("release date", it.releaseDate)
                Spacer(modifier = Modifier.height(15.dp))
                //Q and A Vertical
                HeaderEachParte("Minimum System")
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionDetailVertical(
                    question = "graphics:",
                    answer = it.minimumSystemRequirements?.graphics
                )
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionDetailVertical(
                    question = "memory:",
                    answer = it.minimumSystemRequirements?.memory
                )
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionDetailVertical(
                    question = "os:",
                    answer = it.minimumSystemRequirements?.os
                )
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionDetailVertical(
                    question = "storage:",
                    answer = it.minimumSystemRequirements?.storage
                )
                Spacer(modifier = Modifier.height(12.dp))
                DescriptionDetailVertical(
                    question = "processor:",
                    answer = it.minimumSystemRequirements?.processor
                )
                Spacer(modifier = Modifier.height(15.dp))
                //Button
                BtnNavGameUrl(btnClick = {
                    localUriHandler.openUri(
                        uri = it.gameUrl ?: "https://www.intagram.com/med_ezriouil"
                    )
                })
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        is Resource.Error -> {
            Log.d("TAG", "Detail: ${(game as Resource.Error).msg}")
        }
        is Resource.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color.White)
            }
        }
    }
}