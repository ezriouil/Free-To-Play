package com.ezriouil.freetoplay.presentation.component.detail

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.ezriouil.freetoplay.domain.model.Screenshot
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Carousel(listOfImages: List<Screenshot?>?) {
    val pageState = rememberPagerState(pageCount = listOfImages!!.size)
    LaunchedEffect(Unit) {
        while(true) {
            yield()
            delay(2000)
            pageState.animateScrollToPage(
                page = (pageState.currentPage + 1) % (pageState.pageCount),
                animationSpec = tween(600)
            )
        }
    }
    HorizontalPager(
        state = pageState, modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth(0.8f)
                .padding(start = 8.dp, end = 8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = listOfImages[it]?.image)
                    .crossfade(500)
                    .scale(scale = Scale.FILL)
                    .build(),
                contentDescription = null,
                filterQuality = FilterQuality.Low,
                placeholder = painterResource(id = R.drawable.ic_free_to_play_splash)
            )
        }
    }
}